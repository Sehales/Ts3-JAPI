package net.sehales.ts3_japi.event;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import net.sehales.ts3_japi.ServerQuery;
import net.sehales.ts3_japi.command.response.ArrayResponse;
import net.sehales.ts3_japi.property.EventProperty;
import net.sehales.ts3_japi.wrapper.MapWrapper;

public class EventManager {
    // just used to sync the register and unregister methods
    private final Object                          lock        = new Object();

    private Map<Class<?>, List<CallableListener>> listenerMap = new HashMap<>();

    private ServerQuery                           query;

    public EventManager(ServerQuery query) {
        this.query = query;
    }

    private void addFunctionListener(Class<?> eventClass, String listenerName, Consumer<?> con) {
        List<CallableListener> list = listenerMap.get(eventClass);
        if (list == null) {
            list = new ArrayList<>();
            listenerMap.put(eventClass, list);
        }
        CallableFunctionListener listener = new CallableFunctionListener(listenerName, con);
        list.add(listener);
    }

    private void addMethodListener(Class<?> eventClass, Object obj, Method me) {
        List<CallableListener> list = listenerMap.get(eventClass);
        if (list == null) {
            list = new ArrayList<>();
            listenerMap.put(eventClass, list);
        }
        CallableMethodListener listener = new CallableMethodListener(me, obj);
        list.add(listener);
    }

    private void fireChatEvent(MapWrapper eventWrapper) {
        switch (ChatEvent.MessageType.getByIndex(eventWrapper.getInt(EventProperty.Chat.TARGETMODE))) {
            case CHANNEL: {
                List<CallableListener> cceList = listenerMap.get(ChannelChatEvent.class);
                if ((cceList != null) && (cceList.size() > 0)) {
                    ChannelChatEvent event = new ChannelChatEvent(query, eventWrapper);
                    for (CallableListener listener : cceList) {
                        listener.call(event);
                    }
                }
                break;
            }
            case PRIVATE: {
                List<CallableListener> cceList = listenerMap.get(PrivateChatEvent.class);
                if ((cceList != null) && (cceList.size() > 0)) {
                    PrivateChatEvent event = new PrivateChatEvent(query, eventWrapper);
                    for (CallableListener listener : cceList) {
                        listener.call(event);
                    }
                }
                break;
            }
            case SERVER: {
                List<CallableListener> cceList = listenerMap.get(ServerChatEvent.class);
                if ((cceList != null) && (cceList.size() > 0)) {
                    ServerChatEvent event = new ServerChatEvent(query, eventWrapper);
                    for (CallableListener listener : cceList) {
                        listener.call(event);
                    }
                }
                break;
            }
        }
    }

    /**
     * Parses the raw "notify..."-string returned by the server query interface and fires the appropriate events. (calls registered listeners)
     * 
     * @param notify
     *            The "notify..."-string.
     */
    public void parseNotify(String notify) {
        String eventName = notify.substring(notify.indexOf('y') + 1, notify.indexOf(' '));
        ArrayResponse eventRes = new ArrayResponse(notify.substring(notify.indexOf(' ')));
        MapWrapper eventWrapper = eventRes.getWrapper();

        switch (eventName) {
            case "textmessage": {
                fireChatEvent(eventWrapper);
                break;
            }
            case "cliententerview": {
                break;
            }
            case "clientleftview": {
                break;
            }
            case "tokenused": {
                break;
            }
            default: {
                throw new RuntimeException("Encountered an unknown event: " + eventName);
            }
        }
        System.out.println(eventName + ": " + eventRes);
    }

    @SuppressWarnings("unchecked")
    public void registerListener(String eventClassName, String listenerName, Consumer<?> consumer) throws ClassNotFoundException {
        Class<? extends Event> eventClass = (Class<? extends Event>) Class.forName("net.sehales.ts3_japi.event." + eventClassName);
        addFunctionListener(eventClass, listenerName, consumer);
    }

    /**
     * Register methods of the given object which are marked as {@link EventHandler}s to listen to be called as listener for the appropriate
     * events, which are determined by the
     * parameter's class.
     * 
     * @param obj
     *            The object which shall be inspected for registering event handlers.
     */
    public void registerListeners(Object obj) {
        if (!CallableFunctionListener.isSupported()) {
            throw new UnsupportedOperationException("Usage of CallableFunctionListener is not supported! See log for more details.");
        }
        synchronized (lock) {
            for (Method me : obj.getClass().getMethods()) {
                EventHandler eh = me.getDeclaredAnnotation(EventHandler.class);
                if ((eh != null) && (me.getParameterCount() == 1)) {
                    Class<?> clazz = me.getParameterTypes()[0];
                    addMethodListener(clazz, obj, me);
                }
            }
        }
    }

    /**
     * Unregister listening methods of the given object.
     * 
     * @param obj
     *            The object which shall be inspected for unregistering event handlers.
     */
    public void unregisterListeners(Object obj) {
        synchronized (lock) {
            for (List<CallableListener> list : listenerMap.values()) {
                list.removeIf((cl) -> {
                    if (cl instanceof CallableMethodListener) {
                        CallableMethodListener cml = (CallableMethodListener) cl;
                        return (cml.getOwner() == obj) && cml.getOwner().equals(obj);
                    } else {
                        return false;
                    }
                });
            }
        }
    }

    /**
     * Unregister a listener by its name
     * 
     * @param name
     *            The name of the listene which should be unregistered.
     */
    public void unregisterListeners(String name) {
        synchronized (lock) {
            for (List<CallableListener> list : listenerMap.values()) {
                list.removeIf((cl) -> {
                    if (cl instanceof CallableFunctionListener) {
                        CallableFunctionListener cfl = (CallableFunctionListener) cl;
                        return cfl.getName().equals(name);
                    } else {
                        return false;
                    }
                });
            }
        }
    }
}

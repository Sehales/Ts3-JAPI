package net.sehales.ts3_japi.event;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CallableMethodListener implements CallableListener {
    private Method listener;
    private Object owner;

    CallableMethodListener(Method listener, Object owner) {
        this.listener = listener;
        this.owner = owner;
    }

    public <E extends Event> void call(E event) {
        try {
            listener.invoke(owner, event);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public Method getListener() {
        return listener;
    }

    public Object getOwner() {
        return owner;
    }
}

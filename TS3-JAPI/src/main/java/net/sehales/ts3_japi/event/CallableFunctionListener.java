package net.sehales.ts3_japi.event;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.function.Consumer;

public class CallableFunctionListener implements CallableListener {

    private static Method ACCEPT_METHOD;
    static {
        try {
            ACCEPT_METHOD = Consumer.class.getMethod("accept", Object.class);
        } catch (NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }
    }

    public static boolean isSupported() {
        return ACCEPT_METHOD != null;
    }

    private String      name;

    private Consumer<?> consumer;

    public CallableFunctionListener(String name, Consumer<?> consumer) {
        this.name = name;
        this.consumer = consumer;
    }

    @Override
    public <E extends Event> void call(E event) {
        try {
            ACCEPT_METHOD.invoke(consumer, event);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }
}

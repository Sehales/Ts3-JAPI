package net.sehales.ts3_japi.event;

public interface CallableListener {
    public <E extends Event> void call(E event);
}

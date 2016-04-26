package net.sehales.ts3_japi.event;

public interface CallableListener {
    <E extends Event> void call(E event);
}

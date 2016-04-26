package net.sehales.ts3_japi.event;

import net.sehales.ts3_japi.ServerQuery;
import net.sehales.ts3_japi.wrapper.MapWrapper;

public abstract class Event {
    protected ServerQuery query;

    public Event(ServerQuery query, MapWrapper eventWrapper) {
        this.query = query;
    }
}

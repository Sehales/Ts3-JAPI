package net.sehales.ts3_japi.event;

import net.sehales.ts3_japi.ServerQuery;
import net.sehales.ts3_japi.wrapper.MapWrapper;

public class ServerChatEvent extends ChatEvent {

    public ServerChatEvent(ServerQuery query, MapWrapper wrapper) {
        super(query, wrapper);
    }

}

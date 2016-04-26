package net.sehales.ts3_japi.event;

import net.sehales.ts3_japi.ServerQuery;
import net.sehales.ts3_japi.wrapper.MapWrapper;

public class ChannelChatEvent extends ChatEvent {

    public ChannelChatEvent(ServerQuery query, MapWrapper wrapper) {
        super(query, wrapper);
    }

}

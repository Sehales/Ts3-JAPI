package net.sehales.ts3_japi.event;

import net.sehales.ts3_japi.ServerQuery;
import net.sehales.ts3_japi.property.EventProperty;
import net.sehales.ts3_japi.wrapper.MapWrapper;

public class PrivateChatEvent extends ChatEvent {

    protected int targetClientId;

    public PrivateChatEvent(ServerQuery query, MapWrapper wrapper) {
        super(query, wrapper);
        targetClientId = wrapper.getInt(EventProperty.Chat.TARGET);
    }

    public int getTargetClientId() {
        return targetClientId;
    }

}

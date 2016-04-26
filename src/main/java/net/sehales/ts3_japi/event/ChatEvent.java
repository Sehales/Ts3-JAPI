package net.sehales.ts3_japi.event;

import java.util.HashMap;
import java.util.Map;

import net.sehales.ts3_japi.ServerQuery;
import net.sehales.ts3_japi.property.EventProperty;
import net.sehales.ts3_japi.wrapper.MapWrapper;

public class ChatEvent extends Event {
    public enum MessageType {
        PRIVATE(1), CHANNEL(2), SERVER(3);
        private static Map<Integer, MessageType> indexMapping = new HashMap<>();

        static {
            for (MessageType type : values()) {
                addReference(type);
            }
        }

        private static void addReference(MessageType type) {
            indexMapping.put(type.getIndex(), type);
        }

        /**
         * 
         * @param index
         *            Integer between 1 and 3
         * @return if <code>index == 1</code> it returns {@link #PRIVATE} </br>if <code>index == 2</code> it returns {@link #CHANNEL} </br>if <code>index == 3</code> it
         *         returns {@link #SERVER}
         */
        public static MessageType getByIndex(int index) {
            return indexMapping.get(index);
        }

        private int index;

        MessageType(int index) {
            this.index = index;
        }

        public int getIndex() {
            return index;
        }
    }

    protected String      message;
    protected String      senderName;
    protected int         senderClientId;
    protected String      senderUId;
    protected int         targetMode;
    protected MessageType type;

    public ChatEvent(ServerQuery query, MapWrapper wrapper) {
        super(query, wrapper);
        message = wrapper.getString(EventProperty.Chat.MSG);
        senderName = wrapper.getString(EventProperty.Chat.INVOKERNAME);
        senderClientId = wrapper.getInt(EventProperty.Chat.INVOKERID);
        senderUId = wrapper.getString(EventProperty.Chat.INVOKERUID);
        targetMode = wrapper.getInt(EventProperty.Chat.TARGETMODE);
        type = MessageType.getByIndex(targetMode);
    }

    public String getMessage() {
        return message;
    }

    public MessageType getMessageType() {
        return type;
    }

    public int getSenderClientId() {
        return senderClientId;
    }

    public String getSenderName() {
        return senderName;
    }

    public String getSenderUniqueId() {
        return senderUId;
    }

    public int getTargetMode() {
        return targetMode;
    }

}

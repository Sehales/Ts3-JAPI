package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;
import net.sehales.ts3_japi.property.TokenProperty;
import net.sehales.ts3_japi.property.TokenType;

public class CmdPrivilegeKeyAdd extends ArrayResponseCommand {

    /**
     * if type == {@link TokenType#SERVER_GROUP} channelId will be ignored, otherwise groupId has to be a channelId and channelId has to be a valid
     * channel
     * 
     * @param type
     * @param groupId
     * @param channelId
     */
    public CmdPrivilegeKeyAdd(TokenType type, int groupId, int channelId) {
        super("privilegekeyadd");
        add(new KeyValueParameter("tokentype", type.getIndex()));
        add(new KeyValueParameter("tokenid1", groupId));
        add(new KeyValueParameter("tokenid2", type == TokenType.CHANNEL_GROUP ? channelId : 0));
    }

    public CmdPrivilegeKeyAdd(TokenType type, int groupId, int channelId, String description) {
        this(type, groupId, channelId);
        add(new KeyValueParameter("tokendescription", description));
    }

    public CmdPrivilegeKeyAdd(TokenType type, int groupId, int channelId, String description, String customSet) {
        this(type, groupId, channelId, description);
        add(new KeyValueParameter("tokencustomset", customSet));
    }

    /**
     * @return the newly-created token
     */
    @Override
    public String getResponseWrapper() {
        return response.getWrapper().getString(TokenProperty.TOKEN);
    }
}

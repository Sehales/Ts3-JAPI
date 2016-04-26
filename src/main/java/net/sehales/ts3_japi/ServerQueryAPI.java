package net.sehales.ts3_japi;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;

import net.sehales.ts3_japi.command.CmdQuit;
import net.sehales.ts3_japi.command.CmdServerCreate;
import net.sehales.ts3_japi.command.CmdServerInfo;
import net.sehales.ts3_japi.command.CmdServerList;
import net.sehales.ts3_japi.command.CmdUse;
import net.sehales.ts3_japi.command.Command;
import net.sehales.ts3_japi.exception.APIException;
import net.sehales.ts3_japi.property.VirtualServerProperty;
import net.sehales.ts3_japi.util.QueryUtils;
import net.sehales.ts3_japi.util.ResponseUtil;
import net.sehales.ts3_japi.wrapper.Server;
import net.sehales.ts3_japi.wrapper.ServerCreationInfo;
import net.sehales.ts3_japi.wrapper.ServerInfo;

public class ServerQueryAPI {
    private ServerQuery             query;
    private ObjectProperty<Command> lastCommand = new SimpleObjectProperty<>();

    @SuppressWarnings("unused")
    private ServerQueryAPI() {}

    ServerQueryAPI(ServerQuery query) {
        this.query = query;
    }

    void close() {
        query = null;
        lastCommand = null;
    }

    public Command getLastCommand() {
        return lastCommandProperty().getValue();
    }

    public ObjectProperty<Command> lastCommandProperty() {
        return lastCommand;
    }

    /**
     * Ends a server query session/connection.
     * 
     * </br>Can be omitted, when closing the socket properly
     * 
     * @return true of the command succeeded
     * 
     * @throws APIException
     *             if something fails while sending the command and/or receiving an error message or result
     */
    public APIResponse<CmdQuit, Boolean> quit() {
        CmdQuit quitCmd = new CmdQuit();
        send(quitCmd);
        return new APIResponse<>(quitCmd, (cmd) -> cmd.getError().isOk());
    }

    private void send(Command cmd) {
        if (query.send(cmd)) {
            setLastCommand(cmd);
        } else {
            throw new APIException("Failed to send command: " + cmd.buildString());
        }
    }

    public APIResponse<CmdServerCreate, ServerCreationInfo> serverCreate(String name, int port, int slots, boolean autostart) {
        CmdServerCreate createCmd = new CmdServerCreate();
        if (name != null) {
            createCmd.addParameter(VirtualServerProperty.VIRTUALSERVER_NAME, name);
        }

        if (port > -1) {
            createCmd.addParameter(VirtualServerProperty.VIRTUALSERVER_PORT, port);
        }

        if (slots > -1) {
            createCmd.addParameter(VirtualServerProperty.VIRTUALSERVER_MAXCLIENTS, slots);
        }

        createCmd.addParameter(VirtualServerProperty.VIRTUALSERVER_AUTOSTART, QueryUtils.toInt(autostart));

        send(createCmd);

        APIResponse<CmdServerCreate, ServerCreationInfo> res = new APIResponse<>(createCmd, (cmd) -> new ServerCreationInfo(cmd.getResponseWrapper()));
        return res;
    }

    /**
     * Request detailed information about the selected virtual server (or the virtual server template, if no virtual server is selected)
     * 
     * @return An {@link APIResponse} with the appropriate wrapper for the result.
     */
    public APIResponse<CmdServerInfo, ServerInfo> serverInfo() {
        CmdServerInfo infoCmd = new CmdServerInfo();
        send(infoCmd);
        APIResponse<CmdServerInfo, ServerInfo> res = new APIResponse<>(infoCmd, (cmd) -> new ServerInfo(cmd.getResponseWrapper()));
        return res;
    }

    /**
     * Get a list of all servers present in the database.
     * 
     * This also contains servers which are running in another instance, but are stored in the same database.
     * 
     * @return The server list
     * @throws APIException
     *             if something fails while sending the command and/or receiving an error message or result
     */
    public APIResponse<CmdServerList, ObservableList<Server>> serverList() {
        CmdServerList listCmd = new CmdServerList().all().uid();
        send(listCmd);
        APIResponse<CmdServerList, ObservableList<Server>> res = new APIResponse<>(listCmd, (cmd) ->
        ResponseUtil.convertServerListResponse(cmd.getResponseWrapper())
                        );
        return res;
    }

    private void setLastCommand(final Command lastCommand) {
        lastCommandProperty().setValue(lastCommand);
    }

    /**
     * Select a virtual server by id.
     * 
     * @param id
     *            the server id
     * @param selectVirtual
     *            false selects the server normally, true selects it virtually (doesn't start it)
     * @return true if the command was successful
     * @throws APIException
     *             if something fails while sending the command and/or receiving an error message or result
     */
    public APIResponse<CmdUse, Boolean> use(int id, boolean selectVirtual) {
        CmdUse useCmd = new CmdUse(id);
        if (selectVirtual) {
            useCmd.virtual();
        }
        send(useCmd);
        return new APIResponse<>(useCmd, (cmd) -> cmd.getError().isOk());
    }

    /**
     * Select a virtual server by port.
     * 
     * @param id
     *            the server id
     * @param selectVirtual
     *            false selects the server normally, true selects it virtually (doesn't start it)
     * @return true if the command was successful
     * @throws APIException
     *             if something fails while sending the command and/or receiving an error message or result
     */
    public APIResponse<CmdUse, Boolean> useByPort(int port, boolean selectVirtual) {
        CmdUse useCmd = new CmdUse().withPort(port);
        if (selectVirtual) {
            useCmd.virtual();
        }
        send(useCmd);
        return new APIResponse<>(useCmd, (cmd) -> cmd.getError().isOk());
    }
}

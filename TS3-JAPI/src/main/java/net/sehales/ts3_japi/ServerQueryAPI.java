package net.sehales.ts3_japi;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import net.sehales.ts3_japi.command.CmdServerList;
import net.sehales.ts3_japi.command.Command;
import net.sehales.ts3_japi.util.ResponseUtil;
import net.sehales.ts3_japi.wrapper.Server;

public class ServerQueryAPI {
    private ServerQuery             query;
    private ObjectProperty<Command> lastCommand = new SimpleObjectProperty<>();

    @SuppressWarnings("unused")
    private ServerQueryAPI() {}

    ServerQueryAPI(ServerQuery query) {
        this.query = query;
    }

    public Command getLastCommand() {
        return lastCommandProperty().getValue();
    }

    public ObjectProperty<Command> lastCommandProperty() {
        return lastCommand;
    }

    private void send(Command cmd) {
        query.send(cmd);
        setLastCommand(cmd);
    }

    /**
     * Get a list of all servers present in the database.
     * 
     * This also contains servers which are running in another instance, but are stored in the same database.
     * 
     * @return The server list.
     */
    public ObservableList<Server> serverList() {
        CmdServerList cmd = new CmdServerList().all().uid();
        send(cmd);
        if (!cmd.hasResponse()) {
            return FXCollections.observableArrayList();
        }
        return ResponseUtil.convertServerListResponse(cmd.getResponseWrapper());
    }

    private void setLastCommand(final Command lastCommand) {
        lastCommandProperty().setValue(lastCommand);
    }
}

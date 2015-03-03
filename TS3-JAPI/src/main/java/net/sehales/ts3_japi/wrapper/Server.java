package net.sehales.ts3_japi.wrapper;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import net.sehales.ts3_japi.property.VirtualServerProperty;

public class Server implements Wrapper {
    protected StringProperty  name               = new SimpleStringProperty();
    protected IntegerProperty id                 = new SimpleIntegerProperty();
    protected IntegerProperty port               = new SimpleIntegerProperty();
    protected StringProperty  status             = new SimpleStringProperty();
    protected IntegerProperty clientsOnline      = new SimpleIntegerProperty();
    protected IntegerProperty queryClientsOnline = new SimpleIntegerProperty();
    protected IntegerProperty maxClients         = new SimpleIntegerProperty();
    protected LongProperty    uptime             = new SimpleLongProperty();
    protected IntegerProperty machineId          = new SimpleIntegerProperty();
    protected StringProperty  uid                = new SimpleStringProperty();
    protected BooleanProperty autostart          = new SimpleBooleanProperty();

    public Server(MapWrapper serverWrapper) {
        setName(serverWrapper.getOString(VirtualServerProperty.VIRTUALSERVER_NAME).orElse("unknown"));
        setId(serverWrapper.getOInt(VirtualServerProperty.VIRTUALSERVER_ID).orElse(-1));
        setPort(serverWrapper.getOInt(VirtualServerProperty.VIRTUALSERVER_PORT).orElse(-1));
        setStatus(serverWrapper.getOString(VirtualServerProperty.VIRTUALSERVER_STATUS).orElse("unknown"));
        setClientsOnline(serverWrapper.getOInt(VirtualServerProperty.VIRTUALSERVER_CLIENTSONLINE).orElse(-1));
        setQueryClientsOnline(serverWrapper.getOInt(VirtualServerProperty.VIRTUALSERVER_QUERYCLIENTSONLINE).orElse(-1));
        setMaxClients(serverWrapper.getOInt(VirtualServerProperty.VIRTUALSERVER_MAXCLIENTS).orElse(-1));
        setUptime(serverWrapper.getOLong(VirtualServerProperty.VIRTUALSERVER_UPTIME).orElse(0L));
        setMachineId(serverWrapper.getOInt(VirtualServerProperty.VIRTUALSERVER_MACHINE_ID).orElse(-1));
        setUid(serverWrapper.getOString(VirtualServerProperty.VIRTUALSERVER_UNIQUE_IDENTIFER).orElse("unknown"));
        setAutostart(serverWrapper.getOBoolean(VirtualServerProperty.VIRTUALSERVER_AUTOSTART).orElse(false));
    }

    public BooleanProperty autostartProperty() {
        return autostart;
    }

    public IntegerProperty clientsOnlineProperty() {
        return clientsOnline;
    }

    public java.lang.Boolean getAutostart() {
        return autostartProperty().getValue();
    }

    public Integer getClientsOnline() {
        return clientsOnlineProperty().getValue();
    }

    public Integer getId() {
        return idProperty().getValue();
    }

    public Integer getMachineId() {
        return machineIdProperty().getValue();
    }

    public Integer getMaxClients() {
        return maxClientsProperty().getValue();
    }

    public String getName() {
        return nameProperty().getValue();
    }

    public Integer getPort() {
        return portProperty().getValue();
    }

    public Integer getQueryClientsOnline() {
        return queryClientsOnlineProperty().getValue();
    }

    public String getStatus() {
        return statusProperty().getValue();
    }

    public String getUid() {
        return uidProperty().getValue();
    }

    public Long getUptime() {
        return uptimeProperty().getValue();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public IntegerProperty machineIdProperty() {
        return machineId;
    }

    public IntegerProperty maxClientsProperty() {
        return maxClients;
    }

    public StringProperty nameProperty() {
        return name;
    }

    public IntegerProperty portProperty() {
        return port;
    }

    public IntegerProperty queryClientsOnlineProperty() {
        return queryClientsOnline;
    }

    public void setAutostart(final Boolean autostart) {
        autostartProperty().setValue(autostart);
    }

    public void setClientsOnline(final Integer clientsOnline) {
        clientsOnlineProperty().setValue(clientsOnline);
    }

    public void setId(final Integer id) {
        idProperty().setValue(id);
    }

    public void setMachineId(final Integer machineId) {
        machineIdProperty().setValue(machineId);
    }

    public void setMaxClients(final Integer maxClients) {
        maxClientsProperty().setValue(maxClients);
    }

    public void setName(final java.lang.String name) {
        nameProperty().setValue(name);
    }

    public void setPort(final Integer port) {
        portProperty().setValue(port);
    }

    public void setQueryClientsOnline(final Integer queryClientsOnline) {
        queryClientsOnlineProperty().setValue(queryClientsOnline);
    }

    public void setStatus(final String status) {
        statusProperty().setValue(status);
    }

    public void setUid(final String uid) {
        uidProperty().setValue(uid);
    }

    public void setUptime(final Long uptime) {
        uptimeProperty().setValue(uptime);
    }

    public StringProperty statusProperty() {
        return status;
    }

    @Override
    public String toString() {
        return "Server [name=" + name + ", id=" + id + ", port=" + port + ", status=" + status + ", clientsOnline=" + clientsOnline + ", queryClientsOnline=" + queryClientsOnline + ", maxClients="
                        + maxClients + ", uptime=" + uptime + ", machineId=" + machineId + ", uid=" + uid + ", autostart=" + autostart + "]";
    }

    public StringProperty uidProperty() {
        return uid;
    }

    public LongProperty uptimeProperty() {
        return uptime;
    }

}

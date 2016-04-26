package net.sehales.ts3_japi.wrapper;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import net.sehales.ts3_japi.property.ServerCreateProperty;

public class ServerCreationInfo implements Wrapper {
    public StringProperty  token = new SimpleStringProperty();
    public IntegerProperty port  = new SimpleIntegerProperty();
    public IntegerProperty sid   = new SimpleIntegerProperty();

    public ServerCreationInfo(MapWrapper wrapper) {
        token.set(wrapper.getString(ServerCreateProperty.TOKEN));
        port.set(wrapper.getInt(ServerCreateProperty.VIRTUALSERVER_PORT));
        sid.set(wrapper.getInt(ServerCreateProperty.SID));
    }

    public Integer getPort() {
        return portProperty().getValue();
    }

    public Integer getSid() {
        return sidProperty().getValue();
    }

    public String getToken() {
        return tokenProperty().getValue();
    }

    public IntegerProperty portProperty() {
        return port;
    }

    public void setPort(final Integer port) {
        portProperty().setValue(port);
    }

    public void setSid(final Integer sid) {
        sidProperty().setValue(sid);
    }

    public void setToken(final String token) {
        tokenProperty().setValue(token);
    }

    public IntegerProperty sidProperty() {
        return sid;
    }

    public StringProperty tokenProperty() {
        return token;
    }

}

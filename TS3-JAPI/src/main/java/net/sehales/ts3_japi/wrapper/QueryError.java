package net.sehales.ts3_japi.wrapper;

import java.util.Map;

import net.sehales.ts3_japi.property.ErrorProperty;

public class QueryError extends MapWrapper {

    public QueryError(Map<String, String> data) {
        super(data);
    }

    public String getExtraMessage() {
        return getString(ErrorProperty.EXTRA_MSG);
    }

    public int getId() {
        return getInt(ErrorProperty.ID);
    }

    public String getMessage() {
        return getString(ErrorProperty.MSG);
    }

    /**
     * 
     * @return true if <code>getId() == 0</code>, false otherwise
     */
    public boolean isOk() {
        return getId() == 0;
    }
}

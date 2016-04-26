package net.sehales.ts3_japi.property;

public enum EventProperty implements Property {
    REASONID;

    public enum Chat implements Property {
        MSG, INVOKERNAME, INVOKERID, INVOKERUID, TARGETMODE, TARGET;

        @Override
        public String toString() {
            return name().toLowerCase();
        }
    }

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}

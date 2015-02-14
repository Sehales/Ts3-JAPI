package net.sehales.ts3_japi.property;

public enum GroupProperty implements Property {
    ICONID,
    SAVEDB,
    SORTID,
    NAME,
    N_MEMBER_REMOVEP,

    /**
     * server group id
     */
    SGID,

    /**
     * channel group id
     */
    CGID,
    TYPE,
    N_MEMBER_ADDP,
    NAMEMODE,
    N_MODIFYP;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}

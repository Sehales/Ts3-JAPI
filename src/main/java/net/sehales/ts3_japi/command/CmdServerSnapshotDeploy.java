package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.RawParameter;

public class CmdServerSnapshotDeploy extends Command {

    public CmdServerSnapshotDeploy(String snapshot) {
        super("serversnapshotdeploy");
        add(new RawParameter(snapshot));
    }

}

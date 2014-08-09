package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.wrapper.Wrapper;

public class CmdQuit extends Command {

    public CmdQuit() {
        super("quit");
    }

    /**
     * The quit command is a final command that does not support any response
     * 
     * @throws UnsupportedOperationException
     */
    @Override
    public Wrapper getResponseWrapper() {
        throw new UnsupportedOperationException("The quit command is a final command that does not support any response!");
    }

}

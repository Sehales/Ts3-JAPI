package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.response.ArrayResponse;

// TODO refactor classes to extend this class instead of normal Command.class if needed
public abstract class ArrayResponseCommand extends Command {
    protected ArrayResponse response;

    public ArrayResponseCommand(String command) {
        super(command);
    }

    @Override
    public void feedResponse(String line) {
        response = new ArrayResponse(line);
    }

    @Override
    public ArrayResponse getResponse() {
        return response;
    }

}

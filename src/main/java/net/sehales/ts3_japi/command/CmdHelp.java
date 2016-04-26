package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.ValueParameter;
import net.sehales.ts3_japi.command.response.AppendableResponse;
import net.sehales.ts3_japi.wrapper.GlobalCommandHelp;
import net.sehales.ts3_japi.wrapper.HelpWrapper;
import net.sehales.ts3_japi.wrapper.SingleCommandHelp;

public class CmdHelp extends Command {
    public static final int    SINGLE_CMD_HELP = 0;
    public static final int    GLOBAL_CMD_HELP = 1;

    private int                cmdType         = GLOBAL_CMD_HELP;
    private AppendableResponse response        = new AppendableResponse();

    public CmdHelp() {
        super("help");
    }

    public CmdHelp(String subCommand) {
        this();
        add(new ValueParameter(subCommand));
        cmdType = SINGLE_CMD_HELP;
    }

    @Override
    public void feedResponse(String line) {
        response.append(line);
    }

    public GlobalCommandHelp getGlobalCmdHelp() {
        return cmdType == GLOBAL_CMD_HELP ? new GlobalCommandHelp(response) : null;
    }

    @Override
    public AppendableResponse getResponse() {
        return response;
    }

    public HelpWrapper getResponseWrapper() {
        switch (cmdType) {
            case SINGLE_CMD_HELP: {
                return new SingleCommandHelp(response);
            }
            case GLOBAL_CMD_HELP: {
                return new GlobalCommandHelp(response);
            }
        }
        return null;
    }

    public SingleCommandHelp getSingleCmdHelp() {
        return cmdType == SINGLE_CMD_HELP ? new SingleCommandHelp(response) : null;
    }

    public int getType() {
        return cmdType;
    }

    @Override
    public boolean hasResponse() {
        return !response.getRawResponse().isEmpty();
    }
}

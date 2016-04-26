package net.sehales.ts3_japi.wrapper;

import java.util.LinkedList;

import net.sehales.ts3_japi.command.response.AppendableResponse;

public class SingleCommandHelp implements HelpWrapper {

    private String usage       = "";
    private String description = "";
    private String example     = "";

    public SingleCommandHelp(AppendableResponse response) {
        parseResponse(response);
    }

    public String getDescription() {
        return description;
    }

    public String getExample() {
        return example;
    }

    public String getUsage() {
        return usage;
    }

    // TODO optimize/fix at some commands it fails...
    protected void parseResponse(AppendableResponse response) {
        LinkedList<String> lines = new LinkedList<>(response.getLines());
        String line = lines.poll();
        usage += line.substring(line.indexOf(' ') + 1);
        line = lines.poll();

        do {
            System.out.println(line);
            usage += line.trim();
        } while ((line = lines.poll()).startsWith(" "));

        do {
            description += line;
        } while (!(line = lines.poll()).startsWith("Example:"));
        line = lines.poll();
        do {
            example += line.trim() + "\n";
        } while ((line = lines.poll()) != null);
    }

    @Override
    public String toString() {
        return String.format("Usage: %s\nDescription: %s\nExample: %s", usage, description, example);
    }
}

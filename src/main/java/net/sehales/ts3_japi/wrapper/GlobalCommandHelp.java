package net.sehales.ts3_japi.wrapper;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sehales.ts3_japi.command.response.AppendableResponse;

public class GlobalCommandHelp implements HelpWrapper {
    private Map<String, String>  helpMap        = new HashMap<>();
    private static final Pattern cmdHelpPattern = Pattern.compile("\\s+([a-z]+)\\s+[|]{1}\\s{1}(.+)");

    public GlobalCommandHelp(AppendableResponse response) {
        parseResponse(response);
    }

    public String getHelp(String command) {
        return helpMap.get(command);
    }

    public Map<String, String> getHelpMap() {
        return helpMap;
    }

    protected void parseResponse(AppendableResponse response) {
        LinkedList<String> lines = new LinkedList<>(response.getLines());
        String check;
        do {
            check = lines.poll();
        } while (!check.startsWith("Command Overview:"));

        for (String line : lines) {
            Matcher matcher = cmdHelpPattern.matcher(line);
            if (matcher.find()) {
                helpMap.put(matcher.group(1), matcher.group(2));
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Entry<String, String> e : helpMap.entrySet()) {
            sb.append(String.format(", [%s]='%s'", e.getKey(), e.getValue()));
        }

        return sb.substring(2);

    }
}

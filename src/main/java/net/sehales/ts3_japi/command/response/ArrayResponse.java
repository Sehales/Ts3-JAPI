package net.sehales.ts3_japi.command.response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sehales.ts3_japi.util.QueryUtils;
import net.sehales.ts3_japi.wrapper.MapWrapper;

public class ArrayResponse extends Response {
    private static Pattern            argumentFilter = Pattern.compile("\\s?(\\w+)[=]{1}([^\\s]+)\\s?");
    private List<Map<String, String>> data           = new ArrayList<>();

    public ArrayResponse(String rawResponse) {
        super(rawResponse);
        parseRawResponse(rawResponse);
    }

    public int dataSize() {
        return data.size();
    }

    public List<Map<String, String>> getData() {
        return data;
    }

    public Map<String, String> getMap() {
        return getMap(0);
    }

    public Map<String, String> getMap(int index) {
        return data.get(index);
    }

    public MapWrapper getWrapper() {
        return getWrapper(0);
    }

    public MapWrapper getWrapper(int index) {
        return new MapWrapper(data.get(index));
    }

    public List<MapWrapper> getWrapperList() {
        List<MapWrapper> list = new ArrayList<>();
        data.stream().forEach(map -> list.add(new MapWrapper(map)));
        return list;
    }

    private void parseLine(String line) {
        Map<String, String> map = new HashMap<>();
        Matcher matcher = argumentFilter.matcher(line);

        while (matcher.find()) {
            map.put(QueryUtils.decode(matcher.group(1)), QueryUtils.decode(matcher.group(2)));
        }

        data.add(map);
    }

    private void parseRawResponse(String rawResponse) {
        StringTokenizer tsArray = new StringTokenizer(rawResponse, "|");

        while (tsArray.hasMoreTokens()) {
            parseLine(tsArray.nextToken());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map<String, String> map : data) {
            for (Map.Entry<String, String> e : map.entrySet()) {
                sb.append(String.format("[%s] = \"%s\", ", e.getKey(), e.getValue()));
            }
            sb.append("|\n");
        }

        return sb.substring(0, sb.length() - 4);
    }
}

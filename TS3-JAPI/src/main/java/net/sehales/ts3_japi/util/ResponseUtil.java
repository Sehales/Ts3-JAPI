package net.sehales.ts3_japi.util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import net.sehales.ts3_japi.wrapper.MapWrapper;
import net.sehales.ts3_japi.wrapper.Server;

public class ResponseUtil {
    public static ObservableList<Server> convertServerListResponse(List<MapWrapper> wrapperList) {
        Stream<Server> s = wrapperList.parallelStream().map(ResponseUtil::convertToServer);
        return FXCollections.observableArrayList(s.collect(Collectors.toList()));
    }

    private static Server convertToServer(MapWrapper wrapper) {
        return new Server(wrapper);
    }
}

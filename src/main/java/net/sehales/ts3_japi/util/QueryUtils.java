package net.sehales.ts3_japi.util;

// found @ http://pastebin.com/hJJVjTit
public class QueryUtils {
    public static String decode(String str) {
        str = str.replace("\\\\", "\\[$mksave]"); // $mksave is just a placeholder
        str = str.replace("\\s", " ");
        str = str.replace("\\/", "/");
        str = str.replace("\\p", "|");
        str = str.replace("\\b", "\b");
        str = str.replace("\\f", "\f");
        str = str.replace("\\n", "\n");
        str = str.replace("\\r", "\r");
        str = str.replace("\\t", "\t");

        Character cBell = new Character((char) 7); // \a (not supported by Java)
        Character cVTab = new Character((char) 11); // \v (not supported by Java)

        str = str.replace("\\a", cBell.toString());
        str = str.replace("\\v", cVTab.toString());

        str = str.replace("\\[$mksave]", "\\");
        return str;
    }

    public static String encode(String str) {
        str = str.replace("\\", "\\\\");
        str = str.replace(" ", "\\s");
        str = str.replace("/", "\\/");
        str = str.replace("|", "\\p");
        str = str.replace("\b", "\\b");
        str = str.replace("\f", "\\f");
        str = str.replace("\n", "\\n");
        str = str.replace("\r", "\\r");
        str = str.replace("\t", "\\t");

        Character cBell = new Character((char) 7); // \a (not supported by Java)
        Character cVTab = new Character((char) 11); // \v (not supported by Java)

        str = str.replace(cBell.toString(), "\\a");
        str = str.replace(cVTab.toString(), "\\v");

        return str;
    }

    public static int toInt(boolean b) {
        return b ? 1 : 0;
    }

}

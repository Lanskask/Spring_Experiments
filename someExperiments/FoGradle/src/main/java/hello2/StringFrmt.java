package hello2;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class StringFrmt {
    public static void main(String[] args) {
        StringFrmt stringFrmt = new StringFrmt();
        stringFrmt.run();
    }

    void run() {
        Map<String, Object> args = new HashMap<String, Object>();
        args.put("name", "NAME1");
        System.out.println(String.format("uno: %1$s, dos: %2$s", args.get("name"), 2));

        System.out.println(str2());
    }

    String str2() {
        Map<String, Object> args = new HashMap<String, Object>();
        args.put("PATH", "/usr/bin");
        args.put("file", "foo");
        String s = interpolate("#{PATH}/ls #{file}", args);
        return s;
    }

    public static String interpolate(String format, Map<String, ? extends Object> args) {
        String out = format;
        for (String arg : args.keySet()) {
            out = Pattern.compile(Pattern.quote("#{" + arg + "}")).
                    matcher(out).
                    replaceAll(args.get(arg).toString());
        }
        return out;
    }
}

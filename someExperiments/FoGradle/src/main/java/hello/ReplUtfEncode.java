package hello;

import java.nio.charset.Charset;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplUtfEncode {

    public static void main(String[] args) {
        ReplUtfEncode replUtfEncode = new ReplUtfEncode();
        replUtfEncode.run();
    }

    void run() {
//        System.out.println(this.getData2("ул"));
//        System.out.println(this.removeCaseTest());
//        this.caseInsInR();
        this.caseInsInR2();
    }

    void caseInsInR() {
        Pattern pattern = Pattern.compile("(?iu)\\b(" + Pattern.quote("напитк") + ")\\b", Pattern.UNICODE_CHARACTER_CLASS | Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
        System.out.println(pattern.matcher("some text газированных напитков some other text").find());
    }

    void caseInsInR2() {
        String stringToSearch = "Four score and ул seven years ago our fathers ...";

        // this won't work because the pattern is in upper-case
//        System.out.println("Try 1: " + stringToSearch.matches(".*SEVEN.*"));
        System.out.println("Try 1: " + stringToSearch.matches(".*УЛ.*"));

        // the magic (?i:X) syntax makes this search case-insensitive, so it returns true
        System.out.println("Try 2: " + stringToSearch.matches("(?i:.*УЛ.*)"));
    }

    String removeCaseTest() {
        System.out.println("УЛ правды".replaceAll("(?i)" + this.getData2("ул") + "\\s+", ""));
        System.out.println("FOO Bar".replaceAll("(?i)" + "foo\\s+", ""));
        return "----------";
    }

    public String getData2(String strToDecode) {
        byte[] strInBytes = strToDecode.getBytes(/*Charset.forName("windows-1251")*/);
        String resultString = new String(strInBytes, Charset.forName("UTF-8"));
        return resultString;
    }

    int convertOfBigDataWithMatcher(String compilePattern, List < String > strArrayToAnalyse) {
        Pattern p = Pattern.compile(compilePattern);
        Matcher m = p.matcher(this.fromItemsToCharSequence(strArrayToAnalyse)[0]);
        int idCol = -1;

        for (String columnName: strArrayToAnalyse) {
            if (m.find()) {
                idCol = strArrayToAnalyse.indexOf(columnName);
                break;
            }
        }

        return idCol;
    }

    CharSequence[] fromItemsToCharSequence(List< String > stringList) {
        return stringList.toArray(new CharSequence[stringList.size()]);
    }

}

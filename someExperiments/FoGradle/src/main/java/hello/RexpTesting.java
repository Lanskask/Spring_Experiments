package hello;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RexpTesting {

    static final List<String> REMOVE_WORD_STRING = Arrays.asList(new String[]{"улица", "ул.", "проспект", "пр-кт.", "микрорайон", "мкр.", "квартал", "кв-л.", "переулок", "пер.", "площадь", "пл.", "проезд", "проезд.", "тупик", "туп.", "бульвар", "б-р.", "набережная", "наб.", "просека", "просека.", "аллея", "аллея.", "станция", "ст.", "шоссе", "ш.", "километр", "км.", "территория", "тер.", "платформа", "платф.", "деревня", "д.", "дорога", "дор.", "линия", "линия.", "пер" });
    static final List<String> REMOVE_WORD_STRING_SHORT = Arrays.asList(new String[]{"ул.", "д."});
    String[] testVarables2 = new String[] {"ул.", "д."};

    String[] testVarables = new String[] {"ул. Правды", "ул.Правды", "Правды ул."};

    public static void main(String[] args) {
        RexpTesting rexp = new RexpTesting();
        rexp.run();
    }

    void run() {
        for (String testV : this.testVarables) {
            System.out.println( "littleRegxpTest: " + "testV: " + testV + "; ans: \t" + this.littleRegxpTest(testV));
        }
    }

    String littleRegxpTest(String inputText) {
//        String str1 = inputText.trim().replaceAll("\\s","");
        String str = new String();
        for (int i = 0; i < this.testVarables2.length; i++) {
            inputText = inputText.replaceAll(Matcher.quoteReplacement(this.testVarables2[i]), "");
        }
        return inputText;
    }

    String littleRegxpTest2(String inputText) {
//        String str1 = inputText.trim().replaceAll("\\s","");
//        String str = inputText.replaceAll("ул.", Matcher.quoteReplacement(""));
        String str = inputText.replaceAll(Matcher.quoteReplacement("ул."), "");
        return str;
    }

    private String getTextStreetSearch(String inputText) {
        for (String removeWord : this.REMOVE_WORD_STRING_SHORT) {
            String pattern = String.format("(?i)%s(\\s*|$)", removeWord.trim());
            inputText = inputText.replaceAll(pattern, "").trim();
        }
        return inputText;
    }

    private String getTextStreetSearch3(String inputText) {
        for (String removeWord : this.REMOVE_WORD_STRING_SHORT) { // (\s*|$)
            String pattern = String.format("(?i)(\\w*)%s(\\s*)", removeWord.trim());
            inputText = inputText.replaceAll(pattern, "").trim();
        }
        return inputText;
    }

    private String usePatternMatcher(String inputText) {
//        Pattern regex = Pattern.compile("(?i)%s(\\s*|$)", Pattern.LITERAL );
        Pattern regex = Pattern.compile("(?i)ул.(\\s*|$)", Pattern.LITERAL );
//        Matcher regexMatcher = regex.matcher(inputText);
        Matcher regexMatcher = Pattern.compile("(?i)ул.(\\s*|$)", Pattern.LITERAL ).matcher(inputText);

        String output = regexMatcher.replaceFirst("");  // number 46
        return output;
    }

    private String getTextStreetSearch2(String inputText) {
        String resultText = "";
        for (String removeWord :  this.REMOVE_WORD_STRING) {
            String pattern = String.format("(?i)%s(\\s+|$)", removeWord.trim());
            resultText = inputText.replaceAll(pattern, "").trim();
        }
        return resultText;
    }

    String clearSpaces(String inputText) {
        return inputText.trim().replaceAll("\\s\\s+"," ");
    }
}

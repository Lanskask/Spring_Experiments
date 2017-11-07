package hello;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.nio.charset.StandardCharsets.UTF_8;

public class RexpTesting {
    ArrayList<String> allVars = new ArrayList<>(20);

    static final List<String> REMOVE_WORD_STRING = Arrays.asList(new String[]{"улица", "ул.", "ул", "проспект", "пр-кт.", "микрорайон", "мкр.", "квартал", "кв-л.", "переулок", "пер.", "пер","площадь", "пл","пл.", "проезд", "проезд.", "тупик", "туп.", "бульвар", "б-р.", "набережная", "наб.", "просека", "просека.", "аллея", "аллея.", "станция", "ст.", "шоссе", "ш.", "километр", "км.", "территория", "тер.", "платформа", "платф.", "деревня", "д.", "дорога", "дор.", "линия", "линия.", "пер" });
    static final List<String> REMOVE_WORD_STRING_SHORT = Arrays.asList(new String[]{"ул.", "ул", "улица", "деревня", "д.", "д", "пл", "пл.", "пер", "пер."});

    String[] testVarables2 = new String[] {"ул.", "д."};

    String[] pravdVarables = new String[] {"ул. Правды", "ул.Правды", "Правды ул."};
    String[] pravdaVars2 = new String[] { "ул. Правды", "ул Правды", "улица Правды", "Правды"};
    String[] lazoVars = new String[] { "Лазо ул", "Лазо ул.", "Ул Лазо", "Пер. Лазо", "Пер Лазо"};
    String[] petrovaVars = new String[] { "Петрова пл", "Петрова пл." };
    String[] allSimpArr = new String[] {"ул. Правды", "ул.Правды", "Правды ул.", "ул Правды", "улица Правды", "Правды", "Лазо ул", "Лазо ул.", "Ул Лазо", "Пер. Лазо", "Пер Лазо", "Петрова пл", "Петрова пл.", "УЛ Карла Маркса" };

    List<String> allArray = new ArrayList<>();

    /*List<String> allVars1 = new ArrayList<>(Arrays.asList(this.petrovaVars));
    List<String> allVars2 = new ArrayList<>(Arrays.asList(this.petrovaVars));
    List<String> allVars3 = new ArrayList<>(Arrays.asList(this.petrovaVars));
    List<String> allVars4 = new ArrayList<>(Arrays.asList(this.petrovaVars));*/

    public static void main(String[] args) {
        RexpTesting rexp = new RexpTesting();
        rexp.run();
    }

    void run() {
        this.allArray = this.allArraysBuilder(this.pravdVarables, this.pravdaVars2, this.lazoVars, this.petrovaVars);

        /*for (String testV : this.pravdVarables) {
            System.out.println( "littleRegxpTest: " + "testV: " + testV + "; ans: \t" + this.littleRegxpTest(testV));
        }*/
        for (String testV : this.allSimpArr) {
            System.out.println( "splitBySpaces: testV: " + testV + "; ans: " + this.splitBySpaces(testV));
        }

//        this.printPreaty(this.pravdVarables, "getTextStreetSearch4");
//        this.printPreaty(this.pravdaVars2, "getTextStreetSearch4");
//        this.printPreaty(this.lazoVars, "getTextStreetSearch4");
//        this.printPreaty(this.petrovaVars, "getTextStreetSearch4");
//        System.out.println(this.removeCaseTest());

//        System.out.println(this.getTextStreetSearch5());
    }

    String splitBySpaces(String inputText) {
        List<String> parts;
        if (inputText.contains(".") && !inputText.contains(" ")) {
            parts = new ArrayList<>(Arrays.asList(inputText.split(Pattern.quote("."))));
        } else {
            parts = new ArrayList<>(Arrays.asList(inputText.split(" ")));
        }
        List<String> resultArr = parts;
        for (String removeWord : this.REMOVE_WORD_STRING) {
            for (int i = 0; i < resultArr.size(); i++) {
                if(resultArr.get(i).equalsIgnoreCase(removeWord)) {
                    parts.remove(i);
                }
            }
        }
        String answer;
        if(parts.size() > 1) {
            StringBuilder builder = new StringBuilder();
            for(String part: parts) builder.append(part + " ");
            answer = builder.toString();
        } else {
            answer = parts.get(0);
        }
        return answer;
    }

    //region While unneednt functions
    String getTextStreetSearch5(String inputText) {
        for (String removeWord : this.REMOVE_WORD_STRING) {
            // убрать пробелы - тоже самое что пользователь вводит без пробелов; без trim в конце - т.к. пробелы уже убраны
            inputText = inputText/*.replace(" ", "")*/.replaceAll(
                    "(?ui)" + removeWord.replace(".", "\\.\\s*"), ""
            ).trim();
        }
        return inputText;
    }

    void printPreaty(String[] varsArray, String textName) {
        for (String testV : varsArray) {
            System.out.println(textName + ": testV: " + testV + "; ans: \t" + this.getTextStreetSearch4(testV));
        }
        System.out.println("-------------");
    }

    String getTextStreetSearch4(String inputText) {
        for (String removeWord : this.REMOVE_WORD_STRING) {
            // убрать пробелы - тоже самое что пользователь вводит без пробелов; без trim в конце - т.к. пробелы уже убраны
//            inputText = inputText./*replace(" ", "").*/replaceAll("(?i)" + removeWord.replace(".", "\\."), "");
            inputText = inputText.replaceAll("(?i)" + removeWord, "");
        }
        return inputText;
    }

    String removeCaseTest() {
        System.out.println("FOO Bar".replaceAll("(?ui)" + "foo\\s+", ""));
        System.out.println("УЛ Правды".replaceAll("(?ui)" + "ул\\s+", ""));
        return "----------";
    }

    //region Exprs with regexp
    String getTextStreetSearch_init2(String inputText) {
        for (String removeWord : this.REMOVE_WORD_STRING_SHORT) {
            inputText = inputText.replace(" ", "").replaceAll("(?i)" + removeWord.replace(".", "\\."), "").trim();
        }
        return inputText;
    }

    String getTextStreetSearch_init3(String inputText) {
        for (String removeWord : this.REMOVE_WORD_STRING_SHORT) {
            String pattern = String.format("(?i)%s", removeWord.trim());
            String replPattern = removeWord.replace(".", "\\.");
            inputText = inputText.replaceAll("(?i)" + replPattern, "").trim();
        }
        return inputText;
    }

    String littleRegxpTest(String inputText) {
//        String str1 = inputText.trim().replaceAll("\\s","");
        String str = new String();
        for (int i = 0; i < this.testVarables2.length; i++) {
            String replPattern = this.testVarables2[i].replace(".", "\\.");
            System.out.println("replPattern: " + replPattern);
//            inputText = inputText.replaceAll(Matcher.quoteReplacement(replPattern), "");
//            inputText = inputText.replace(replPattern,"");
            inputText = inputText.replace("ул.","");
            inputText = inputText.replace("д.","");
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
    //endregion

    String clearSpaces(String inputText) {
        return inputText.trim().replaceAll("\\s\\s+"," ");
    }
    //endregion

    // For spliting string by " " (space)
    ArrayList<String> allArraysBuilder(String[] ...arrays) {
        ArrayList<String> allArr = new ArrayList<String>();
        for (String[] arr: arrays) {
            for (int i = 0; i < arr.length; i++) {
                allArr.add(arr[i]);
            }
        }
        return allArr;
    }

    void printSimpleArray(String[] array) {
        System.out.println("SimpArray: ");
        for (String arrP : array) {
            System.out.print(arrP + "; ");
        }
        System.out.println();
    }

    void printArrayList(List<String> array) {
        System.out.println("ArrayList: ");
        for (String arrP : array) {
            System.out.print(arrP + "; ");
        }
        System.out.println();
    }
}

package hello;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringConv {
    private static final String BIG_UNDECODED_STRING = "Р�РґРµРЅС‚РёС„РёРєР°С‚РѕСЂ&Р’РёРґРўРЎ&РњР°СЂС€СЂСѓС‚&Р”Р°С‚Р°_РІРІРѕРґР°&Р”Р°С‚Р°_РІС‹РІРѕРґР°&Р’РёРґ_РјР°СЂС€СЂСѓС‚Р°&Рђ_0&Р‘_0&A_1&Р‘_1&РњР’&РЎР’&Р‘Р’&РћР‘Р’&РћР”&Р”Р’&РўРёРїС‹_СЂР°СЃРїРёСЃР°РЅРёР№&Р РµР¶РёРјС‹_СЂР°Р±РѕС‚С‹&РџРѕРЅРµРґРµР»СЊРЅРёРє_1&Р’С‚РѕСЂРЅРёРє_1&РЎСЂРµРґР°_1&Р§РµС‚РІРµСЂРі_1&РџСЏС‚РЅРёС†Р°_1&РЎСѓР±Р±РѕС‚Р°_1&Р’РѕСЃРєСЂРµСЃРµРЅСЊРµ_1&РџСЂР°Р·РґРЅРёРєРё_1&РќР°С‡Р°Р»Рѕ_РїСЂСЏРјРѕРµ_1&РћРєРѕРЅС‡Р°РЅРёРµ_РїСЂСЏРјРѕРµ_1&РќР°С‡Р°Р»Рѕ_РѕР±СЂР°С‚РЅРѕРµ_1&РћРєРѕРЅС‡Р°РЅРёРµ_РѕР±СЂР°С‚РЅРѕРµ_1&РџРµСЂРёРѕРґС‹_РёРЅС‚РµСЂРІР°Р»РѕРІ_РїСЂСЏРјРѕР№_1&Р�РЅС‚РµСЂРІР°Р»С‹_РїСЂСЏРјРѕР№_1&РџРµСЂРёРѕРґС‹_РёРЅС‚РµСЂРІР°Р»РѕРІ_РѕР±СЂР°С‚РЅС‹Р№_1&Р�РЅС‚РµСЂРІР°Р»С‹_РѕР±СЂР°С‚РЅС‹Р№_1&РџРѕРЅРµРґРµР»СЊРЅРёРє_2&Р’С‚РѕСЂРЅРёРє_2&РЎСЂРµРґР°_2&Р§РµС‚РІРµСЂРі_2&РџСЏС‚РЅРёС†Р°_2&РЎСѓР±Р±РѕС‚Р°_2&Р’РѕСЃРєСЂРµСЃРµРЅСЊРµ_2&РџСЂР°Р·РґРЅРёРєРё_2&РќР°С‡Р°Р»Рѕ_РїСЂСЏРјРѕРµ_2&РћРєРѕРЅС‡Р°РЅРёРµ_РїСЂСЏРјРѕРµ_2&РќР°С‡Р°Р»Рѕ_РѕР±СЂР°С‚РЅРѕРµ_2&РћРєРѕРЅС‡Р°РЅРёРµ_РѕР±СЂР°С‚РЅРѕРµ_2&РџРµСЂРёРѕРґС‹_РёРЅС‚РµСЂРІР°Р»РѕРІ_РїСЂСЏРјРѕР№_2&Р�РЅС‚РµСЂРІР°Р»С‹_РїСЂСЏРјРѕР№_2&РџРµСЂРёРѕРґС‹_РёРЅС‚РµСЂРІР°Р»РѕРІ_РѕР±СЂР°С‚РЅС‹Р№_2&Р�РЅС‚РµСЂРІР°Р»С‹_РѕР±СЂР°С‚РЅС‹Р№_2&РџРѕРЅРµРґРµР»СЊРЅРёРє_3&Р’С‚РѕСЂРЅРёРє_3&РЎСЂРµРґР°_3&Р§РµС‚РІРµСЂРі_3&РџСЏС‚РЅРёС†Р°_3&РЎСѓР±Р±РѕС‚Р°_3&Р’РѕСЃРєСЂРµСЃРµРЅСЊРµ_3&РџСЂР°Р·РґРЅРёРєРё_3&РќР°С‡Р°Р»Рѕ_РїСЂСЏРјРѕРµ_3&РћРєРѕРЅС‡Р°РЅРёРµ_РїСЂСЏРјРѕРµ_3&РќР°С‡Р°Р»Рѕ_РѕР±СЂР°С‚РЅРѕРµ_3&РћРєРѕРЅС‡Р°РЅРёРµ_РѕР±СЂР°С‚РЅРѕРµ_3&РџРµСЂРёРѕРґС‹_РёРЅС‚РµСЂРІР°Р»РѕРІ_РїСЂСЏРјРѕР№_3&Р�РЅС‚РµСЂРІР°Р»С‹_РїСЂСЏРјРѕР№_3&РџРµСЂРёРѕРґС‹_РёРЅС‚РµСЂРІР°Р»РѕРІ_РѕР±СЂР°С‚РЅС‹Р№_3&Р�РЅС‚РµСЂРІР°Р»С‹_РѕР±СЂР°С‚РЅС‹Р№_3&РџРѕРЅРµРґРµР»СЊРЅРёРє_4&Р’С‚РѕСЂРЅРёРє_4&РЎСЂРµРґР°_4&Р§РµС‚РІРµСЂРі_4&РџСЏС‚РЅРёС†Р°_4&РЎСѓР±Р±РѕС‚Р°_4&Р’РѕСЃРєСЂРµСЃРµРЅСЊРµ_4&РџСЂР°Р·РґРЅРёРєРё_4&РќР°С‡Р°Р»Рѕ_РїСЂСЏРјРѕРµ_4&РћРєРѕРЅС‡Р°РЅРёРµ_РїСЂСЏРјРѕРµ_4&РќР°С‡Р°Р»Рѕ_РѕР±СЂР°С‚РЅРѕРµ_4&РћРєРѕРЅС‡Р°РЅРёРµ_РѕР±СЂР°С‚РЅРѕРµ_4&РџРµСЂРёРѕРґС‹_РёРЅС‚РµСЂРІР°Р»РѕРІ_РїСЂСЏРјРѕР№_4&Р�РЅС‚РµСЂРІР°Р»С‹_РїСЂСЏРјРѕР№_4&РџРµСЂРёРѕРґС‹_РёРЅС‚РµСЂРІР°Р»РѕРІ_РѕР±СЂР°С‚РЅС‹Р№_4&Р�РЅС‚РµСЂРІР°Р»С‹_РѕР±СЂР°С‚РЅС‹Р№_4&Р’Р°СЂРёР°РЅС‚_1_РёРґ&РўРёРї_РІР°СЂРёР°РЅС‚Р°_1&Р’РёРґ_РІР°СЂРёР°РЅС‚Р°_1&Р”Р»РёРЅР°_РІР°СЂРёР°РЅС‚Р°_1&РџРѕСЃР»РµРґРѕРІР°С‚РµР»СЊРЅРѕСЃС‚СЊ_РћРџ_РІР°СЂРёР°РЅС‚Р°_1&Р’Р°СЂРёР°РЅС‚_2_РёРґ&РўРёРї_РІР°СЂРёР°РЅС‚Р°_2&Р’РёРґ_РІР°СЂРёР°РЅС‚Р°_2&Р”Р»РёРЅР°_РІР°СЂРёР°РЅС‚Р°_2&РџРѕСЃР»РµРґРѕРІР°С‚РµР»СЊРЅРѕСЃС‚СЊ_РћРџ_РІР°СЂРёР°РЅС‚Р°_2&Р’Р°СЂРёР°РЅС‚_3_РёРґ&РўРёРї_РІР°СЂРёР°РЅС‚Р°_3&Р’РёРґ_РІР°СЂРёР°РЅС‚Р°_3&Р”Р»РёРЅР°_РІР°СЂРёР°РЅС‚Р°_3&РџРѕСЃР»РµРґРѕРІР°С‚РµР»СЊРЅРѕСЃС‚СЊ_РћРџ_РІР°СЂРёР°РЅС‚Р°_3&Р’Р°СЂРёР°РЅС‚_4_РёРґ&РўРёРї_РІР°СЂРёР°РЅС‚Р°_4&Р’РёРґ_РІР°СЂРёР°РЅС‚Р°_4&Р”Р»РёРЅР°_РІР°СЂРёР°РЅС‚Р°_4&РџРѕСЃР»РµРґРѕРІР°С‚РµР»СЊРЅРѕСЃС‚СЊ_РћРџ_РІР°СЂРёР°РЅС‚Р°_4&РџРµСЂРµРіРѕРЅС‹&РћСЃС‚Р°РЅРѕРІРєРё_1&РћСЃС‚Р°РЅРѕРІРєРё_2&Р”Р»РёРЅР°_РїРµСЂРµРіРѕРЅР°&Р РµР±СЂР°_РїРµСЂРµРіРѕРЅР°&РћСЃС‚Р°РЅРѕРІРєРё_РёРґ&РћСЃС‚Р°РЅРѕРІРєРё_РёРјСЏ&РћСЃС‚Р°РЅРѕРІРєРё_С€РёСЂРѕС‚Р°&РћСЃС‚Р°РЅРѕРІРєРё_РґРѕР»РіРѕС‚Р°&Р РµР±СЂРѕ_РіСЂР°С„Р°_РёРґ&Р РµР±СЂРѕ_РіСЂР°С„Р°_С‚СЂР°СЃСЃР°&Р РµР±СЂРѕ_РіСЂР°С„Р°_СЃРєРѕСЂРѕСЃС‚СЊ&РћР Рџ_РёРґ&РћР Рџ_РёРјСЏ&РћР Рџ_С€РёСЂРѕС‚Р°&РћР Рџ_РґРѕР»РіРѕС‚Р°14150082&РђРІС‚РѕР±СѓСЃ&667&02.06.2016&02.06.2021&РџРѕСЃС‚РѕСЏРЅРЅС‹Р№&";
    private static final List<String> DECODED_COLOMN_ARRAY = Arrays.asList(new String[] {"�?дентификатор", "ВидТС", "Маршрут", "Дата_ввода", "Дата_вывода", "Вид_маршрута", "А_0", "Б_0", "A_1", "Б_1", "МВ", "СВ", "БВ", "ОБВ", "ОД", "ДВ", "Типы_расписаний", "Режимы_работы", "Понедельник_1", "Вторник_1", "Среда_1", "Четверг_1", "Пятница_1", "Суббота_1", "Воскресенье_1", "Праздники_1"});

    public static void main(String[]args){
        StringConv stringConv = new StringConv();
        stringConv.run();
    }

    void run() {
        List<String> strArrayToAnalyse = this.convertData().get(0);
        System.out.println(
                "convertOfBigDataWithMatcher result: idCol: " +
                this.convertOfBigDataWithMatcher("дентификатор$", strArrayToAnalyse)

        );
        System.out.println(
                "convertOfBigDataWithMatcher2 result: idCol: " +
                this.convertOfBigDataWithMatcher2("дентификатор$", strArrayToAnalyse)
        );
//        this.testCustConvertFrcharToByteAndBack((byte) -48);
    }

    void testCustConvertFrcharToByteAndBack(byte b) {
        System.out.println("In testCustConvertFrcharToByteAndBack: where b = " + b + ": " + (b & 0xff) + " ");
        System.out.println("0xff: " + 0xff);
    }

    int convertOfBigDataWithMatcher(String compilePattern, List<String> strArrayToAnalyse) {
        Pattern p = Pattern.compile("дентификатор$");  // insert your pattern here
        Matcher m = p.matcher(this.fromItemsToCharSecuence(strArrayToAnalyse)[0]);

        int idCol = -1;
        for (String colomnName : strArrayToAnalyse ){
            if (m.find()) {
                idCol = strArrayToAnalyse.indexOf(colomnName);
                break;
            }
        }

        return idCol;
    }

    int convertOfBigDataWithMatcher2(String compilePattern, List<String> strArrayToAnalyse) {

        int idCol = -1;
//        for (int i = 0; i < strArrayToAnalyse.size(); i++) {
        for (int i = 0; i < strArrayToAnalyse.size(); i++) {
//            if(Pattern.matches(compilePattern, strArrayToAnalyse.get(i))) {
            Matcher m = Pattern.compile(compilePattern).matcher(strArrayToAnalyse.get(i));
            if(m.find()) {
                idCol = i;
                break;
            }
        }
        /*for (String colomnName : strArrayToAnalyse ){
            if(Pattern.matches(compilePattern, colomnName)) {
                idCol = strArrayToAnalyse.indexOf(colomnName);
                break;
            }
        }*/
        return idCol;
    }



    List<List<String>> convertData() {
        byte[] bytesFromWin1251 = this.BIG_UNDECODED_STRING.getBytes(Charset.forName("windows-1251"));
        String resultString = new String(bytesFromWin1251, Charset.forName("UTF-8"));

        List<List<String>> lines = Arrays.stream(resultString.split("\n"))
                .map(x -> Arrays.asList(x.split("&")))
                .collect(Collectors.toList());

        return lines;
    }

    CharSequence[] fromItemsToCharSecuence(List<String> stringList) {
        CharSequence[] cs = stringList.toArray(new CharSequence[stringList.size()]);
//        System.out.print("In fromItemsToCharSecuence: CharSequence[]: ");
//        this.printCharSecuenceArr(cs);
        return cs;
    }

    void printCharSecuenceArr(CharSequence[] csArr) {
        for (CharSequence cs : csArr ) {
            System.out.print(cs + ", ");
        }
        System.out.println("\n");
    }

    void convertingOfLitera() {
        String strToConvert = "И";
        System.out.println(
                new String(
                        strToConvert.getBytes(Charset.forName("windows-1251")),
                        Charset.forName("UTF-8")
                )
        );
    }

    void convertingOfBytes() {
        byte[] byteToConvert = new byte[5];
        byteToConvert[0] = -48;
        // System.out.println(new String(byteToConvert.getBytes(Charset.forName(("UTF-8")), Charset.forName("windows-1251") ));

        String text1 = new String(byteToConvert, Charset.forName("UTF-8"));
        System.out.println("text1" + text1);
    }
}

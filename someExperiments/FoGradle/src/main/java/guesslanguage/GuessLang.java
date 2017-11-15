package guesslanguage;

import com.google.common.base.Optional;
import com.optimaize.langdetect.LanguageDetector;
import com.optimaize.langdetect.LanguageDetectorBuilder;
import com.optimaize.langdetect.i18n.LdLocale;
import com.optimaize.langdetect.ngram.NgramExtractors;
import com.optimaize.langdetect.profiles.LanguageProfile;
import com.optimaize.langdetect.profiles.LanguageProfileReader;
import com.optimaize.langdetect.text.CommonTextObjectFactories;
import com.optimaize.langdetect.text.TextObject;
import com.optimaize.langdetect.text.TextObjectFactory;

import java.io.IOException;
import java.util.List;

public class GuessLang {
    public static void main(String[] args) {
        GuessLang guessLang = new GuessLang();
        guessLang.run();
    }

    void run() {
//        this.langFun();
        String str1 = "a1q2s3w4d5f6g7h8j9k0";
        System.out.println(str1.substring(0, 10));
    }

    void langFun() {
        try {
            List<LanguageProfile> languageProfiles = new LanguageProfileReader().readAllBuiltIn();

            //build language detector:
            LanguageDetector languageDetector = LanguageDetectorBuilder.create(NgramExtractors.standard())
                    .withProfiles(languageProfiles)
                    .build();
            //create a text object factory
            TextObjectFactory textObjectFactory = CommonTextObjectFactories.forDetectingOnLargeText();

            //query:
            TextObject textObject = textObjectFactory.forText("my text");
            Optional<LdLocale> lang = languageDetector.detect(textObject);

            System.out.println("Lang: " + lang);
        } catch (IOException ioe) {
            //load all languages:
            System.out.println(ioe);
        }
    }

}

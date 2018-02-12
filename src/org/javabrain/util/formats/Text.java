package org.javabrain.util.formats;

import java.io.IOException;
import java.util.zip.ZipFile;
import org.dts.spell.SpellChecker;
import org.dts.spell.dictionary.SpellDictionary;
import org.dts.spell.dictionary.openoffice.OpenOfficeSpellDictionary;
import org.javabrain.util.alerts.Message;

/**
 *
 * @author Fernando Isaías García Aguirre
 */
public class Text {
    
    private static boolean warning = true;
    private static Spell spell = Spell.getInstance();

    public static String check(String text){

        String texts[] = text.replace(".","").split(" ");
        String out = "";

            SpellChecker checker = spell.getChecker();
            checker.setCaseSensitive(false);
            String word = "";
            String suggetion[];
            String words = "";

            for (int i = 0; i < texts.length; i++) {

                words = "";
                try{
                    word = checker.hasSpellErrors(texts[i]).getFirstSuggestion();
                    suggetion = checker.hasSpellErrors(texts[i]).getSuggestions();
                    for (int j = 0; j < suggetion.length; j++){

                        if( j == 0){
                            words = words +suggetion[j]+"\n";
                        }else{
                            words = words +" - "+suggetion[j]+"\n";
                        }
                    }

                    if (warning) {
                        Message.warning(texts[i] + " fue cambiado por: " + words);
                    }

                }catch (Exception e){
                    word = texts[i];
                }

                if(word != null) {
                    out = out +" "+ word;
                }

            }

        
        return upperFirst(out.substring(1,out.length())+".");
    }

    public static String upperFirst(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        } else {
            return str.substring(0, 1).toUpperCase() + str.substring(1);
        }
    }

    public static void addIgnore(String text){
        spell.getChecker().addIgnore(text);
    }

    public static boolean isCorrect(String text){
        return spell.getChecker().isCorrect(text);
    }
}

class Spell {

    private SpellDictionary dict;
    private SpellChecker checker;

    private static Spell ourInstance = new Spell();

    public static Spell getInstance() {
        return ourInstance;
    }

    private Spell() {

        try {
            dict = new OpenOfficeSpellDictionary(new ZipFile("es_MX.zip"));
            checker = new SpellChecker(dict);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public SpellChecker getChecker() {
        return checker;
    }

    public void setChecker(SpellChecker checker) {
        this.checker = checker;
    }
}
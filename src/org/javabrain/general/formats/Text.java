package org.javabrain.general.formats;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipFile;
import org.dts.spell.SpellChecker;
import org.dts.spell.dictionary.SpellDictionary;
import org.dts.spell.dictionary.openoffice.OpenOfficeSpellDictionary;

/**
 *
 * @author QualtopGroup
 */
public class Text {
    
    
    
    
    public static void check(String text){
        
        String texts[] = text.split(" ");
        String out = "";
        
        try {
            SpellDictionary dict = new OpenOfficeSpellDictionary(new ZipFile("es_MX.zip"));
            SpellChecker checker = new SpellChecker(dict) ;
            checker.setCaseSensitive(false) ;

            for (int i = 0; i < texts.length; i++) {
                
                out = out + checker.hasSpellErrors(texts[i]).getFirstSuggestion();
  
            }
            
            System.out.println(out);
            
        } catch (IOException ex) {
            Logger.getLogger(Text.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
}

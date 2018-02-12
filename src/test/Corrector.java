package test;

import java.io.File;
import java.io.IOException;
import java.util.zip.ZipFile;
import org.dts.spell.SpellChecker;
import org.dts.spell.dictionary.SpellDictionary;
import org.dts.spell.dictionary.openoffice.OpenOfficeSpellDictionary;
import org.javabrain.util.web.Service;


/**
 *
 * @author QualtopGroup
 */
public class Corrector {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        File f = new File("es_MX.zip");
        if(f.exists())
        {
            System.out.println("el archivo existe");
        }
        else{
            Service.dowload("http://javabrain2.webcindario.com/dics/es_MX.zip");
        }
        
        try 
        {

           SpellDictionary dict = new OpenOfficeSpellDictionary(new ZipFile("es_MX.zip"));
           SpellChecker checker = new SpellChecker(dict) ;

           checker.setCaseSensitive(false);
           
            System.out.println(checker.isCorrect("testo")); 
           
            for (int i = 0; i < checker.hasSpellErrors("conexion").getSuggestions().length; i++) {
                System.out.println(checker.hasSpellErrors("conexion").getSuggestions()[i]);
                
            }
           
        } catch (IOException ex) {
            System.err.print(ex.getMessage());
        }
        
    }
    
}

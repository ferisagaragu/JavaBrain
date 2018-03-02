package iconsdoc;

import java.net.URL;

/**
 *
 * @author Fernando Isaías García Aguirre
 */
public class Template {
    
    public static String _0 = "0";
    
    public static URL get(String icon) {
        try {
            return new URL("http://javabrain2.webcindario.com/color_icons/alphabet/"+icon+".bcon");
        } catch (java.net.MalformedURLException e) {}
        return null;
    }
    
}

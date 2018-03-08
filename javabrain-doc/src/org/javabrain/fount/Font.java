package org.javabrain.fount;

import java.awt.GraphicsEnvironment;
import java.io.File;

/**
 *
 * @author Fernando García
 */
public class Font {
    
    private Font() {
        try {
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(java.awt.Font.createFont(java.awt.Font.TRUETYPE_FONT,getClass().getResourceAsStream("/org/javabrain/fount/helvetica.ttf")));//Registramos la fuente que queremos utilizar, ademas es necesario pasar la ruta donde se encuentre el archivo.
        } catch (Exception ex) {
            
        } 
    }
    
    public static Font getInstance() {
        return FontHolder.INSTANCE;
    }
    
    private static class FontHolder {

        private static final Font INSTANCE = new Font();
    }
}

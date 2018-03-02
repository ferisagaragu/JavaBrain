package test;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author QualtopGroup
 */
public class Fuente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FontFormatException, IOException {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        
        ge.registerFont(Font.createFont(Font.TRUETYPE_FONT,new File("C:\\Users\\Fernando García\\Documents\\GitHub\\JavaBrain\\Fuente\\Fondos Aporbados\\helvetica.ttf")));
        ge.registerFont(Font.createFont(Font.TRUETYPE_FONT,new File("C:\\Users\\Fernando García\\Documents\\GitHub\\JavaBrain\\Fuente\\Fondos Aporbados\\roboto.ttf")));
        ge.registerFont(Font.createFont(Font.TRUETYPE_FONT,new File("JosefinSans-Light.ttf")));
        
        String[] fuentes = ge.getAvailableFontFamilyNames();
        
        for (int i = 0; i < fuentes.length; i++) {
            System.out.println(fuentes[i]);
        }
        
        /*NewJFrame frame = new NewJFrame();
        frame.setVisible(true);*/
    }
    
}

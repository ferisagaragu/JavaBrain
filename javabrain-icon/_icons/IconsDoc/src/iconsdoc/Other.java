package iconsdoc;

import java.awt.Image;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author QualtopGroup
 */
public class Other {
    
    private static boolean dowload = true;
    private static Path_Other path = new Path_Other();
    private static String urls = "http://javabrain2.webcindario.com/color_icons/alphabet/";
    
    public static Bcon _0 = new Bcon(get("0_c"));
    
    private static ImageIcon get(String icon) {

        ImageIcon ico = null;
        
        if(dowload){
            
            if(path.getPath(icon) == null){
                saveImg(icon);
                ico = iconUrl(icon);
                System.out.println("web");
            }else{
                ico = path.getPath(icon);
                System.out.println("sistema");
            }
            
        }else{
            //ico = iconUrl(icon);
        }
        
        
        return ico;
    }
    
    public static void saveImg(String name) {
        
        try {
            File fil = new File(System.getProperty("user.dir")+"\\src\\org\\brain\\img\\");
            fil.mkdirs();
            
            URL url = new URL(urls+name+".bcon");

            URLConnection urlCon = url.openConnection();
            InputStream is = urlCon.getInputStream();
            FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir")+"\\src\\org\\brain\\img\\"+name+".bcon");

            byte[] array = new byte[1000];
            int leido = is.read(array);
            while (leido > 0) {
                fos.write(array, 0, leido);
                leido = is.read(array);
            }

            is.close();
            fos.close();
        } catch (Exception e) {}
    }
    
    private static ImageIcon iconUrl(String link) {
        ImageIcon icon = null;
        try {
            icon = new javax.swing.ImageIcon(
            new java.net.URL(urls+link+".bcon"));
        } catch (java.net.MalformedURLException e) {}
        
        return icon;
    }

}

class Path_Other{
    
    public ImageIcon getPath(String file){
        ImageIcon img = null;
        try {
            InputStream is = getClass().getResourceAsStream("/org/brain/img/"+file+".bcon");
            Image image = ImageIO.read(is);
            img = new ImageIcon(image);
        } catch (Exception e) {System.out.println(e.getMessage());}
        
        return img;
    }

}
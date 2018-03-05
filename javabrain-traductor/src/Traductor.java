
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;


/**
 *
 * @author QualtopGroup
 */
public class Traductor {

    public static String traslate(Language origin,Language pastto,String text){
        URL url;
        String linea = "";
        String newline = "";
        try {
            // Creando un objeto URL
            url = new URL("https://statickidz.com/scripts/traductor/?&source="+"auto"+"&target="+pastto.getType()+"&q="+URLEncoder.encode(text,"UTF-8"));
            // Realizando la petición GET
            URLConnection con = url.openConnection();
 
            // Leyendo el resultado
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));

            while ((linea = in.readLine()) != null) {
                newline += linea;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return newline;
    }
    
}

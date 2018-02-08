package org.figtech.general.web;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import org.figtech.general.console.alerts.Message;

/**
 *
 * @author Fernando Isaías García Aguirre
 */
public class Service {
    
    public static boolean dowload(String urls){
        
        boolean isDowload = false;
        InputStream is = null;
        FileOutputStream inf = null;
        String data[] = urls.split("/");
        URL url = null;
        
        try {
            Message.setLanguage("ES");
            Message.information("Descargando fichero...","Conectando al servidor");
            url = new URL(urls);
            URLConnection urlCon = url.openConnection();
            
            is = urlCon.getInputStream();
            inf = new FileOutputStream(data[data.length-1]);

            byte[] array = new byte[1000];
            int leido = is.read(array);
            while (leido > 0) {
                inf.write(array, 0, leido);
                leido = is.read(array);
            }

            isDowload = true;
        } catch (Exception e) {
            Message.error("Hubo un error al descargar el archivo",true);
            e.printStackTrace();
        }finally{
            try {
                is.close();
                inf.close();
            } catch (IOException ex) {
            }
        }
        
        String fileName = url.getFile();
        Message.susseful("Archivo "+fileName.split("/")[2]+" y alojado en: aquí va la ruta");
        
        return isDowload;
    }
    
    
}

package org.javabrain.util.resources;

import org.javabrain.util.data.JSON;

import javax.swing.*;
import java.io.*;
import java.net.URL;

/***
 * @author Fernando García
 * @version 0.0.1
 */
public class Path {

    private static Pth pth = new Pth();

    public static String PROYECT = System.getProperty("user.dir");

    public static ImageIcon getRes(String resName){

        String out = "";

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(pth.getPath("/config/neuron.json"), "utf-8"));
            String sCadena = "";

            while ((sCadena = in.readLine())!=null) {
                out += sCadena;
            }

            JSON json = new JSON(out);
            json.setJSON(json.getObject("path"));
            out = json.getString("img");
        }catch (Exception e){}

        return new ImageIcon(pth.getPathRes(out+resName));
    }

    public static InputStream getFile(String fileName){

        String out = "";

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(pth.getPath("/config/neuron.json"), "utf-8"));
            String sCadena = "";

            while ((sCadena = in.readLine())!=null) {
                out += sCadena;
            }

            JSON json = new JSON(out);
            json.setJSON(json.getObject("path"));
            out = json.getString("file");

        }catch (Exception e){}

        return pth.getPath(out+fileName);
    }

}

class Pth{

    public InputStream getPath(String path){
        return getClass().getResourceAsStream(path);
    }

    public URL getPathRes(String path){
        return getClass().getResource(path);
    }
}

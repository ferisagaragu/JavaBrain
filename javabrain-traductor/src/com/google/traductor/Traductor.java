package com.google.traductor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

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

            url = new URL("https://statickidz.com/scripts/traductor/?&source="+origin+"&target="+pastto.getType()+"&q="+URLEncoder.encode(text,"UTF-8"));
            URLConnection con = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

            while ((linea = in.readLine()) != null) {
                newline += linea;
            }
            System.out.println(newline);
            JSONParser parser = new JSONParser();
            JSONObject obj = (JSONObject) parser.parse(newline);
            newline = obj.get("translation").toString();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return newline;
    }
    
    
    public static String traslate(Language pastto,String text){
        URL url;
        String linea = "";
        String newline = "";
        try {

            url = new URL("https://statickidz.com/scripts/traductor/?&source=auto&target="+pastto.getType()+"&q="+URLEncoder.encode(text,"UTF-8"));
            URLConnection con = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

            while ((linea = in.readLine()) != null) {
                newline += linea;
            }
            
            JSONParser parser = new JSONParser();
            JSONObject obj = (JSONObject) parser.parse(newline);
            newline = obj.get("translation").toString();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
        
        return newline;
    }
    
}

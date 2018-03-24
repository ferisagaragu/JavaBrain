package com.google.traductor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author QualtopGroup
 */
public class Traductor {

    private static Thread thread;
    
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
    
    
    public static String autoTraslate(Language pastto,String text){
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
    
    public static Thread translateAsynchronous(Language origin, Language pastto, String text,JLabel jl) {
        jl.setIcon(new ImageIcon("C:\\Users\\Fernando García\\Documents\\GitHub\\JavaBrain\\javabrain-traductor\\src\\com\\google\\traductor\\iconL.gif"));
        jl.setText("");
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                URL url;
                String linea = "";
                String newline = "";
                try {

                    url = new URL("https://statickidz.com/scripts/traductor/?&source=" + origin + "&target=" + pastto.getType() + "&q=" + URLEncoder.encode(text, "UTF-8"));
                    URLConnection con = url.openConnection();
                    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

                    while ((linea = in.readLine()) != null) {
                        newline += linea;
                    }
                    JSONParser parser = new JSONParser();
                    JSONObject obj = (JSONObject) parser.parse(newline);
                    newline = obj.get("translation").toString();
                    jl.setText("<html>"+newline+"</html>");
                    jl.setIcon(null);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        });
        thread.start();
        return thread;
    }
}

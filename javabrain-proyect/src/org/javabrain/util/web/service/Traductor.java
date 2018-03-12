package org.javabrain.util.web.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.swing.*;

/**
 *
 * @author QualtopGroup
 */
public class Traductor {

    private static ArrayList<Object> list = new ArrayList<>();

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
    
    //lista
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

    public static boolean addComponent(Object element){
        try {
            list.add(element);
        }catch (Exception e){return false;}
        return true;
    }

    public static boolean removeComponent(Object element){
        try {
            list.remove(element);
        }catch (Exception e){return false;}
        return true;
    }

    public static boolean clearComponent(){
        try {
            list.clear();
        }catch (Exception e){return false;}
        return true;
    }

    public static boolean setComponent(int index,Object element){
        try {
            list.set(index,element);
        }catch (Exception e){return false;}
        return true;
    }

    public static int sizeListComponents(){
        try {
            return list.size();
        }catch (Exception e){return 0;}
    }

    public static ArrayList<Object> getListComponents(){
        try {
            return list;
        }catch (Exception e){return null;}
    }
    //fin - lista

    //use - list
    public static boolean traslateList(Language index,Language traslate){
        try{

            for (Object obj :list) {
                boolean pass = true;
                try{
                    if(pass) {
                        JButton button = (JButton) obj;
                        button.setText(traslate(index, traslate,
                                button.getText())
                                .replace("</ b>","</b>")
                                .replace("</ h2>","</h2>")
                                .replace("</ body>","</body>")
                                .replace("</ html>","</html>"));
                        pass = false;
                    }
                }catch (Exception e){}

                try{
                    if(pass) {
                        JLabel label = (JLabel) obj;
                        label.setText(traslate(index, traslate,
                                label.getText())
                                .replace("</ b>","</b>")
                                .replace("</ h2>","</h2>")
                                .replace("</ body>","</body>")
                                .replace("</ html>","</html>"));
                        pass = false;
                    }
                }catch (Exception e){}

                try{
                    if(pass) {
                        Button button = (Button) obj;
                        button.setText(traslate(index, traslate,
                                button.getText())
                                .replace("</ b>","</b>")
                                .replace("</ h2>","</h2>")
                                .replace("</ body>","</body>")
                                .replace("</ html>","</html>"));
                        pass = false;
                    }
                }catch (Exception e){}

                try{
                    if (pass) {
                        Label label = (Label) obj;
                        label.setText(traslate(index, traslate,
                                label.getText())
                                .replace("</ b>","</b>")
                                .replace("</ h2>","</h2>")
                                .replace("</ body>","</body>")
                                .replace("</ html>","</html>"));
                        pass = false;
                    }
                }catch (Exception e){}
            }

        }catch (Exception e){return false;}

        return true;
    }

    public static boolean autoTraslateList(Language traslate){
        try{

            for (Object obj :list) {
                boolean pass = true;
                try{
                    if(pass) {
                        JButton button = (JButton) obj;
                        button.setText(autoTraslate(traslate,
                                button.getText())
                                .replace("</ b>","</b>")
                                .replace("</ h2>","</h2>")
                                .replace("</ body>","</body>")
                                .replace("</ html>","</html>"));
                        pass = false;
                    }
                }catch (Exception e){}

                try{
                    if(pass) {
                        JLabel label = (JLabel) obj;
                        label.setText(autoTraslate(traslate,
                                label.getText())
                                .replace("</ b>","</b>")
                                .replace("</ h2>","</h2>")
                                .replace("</ body>","</body>")
                                .replace("</ html>","</html>"));
                        System.out.println(label.getText());
                        pass = false;
                    }
                }catch (Exception e){}

                try{
                    if(pass) {
                        Button button = (Button) obj;
                        button.setText(autoTraslate(traslate,
                                button.getText())
                                .replace("</ b>","</b>")
                                .replace("</ h2>","</h2>")
                                .replace("</ body>","</body>")
                                .replace("</ html>","</html>"));
                        pass = false;
                    }
                }catch (Exception e){}

                try{
                    if (pass) {
                        Label label = (Label) obj;
                        label.setText(autoTraslate(traslate,
                                label.getText())
                                .replace("</ b>","</b>")
                                .replace("</ h2>","</h2>")
                                .replace("</ body>","</body>")
                                .replace("</ html>","</html>"));
                        pass = false;
                    }
                }catch (Exception e){}
            }

        }catch (Exception e){return false;}

        return true;
    }
    // fin - use list
}

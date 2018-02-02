package org.javabrain.config;

import org.javabrain.console.alerts.Message;
import org.javabrain.data.JSON;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Paths {

    private static Paths paths = null;
    private String key[];
    private String JSONPath;
    private String imgPath;
    private String rawPath;
    private String drawablePath;
    private String otherPath;

    public Paths() {

        key = "JSON,img,raw,other,drawable".split(",");

        JSONObject object = readJSON("paths");

        try{JSONPath = configPath(object.get("JSON").toString());}catch (Exception e){}
        try{imgPath = configPath(object.get("img").toString());}catch (Exception e){}
        try{rawPath = configPath(object.get("raw").toString());}catch (Exception e){}
        try{otherPath = configPath(object.get("other").toString());}catch (Exception e){}
        try{drawablePath = configPath(object.get("drawable").toString());}catch (Exception e){}
    }

    //Singleton
    public static Paths getInstance() {
        if(paths == null) {
            paths = new Paths();
        }
        return paths;
    }

    //Private method
    private String configPath(String path){

        String[] fragment = path.split("/");

        for (int i = 0; i < fragment.length; i++) {

            if(fragment[i].equals("..")){
               return path.replace("..",System.getProperty("user.dir")).replace("/","\\");
            }

        }

        return path;
    }

    private JSONObject readJSON(String fileName){

        JSONObject data = null;

        try{
            JSONParser parser = new JSONParser();
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(System.getProperty("user.dir")+"\\config\\"+fileName+".json"), "utf-8"));
            data = (JSONObject) parser.parse(in);
            in.close();
        }catch (FileNotFoundException | ParseException ex){
            System.err.println(ex.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(JSON.class.getName()).log(Level.SEVERE, null, ex);
        }

        return data;

    }

    //Get and set
    public String getJSONPath() {

        if (JSONPath == null)
        {
            Message.error("The JSON path can not be found in the mapping of the file \"paths.json\",\n" +
            "it will be defined \""+System.getProperty("user.dir")+"\"\nby default until the route deduced is mapped");
            JSONPath = System.getProperty("user.dir");
        }

        return JSONPath;
    }

    public String getImgPath() {

        if (imgPath == null)
        {
            Message.error("The img path can not be found in the mapping of the file \"paths.json\",\n" +
                    "it will be defined \""+System.getProperty("user.dir")+"\"\nby default until the route deduced is mapped");
            imgPath = System.getProperty("user.dir");
        }

        return imgPath;
    }

    public String getRawPath() {

        if (rawPath == null)
        {
            Message.error("The raw path can not be found in the mapping of the file \"paths.json\",\n" +
                    "it will be defined \""+System.getProperty("user.dir")+"\"\nby default until the route deduced is mapped");
            rawPath = System.getProperty("user.dir");
        }

        return rawPath;
    }

    public String getDrawablePath() {

        if (drawablePath == null)
        {
            Message.error("The drawable path can not be found in the mapping of the file \"paths.json\",\n" +
                    "it will be defined \""+System.getProperty("user.dir")+"\"\nby default until the route deduced is mapped");
            drawablePath = System.getProperty("user.dir");
        }

        return drawablePath;
    }

    public String getOtherPath() {

        if (otherPath == null)
        {
            Message.setLanguage("ES");
            Message.error("The other path can not be found in the mapping of the file \"paths.json\",\n" +
                    "it will be defined \""+System.getProperty("user.dir")+"\"\nby default until the route deduced is mapped");
            otherPath = System.getProperty("user.dir");
        }

        return otherPath;
    }
}

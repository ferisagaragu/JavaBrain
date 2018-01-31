package org.javabrain.config;

import org.javabrain.data.JSON;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Paths {

    private String JSONPath;
    private String imgPath;

    public Paths() {
        JSONObject data = null;
        BufferedReader in = null;

        try
        {
            JSONParser parser = new JSONParser();
            in = new BufferedReader(new InputStreamReader(new FileInputStream(System.getProperty("user.dir")+"//data//config.json"), "utf-8"));
            data = (JSONObject) parser.parse(in);
        }
        catch (FileNotFoundException | ParseException ex)
        {
            System.err.println(ex.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(JSON.class.getName()).log(Level.SEVERE, null, ex);
        }

        JSONPath = data.get("JSON").toString().replace("..",System.getProperty("user.dir")).replace("/","\\");
        imgPath  = data.get("img").toString().replace("..",System.getProperty("user.dir")).replace("/","\\");
    }

    public String getJSONPath() {
        return JSONPath;
    }

    public String getImgPath() {
        return imgPath;
    }
}

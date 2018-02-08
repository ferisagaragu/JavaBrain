package org.javabrain.data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JSON {

    private static final JSONParser parser = new JSONParser();

    public static JSONObject parser(Object obj)
    {
        JSONObject jsono = null;

        try {
            jsono = (JSONObject) parser.parse(obj.toString());
        } catch (ParseException ex) {
            Logger.getLogger(JSON.class.getName()).log(Level.SEVERE, null, ex);
        }

        return jsono;
    }

    public static JSONArray read(String fileName)
    {
        JSONArray data = null;

        try
        {
            JSONParser parser = new JSONParser();
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(System.getProperty("user.dir")+"//data//"+fileName+".json".replace("/","\\")), "utf-8"));
            data = (JSONArray) parser.parse(in);
        }
        catch (FileNotFoundException | ParseException ex)
        {
            System.err.println(ex.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(JSON.class.getName()).log(Level.SEVERE, null, ex);
        }

        return data;
    }

    public static JSONArray generate(String fileName,String JSON)
    {
        JSONArray data = null;
        JSONParser parser = new JSONParser();

        try {
            BufferedWriter out =
                    new BufferedWriter(new OutputStreamWriter(new FileOutputStream(System.getProperty("user.dir")+"\\data\\"+fileName+".json".replace("/","\\")), "utf-8"));
            out.write(JSON.replace("\\","").replace("\"{","{").replace("}\"","}"));
            out.close();

            data = (JSONArray)parser.parse(JSON);

        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(JSON.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JSON.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException | IOException ex) {
            Logger.getLogger(JSON.class.getName()).log(Level.SEVERE, null, ex);
        }

        return data;
    }

    public static JSONArray where(JSONArray array,String idJSON,String match){

        JSONArray array2 = new JSONArray();

        for (Object obj : array){

            JSONObject js = parser(obj);

            if(js.get(idJSON).toString().toLowerCase().equals(match.toLowerCase()))
            {
                array2.add(obj);
            }
        }

        return array2;
    }

    public static JSONArray join(JSONArray array,JSONArray arrayJoin,String idJSON,String idJSON2,String match){

        JSONArray  nArray = new JSONArray();

        for (Object obj1 : array) {

            JSONObject js1 = parser(obj1);

            for (Object obj2 : arrayJoin) {

                JSONObject js2 = parser(obj2);

                if(js1.get(idJSON).toString().toLowerCase().equals(match.toLowerCase())&&
                        js2.get(idJSON2).toString().toLowerCase().equals(match.toLowerCase()))
                {
                    nArray.add(parser(js1.toString().replace("}",js2.toString().replace("{",",").replace("\"id\"","\"idjoin\""))));
                }

            }

        }

        return nArray;
    }





}

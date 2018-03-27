package org.javabrain.util.data;

import org.javabrain.util.resources.Path;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/***
 * @author Fernando García
 * @version 0.0.1
 */
public class JSON {

    private JSONParser parser;
    private JSONObject obj;
    private JSONArray array;

    //CONSTRUCTORES
    public JSON(){
        parser = new JSONParser();
        try {
            obj = (org.json.simple.JSONObject) parser.parse("{}");
        } catch (ParseException e) {}
    }

    public JSON(Object json) {
        parser = new JSONParser();
        if(json.toString().charAt(0) == '['){
            try {
                array = (org.json.simple.JSONArray) parser.parse(json.toString());
            } catch (ParseException e) {}
        }else {
            try {
                obj = (org.json.simple.JSONObject) parser.parse(json.toString());
            } catch (ParseException e) {}
        }

    }

    public JSON(InputStream inputStream) {
        parser = new JSONParser();

        String out = "";
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
            String sCadena = "";

            while ((sCadena = in.readLine())!=null) {
                out += sCadena;
            }

        }catch (Exception e){}

        if(out.toString().charAt(0) == '['){
            try {
                array = (org.json.simple.JSONArray) parser.parse(out);
            } catch (ParseException e) {}
        }else {
            try {
                obj = (org.json.simple.JSONObject) parser.parse(out);
            } catch (ParseException e) {}
        }
    }

    //================================================================

    //METODOS GET

    public String getString(Object key){
        return obj.get(key).toString();
    }

    public int getInteger(Object key){
        return Integer.parseInt(obj.get(key).toString());
    }

    public float getFloat(Object key){
        return Float.parseFloat(obj.get(key).toString());
    }

    public boolean getBoolean(Object key){
        return Boolean.parseBoolean(obj.get(key).toString());
    }

    public char getCharacter(Object key){
        return obj.get(key).toString().charAt(0);
    }

    public double getDouble(Object key){
        return Double.parseDouble(obj.get(key).toString());
    }

    public Object getObject(Object key){
        return obj.get(key);
    }

    public JSON getJSON(Object key){
        return new JSON(obj.get(key));
    }

    public JSON getJSONArray(Object key, int index){
        JSONArray array = null;

        try{array = (JSONArray) parser.parse(obj.get(key).toString());}catch (Exception e){}

        return new JSON(array.get(index));
    }

    public JSON getJSONArray(int index){
        return new JSON(array.get(index));
    }

    public Object[] getArray(Object key){
        Object[] dat = null;
        if(getString(key).charAt(0) == '['){
           String dato = getString(key).replace("[","").replace("]","");
           dat = dato.split(",");
            for (int i = 0; i < dat.length; i++) {
                if(dat[i].toString().equals("\"\"")){
                    dat[i] = "";
                }else {
                    dat[i] = dat[i].toString().replace("\"","");
                }
            }
        }
        return dat;
    }


    public JSON getJSONArray(Object key){
        JSONArray array = null;
        try{array = (JSONArray) parser.parse(obj.get(key).toString());}catch (Exception e){}
        return new JSON(array);
    }

    //===============================================================

    //METODOS SET

    public void setJSON(Object json) {
        if(json.toString().charAt(0) == '['){
            try {
                array = (org.json.simple.JSONArray) parser.parse(json.toString());
            } catch (ParseException e) {}
        }else {
            try {
                obj = (org.json.simple.JSONObject) parser.parse(json.toString());
            } catch (ParseException e) {}
        }
    }

    public void read(InputStream inputStream){
        String out = "";
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
            String sCadena = "";

            while ((sCadena = in.readLine())!=null) {
                out += sCadena;
            }

        }catch (Exception e){}

        if(out.toString().charAt(0) == '['){
            try {
                array = (org.json.simple.JSONArray) parser.parse(out);
            } catch (ParseException e) {}
        }else {
            try {
                obj = (org.json.simple.JSONObject) parser.parse(out);
            } catch (ParseException e) {}
        }
    }

    public void read(String jsonFile){
        String out = "";
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(Path.getJson(jsonFile), "utf-8"));
            String sCadena = "";

            while ((sCadena = in.readLine())!=null) {
                out += sCadena;
            }

        }catch (Exception e){}

        if(out.toString().charAt(0) == '['){
            try {
                array = (org.json.simple.JSONArray) parser.parse(out);
            } catch (ParseException e) {}
        }else {
            try {
                obj = (org.json.simple.JSONObject) parser.parse(out);
            } catch (ParseException e) {}
        }
    }

    //===============================================================

    //METODOS DE ACCION

    public void remove(Object key){
        obj.remove(key);
    }

    public int size(){

        if(obj == null){
            return array.size();
        }

        return obj.size();
    }

    public Object replace(Object key, Object value){
        return obj.replace(key,value);
    }

    public Object replaceJSONArray(Object key, Map<Object,Object> objects){
        Object ob = null;
        String data = "";
        Iterator it = objects.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry e = (Map.Entry)it.next();
            data += "{\""+e.getKey()+"\":\"" + e.getValue()+"\"},";
        }
        data = "["+data.substring(0,data.length()-1)+"]";

        try {
            ob = obj.replace(key,(JSONArray) parser.parse(data));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return  ob;
    }

    public Object putInJSONArray(Object key,Map<Object,Object> objects){
        Object ob = null;
        String data = obj.get(key).toString().substring(1,obj.get(key).toString().length()-1);
        Iterator it = objects.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry e = (Map.Entry)it.next();
            data += "{\""+e.getKey()+"\":\"" + e.getValue()+"\"},";
        }
        data = data.replace(",","");
        data = data.replace("}","},");
        data = data.substring(0,data.length()-1);
        data = "["+data+"]";
        try {
            ob = obj.replace(key,(JSONArray) parser.parse(data));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return  ob;
    }

    public String getKey(int index) {
        int i = 0;
        for (Object sets:obj.keySet()) {
            if(i == index){
                return sets.toString();
            }
            i++;
        }
        return null;
    }

    public Collection getKeys(){
        ArrayList<Object> keys = new ArrayList<>();
        Collection collection = new ArrayList();
        for (Object sets:obj.keySet()) {
            collection.add(sets);
        }
        return collection;
    }

    public String toJSONString(){

        if(obj == null){
            return array.toJSONString();
        }

        return obj.toJSONString();
    }

    public Object putJSON(Object key, Object value){
        return obj.put(key,value);
    }

    public Object putJSONArray(Object key, Map<Object,Object> objects){
        Object ob = null;
        String data = "";
        Iterator it = objects.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry e = (Map.Entry)it.next();
            data += "{\""+e.getKey()+"\":\"" + e.getValue()+"\"},";
        }
        data = "["+data.substring(0,data.length()-1)+"]";

        try {
            ob = obj.put(key,(JSONArray) parser.parse(data));
        } catch (ParseException e) {
            e.printStackTrace();
        }

         return  ob;
    }

    public ArrayList<JSON> values(){
        ArrayList<JSON> list = new ArrayList<>();

        if (obj == null){
            for (Object object:array.toArray()) {
                list.add(new JSON(object));
            }
        }else {
            for (Object object:obj.values()) {
                list.add(new JSON(object));
            }
        }

        return list;
    }

    public boolean write(String path){
        try {
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), "utf-8"));
            out.write(toJSONString().toString().replace("\\","").replace("\"{","{").replace("}\"","}"));
            out.close();
            return true;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    //===============================================================

    //METODOS PRIVADOS
    //==============================================================

    //Versión 0.0.2 ->
    //{"path":{"img":"/config/","file":"/config/","json":"/db/"}}
    //AGREGAR JSONSELECT
    //AGREGAR JSONJOIN
    //TIPEAR EL BSON "HACER EN OTRA CLACE"
}


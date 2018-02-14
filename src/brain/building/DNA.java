package brain.building;

import org.javabrain.util.alerts.Consol;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;


/**
 *
 * @author Fernando García
 */
public class DNA {

    //Publics
    public final String language;
    public final boolean download;
    public final String[] spell;
    public final String[] fount;
    public final boolean warning;
    public final String company;
    public final String[] folder;
     
    private DNA() {

        if(read() != null) {
            JSONObject object = read();

            if(object.get("language").toString().isEmpty()){
                language = "es";
            }
            else{
                language = object.get("language").toString().toLowerCase();
            }

            if(object.get("download").toString().isEmpty()){
                download = true;
            }
            else{
                download = Boolean.parseBoolean(object.get("download").toString());
            }

            if (object.get("spell").toString().isEmpty()) {
                spell = null;
            } else {
                spell = object.get("spell").toString().replace(" ", "").split(",");
            }

            if (object.get("fount").toString().isEmpty()) {
                fount = null;
            } else {
                fount = object.get("fount").toString().toLowerCase().split(" ");
            }

            if(object.get("warning").toString().isEmpty()){
                warning = true;
            }
            else{
                warning = Boolean.parseBoolean(object.get("warning").toString());
            }

            if(object.get("company").toString().isEmpty()){
                company = "";
            }
            else{
                company = object.get("company").toString().replace(" ", "");
            }

            if(object.get("folder").toString().isEmpty()){
                folder = null;
            }else {
                folder = object.get("folder").toString().toLowerCase().split(",");
            }

            makeFolders();
            makeDic();
            makePath();

            if(download){

                if(spell != null) {
                    for (int i = 0; i < spell.length; i++) {
                        if (!(new File(System.getProperty("user.dir") + "\\conf\\dic\\" + spell[i] + ".zip").exists())) {
                            dowload(spell[i]);
                        }
                    }
                }

                if(fount != null) {
                    if (!(new File((System.getProperty("user.dir") + "\\conf\\fount\\" + fount[0] + ".ttf").toLowerCase()).exists())) {
                        fount(fount[0]);
                    }
                }

            }

        }else {
            Consol.blue(Talk.formatText(Talk.Message("DNA1", "en", "info"),"text"));
            Consol.blue(Talk.formatText(Talk.Message("DNA1", "es", "info"),"text 9"));
            makeDNA();

            Consol.green(Talk.formatText(Talk.Message("DNA2", "en", "info"),"text"));
            Consol.green(Talk.formatText(Talk.Message("DNA2", "es", "info"),"text"));

            System.exit(0);
            language = "";
            download = false;
            spell = null;
            fount = null;
            warning = false;
            company = null;
            folder = null;
        }

    }

    //Singleton
    private static DNA ourInstance = new DNA();
    public static DNA getInstance() {
        return ourInstance;
    }

    //Cargar el archivo JSON
    public JSONObject read() {
        JSONObject object = null;
        BufferedReader in = null;

        try{
            JSONParser parser = new JSONParser();
            in = new BufferedReader(new InputStreamReader(new FileInputStream((System.getProperty("user.dir")+"/conf/neuron.json").replace("/","\\")), "utf-8"));
            object = (JSONObject) parser.parse(in);
            in.close();
        }catch (Exception e){}

        return object;
    }

    //Regeneracion
    private void makeDNA(){

        File folder = new File(System.getProperty("user.dir") + "\\conf\\dic");
        File folder2 = new File(System.getProperty("user.dir") + "\\conf\\fount");

        try {
           folder.mkdirs();
           folder2.mkdirs();
           BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream((System.getProperty("user.dir") + "/conf/neuron.json").replace("/", "\\")), "utf-8"));
           out.write("{\n" +
                   "  \"language\":\"es\",\n" +
                   "  \"download\":true,\n" +
                   "  \"spell\":\"es_MX,en_US\",\n" +
                   "  \"fount\":\"roboto ti-20 tx-16 ts-12\",\n" +
                   "  \"warning\":true,\n" +
                   "  \"company\":\"org.myapp\",\n" +
                   "  \"folder\": \"model,view,controller,res,raw\",\n" +
                   "  \"library\":\"on proces\"\n" +
                   "}");
           out.close();
        } catch (Exception e) {}

    }
    private void makeDic(){

        File folder = new File(System.getProperty("user.dir") + "\\conf\\dic\\myspell.dic");

        if (!folder.exists()) {
            try {
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream((System.getProperty("user.dir") + "/conf/dic/myspell.dic").replace("/", "\\")), "utf-8"));
                out.write("Java,\n" +
                        "Brain");
                out.close();
            } catch (Exception e) {
            }
        }

    }
    private void makePath(){

        File folder = new File(System.getProperty("user.dir") + "\\conf\\path.json");

        if (!folder.exists()) {
            try {
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream((System.getProperty("user.dir") + "/conf/path.json").replace("/", "\\")), "utf-8"));
                out.write("{\n" +
                        "  \"img\":\"\",\n" +
                        "  \"raw\":\"\",\n" +
                        "  \"svg\":\"\",\n" +
                        "  \"html\":\"\",\n" +
                        "  \"css\":\"\",\n" +
                        "  \"json\":\"\",\n" +
                        "  \"messages\":\"\",\n" +
                        "  \"file\":\"\",\n" +
                        "  \"xml\":\"\"\n" +
                        "}");
                out.close();
            } catch (Exception e) {
            }
        }

    }
    private void makeFolders(){
        File fold = new File(System.getProperty("user.dir") +"\\src\\"+company.replace(".","\\"));
        fold.mkdirs();

        if(folder != null) {
            for (int i = 0; i < folder.length; i++) {
                File folder2 = new File(System.getProperty("user.dir") + "\\src\\" + company.replace(".", "\\") + "\\" + folder[i]);
                folder2.mkdirs();
            }
        }

        File folder2 = new File(System.getProperty("user.dir") +"\\src\\Run");
        folder2.mkdirs();

        File fold3 = new File(System.getProperty("user.dir") + "\\conf\\dic");
        File fold4 = new File(System.getProperty("user.dir") + "\\conf\\fount");
        fold3.mkdirs();
        fold4.mkdirs();
    }
    private boolean dowload(String file){

        boolean isDowload = false;
        InputStream is = null;
        FileOutputStream inf = null;
        String urls = "http://javabrain2.webcindario.com/dics/"+file+".zip";
        String data[] = urls.split("/");
        URL url = null;

        try {
            Consol.blue(Talk.formatText(Talk.Message("DNA3", language, "info",file),"text"));
            url = new URL(urls);
            URLConnection urlCon = url.openConnection();

            is = urlCon.getInputStream();
            inf = new FileOutputStream(System.getProperty("user.dir")+"\\conf\\dic\\"+data[data.length-1]);

            byte[] array = new byte[1000];
            int leido = is.read(array);
            while (leido > 0) {
                inf.write(array, 0, leido);
                leido = is.read(array);
            }

            isDowload = true;
            Consol.green(Talk.formatText(Talk.Message("DNA3", language, "success","dic,"+file),"text"));
        } catch (Exception e) {
            Consol.red(Talk.formatText(Talk.Message("DNA3", language, "error",file),"text"));
        }finally{
            try {
                is.close();
                inf.close();
            } catch (IOException ex) {
            }
        }

        return isDowload;
    }
    private boolean fount(String file){

        boolean isDowload = false;
        InputStream is = null;
        FileOutputStream inf = null;
        String urls = "http://javabrain2.webcindario.com/fount/"+file+".ttf";
        String data[] = urls.split("/");
        URL url = null;

        try {
            Consol.blue(Talk.formatText(Talk.Message("DNA3", language, "info",file),"text"));
            url = new URL(urls);
            URLConnection urlCon = url.openConnection();

            is = urlCon.getInputStream();
            inf = new FileOutputStream(System.getProperty("user.dir")+"\\conf\\fount\\"+data[data.length-1]);

            byte[] array = new byte[1000];
            int leido = is.read(array);
            while (leido > 0) {
                inf.write(array, 0, leido);
                leido = is.read(array);
            }

            isDowload = true;
            Consol.green(Talk.formatText(Talk.Message("DNA3", language, "success","fount,"+file),"text"));
        } catch (Exception e) {
            Consol.red(Talk.formatText(Talk.Message("DNA3", language, "error",file),"text"));
        }finally{
            try {
                is.close();
                inf.close();
            } catch (IOException ex) {
            }
        }

        return isDowload;
    }

}

class Talk {

    private static JSONArray readMessages() {
        JSONArray data = null;
        Path path = new Path();
        try{
            JSONParser parser = new JSONParser();
            BufferedReader in = new BufferedReader(new InputStreamReader(path.getPath(), "utf-8"));
            data = (JSONArray) parser.parse(in);
        }catch (FileNotFoundException | ParseException ex){
            System.err.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.print(ex.getMessage());
        }

        return data;
    }


    public static String Message(String categorie, String language, String type){

        JSONParser parser = new JSONParser();
        int number = Integer.parseInt(categorie.substring(categorie.length()-1));
        String out = "";
        try {
            JSONArray array = (JSONArray) parser.parse(readMessages().toString());
            JSONObject object = (JSONObject) parser.parse(array.get(number-1).toString());
            JSONObject object2 = (JSONObject) parser.parse(object.get(categorie).toString());
            JSONObject object3 = (JSONObject) parser.parse(object2.get(language).toString());
            out = object3.get(type).toString();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return out;
    }

    public static String Message(String categorie, String language, String type,String between){

        String[] array2 = between.split(",");
        JSONParser parser = new JSONParser();
        int number = Integer.parseInt(categorie.substring(categorie.length()-1));
        String out = "";
        try {
            JSONArray array = (JSONArray) parser.parse(readMessages().toString());
            JSONObject object = (JSONObject) parser.parse(array.get(number-1).toString());
            JSONObject object2 = (JSONObject) parser.parse(object.get(categorie).toString());
            JSONObject object3 = (JSONObject) parser.parse(object2.get(language).toString());
            out = object3.get(type).toString();

            for (int i = 0; i < array2.length; i++) {
                 out = out.replace("&?"+(i+1)+"&",array2[i]);
            }


        } catch (ParseException e) {
            e.printStackTrace();
        }

        return out;
    }

    public static String formatText(String text, String params){

        String[] parameters = params.split(" ");
        String type = parameters[0].toUpperCase();
        int format,base;

        if(parameters.length == 1){
            format = 10;
            base = 10;
        }else {
            format = Integer.parseInt(parameters[1]);
            base = Integer.parseInt(parameters[1]);
        }

        switch (type) {

            case "HTML":
                String[] texts = text.split(" ");
                String out = "<html><body>";
                for (int i = 0; i < texts.length; i++) {
                    if (i == format-1) {
                        out = out + texts[i] + "<br>";
                        format = format + base;
                    } else {
                        out = out + texts[i] + " ";
                    }
                }
                return out+"</body></html>";

            case "TEXT":
                String[] texts2 = text.split(" ");
                String out2 = "";
                for (int i = 0; i < texts2.length; i++) {

                    if (i == format-1) {
                        out2 = out2 + texts2[i] + "\n";
                        format = format + base;
                    } else {
                        out2 = out2 + texts2[i] + " ";
                    }
                }
                return out2;
        }

        return type;
    }


}

class Path{

    public InputStream getPath(){
        return getClass().getResourceAsStream("/brain/building/messages.json");
    }


}

package iconsdoc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fernando Isaías García Aguirre
 */
public class Main {
    
    public static String ucFirst(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        } else {
            return str.substring(0, 1).toUpperCase() + str.substring(1);
        }
    }
    
    private static boolean isNumeric(String cadena){
	try {
		Integer.parseInt(cadena);
		return true;
	} catch (NumberFormatException nfe){
		return false;
	}
    }
    
    public static void doc(){
        File fil = new File(System.getProperty("user.dir")+"\\");
        String[] files = fil.list();
        String p = System.getProperty("user.dir").replace("\\",",").toLowerCase();
        String[] phat = p.split(",");
        
        String footer = "";
        for (int i = 0; i < files.length; i++) {
            String file = files[i];
            
            if(!(file.equals("IconsDoc.jar") || file.equals("index.html"))){
            footer += "\n      <div class=\"col-md-2 col-sm-2 col-lg-2\">\n"
                    + "        <div class=\"panel panel-default\">\n"
                    + "          <div class=\"panel-body text-center\">\n"
                    + "            <img src=\"http://javabrain2.webcindario.com/" + phat[phat.length - 2] + "/" + phat[phat.length-1] + "/" + file + "\" alt=\"\">\n"
                    + "          </div>\n"
                    + "          <div class=\"panel-footer text-center\">\n"
                    + "              <p>" + file.replace(".bcon","") + "</p>\n"
                    + "          </div>\n"
                    + "        </div>\n"
                    + "      </div>\n";
            }
        }
        footer = "<div class=\"col-md-12 col-sm-12 col-lg-12 mrg-20-t\">"+footer+"</div>";
        
        footer = "<!DOCTYPE html>\n"
                + "<html>\n"
                + "  <head>\n"
                + "    <meta charset=\"utf-8\">\n"
                + "    <title>Java Brain</title>\n"
                + "    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">\n"
                + "    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css\" integrity=\"sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp\" crossorigin=\"anonymous\">\n"
                + "  </head>\n"
                + "  <body>\n"
                + "    <div class=\"col-md-12 col-sm-12 col-lg-12\">\n"
                + "      <h1>IconColor - "+ucFirst(phat[phat.length-1])+"</h1>\n"
                + "    </div>" + footer + "  </body>\n"
                + "  <script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\n"
                + "  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\n"
                + "  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>\n"
                + "</html>";
        
        fil = new File(System.getProperty("user.dir")+"\\");
        String[] other = fil.list();
        
        String variables = "";
        for (int i = 0; i < other.length; i++) {
            String other1 = other[i];
            
            if (!(other1.equals("IconsDoc.jar") || other1.equals("index.html"))) {
                if (isNumeric(String.valueOf(other1.charAt(0)))) {
                    variables
                            += "    public static URL _" + other1.replace(".bcon", "").toUpperCase() + " = get(\"" + other1.replace(".bcon", "") + "\");\n";
                } else {
                    variables
                            += "    public static URL " + other1.replace(".bcon", "").toUpperCase() + " = get(\"" + other1.replace(".bcon", "") + "\");\n";
                }
            }
        }
        
        String javaclass = 
                "import java.net.URL;\n"
                + "\n"
                + "/**\n"
                + " *\n"
                + " * @author Fernando Isaías García Aguirre\n"
                + " */\n"
                + "public class "+ucFirst(phat[phat.length-1])+" {\n"
                + "    \n"
                + variables
                + "    \n"
                + "    private static URL get(String icon) {\n"
                + "        try {\n"
                + "            return new URL(\"http://javabrain2.webcindario.com/"+phat[phat.length - 2]+"/"+phat[phat.length-1]+"/\"+icon+\".bcon\");\n"
                + "        } catch (java.net.MalformedURLException e) {}\n"
                + "        return null;\n"
                + "    }\n"
                + "    \n"
                + "}";

        try {
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("index.html"), "utf-8"));
            out.write(footer);
            out.close();
            
            BufferedWriter out2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(ucFirst(phat[phat.length-1])+".java"), "utf-8"));
            out2.write(javaclass);
            out2.close();
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File f = new File(System.getProperty("user.dir")+"\\");
        String list[] = f.list();
        
        for (int i = 0; i < list.length; i++) {
            String list1 = list[i];
            System.out.println(list1);
            
            File fil = new File(System.getProperty("user.dir")+"\\"+list1);
            fil.renameTo(new File(list1.replace("_100px_1", "").replace("_100px_2", "").replace("icons8_","").replace("_100px","").toLowerCase().replace(".png", ".bcon").replace("'","")));
        }
        
        doc();
            }
    
}

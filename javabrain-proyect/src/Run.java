
import org.javabrain.util.alerts.Consol;

import java.io.File;

public class Run {

    public static void main(String[] args){
        //DNA dna = DNA.getInstance();


        File fil = new File("C:\\Users\\QualtopGroup\\Desktop\\color icons\\alphabet\\");
        String[] files = fil.list();



        for (int i = 0; i < files.length; i++) {
            Consol.blue("     /***\n" +
                    "     * <html>\n" +
                    "     *    <img src=\""+"http://javabrain2.webcindario.com/icon-color/alphabet/"+files[i]+"\"/>\n" +
                    "     *    <br/> by <a href=\"https://iconos8.es/\">iconos8.es</a><br/>\n" +
                    "     *    <b>String px</b> is a size to the icon\n" +
                    "     * </html>\n" +
                    "     */"
                    +"public URL "+files[i]
                    .replace("icons8_","")
                    .replace("_100px","")
                    .replace(".png","")
                    +"(){\n" +
                    "        try {\n" +
                    "            URL url =  new URL(\"http://javabrain2.webcindario.com/icon-color/alphabet/"+files[i]+"\");\n" +
                    "            return url;\n" +
                    "        } catch (MalformedURLException e) {\n" +
                    "            e.printStackTrace();\n" +
                    "        }\n" +
                    "        return null;\n" +
                    "    }\n\n");
        }

    }

}

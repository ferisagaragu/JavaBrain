package test;

import java.io.*;

public class DoLibrari {

    public static  void main(String[] args){

            try {
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("java_brain.xml"), "utf-8"));
                out.write("<component name=\"libraryTable\">\n" +
                        "  <library name=\"java-brain\">\n" +
                        "    <CLASSES>\n" +
                        "      <root url=\"jar://$PROJECT_DIR$/lib/java-brain.jar!/\" />\n" +
                        "    </CLASSES>\n" +
                        "    <JAVADOC />\n" +
                        "    <SOURCES />\n" +
                        "  </library>\n" +
                        "</component>");
                out.close();
            } catch (Exception e) {
            }




    }

}

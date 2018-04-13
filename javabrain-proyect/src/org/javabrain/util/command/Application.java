package org.javabrain.util.command;

import java.io.*;

/***
 * @author Fernando García
 * @version 0.0.1
 */
public class Application {

    public static String execute(String command) {

        String s = "";
        String out = "";

        try {

            String so = System.getProperty("os.name");
            String comando;
            if (so.equals("Linux")) {
                comando = "ifconfig";
            } else {
                comando = "cmd /c " + command;
            }

            Process p = Runtime.getRuntime().exec(comando);
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
            BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            while ((s = stdInput.readLine()) != null) {
                out += s;
            }
            while ((s = stdError.readLine()) != null) {
                out += s;
            }

        } catch (IOException e) {}

        return out;
    }
}

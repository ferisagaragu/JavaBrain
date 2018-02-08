import org.javabrain.config.Paths;

import java.io.File;

public class run {

    public static void main(String[] args){

        Paths paths = Paths.getInstance();

        File file = new File(paths.getJSONPath());
        System.out.println(file.list()[0]);
    }


}


import java.io.File;
import org.javabrain.general.config.Paths;

public class run {

    public static void main(String[] args){

        Paths paths = Paths.getInstance();

        File file = new File(paths.getJSONPath());
        System.out.println(file.list()[0]);
    }


}

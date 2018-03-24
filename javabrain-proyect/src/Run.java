import org.javabrain.util.alerts.Console;
import org.javabrain.util.data.JSON;

import java.util.HashMap;
import java.util.Map;

public class Run {

    public static void main(String[] args){

        JSON json = new JSON();
        json.setJSON("{\n" +
                "  \"saludo\":\"buena niña\",\n" +
                "  \"array\":[{\"el\":\"arturo\",\"ella\":\"11\"}]\n" +
                "}");

        json.putJSON("ellos","un grupo");
        JSON json2 = json.getJSONArray("array",0);

        Map<Object,Object> map = new HashMap<>();
        map.put("uno","1");
        map.put("dos","2");

        Console.blue(json.putJSONArray("hola",map));

        Map<Object,Object> map2 = new HashMap<>();
        map2.put("cuatro","1");
        map2.put("cinco","2");

        json.putInJSONArray("hola",map2);
        Console.cyan(json.toJSONString());
    }

}

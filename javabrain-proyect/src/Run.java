import org.javabrain.util.alerts.Console;
import org.javabrain.util.command.Application;
import org.javabrain.util.data.JSON;

import java.util.HashMap;
import java.util.Map;

public class Run {

    public static void main(String[] args){

        String comando = Application.execute("type C:\\Roms\\a.txt");
        Console.black(comando);

        JSON json = JSON.getInstance();
        json.setJSON("{\n" +
                "  \"addsgas\": [\n" +
                "    {\n" +
                "      \"namea\": \"maquina1\",\n" +
                "      \"hours\": \"2018-03-01 13:28:00\",\n" +
                "      \"costo\": 36,\n" +
                "      \"liters\": 25,\n" +
                "      \"id\": 1\n" +
                "    }\n" +
                "  ],\n" +
                "  \"namec\": \"Vehículo\",\n" +
                "  \"costo\": 256,\n" +
                "  \"kmi\": 26,\n" +
                "  \"kmf\": 36,\n" +
                "  \"id\": 1,\n" +
                "  \"gangsid\": 2,\n" +
                "  \"estatus\": 1\n" +
                "}");
        Console.black(json);
        Map<Object,Object> map = new HashMap<>();
        map.put("otro","son a ba bich");

        json.putJSONArray("addsgas",map);
        Console.black(json);
    }

}

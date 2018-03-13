import brain.building.DNA;
import org.javabrain.util.web.service.Language;
import org.javabrain.util.web.service.Traductor;

import javax.swing.*;

public class Main {

    public static void main(String[] args){
        /*JOptionPane.showMessageDialog(null,"Hola wee");
        DNA dna = DNA.getInstance();*/
        String data = Traductor.autoTraslate(Language.ENGLISH,"Oigan amigos, oigan amigos escuchenme a mi!!");
        System.out.println(data);
    }

}

package org.javabrain.swing.container;

import brain.building.DNA;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    private DNA dna;

    public Frame() throws HeadlessException {
        dna = DNA.getInstance();
        setTitle(dna.title);
        getContentPane().setBackground(Color.WHITE);
        setIconImage(new ImageIcon(getClass().getResource("/res/icon.png")).getImage());
    }

    public void showOnCenter(){
        setLocationRelativeTo(null);
        setVisible(true);

    }


}

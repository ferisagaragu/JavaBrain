package org.javabrain.custom;

import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author Fernando García
 */
public class Frame extends JFrame{

    public Frame() {
        
        getContentPane().setBackground(Color.white);
        setSize(600,400);
    }
    
    public void showOnCenter(){
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    
}

package com.google.traductor;

import javax.swing.JFrame;

/**
 *
 * @author Fernando García
 */
public class Frame extends JFrame{

    public void showOnCenter(){
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void hideWindow(){
        setVisible(false);
    }
}

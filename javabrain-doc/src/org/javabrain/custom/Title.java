package org.javabrain.custom;

import java.awt.Font;
import javax.swing.JLabel;

/**
 *
 * @author Fernando García
 */
public class Title extends JLabel{

    public Title() {
        org.javabrain.fount.Font f = org.javabrain.fount.Font.getInstance();
        setFont(new Font("Helvetica 35 Thin",0,18));
    }
    
    
    
}

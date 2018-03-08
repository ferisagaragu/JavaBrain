/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javabrain.custom;

import java.awt.Font;
import javax.swing.JLabel;

/**
 *
 * @author Fernando García
 */
public class PlainText extends JLabel{

    public PlainText() {
        org.javabrain.fount.Font f = org.javabrain.fount.Font.getInstance();
        setFont(new Font("Helvetica 35 Thin",0,16));
    }
    
    
    
}

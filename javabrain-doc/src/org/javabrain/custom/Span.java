package org.javabrain.custom;

import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author Fernando García
 */
public class Span extends JPanel{

    private Color spanColor;
    private Title title;
    
    public Span() {
        spanColor = new java.awt.Color(92, 184, 92);
        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(0, 3, 0, 0,spanColor), javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 1, new java.awt.Color(204, 204, 204))));
        setSize(500,100);
    }

    public Color getSpanColor() {
        return spanColor;
    }

    public void setSpanColor(Color spanColor) {
        this.spanColor = spanColor;
        setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(0, 3, 0, 0,spanColor), javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 1, new java.awt.Color(204, 204, 204))));
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title spanTitle) {
        this.title = spanTitle;
        String text = this.title.getText();
        this.title.setText(text);
        this.title.setForeground(spanColor);
    }
    
}

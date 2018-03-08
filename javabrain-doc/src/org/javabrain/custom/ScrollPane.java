package org.javabrain.custom;

import java.awt.Color;
import javax.swing.JScrollPane;

/**
 *
 * @author Fernny
 */
public class ScrollPane extends JScrollPane{

    public ScrollPane() {
        setHorizontalScrollBar(new ScrollPaneBar().getHorizontalScrollBar());
        setVerticalScrollBar(new ScrollPaneBar().getVerticalScrollBar());
        setBackground(Color.WHITE);
        setBorder(null);
    }
    
    
    
}

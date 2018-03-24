package org.javabrain.swing.container;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.text.JTextComponent;

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
    
    public boolean clearTextComponets(){
        try{clearText(this.getContentPane().getComponents());}catch(Exception e){return false;}
        return true;
    }

    public boolean setEnabledComponets(boolean in){
        try{enabledComponents(this.getContentPane().getComponents(),in);}catch(Exception e){return false;}
        return true;
    }

    private void clearText(Component[] components){
        for (Component component : components) {

            try{
                JTextComponent jtc = (JTextComponent) component;
                jtc.setText("");
            }catch(Exception e){}
            
            try{
                JScrollPane j = (JScrollPane) component;
                clearText(j.getViewport().getComponents());
            }catch(Exception e){}
            
            try{
                JPanel panel = (JPanel) component;
                clearText(panel.getComponents());
                
            }catch(Exception e){}

        }
    }

    public void enabledComponents(Component[] components,boolean in){
        for (Component component : components) {
            component.setEnabled(in);

            try{
                JScrollPane j = (JScrollPane) component;
                enabledComponents(j.getViewport().getComponents(),in);
            }catch(Exception e){}

            try{
                JPanel panel = (JPanel) component;
                enabledComponents(panel.getComponents(),in);

            }catch(Exception e){}

        }
    }
    
}

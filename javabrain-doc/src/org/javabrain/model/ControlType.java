package org.javabrain.model;

/**
 *
 * @author Fernando García
 */
public class ControlType{
    
    public static ControlType LABEL = new ControlType(0);
    public static ControlType BUTTON = new ControlType(1);
    
    public static ControlType FXLABEL = new ControlType(100);
    public static ControlType FXBUTTON = new ControlType(101);
    
    private int type;

    public ControlType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

}

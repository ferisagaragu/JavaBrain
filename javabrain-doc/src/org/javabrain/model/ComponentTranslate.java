package org.javabrain.model;

import java.util.jar.Attributes;

/**
 *
 * @author Fernando García
 */
public class ComponentTranslate {
    
    
    
    private int type;
    private Object component;

    public ComponentTranslate(ControlType type,Object component) {
        this.type = type.getType();
        this.component = component;
    }

    public int getType() {
        return type;
    }

    public Object getComponent() {
        return component;
    }
    
    

}

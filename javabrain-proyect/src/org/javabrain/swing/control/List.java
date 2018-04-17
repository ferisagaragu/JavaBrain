package org.javabrain.swing.control;


import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.javabrain.swing.container.ScrollPanel;

public class List extends ScrollPanel implements MouseListener{

    //Private
    private Map<Object, Component> map;
    private Map<Component, Color> colors;
    private JPanel panel;
    private String message;
    private Color listColor;
    private Color originalColor;
    private boolean isRemove = true;
    private int grindMode;
    private Component selectedComponet;
    //===========================================================

    //Modes
    public static int VERTICAL_MODE = 0;
    public static int HORIZONTAL_MODE = 1;
    //===========================================================

    public List() {
        setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
        setPreferredSize(new Dimension(300,400));
        
        map = new LinkedHashMap<>();
        colors = new LinkedHashMap<>();
        panel = new JPanel();
        
        message = "No items on list";
        panel.setBackground(Color.WHITE);
        
        noItem();
        getViewport().setBackground(Color.white);
        grindMode = 0;
        VERTICAL_MODE = map.size();
    }
    
    //Renders
    private void noItem(){
        panel.removeAll();
        panel.setLayout(new GridLayout(1,0));
        JLabel messageL = new JLabel();
        messageL.setPreferredSize(new Dimension(panel.getWidth(),panel.getHeight()));
        messageL.setText("<html><br>"+this.message+"</html>");
        messageL.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        messageL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        messageL.setFont(new Font(messageL.getFont().getName(), 0, 16)); // NOI18N
        
        panel.add(messageL);
        getViewport().add(panel);
    }
    
    private void renderItems() {
        getViewport().removeAll();
        panel.removeAll();
        switch (grindMode) {
            case 0:
                panel.setLayout(new GridLayout(map.size(), 0));
                setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_AS_NEEDED);
                setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
                break;
            case 1:
                panel.setLayout(new GridLayout(grindMode, 0));
                setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_NEVER);
                setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_AS_NEEDED);
                break;
            default:
                panel.setLayout(new GridLayout(grindMode, 0));
                setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_AS_NEEDED);
                setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_AS_NEEDED);
                
        }
        
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            Object key = it.next();
            panel.add(map.get(key));
            
        }
        
        panel.setVisible(false);
        panel.setVisible(true);
        getViewport().add(panel); 
    }

    private void selectedColor(){
        if (selectedComponet != null) {
            selectedComponet.setBackground(originalColor);
        }
        map.forEach((k,o)->{
            colors.put(o,o.getBackground());
        });
        colors.forEach((k,o)->{
            k.setBackground(o);
        });
    }


    //===========================================================
    
    //Funciones de la lista
    public void addItem(Object key, Component component) {
        map.put(key, component);
        component.addMouseListener(this);
    }
    
    public void addItemAndShow(Object key, Component component){
        addItem(key,component);
        switch(grindMode){
            case 0:
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        renderItems();
                        getVerticalScrollBar().setValue(panel.getHeight());
                    }
                });
                thread.start();
                break;
            case 1:
                Thread thread2 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        renderItems();
                        getHorizontalScrollBar().setValue(panel.getWidth());
                    }
                });
                thread2.start();
                break;
            default:
                Thread thread3 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        renderItems();
                    }
                });
                thread3.start();
        }        
    }
    
    public void showItems(){
        
        if(map.size() == 0){
            noItem();
        } else {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    renderItems();
                }
            });
            thread.start();
        }      
    }
    
    public void removeItem(Object key) {

        if (isRemove) {
            isRemove = false;
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {

                    int y = 0;
                    int x = 0;
                    while (y < getItem(key).getWidth()) {
                        try {
                            getItem(key).setLocation(getItem(key).getX() + x, getItem(key).getY());
                            x++;
                            if (getItem(key).getWidth() > 1000) {
                                y = y + 20;
                            } else {
                                y = y + 10;
                            }
                            Thread.sleep(10);
                        } catch (InterruptedException ex) {}
                    }
                    map.remove(key);
                    showItems();
                    isRemove = true;
                }
            });
            thread.start();
        }

    }
    
    public Component getItem(Object key){
        return map.get(key);
    }

    public Component getSelectdItem(){
        return selectedComponet;
    }

    public void setSelectedItem(Object key){
        selectedColor();
        selectedComponet = map.get(key);
        selectedComponet.setBackground(Color.decode("#CFD8DC"));
    }

    //==========================================================

    //gets and sets
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
        System.out.println(this.message);
        noItem();
    }

    public Color getListColor() {
        return listColor;
    }

    public void setListColor(Color listColor) {
        this.listColor = listColor;
        panel.setBackground(listColor);
    }

    public Map<Object, Component> getMap() {
        return map;
    }

    public void setMap(Map<Object, Component> map) {
        this.map = map;
        showItems();
    }
    
    public int itemSize(){
        return map.size();
    }

    public int getGrindMode() {
        return grindMode;
    }

    public void setGrindMode(int grind) {
        this.grindMode = grind;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        selectedColor();
        selectedComponet = (Component) e.getSource();
        originalColor = selectedComponet.getBackground();
        selectedComponet.setBackground(Color.decode("#CFD8DC"));
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

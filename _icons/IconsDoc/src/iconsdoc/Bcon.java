/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iconsdoc;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author QualtopGroup
 */
public class Bcon extends ImageIcon{
    
    private ImageIcon img;

    public Bcon(ImageIcon image) {
        img = image;
    }
    
    public ImageIcon px(int escale){
        ImageIcon icon = null;
        try{
            icon = new ImageIcon(img.getImage().getScaledInstance(escale,escale,Image.SCALE_SMOOTH));
        }catch(Exception e){}
        return icon;
    }
    
    public ImageIcon px(int scaleW,int scaleH){
        ImageIcon icon = null;
        try{
            icon = new ImageIcon(img.getImage().getScaledInstance(scaleW,scaleH,Image.SCALE_SMOOTH));
        }catch(Exception e){}
        return icon;
    }
    
}

package org.javabrain.swing.control;

import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicButtonUI;

/**
 *
 * @author Fernando García
 */
public class Tag extends JButton{
    
    private final Color PRIMARY = new Color(249,249,249);

    public Tag() {
        super();
        setBorder(null);
        setForeground(new Color(51,51,51));
        setSize(90,26);
        setPreferredSize(new Dimension(90, 24));
        setBackground(PRIMARY);
        setFocusPainted(false);
        setFocusable(false);
    }

    
    @Override
    public void updateUI() {
        super.updateUI(); //To change body of generated methods, choose Tools | Templates.
        RoundedCornerTagUI buttonUI = new RoundedCornerTagUI();
        setUI(buttonUI);
    }
    
}

class RoundedCornerTagUI extends BasicButtonUI{
  private static final float arcwidth  = 16.0f;
  private static final float archeight = 16.0f;
  protected static final int focusstroke = 2;
  private Color fc = Color.WHITE;
  private Color ac = Color.WHITE;
  private Color rc = Color.WHITE;
  protected Shape shape;
  protected Shape border;
  protected Shape base;

  @Override protected void installDefaults(AbstractButton b) {
    super.installDefaults(b);
    b.setContentAreaFilled(false);
    b.setOpaque(false);
    b.setBackground(new Color(250, 250, 250));
    initShape(b);
  }

  @Override public void paint(Graphics g, JComponent c) {
    Graphics2D g2 = (Graphics2D)g;
    AbstractButton b = (AbstractButton) c;
    ButtonModel model = b.getModel();
    initShape(b);
    //ContentArea
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
    if(model.isArmed()) {
      g2.setColor(ac);
      g2.fill(shape);
    }else if(b.isRolloverEnabled() && model.isRollover()) {
      paintFocusAndRollover(g2, c, rc);
    }else if(b.hasFocus()) {
      paintFocusAndRollover(g2, c, fc);
    }else{
      g2.setColor(c.getBackground());
      g2.fill(shape);
    }
    //Border
    g2.setPaint(c.getForeground());
    g2.draw(shape);

    g2.setColor(c.getBackground());
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_OFF);
    super.paint(g2, c);
  }
  private void initShape(JComponent c) {
    if(!c.getBounds().equals(base)) {
      base = c.getBounds();
      shape = new RoundRectangle2D.Float(0, 0, c.getWidth()-1, c.getHeight()-1,
                                         arcwidth, archeight);
      border = new RoundRectangle2D.Float(focusstroke, focusstroke,
                        c.getWidth()-1-focusstroke*2,
                        c.getHeight()-1-focusstroke*2,
                        arcwidth, archeight);
    }
  }
  private void paintFocusAndRollover(Graphics2D g2, JComponent c, Color color) {
    g2.setPaint(new GradientPaint(0, 0, color, c.getWidth()-1, c.getHeight()-1,
                                  color.brighter(), true));
    g2.fill(shape);
    g2.setColor(c.getBackground());
    g2.fill(border);
  }

    public void setFc(Color fc) {
        this.fc = fc;
        this.rc = fc;
    }


}

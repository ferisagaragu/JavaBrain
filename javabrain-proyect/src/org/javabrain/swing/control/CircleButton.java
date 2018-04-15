package org.javabrain.swing.control;

import org.javabrain.swing.animation.ElevationEffectCircle;
import org.javabrain.swing.animation.RippleEffect;
import org.javabrain.swing.animation.ShadowCircle;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;

/**
 * A Material Design button.
 *
 * @see
 * <a href="https://www.google.com/design/spec/components/buttons.html">Buttons
 * (Google design guidelines)</a>
 */
public class CircleButton extends JButton {

    private RippleEffect ripple;
    private ElevationEffectCircle elevation;
    private Type type = Type.DEFAULT;
    private boolean isMousePressed = false;
    private boolean isMouseOver = false;
    private Color rippleColor = Color.WHITE;
    private Cursor cursor = super.getCursor();

    //Propiedades para botton
    private Icon icono = new ImageIcon(getClass().getResource("/res/component/user.png"));
    private ImageIcon imagenIcon = (ImageIcon) this.icono;
    private Image image = this.imagenIcon.getImage();
    private Image image_default = this.image;
    private RippleEffect rippleC;
    private ElevationEffectCircle elevationC;
    private boolean isImage = false;

    /**
     * Creates a new button.
     */
    public CircleButton() {
        ripple = RippleEffect.applyTo(this);
        elevation = ElevationEffectCircle.applyTo(this, 1);
        setOpaque(false);
        setPreferredSize(new Dimension(60, 60));
        setText("");

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                isMousePressed = true;
            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
                isMousePressed = false;
                repaint();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                isMouseOver = true;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                isMouseOver = false;
                repaint();
            }
        });


        setUI(new BasicButtonUI() {
            @Override
            public boolean contains(JComponent c, int x, int y) {
                return x > ShadowCircle.OFFSET_LEFT && y > ShadowCircle.OFFSET_TOP
                        && x < getWidth() - ShadowCircle.OFFSET_RIGHT && y < getHeight() - ShadowCircle.OFFSET_BOTTOM;
            }
        });
    }

    //GETS
    public Type getType() {
        return type;
    }
    
    public Color getRippleColor() {
        return rippleColor;
    }
    
    private int getElevation() {
        if (isMousePressed) {
            return 2;
        } else if (type == Type.RAISED || isFocusOwner() || isMouseOver) {
            return 1;
        } else {
            return 0;
        }
    }

    //==========================================================
    //SETS
    public void setType(Type type) {
        this.type = type;
        repaint();
    }
    
    public void setRippleColor(Color rippleColor) {
        this.rippleColor = rippleColor;
    }

    @Override
    public void setEnabled(boolean b) {
        super.setEnabled(b);
        elevation.setLevel(getElevation());
        super.setCursor(b ? cursor : Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }

    @Override
    public void setCursor(Cursor cursor) {
        super.setCursor(cursor);
        this.cursor = cursor;
    }
    
    public void setImagen(Icon icon) {
        
        //Propiedades para la foto
        rippleC = RippleEffect.applyTo(this);
        elevationC = ElevationEffectCircle.applyCirularTo(this, 1);
        setCursor(new Cursor(12));
        setContentAreaFilled(false);
        setBorderPainted(false);
        setPreferredSize(new Dimension(60,60));
        isImage = true;
        
        if (icon != null) {
            this.icono = icon;
            this.imagenIcon = ((ImageIcon) this.icono);
            this.image = this.imagenIcon.getImage();
        } else {
            this.image = this.image_default;
        }
        repaint();
        setText("");
    }

    //==========================================================
    
    @Override
    protected void processFocusEvent(FocusEvent focusEvent) {
        super.processFocusEvent(focusEvent);
        elevation.setLevel(getElevation());
    }

    @Override
    protected void processMouseEvent(MouseEvent mouseEvent) {
        super.processMouseEvent(mouseEvent);
        elevation.setLevel(getElevation());
    }
    
    @Override
    protected void paintComponent(Graphics g) {

        if (isImage) {
            super.paintComponent(g);
            int w = getWidth()+2;
            int h = getHeight()+2;

            elevation.paint(g);
            g.drawString("", 0, 0);

            Graphics2D g2 = (Graphics2D) g.create();
            g2.translate(ShadowCircle.OFFSET_LEFT, ShadowCircle.OFFSET_TOP);
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

            final int offset_lr = ShadowCircle.OFFSET_LEFT + ShadowCircle.OFFSET_RIGHT;
            final int offset_td = ShadowCircle.OFFSET_TOP + ShadowCircle.OFFSET_BOTTOM;

            g2.fill(new Ellipse2D.Double(0, 0, w - offset_lr, offset_td - h));

            g2.setClip(new Ellipse2D.Float(0, 0, w - offset_lr, h - offset_td));
            g2.drawImage(this.image, 0, 0, w - offset_lr, h - offset_td, this);

            g2.setClip(new RoundRectangle2D.Float(0, 0, getWidth() - offset_lr, getHeight() - offset_td, 100, 100));
            ripple.paint(g2);

            g2.dispose();

        } else {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

            if (type != Type.FLAT && isEnabled()) {
                elevation.paint(g);
            }
            g2.translate(ShadowCircle.OFFSET_LEFT, ShadowCircle.OFFSET_TOP);

            final int offset_lr = ShadowCircle.OFFSET_LEFT + ShadowCircle.OFFSET_RIGHT;
            final int offset_td = ShadowCircle.OFFSET_TOP + ShadowCircle.OFFSET_BOTTOM;

            if (isEnabled()) {
                g2.setColor(getBackground());
                g2.fill(new RoundRectangle2D.Float(0, 0, getWidth() - offset_lr, getHeight() - offset_td, 100, 100));

                g2.setColor(new Color(rippleColor.getRed() / 255f, rippleColor.getBlue() / 255f, rippleColor.getBlue() / 255f, 0.12f));
                if ((type == Type.FLAT && isMouseOver) || isFocusOwner()) {
                    g2.fill(new RoundRectangle2D.Float(0, 0, getWidth() - offset_lr, getHeight() - offset_td, 100, 100));
                }
            } else {
                Color bg = getBackground();
                g2.setColor(new Color(bg.getRed() / 255f, bg.getGreen() / 255f, bg.getBlue() / 255f, 0.6f));
                g2.fill(new RoundRectangle2D.Float(0, 0, getWidth() - offset_lr, getHeight() - offset_td, 100, 100));
            }

            FontMetrics metrics = g.getFontMetrics(getFont());
            int x = (getWidth() - offset_lr - metrics.stringWidth(getText().toUpperCase())) / 2;
            int y = (getHeight() - offset_td - metrics.getHeight()) / 2 + metrics.getAscent();
            g2.setFont(getFont());
            if (isEnabled()) {
                g2.setColor(getForeground());
            } else {
                Color fg = getForeground();
                g2.setColor(new Color(fg.getRed() / 255f, fg.getGreen() / 255f, fg.getBlue() / 255f, 0.6f));
            }
            g2.drawString(getText().toUpperCase(), x, y);

            if (isEnabled()) {
                g2.setClip(new RoundRectangle2D.Float(0, 0, getWidth() - offset_lr, getHeight() - offset_td, 100, 100));
                g2.setColor(rippleColor);
                ripple.paint(g2);
            }
        }

    }

    @Override
    protected void paintBorder(Graphics g) {
        if (isImage) {
            int w = getWidth() + 1;
            int h = getHeight() + 2;
            final int offset_lr = ShadowCircle.OFFSET_LEFT + ShadowCircle.OFFSET_RIGHT;
            final int offset_td = ShadowCircle.OFFSET_TOP + ShadowCircle.OFFSET_BOTTOM;

            Graphics2D g2 = (Graphics2D) g.create();
            g2.translate(ShadowCircle.OFFSET_LEFT, ShadowCircle.OFFSET_TOP);
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setStroke(new BasicStroke(1));
            g2.setColor(Color.decode("#BCBCBC"));
            g2.drawOval(0, 0, w - offset_lr, h - offset_td);
            g2.dispose();
        }
    }
    
    @Override
    public void setText(String text) {
        if(isImage){
            super.setText("");
        }else{
            super.setText(text);
        }
        
    }

    //ENUMS
    public enum Type {
        DEFAULT,
        RAISED,
        FLAT
    }
    //==========================================================
}

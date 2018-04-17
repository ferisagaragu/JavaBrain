package org.javabrain.swing.control;

import org.javabrain.swing.animation.SafePropertySetter;
import org.javabrain.swing.ui.TextFieldUI;
import org.jdesktop.core.animation.timing.Animator;
import org.jdesktop.core.animation.timing.interpolators.SplineInterpolator;
import org.jdesktop.swing.animation.timing.sources.SwingTimerTimingSource;

import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

public class TextField extends JTextField{

    private final Line line = new Line(this);

    private String hint = "";
    private Color hintColor;
    private Color lineColor;

    public TextField() {
        setBorder(null);
        setCaret(new DefaultCaret() {
            @Override
            protected synchronized void damage(Rectangle r) {
               TextField.this.repaint(); //fix caret not being removed completely
            }
        });
        setFont(new Font("Tahoma",0,14));
        setPreferredSize(new Dimension(150,25));
        hintColor = Color.gray;
        getCaret().setBlinkRate(500);
        setOpaque(true);
        setUI(new TextFieldUI(hint,hintColor,getFont().getSize(),getFont().getStyle(),getFont().getName()));
        lineColor = Color.decode("#3F51B5");
        setCaretColor(lineColor);
        setSelectionColor(lineColor);
        setSelectedTextColor(Color.WHITE);
    }

    @Override
    public void setText(String s) {
        super.setText(s);
        line.update();
    }

    @Override
    protected void processFocusEvent(FocusEvent e) {
        super.processFocusEvent(e);
        line.update();
    }

    @Override
    protected void processKeyEvent(KeyEvent e) {
        super.processKeyEvent(e);
        line.update();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.fillRect(0, 0, getWidth(), getHeight());
        g2.translate(0, -1);

        super.paintComponent(g);

        g2.translate(0, 9);
        g2.setColor(Color.BLACK);
        g2.fillRect(0,1,1, 1);
        g2.setColor(lineColor);
        g2.fillRect((int) ((getWidth() - line.getWidth()) / 2), getHeight() - 10, (int) line.getWidth(), 2);
    }

    @Override
    protected void paintBorder(Graphics g) {

    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
        setUI(new TextFieldUI(hint,hintColor,getFont().getSize(),getFont().getStyle(),getFont().getName()));
    }

    public Color getHintColor() {
        return hintColor;
    }

    public void setHintColor(Color hintColor) {
        this.hintColor = hintColor;
        setUI(new TextFieldUI(hint,hintColor,getFont().getSize(),getFont().getStyle(),getFont().getName()));
    }

    public Color getLineColor() {
        return lineColor;
    }

    public void setLineColor(Color lineColor) {
        this.lineColor = lineColor;
        repaint();
    }

    public static class Line {
        private final SwingTimerTimingSource timer;
        private final JComponent target;
        private Animator animator;
        private final SafePropertySetter.Property<Double> width;

        Line(JComponent target) {
            this.target = target;
            this.timer = new SwingTimerTimingSource();
            timer.init();
            width = SafePropertySetter.animatableProperty(target, 0d);
        }

        void update() {
            if (animator != null) {
                animator.stop();
            }
            animator = new Animator.Builder(timer)
                    .setDuration(200, TimeUnit.MILLISECONDS)
                    .setEndBehavior(Animator.EndBehavior.HOLD)
                    .setInterpolator(new SplineInterpolator(0.4, 0, 0.2, 1))
                    .addTarget(SafePropertySetter.getTarget(width, width.getValue(), target.isFocusOwner() ? (double) target.getWidth() + 1 : 0d))
                    .build();
            animator.start();
        }

        public double getWidth() {
            return width.getValue();
        }
    }

}

package org.javabrain.swing.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Arc2D;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicProgressBarUI;

public class ProgressCircleUI extends BasicProgressBarUI {

    public static Color colorText = new Color(0, 0, 0);

    protected Color getSelectionBackground() {
        return colorText;
    }

    public Dimension getPreferredSize(JComponent c) {
        Dimension d = super.getPreferredSize(c);
        int v = Math.max(d.width, d.height);
        d.setSize(v, v);
        return d;
    }

    public void paint(Graphics g, JComponent c) {
        Insets b = this.progressBar.getInsets();
        int barRectWidth = this.progressBar.getWidth() - b.right - b.left;
        int barRectHeight = this.progressBar.getHeight() - b.top - b.bottom;
        if ((barRectWidth <= 0) || (barRectHeight <= 0)) {
            return;
        }

        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setPaint(this.progressBar.getForeground());
        double degree = 360.0D * this.progressBar.getPercentComplete();
        double sz = Math.min(barRectWidth, barRectHeight);
        double cx = b.left + barRectWidth * 0.5D;
        double cy = b.top + barRectHeight * 0.5D;
        double or = sz * 0.5D;
        double ir = or * 0.5D;
        Shape inner = new Ellipse2D.Double(cx - ir, cy - ir - 5, ir * 2.0D, ir * 2.6D);
        Shape outer = new Arc2D.Double(cx - or, cy - or, sz, sz, 90.0D - degree, degree, 2);

        Area area = new Area(outer);
        area.subtract(new Area(inner));
        g2.fill(area);
        g2.dispose();

        if (this.progressBar.isStringPainted()) {
            paintString(g, b.left, b.top, barRectWidth, barRectHeight, 0, b);
        }
    }
}

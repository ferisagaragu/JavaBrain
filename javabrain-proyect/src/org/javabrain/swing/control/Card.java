package org.javabrain.swing.control;

import org.javabrain.swing.animation.RippleEffect;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Fernando García
 */
public class Card extends JPanel {

    public static final int DETAIL_MODE_LEFT = 0;
    public static final int SMALL_MODE_LEFT = 1;
    public static final int DETAIL_MODE_RIGHT = 2;
    public static final int SMALL_MODE_RIGHT = 3;
    public static final int DETAIL_MODE_TOP = 4;
    public static final int SMALL_MODE_TOP = 5;
    
    private String title;
    private String text;
    private RippleEffect ripple;
    private CircleButton icon;
    private JLabel textL;
    private JLabel titleL;
    private int mode;
    private JPanel line;
    
    public Card() {
        mode = 0;
        initComponents();
        ripple = RippleEffect.applyTo(this);
        char letter = titleL.getText().replace("<html>","").replace("</html>","").toLowerCase().charAt(0);
        icon.setBackground(colorLetter(letter));
        ripple.setColor(Color.decode("#E4E5E5"));
        setTitle(title);
        repaint();
    }
    
    private void initComponents() {

        switch (mode) {
            case 0:
                titleL = new JLabel();
                textL = new JLabel();
                textL.setHorizontalAlignment(JLabel.LEFT);
                icon = new CircleButton();

                setBackground(new Color(255, 255, 255));
                setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(230, 230, 230)));
                addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        formMouseClicked(evt);
                    }
                });

                titleL.setFont(new Font("Tahoma", 0, 20)); // NOI18N
                titleL.setText("<html>Title</html>");

                textL.setBackground(new Color(204, 204, 204));
                textL.setFont(new Font("Tahoma", 0, 14)); // NOI18N
                textL.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
                textL.setText("<html>Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500, cuando un impresor (N. del T. persona que se dedica a la imprenta) desconocido usó una galería de textos y los mezcló de tal manera que logró hacer un libro de textos especimen.</html>");
                textL.setVerticalAlignment(javax.swing.SwingConstants.TOP);
                textL.setEnabled(false);

                icon.setBackground(Color.decode("#CDDC39"));
                icon.setForeground(new Color(255, 255, 255));
                icon.setText("T");
                icon.setFont(new Font("Roboto Medium", 0, 32)); // NOI18N

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(titleL, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                                                .addComponent(textL, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                        .addContainerGap())
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(titleL, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(textL))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(0, 0, Short.MAX_VALUE)))
                                        .addGap(18, 18, 18))
                );

                title = "My title";
                break;

            case 1:

                titleL = new JLabel();
                icon = new CircleButton();

                setBackground(new Color(255, 255, 255));
                setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(230, 230, 230)));
                addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        formMouseClicked(evt);
                    }
                });

                titleL.setFont(new Font("Tahoma", 0, 20)); // NOI18N
                titleL.setText("<html>Title</html>");

                icon.setBackground(Color.decode("#CDDC39"));
                icon.setForeground(new Color(255, 255, 255));
                icon.setText("T");
                icon.setFont(new Font("Roboto Medium", 0, 32)); // NOI18N

                javax.swing.GroupLayout layout1 = new javax.swing.GroupLayout(this);
                this.setLayout(layout1);
                layout1.setHorizontalGroup(
                        layout1.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout1.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(titleL, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                                        .addContainerGap())
                );
                layout1.setVerticalGroup(
                        layout1.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout1.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addGroup(layout1.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(titleL, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addContainerGap(15, Short.MAX_VALUE))
                );
                break;

            case 2:

                titleL = new JLabel();
                textL = new JLabel();
                icon = new CircleButton();

                setBackground(new Color(255, 255, 255));
                setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(230, 230, 230)));

                icon.setBackground(Color.decode("#CDDC39"));
                icon.setForeground(new Color(255, 255, 255));
                icon.setText("T");
                icon.setFont(new Font("Roboto Medium", 0, 32)); // NOI18N

                titleL.setFont(new Font("Tahoma", 0, 20)); // NOI18N
                titleL.setText("<html>Title</html>");

                textL.setBackground(new Color(204, 204, 204));
                textL.setFont(new Font("Tahoma", 0, 14)); // NOI18N
                textL.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
                textL.setText("<html>Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500, cuando un impresor (N. del T. persona que se dedica a la imprenta) desconocido usó una galería de textos y los mezcló de tal manera que logró hacer un libro de textos especimen.<br></html>");
                textL.setVerticalAlignment(javax.swing.SwingConstants.TOP);
                textL.setEnabled(false);

                javax.swing.GroupLayout layout2 = new javax.swing.GroupLayout(this);
                this.setLayout(layout2);
                layout2.setHorizontalGroup(
                        layout2.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout2.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(layout2.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(titleL, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                                                .addComponent(textL, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap())
                );
                layout2.setVerticalGroup(
                        layout2.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout2.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(layout2.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout2.createSequentialGroup()
                                                        .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGroup(layout2.createSequentialGroup()
                                                        .addComponent(titleL, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(textL, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                                                        .addGap(18, 18, 18))))
                );

                break;
            
            case 3:
                titleL = new JLabel();
                icon = new org.javabrain.swing.control.CircleButton();

                setBackground(new Color(255, 255, 255));
                setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(230, 230, 230)));

                titleL.setFont(new Font("Tahoma", 0, 20)); // NOI18N
                titleL.setText("<html>Title</html>");

                icon.setBackground(Color.decode("#CDDC39"));
                icon.setForeground(new Color(255, 255, 255));
                icon.setText("T");
                icon.setFont(new Font("Roboto Medium", 0, 32)); // NOI18N

                javax.swing.GroupLayout layout8 = new javax.swing.GroupLayout(this);
                this.setLayout(layout8);
                layout8.setHorizontalGroup(
                        layout8.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout8.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(titleL, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap())
                );
                layout8.setVerticalGroup(
                        layout8.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout8.createSequentialGroup()
                                        .addContainerGap(18, Short.MAX_VALUE)
                                        .addGroup(layout8.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(titleL, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addContainerGap(18, Short.MAX_VALUE))
                );
                break;
                
            case 4:
                textL = new JLabel();
                icon = new org.javabrain.swing.control.CircleButton();
                line = new JPanel();
                titleL = new JLabel();

                setBackground(new Color(255, 255, 255));
                setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(230, 230, 230)));

                textL.setBackground(new Color(204, 204, 204));
                textL.setFont(new Font("Tahoma", 0, 14)); // NOI18N
                textL.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
                textL.setText("<html>Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500, cuando un impresor (N. del T. persona que se dedica a la imprenta) desconocido usó una galería de textos y los mezcló de tal manera que logró hacer un libro de textos especimen.<br></html>");
                textL.setVerticalAlignment(javax.swing.SwingConstants.TOP);
                textL.setEnabled(false);
                
                icon.setBackground(Color.decode("#CDDC39"));
                icon.setText("L");
                icon.setForeground(Color.white);
                icon.setFont(new Font("Tahoma",0,50));
                textL.setHorizontalAlignment(JLabel.CENTER);
                line.setOpaque(false);
                
                line.setBackground(new Color(255, 255, 255));
                line.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(220, 219, 219)));

                titleL.setFont(new Font("Tahoma", 0, 20)); // NOI18N
                titleL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                titleL.setText("<html>Title</html>");

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(line);
                line.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(titleL)
                                        .addContainerGap())
                );
                jPanel1Layout.setVerticalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(titleL, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap())
                );

                javax.swing.GroupLayout layout3 = new javax.swing.GroupLayout(this);
                this.setLayout(layout3);
                layout3.setHorizontalGroup(
                        layout3.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout3.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(layout3.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(textL, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                                .addGroup(layout3.createSequentialGroup()
                                                        .addGap(0, 0, Short.MAX_VALUE)
                                                        .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(0, 0, Short.MAX_VALUE)))
                                        .addContainerGap())
                                .addGroup(layout3.createSequentialGroup()
                                        .addGap(64, 64, 64)
                                        .addComponent(line, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(64, 64, 64))
                );
                layout3.setVerticalGroup(
                        layout3.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout3.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(20, 20, 20)
                                        .addComponent(line, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(textL)
                                        .addGap(18, 18, 18))
                );
                break;
            
            case 5:
                icon = new org.javabrain.swing.control.CircleButton();
                line = new JPanel();
                titleL = new JLabel();

                setBackground(new Color(255, 255, 255));
                setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(230, 230, 230)));
                
                icon.setBackground(Color.decode("#CDDC39"));
                icon.setText("L");
                icon.setForeground(Color.white);
                icon.setFont(new Font("Tahoma",0,50));
                line.setOpaque(false);

                line.setBackground(new Color(255, 255, 255));
                line.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(220, 219, 219)));

                titleL.setFont(new Font("Tahoma", 0, 20)); // NOI18N
                titleL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                titleL.setText("<html>Title</html>");

                javax.swing.GroupLayout jPanel1Layout4 = new javax.swing.GroupLayout(line);
                line.setLayout(jPanel1Layout4);
                jPanel1Layout4.setHorizontalGroup(
                        jPanel1Layout4.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout4.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(titleL, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                                        .addContainerGap())
                );
                jPanel1Layout4.setVerticalGroup(
                        jPanel1Layout4.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout4.createSequentialGroup()
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(titleL, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap())
                );

                javax.swing.GroupLayout layout6 = new javax.swing.GroupLayout(this);
                this.setLayout(layout6);
                layout6.setHorizontalGroup(
                        layout6.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout6.createSequentialGroup()
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout6.createSequentialGroup()
                                        .addGap(64, 64, 64)
                                        .addComponent(line, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(64, 64, 64))
                );
                layout6.setVerticalGroup(
                        layout6.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout6.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(20, 20, 20)
                                        .addComponent(line, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                break;
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        ripple.paint(g);
    }
    
    private Color colorLetter(char letter){
        
        switch(letter){
            case 'a': return Color.decode("#32B578");
            case 'b': return Color.decode("#64B045");
            case 'c': return Color.decode("#E57267");
            case 'd': return Color.decode("#14A0CB");
            case 'e': return Color.decode("#E7711A");
            case 'f': return Color.decode("#F15722");
            case 'g': return Color.decode("#9E69AF");
            case 'h': return Color.decode("#4150A3");
            case 'i': return Color.decode("#607D8B");
            case 'j': return Color.decode("#4AB360");
            case 'k': return Color.decode("#795548");
            case 'l': return Color.decode("#3F51B5");
            case 'm': return Color.decode("#2196F3");
            case 'n': return Color.decode("#673AB7");
            case 'ñ': return Color.decode("#9C27B0");
            case 'o': return Color.decode("#009688");
            case 'p': return Color.decode("#00BCD4");
            case 'q': return Color.decode("#03A9F4");
            case 'r': return Color.decode("#4CAF50");
            case 's': return Color.decode("#8BC34A");
            case 't': return Color.decode("#CDDC39");
            case 'u': return Color.decode("#FF9800");
            case 'v': return Color.decode("#FF5722");
            case 'w': return Color.decode("#E91E63");
            case 'x': return Color.decode("#F50057");
            case 'y': return Color.decode("#FF9100");
            case 'z': return Color.decode("#00838F");
        }
        return Color.decode("#D32F2F");
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        titleL.setText("<html>"+title+"</html>");
        char letter = titleL.getText().replace("<html>","").replace("</html>","").toLowerCase().charAt(0);
        icon.setText(letter+"".toLowerCase());
        icon.setBackground(colorLetter(letter));
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        textL.setText("<html>"+text+"</html>");
        textL.setHorizontalAlignment(JLabel.LEFT);
    }

    public JLabel getTitleLabel() {
        return titleL;
    }

    public void setTitleLabel(JLabel titleLabel) {
        this.titleL = titleLabel;
    }

    public JLabel getTextLabel() {
        return textL;
    }

    public void setTextLabel(JLabel textLabel) {
        this.textL = textLabel;
    }

    public CircleButton getButton() {
        return icon;
    }

    public void setButton(CircleButton button) {
        this.icon = button;
    }
    
    

    private void formMouseClicked(java.awt.event.MouseEvent evt) {                                  
        repaint();
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
        initComponents();
    }

}

/**
 * RGBSelector
 */

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class RGBSelector extends JFrame {
    private static final long serialVersionUID = 1L;
    
    public RGBSelector(String titre) {
        super(titre);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.X_AXIS));
        this.setSize(new Dimension(450, 170));
        this.init();
        
        this.setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }
    
    public void init() {
        JPanel panelGauche = new JPanel();
        panelGauche.setLayout(new GridLayout(3, 2));
        panelGauche.setBorder(new EmptyBorder(10, 10, 10, 10));
        JPanel panelDroite = new JPanel();
        panelDroite.setLayout(new BoxLayout(panelDroite, BoxLayout.Y_AXIS));
        panelDroite.setBorder(new EmptyBorder(10, 10, 10, 10));
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();
        panel5.setBackground(new Color(127, 127, 127));
        panel5.setLayout(new BorderLayout());
        JLabel r = new JLabel("R : ");
        JLabel g = new JLabel("G : ");
        JLabel b = new JLabel("B : ");
        JSlider slider1 = new JSlider(0, 255);
        slider1.setMinorTickSpacing(1);
        JSlider slider2 = new JSlider(0, 255);
        slider2.setMinorTickSpacing(1);
        JSlider slider3 = new JSlider(0, 255);
        slider3.setMinorTickSpacing(1);
        JTextField text1 = new JTextField(3);
        text1.setText("" + slider1.getValue());
        JTextField text2 = new JTextField(3);
        text2.setText("" + slider2.getValue());
        JTextField text3 = new JTextField(3);
        text3.setText("" + slider3.getValue());
        String hex = String.format("#%02x%02x%02x", slider1.getValue(), slider2.getValue(), slider3.getValue());
        JTextField color = new JTextField(hex, 5);
        
        slider1.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent event) {
                text1.setText("" + slider1.getValue());
                panel5.setBackground(new Color(slider1.getValue(), slider2.getValue(), slider3.getValue()));
                String hex = String.format("#%02x%02x%02x", slider1.getValue(), slider2.getValue(), slider3.getValue());
                color.setText("" + hex);
            }
        });

        text1.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent ke) {
                String typed = text1.getText();
                if(!typed.matches("\\d+") || typed.length() > 3) {
                    return;
                }
                slider1.setValue(Integer.parseInt(typed));
            }
        });

        slider2.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent event) {
                text2.setText("" + slider2.getValue());
                panel5.setBackground(new Color(slider1.getValue(), slider2.getValue(), slider3.getValue()));
                String hex = String.format("#%02x%02x%02x", slider1.getValue(), slider2.getValue(), slider3.getValue());
                color.setText("" + hex);
            }
        });

        text2.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent ke) {
                String typed = text2.getText();
                if(!typed.matches("\\d+") || typed.length() > 3) {
                    return;
                }
                slider2.setValue(Integer.parseInt(typed));
            }
        });

        slider3.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent event) {
                text3.setText("" + slider3.getValue());
                panel5.setBackground(new Color(slider1.getValue(), slider2.getValue(), slider3.getValue()));
                String hex = String.format("#%02x%02x%02x", slider1.getValue(), slider2.getValue(), slider3.getValue());
                color.setText("" + hex);
            }
        });

        text3.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent ke) {
                String typed = text3.getText();
                if(!typed.matches("\\d+") || typed.length() > 3) {
                    return;
                }
                slider3.setValue(Integer.parseInt(typed));
            }
        });

        color.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent ke) {
                String typed = color.getText();
                typed = typed.replace("#", "");
                if (typed.length() != 6) {
                    return;
                }
                slider1.setValue(Integer.valueOf(typed.substring(0, 2), 16));
                slider2.setValue(Integer.valueOf(typed.substring(2, 4), 16));
                slider3.setValue(Integer.valueOf(typed.substring(4, 6), 16));
            }
        });
        
        panel1.add(r);
        panel1.add(slider1);
        panel1.add(text1);
        panel2.add(g);
        panel2.add(slider2);
        panel2.add(text2);
        panel3.add(b);
        panel3.add(slider3);
        panel3.add(text3);
        panel4.add(color);
        panelGauche.add(panel1);
        panelGauche.add(panel2);
        panelGauche.add(panel3);
        panelDroite.add(panel4);
        panelDroite.add(panel5);
        this.add(panelGauche);
        this.add(panelDroite);
    }
    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new RGBSelector("RGBSelector");
            }
        });
    }
}
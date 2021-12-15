package com.company;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

class MyFrame extends JFrame implements ItemListener{
    private JComboBox CB;
    private JButton B;
    private JLabel L;
    private String[] animals = new String[]{"Fox", "Wolf", "Bear", "Racoon"};
    private String[] files = new String[]{"foxM.png", "wolfM.png", "bearM.png", "raccoonM.png"};
    private ImageIcon[] imgs;

    public void itemStateChanged(ItemEvent e){
        L.setIcon(imgs[CB.getSelectedIndex()]);
    }
    MyFrame(){
        super("Output list");
        setBounds(250,250,310,160);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);

        imgs = new ImageIcon[files.length];

        for (int k = 0; k < imgs.length; k++) {
            imgs[k] = new ImageIcon(files[k]);
        }

        L = new JLabel(imgs[0]);
        L.setBounds(10,10,150,100);

        add(L);

        JLabel lbl = new JLabel("Choose!:");
        lbl.setBounds(170, 10, 120, 20);
        add(lbl);
        CB = new JComboBox(animals);
        CB.setBounds(170,40,120,30);
        CB.setSelectedIndex(0);
        CB.addItemListener(this);

        add(CB);

        B= new JButton("OK");
        B.setBounds(170,80,120,30);
        B.addActionListener(e ->System.exit(0));

        add(B);

        setVisible(true);
    }
}

public class JustAwindowApplication {
    public static void main(String[] args) {
        new MyFrame();
    }
}

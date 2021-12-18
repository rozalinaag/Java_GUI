package com.company;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


class MyFrame extends JFrame implements ItemListener {

    private JRadioButton[] R;
    private JButton B;
    private JLabel L;
    private String[] animals = new String[]{"Fox", "Wolf", "Bear", "Racoon"};
    private String[] files = new String[]{"foxM.png", "wolfM.png", "bearM.png", "raccoonM.png"};
    private ImageIcon[] imgs;

    public void itemStateChanged(ItemEvent e){
        for (int k = 0; k < R.length; k++) {
            if (R[k].isSelected()){
                L.setIcon(imgs[k]);
                break;
            }
        }
    }
    MyFrame(){
        super("Radio button");
        setBounds(250,250,310,185);
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

        ButtonGroup BG = new ButtonGroup();
        R = new JRadioButton[animals.length];
        for (int k = 0; k < R.length; k++) {
            R[k] = new JRadioButton(animals[k]);
            BG.add(R[k]);
            R[k].setBounds(170, 31+ 21*k, 120, 20);
            R[k].addItemListener(this);
            add(R[k]);
        }
        R[0].setSelected(true);

        B= new JButton("OK");
        B.setBounds(90,120,120,30);
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

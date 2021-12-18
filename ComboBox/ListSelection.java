package com.company;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class MyFrame extends JFrame implements ListSelectionListener {
    private JList LS;
    private JButton B;
    private JLabel L;
    private String[] animals = new String[]{"Fox", "Wolf", "Bear", "Racoon"};
    private String[] files = new String[]{"foxM.png", "wolfM.png", "bearM.png", "raccoonM.png"};
    private ImageIcon[] imgs;

    public void valueChanged(ListSelectionEvent e){
        L.setIcon(imgs[LS.getSelectedIndex()]);
    }
    MyFrame(){
        super("List selection");
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

        LS = new JList(animals);
        LS.setBounds(170,35,120,75);
        LS.setSelectedIndex(0);
        LS.addListSelectionListener(this);
        LS.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        LS.setSelectedIndex(0);
        add(LS);

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

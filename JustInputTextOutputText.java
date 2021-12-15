package com.company;

import javax.swing.*;
import javax.swing.border.BevelBorder;

class MyFrame extends JFrame{
    private JLabel L;
    private JTextField T;
    MyFrame(){
        
        super("The window with text area");
        int w = 300, h = 160;
        setBounds(250,250,w,h);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        
        L = new JLabel();
        L.setBounds(10,10,w - 25,30);
        L.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        
        T = new JTextField();
        T.setBounds(L.getX(), 50, L.getWidth(), 30);
        
        //the first button
        int bw = (T.getWidth() - 20)/2; //width of buttons
        JButton appB = new JButton("Use");
        appB.setBounds(T.getX(), 90, bw, 30);
        appB.setFocusPainted(false);
        appB.addActionListener(e ->L.setText(T.getText()));

        //the second button
        JButton extB = new JButton("Close");
        extB.setBounds(appB.getX() + appB.getWidth() + 20, appB.getY(), appB.getWidth(), appB.getHeight());
        extB.setFocusPainted(false);
        extB.addActionListener(e->System.exit(0));

        add(L);
        add(T);
        add(appB);
        add(extB);
        setVisible(true);
    }
}

public class JustInputTextOutputText {
    public static void main(String[] args) {
        new MyFrame();
    }
}

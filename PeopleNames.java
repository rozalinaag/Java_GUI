package com.company;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;


class MyFrame extends JFrame implements ActionListener {

    private JTextPane F;
    private JTextPane I;
    private JTextPane O;

    private JTextField T;
    private JButton CLEAN;
    private JButton ADD;

    private String name = "Arial";
    private int size = 15;
    private String exit = "Close";

    private JLabel Ff;
    private JLabel Ii;
    private JLabel Oo;


    public void actionPerformed(ActionEvent e){
        if (e.getSource() == ADD) {

            String [] FIO = T.getText().split(" ");
            F.setText(F.getText() +"\n" + FIO[0]);
            I.setText(I.getText() +"\n" + FIO[1]);
            O.setText(O.getText() +"\n" + FIO[2]);
        }
        else{
            T.setText("");
        }
    }
    
    public void labels(){
        Ff = new JLabel();
        Ff.setBounds(12,130,100,20);
        Ff.setText("First Name");
        Ii = new JLabel();
        Ii.setBounds(202,130,100,20);
        Ii.setText("Last Name");
        Oo = new JLabel();
        Oo.setBounds(392,130,100,20);
        Oo.setText("Father Name");
    }

    MyFrame(){
        super("FIO of people");
        setBounds(350,250,570, 380);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        
        F = new JTextPane();
        F.setBounds(10,150,150,170);
        F.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        F.setForeground(Color.RED);

        I = new JTextPane();
        I.setBounds(200,150,150,170);
        I.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        I.setForeground(Color.BLUE);

        O = new JTextPane();
        O.setBounds(390,150,150,170);
        O.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        O.setForeground(Color.MAGENTA);
        

        T = new JTextField();
        T.setBounds(140, 10, 275, 30);

        CLEAN = new JButton("Clean");
        CLEAN.setBounds(190, 90, 175, 30);
        CLEAN.setFocusPainted(false);
        CLEAN.setFont(new Font(name, Font.PLAIN, size));
        CLEAN.setForeground(Color.RED);
        CLEAN.addActionListener(this);

        ADD = new JButton("ADD");
        ADD.setBounds(190, 50, 175, 30);
        ADD.setFocusPainted(false);
        ADD.setFont(new Font(name, Font.PLAIN, size));
        ADD.setForeground(Color.GREEN);
        ADD.addActionListener(this);

        add(F);
        add(I);
        add(O);
        add(T);
        add(CLEAN);
        add(ADD);

        labels();

        add(Ff);
        add(Ii);
        add(Oo);
        setVisible(true);
    }

}

public class PeopleNames {
    public static void main(String[] args) {
        new MyFrame();
    }
}

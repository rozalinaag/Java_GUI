package com.company;

import com.company.*;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.*;
import java.security.Key;

class MyFrame extends JFrame implements ActionListener, MouseListener, KeyListener {

    private JLabel L;
    private JTextField T;

    private JButton B;

    private String name = "Arial";
    private int size = 15;
    private String exit = "Close";

    public void actionPerformed(ActionEvent e){
        System.exit(0);
    }

    public void mouseExited(MouseEvent e){
        if (e.getSource() == L) {
            L.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
            L.setHorizontalAlignment(JLabel.LEFT);
        }
        else{
            B.setText(exit);
            B.setForeground(Color.BLUE);
            B.setFont(new Font(name, Font.PLAIN, size));
        }
    }

    public void mouseEntered(MouseEvent e){
        if (e.getSource() == L){
            L.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
            L.setHorizontalAlignment(JLabel.RIGHT);
        }
        else{
            B.setText("<html><u>" + exit + "</u></html>");
            B.setForeground(Color.RED);
            B.setFont(new Font(name, Font.BOLD, size + 2));
        }
    }

    public void mouseReleased(MouseEvent e){}
    public void mousePressed(MouseEvent e){}
    public void mouseClicked(MouseEvent e){}

    public void keyReleased(KeyEvent e){
        L.setText(T.getText());
    }

    public void keyPressed(KeyEvent e){}
    public void keyTyped(KeyEvent e){}

    MyFrame(){
        super("the window with text area");

        setBounds(250,250,300, 160);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);

        L = new JLabel();
        L.setBounds(10,10,275,30);
        L.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        L.addMouseListener(this);

        T = new JTextField();
        T.setBounds(10, 50, 275, 30);
        T.addKeyListener(this);


        B = new JButton("Exit");
        B.setBounds(60, 90, 175, 30);
        B.setFocusPainted(false);
        B.setFont(new Font(name, Font.PLAIN, size));
        B.setForeground(Color.BLUE);
        B.addActionListener(this);
        B.addMouseListener(this);


        add(L);
        add(T);
        add(B);
        setVisible(true);
    }
}

public class JustAwindowApplication{
    public static void main(String[] args) {
        new MyFrame();
    }
}

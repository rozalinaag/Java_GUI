package com.company;

import com.company.*;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class MyFrame extends JFrame implements ActionListener, MouseListener{

    private JLabel L;
    private JTextField T;

    private String exit = "Close";
    private String apply = "Use";

    public void actionPerformed(ActionEvent e){
        String txt = e.getActionCommand();
        if (txt.equals(apply)){
            L.setText(T.getText());
        }
        else{
            System.exit(0);
        }
    }

    //выполняется, когда курсор мыши покидает поле с текстом 
    public void mouseExited(MouseEvent e){
        L.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        L.setHorizontalAlignment(JLabel.LEFT);
    }

    //метод вызывается, когда курсор оказывается над областью компонента
    public void mouseEntered(MouseEvent e){
        L.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        L.setHorizontalAlignment(JLabel.RIGHT);
    }

    public void mouseReleased(MouseEvent e){}
    public void mousePressed(MouseEvent e){}
    public void mouseClicked(MouseEvent e){}

    MyFrame(){
        super("the window with text area");
        int w = 300, h = 165;
        setBounds(250,250,w,h);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);

        L = new JLabel();
        L.setBounds(10,10,w - 25,30);
        L.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        L.addMouseListener(this);

        T = new JTextField();
        T.setBounds(L.getX(), 50, L.getWidth(), 30);

        //the first button
        int bw = (T.getWidth() - 20)/2; //width of buttons
        JButton appB = new JButton("Use");
        appB.setBounds(T.getX(), 90, bw, 30);
        appB.setFocusPainted(false);
        appB.addActionListener(this);

        JButton extB = new JButton("Close");
        extB.setBounds(appB.getX() + appB.getWidth() + 20, appB.getY(), appB.getWidth(), appB.getHeight());
        extB.setFocusPainted(false);
        extB.addActionListener(this);

        add(L);
        add(T);
        add(appB);
        add(extB);
        setVisible(true);
    }
}

public class JustAwindowApplication{
    public static void main(String[] args) {
        new MyFrame();
    }
}

import org.w3c.dom.ls.LSOutput;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;

public class Runners extends JComponent implements KeyListener, ActionListener {
    private int x = 200, y = 200;
    double i=0.009;
    private int H=20,W=20;
    Rectangle rectangle = new Rectangle(x,y,W,H);
    Timer t = new Timer(5,this);
    Image grass = new ImageIcon("grass.jpg").getImage();
    private boolean inGame = true;

    JButton buttonOptions = new JButton("Start");

    private double r = 100.0;
    double angle = 6;

    public static void main(String[] args) {
        Runners main = new Runners();
        JFrame f = new JFrame("Game");

        f.add(main);
        f.addKeyListener(main);

        JButton button = new JButton("Stop!");

        final JTextField tf= new JTextField();
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                tf.setText( "Welcome to Javatpoint.");
            }  ;});

        //f.add(tf);
        button.setBounds(40,100,100,60);
        f.add(button,BorderLayout.SOUTH, BoxLayout.X_AXIS);

        button.setPreferredSize(new Dimension(f.getWidth(), 30));
        button.setLayout(new BoxLayout(button, BoxLayout.X_AXIS));

        f.setSize(410,450);
        f.setLocation(500,280);
        //f.setLayout(null);
        f.setVisible(true);

        /*
        //status bar
        JPanel statusPanel = new JPanel();
        statusPanel.setBorder(new BevelBorder(BevelBorder.RAISED));
        f.add(statusPanel, BorderLayout.SOUTH);

        statusPanel.setPreferredSize(new Dimension(f.getWidth(), 16));
        statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.X_AXIS));

        JLabel statusLabel = new JLabel("status");
        statusLabel.setHorizontalAlignment(SwingConstants.LEFT);
        statusPanel.add(statusLabel);
        */


        //f.add(main.buttonOptions, gbc);

    }

    public void move() {

        if (i*angle > 360) {
          i=0;
          //inGame=false;
        }
        else i+=0.009;

        int x1 = (int)(x+r*Math.cos(i*angle));
        int y1 = (int)(y+r*Math.sin(i*angle));

        rectangle.setLocation(x1, y1);

    }

    public void paint(Graphics g){
        Graphics2D g1 = (Graphics2D) g; //приведение типа к двумерной графике

        Rectangle2D rectangle2D = new Rectangle2D.Double(100,100,300,300); //прямугольник для картинки травы внутри
        Rectangle2D rectangle2D2 = new Rectangle2D.Double(200,200,20,20); //прямугольник для маленького бегуна 1

        g1.fill(rectangle2D);

        g1.drawImage(grass, 0,0, 400,400,null);

        g1.setColor(new Color(227,105,68)); // самый большой круг
        g1.fillOval(50,50,325,325);

        g1.setColor(new Color(249,248,247)); //white line
        g1.fillOval(74,74,277,277);

        g1.setColor(new Color(253,155,78)); //middle
        g1.fillOval(75,75,275,275);

        g1.setColor(new Color(249,248,247)); //white line
        g1.fillOval(98,98,227,227);

        Color c1 = new Color(227,117,70); //small круг
        g1.setColor(c1);
        g1.fillOval(99,99,225,225);




        try{
            g1.setPaint(new TexturePaint(ImageIO.read(new File("grass.jpg")),rectangle2D));
        }catch(IOException e){
            e.printStackTrace();
        }
        g1.fillOval(127,127,170,170);

        Point2D point = new Point2D.Double(295,205); //white line
        Point2D point2 = new Point2D.Double(377,205);
        Line2D line = new Line2D.Double(point, point2);
        g1.setColor(new Color(249,248,247));
        g1.draw(line);

        try{
            g1.setPaint(new TexturePaint(ImageIO.read(new File("cat.jpg")),rectangle2D2));
        }catch(IOException e){
            e.printStackTrace();
        }


        //g1.setColor(Color.BLACK);
        g1.fill(rectangle);



        t.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (inGame){
            move();
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        repaint();// update window
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode()==KeyEvent.VK_RIGHT){
                rectangle.setLocation(rectangle.x + 2, rectangle.y);
                x+=2;
        }
        if (e.getKeyCode()==KeyEvent.VK_DOWN){
                rectangle.setLocation(rectangle.x, rectangle.y + 2);
                y+=2;
        }
        if (e.getKeyCode()==KeyEvent.VK_UP){
                rectangle.setLocation(rectangle.x, rectangle.y -2);
                y-=2;

        }
        if (e.getKeyCode()==KeyEvent.VK_LEFT){
                rectangle.setLocation(rectangle.x-2, rectangle.y);
                x-=2;

        }
        if (e.getKeyCode()==KeyEvent.VK_LEFT&& e.getKeyCode()==KeyEvent.VK_UP){
                rectangle.setLocation(rectangle.x-1, rectangle.y-1);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

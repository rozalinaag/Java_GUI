import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import  java.awt.event.ActionListener;
import java.awt.geom.*;

public class Square extends JPanel implements Runnable {
    Color color = Color.red;
    int dia = 30;
    long delay = 40;
    private int x = 20;
    private int y = 20;
    private int dx = 5;
    private int dy = 10;
    private boolean isRunning;

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Color c = new Color(60,150,120);
        Color c1 = new Color(50,170,80);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(color);
        g.fillOval(x,y,30,30);   // adds color to circle
        g.setColor(Color.red);
        g2.setColor(c);
        g2.drawPolygon( new int[]{10,20,30}, new int[] {100,20,100},3);
        g2.setColor(c1);
        g2.fillPolygon(new int[]{10,20,30}, new int[] {100,20,100},3);

    }

    public void run() {
        while(isVisible()) {
            try {
                Thread.sleep(delay);
            } catch(InterruptedException e) {
                System.out.println("interrupted");
            }
            move();
            repaint();
        }
    }

    public void move() {
        if (isRunning) {
            if(x + dx < 0 || x + dia + dx > getWidth()) {
                dx *= -1;
                color = getColor();
            }
            if(y + dy < 0 || y + dia + dy > getHeight()) {
                dy *= -1;
                color = getColor();
            }
            x += dx;
            y += dy;
        }
    }

    private Color getColor() {
        int rval = (int)Math.floor(255);
        int gval = (int)Math.floor(0);
        int bval = (int)Math.floor(0);
        return new Color(rval, gval, bval);
    }

    private void start() {
        while(!isVisible()) {
            try {
                Thread.sleep(25);
            } catch(InterruptedException e) {
                System.exit(1);
            }
        }
        Thread thread = new Thread(this);
        thread.setPriority(Thread.NORM_PRIORITY);
        thread.start();
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                final Square test = new Square();
                JFrame f = new JFrame();

                JButton start = new JButton("start");
                start.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                        test.isRunning = true;
                    }
                });

                JButton stop = new JButton("stop");
                stop.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                        test.isRunning = false;
                    }
                });

                JPanel panel = new JPanel();
                panel.add(start);
                panel.add(stop);

                f.add(panel, java.awt.BorderLayout.NORTH);
                f.getContentPane().add(test);

                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setSize(new Dimension(600, 600));
                f.setLocationRelativeTo(null);
                f.setVisible(true);
                test.start();
            }

        });



    }
}

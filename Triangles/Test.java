import javax.imageio.ImageIO;
import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.geom.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Random;

public class Test {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input counts of triangles(0-15): ");
        int num = in.nextInt();
        if (num<0 || num>15)
            System.out.println("You input NOT CORRECT counts of triangles!!\nMeanings can be dont accurate");

        JFrame jFrame = getFrame();
        jFrame.add(new Triangle(num));

        //SimpleGUI app =new SimpleGUI();
        //app.setVisible(true);

    }

    static class Triangle extends JComponent {

        private int num;

        Triangle(int num1){
            num = num1;
        }

        @Override
        public void paint(Graphics g){
            Random random = new Random();
            Graphics2D g2 = (Graphics2D) g;

            //background
            try {
                Image img = ImageIO.read(new File("fon.jpg"));
                g2.drawImage(img, 0, 0, null);
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("programss start");
            g2.setPaint(new GradientPaint(new Point (0,0), Color.red, new Point(200,200),Color.yellow)); //gradient
            g2.setStroke(new BasicStroke(3f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER,10f)); //line


            //Color c1 = new Color(50,170,80);
            //g2.setColor(c1);

            Color[] colors = { Color.BLUE, Color.GREEN, Color.MAGENTA, Color.RED,
                    Color.CYAN };

            int [][] massX = {{20,20,60}, {410,445,490},{550,600,750},{250,150,90},{30,30,70},{60,75,100},{130,130,80},{220,200,140},{360,310,240},{400,400,370},{450,480,410},{570,530,490},{630,630,580},{800,750,640},{810,810,860}};
            int [][] massY = {{200,20,200},{250,210,240},{250,230,250},{260,210,260},{250,220,250},{70,10,50},{200,3,200},{200,20,160},{200,10,200},{200,20,200},{200,5,150},{180,10,210},{210,30,210},{250,20,178},{230,40,230}};


            g2.setColor(Color.black);
            for (int i=0;i<num+1;i++) {
                int ran = random.nextInt(massX.length);
                if (massX[ran][0] == massX[ran][1]){
                    int pos = random.nextInt(colors.length);
                    g2.setColor(colors[pos]);
                    g2.drawPolygon(massX[ran], massY[ran], 3);
                    g2.fillPolygon(massX[ran], massY[ran], 3);
                }
                else {
                    g2.setColor(Color.black);
                    g2.drawPolygon(massX[ran], massY[ran], 3);
                    g2.fillPolygon(massX[ran], massY[ran], 3);

                }
            }

            //прямоугольник
            g2.setColor(Color.black);
            Rectangle2D rectangle2D = new Rectangle2D.Double(300,203,100,50);
            g2.fill(rectangle2D);

            //paint pictures
            try{
                g2.setPaint(new TexturePaint(ImageIO.read(new File("cat.jpeg")), rectangle2D));
            }catch(IOException e){
                e.printStackTrace();
            }



            //элипс
            Ellipse2D ellipse2D = new Ellipse2D.Double(300,203,100,50);
            g2.fill(ellipse2D); //полное заполнение цвета - филл, эдд просто добавить

        }
    }
    static JFrame getFrame(){
        JFrame jFrame = new JFrame();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        jFrame.setBounds(dimension.width/2-450, dimension.height/2-150, 900, 300);
        return jFrame;
    }
}

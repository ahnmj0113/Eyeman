import java.applet.Applet;
import java.awt.*;

/**
 * Created by S10080586 on 5/9/2017.
 */
public class GraphicsProject2 extends Applet{
    Rectangle area, area2;
    int num, tear;
    Color water,lCloth,dCloth;

    //initial value
    public void init(){
        setBackground(new Color(102, 96, 85));
        num=255;
        tear=0;

        area= new Rectangle(409, 240, 145, 100);
        area2= new Rectangle(377, 256, 200, 60);

        water = new Color(152, 221, 255);
        lCloth = new Color(61, 36, 3);
        dCloth = new Color(50, 30, 0);
    }

    //drawing eye man and when you click the eye 15 times, it will close his eye and start to cry.
    public void paint(Graphics g) {

        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(4));

        //water
        g.setColor(water);
        g.fillOval(310, 600, 350, 50);

        //body
        g.setColor(dCloth);
        g.fillRoundRect(390, 345, 50, 120, 50, 50);
        g.fillRoundRect(528, 345, 50, 120, 50, 50);
        g.fillRect(425, 482, 55, 110);
        g.fillRect(490, 482, 55, 110);
        g.setColor(new Color(255, 237, 206));
        g.fillOval(385, 450, 45, 45);
        g.setColor(new Color(255, 237, 206));
        g.fillOval(535, 450, 45, 45);
        g.fillRect(440, 592, 30, 20);
        g.fillRect(500, 592, 30, 20);
        g.setColor(lCloth);
        g.fillRect(425, 300, 120, 200);
        //necktie
        g.setColor(Color.white);
        g.fillPolygon(new int[] {453,511, 483}, new int[] {347, 347, 415}, 3);
        g.setColor(Color.red);
        g.fillPolygon(new int[] {469,474,478,472,483,493,489,492,497}, new int[] {346,360,360,392,415,392,360,360,346}, 9);
        //shoes
        g.setColor(Color.black);
        g.fillRect(431, 598, 40, 20);
        g.fillRect(500, 598, 40, 20);
        g.fillArc(410, 600, 70, 60,0, 180);
        g.fillArc(490, 600, 70, 60,0, 180);

        //head
        g.setColor(new Color(255, 237, 206));
        g.fillOval(355, 200, 250, 150);
        g.setColor(new Color(225, 207, 186));
        g.fillOval(355, 230, 250, 100);

        //eye
        g.setColor(new Color(255, num, num));
        g.fillOval(362, 239, 235, 100);

        //eye pupil
        g.setColor(new Color(50, 50, 255));
        g.fillOval(430, 239, 100, 100);
        g.setColor(new Color(33, 118, 255));
        g.fillOval(435, 253, 90, 80);
        g.setColor(new Color(33, 180, 255));
        g.fillOval(446, 290, 68, 40);
        g.drawOval(430, 239, 100, 100);
        g.drawOval(466, 273, 32, 32);
        g.setColor(new Color(0, 0, 95));
        g.fillOval(466, 273, 32, 32);
        g.setColor(new Color(33, 200, 255));
        g.fillOval(505, 280, 15, 15);
        g.setColor(new Color(83, 255, 255));
        g.fillOval(493, 295, 24, 24);
        g.setColor(new Color(33, 230, 255));
        g.fillOval(440, 295, 20, 20);
        g.setColor(new Color(123, 255, 255));
        g.fillOval(460, 310, 15, 15);
        g.setColor(Color.white);
        g.fillOval(410, 255, 70, 25);

        //eyelash
        g2.setStroke(new BasicStroke(7));
        g.setColor(Color.black);
        g.drawLine(373,265,344,230);
        g.drawLine(420,243,400,188);
        g.drawLine(480,237,480,172);
        g.drawLine(535,242,555,188);
        g.drawLine(583,260,610,221);
        g2.setStroke(new BasicStroke(4));
        g.setColor(new Color(186, 160, 138));
        g.drawOval(362, 239, 235, 100);

        //tear in the eye
        if(tear>=3) {
            g2.setStroke(new BasicStroke(7));
            g.setColor(water);
            g.drawOval(410, 315, 65, 25);
        }
        if(tear>=6) {
            g.drawOval(450, 322, 55, 20);
            g.setColor(Color.white);
            g.fillOval(503, 304, 55, 20);
            g.setColor(water);
        }
        if(tear>=9) {
            g.drawOval(480, 312, 60, 25);
        }
        if(tear>=12) {
            g.drawOval(530, 307, 45, 20);
        }
        if(tear>=15) {
            g.drawOval(387, 308, 45, 20);
        }

        if(num==0){
            g.setColor(new Color(102, 96, 85));
            g.fillRect(340, 159, 400, 150);
            g.setColor(new Color(255, 237, 206));
            g.fillOval(355, 200, 250, 150);
            g.setColor(new Color(245, 227, 196));
            g.fillOval(485, 223, 100, 50);
            g.setColor(new Color(255, 240, 240));
            g.fillOval(490, 230, 90, 40);
            g.setColor(Color.black);
            g.drawArc(358,245,245,50,180,180);
            g.drawLine(373,282,356,303);
            g.drawLine(420,291,411,322);
            g.drawLine(480,296,480,335);
            g.drawLine(536,292,548,323);
            g.drawLine(585,283,601,303);
        }

        //start to cry
        if(tear==20){
            for(int i=0;i<5;i++) {
                tearing(505, g);
                delay(400);
                tearing(430, g);
                g.setColor(water);
            }
        }

    }

    //it is an animation for tears drops.
    public void tearing(int x, Graphics g ){
            super.paint(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(5));
            delay(70);
            g.setColor(water);
            g.drawOval(x, 310, 20, 25);
            delay(100);
            g.setColor(new Color(255, 237, 206));
            g.fillRect(x-2, 308, 30, 30);
            g.setColor(water);
            g.drawOval(x, 367, 20, 25);
            delay(100);
            g.setColor(lCloth);
            g.fillPolygon(new int[]{x+2, x-10, x+25, x+25}, new int[]{362, 399, 400, 356}, 4);
            g.setColor(water);
            g.drawOval(x+4, 449, 20, 25);
            delay(100);
            g.setColor(lCloth);
            g.fillRect(x-4, 444, 35, 35);
            g.setColor(water);
            g.drawOval(x+4, 615, 20, 25);
            delay(100);
            g.setColor(Color.black);
            g.fillRect(x+1, 610, 35, 20);
            delay(100);
    }

    //make delays to make an animation
    public void delay(int n){
        long startDelay = System.currentTimeMillis();
        long endDelay = 0;
        while (endDelay - startDelay < n)
            endDelay = System.currentTimeMillis();
    }

    //when you click the eye, it add the number you clicked the eye.
    public boolean mouseDown(Event e, int x, int y) {
        if(area.inside(x,y)||area2.inside(x,y)) {
            if(num==0){
                tear=20;
            }
            else {
                tear++;
                num -= 15;
            }
        }
        repaint();
        return true;
    }

}

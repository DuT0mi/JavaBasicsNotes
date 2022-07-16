import java.awt.*;
public class Circle extends Canvas{
    // variables
    private int radius;
    // functions
    public Circle(Color pForeground, int radius){
        setForeground(pForeground);
        this.radius = radius;
        setSize(2 * radius,2*radius);

    }
    public void paint(Graphics g){
        g.fillOval(0,0,2 * radius,2 * radius);
    }
    public void setCenter(int pX,int pY){
        setLocation(pX - radius, pY - radius);
    }

    public static void main(String[] args){
        Frame f = new Frame();
        f.setLayout(new FlowLayout());
        f.setBounds(20,20,250,250);
        f.setBackground(Color.lightGray);
        f.add(new Circle(Color.white,20));
        f.add(new Circle(Color.red,30));
        f.add(new Circle(Color.green,40));
        f.setVisible(true);
    }
}

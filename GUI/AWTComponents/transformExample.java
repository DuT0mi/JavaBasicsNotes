import java.awt.*;
import java.awt.geom.*;
    /**
     *          The Maths behind that
     *          ( x_2 )       ( m_00    m_01    m_02    )   ( x_1 )
     *          ( y_2 )     = ( m_10    m_11    m_12    )   ( y_1 )
     *          ( 1   )       ( 0       0       1       )   ( 1   )
     * */
// link: https://github.com/DuT0mi/Container/blob/main/Demo/apple.png
    public  class TransformExample extends Frame{
        // variables
            private Color[] colors = {Color.white,Color.black};
            private Ellipse2D.Double circle = new Ellipse2D.Double(10,40,250,250);
        // functions
            public TransformExample(){
                setBounds(0,0,280,300);
                setResizable(false);
                setBackground(Color.gray);
                setVisible(true);
                setFont(new Font("Times",Font.BOLD,32));
            }
            public void paint(Graphics g){
                Graphics2D g2d = (Graphics2D)g;
                g2d.setStroke(new BasicStroke(4));
                g2d.draw(circle);
                g2d.translate(135.0,165.0);     // translate with 22.5 degree 16 times
                    for(int i = 0; i < 16 ; i++) {
                        g2d.rotate(Math.PI/8.0);
                        g2d.setPaint(colors[i%2]);
                        g2d.drawString("    Apple",0,0);
                }
            }
        public static void main(String[] args){
                new TransformExample();
        }
    }

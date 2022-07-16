import java.awt.*;
    class Animate extends Frame implements Runnable{
        // variables
        Thread t;
        int x; // actual position
        // functions
        Animate(String paramS){
            super(paramS);
            t = new Thread(this,"animate");
            t.start();
        }
        public void paint(Graphics g){
            // drawing a circle in a new position
            g.setColor(Color.red);
            g.fillOval(x,x,20,20);
        }
        public void update(Graphics g){
            // for avoid flicking
                // delete the previous circle
                g.setColor(Color.white);
                int xp = (x==1)? 160:x-1;
                g.fillRect(xp,xp,20,20);
                    // paint the new
                    paint(g);
        }
        public void run(){
            try{
                while(true){
                    x = 0;
                    for(int i = 0; i < 160 ; i++) {
                        x++;
                        repaint();
                        Thread.sleep(20);
                    }
                }
            }
            catch(InterruptedException e){

            }

        }
        public static void main(String[] args){
            Animate anim = new Animate("Animation window");
            anim.setBounds(50,50,200,200);
            anim.setVisible(true);
        }
    }

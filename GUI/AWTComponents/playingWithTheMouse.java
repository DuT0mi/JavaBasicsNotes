import java.awt.*;
import java.awt.event.*;
import java.util.*;
    public  class main extends Frame implements MouseListener,MouseMotionListener {
        // variables
            Vector pv;
            Button b;
        // functions
        public main(){
             pv = new Vector();
             setBounds(100,100,300,200);
             setVisible(true);
             b = new Button("There is no event right now.");
             add(b,BorderLayout.SOUTH);
             b.addMouseListener(this);
             b.addMouseMotionListener(this);
             validate();
        }
        @Override
        public void paint(Graphics g){
            int length = pv.size();
            if(length > 1)
                for(int i = 1; i < length; i++){
                    Point p1 = (Point) pv.elementAt(i-1);
                    Point p2 = (Point) pv.elementAt(i);
                    g.drawLine(p1.x,p1.y + 100,p2.x,p2.y + 100);
                }
        }
        public void mouseClicked(MouseEvent e){
            b.setLabel("Mouse clicked");
            repaint();
        }
        public void mouseEntered(MouseEvent e){
            b.setLabel("Mouse has entered the chat");
            repaint();
        }
        public void mouseExited(MouseEvent e){
            b.setLabel("Mouse has left the chat");
            repaint();
        }
        public void mousePressed(MouseEvent e){
            b.setLabel("Mouse's button pressed");
            repaint();
        }
        public void mouseReleased(MouseEvent e){
            b.setLabel("Mouse's button release");
            repaint();
        }
        public void mouseDragged(MouseEvent e){
            pv.add(e.getPoint());
            repaint();
        }
        public void mouseMoved(MouseEvent e){}
        public static void main(String[] args){

            new main();
        }
}

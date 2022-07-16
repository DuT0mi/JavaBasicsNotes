import java.awt.*;
import java.awt.event.*;


public class BgChange extends Frame implements ActionListener {
    // variables
        Color c;
        Button butt1,butt2,butt3;
    // functions
        public BgChange(){
            setBounds(100,100,200,100);
            setLayout(new FlowLayout());
            butt1 = new Button("Pink");
            butt2 = new Button("White");
            butt3 = new Button("Black");
            this.add(butt1);
            this.add(butt2);
            this.add(butt3);
            butt1.addActionListener(this);
            butt2.addActionListener(this);
            butt3.addActionListener(new EventExecuter(this,Color.black)); // Here we must to adjust "this" because of that will get an object-notification from an external class
            validate();
            setVisible(true);
        }
        public void actionPerformed(ActionEvent e){
            if(e.getSource().equals(butt1)){
                setBackground(Color.pink);
            }
            if("White".equals(e.getActionCommand())){
                setBackground(Color.white);
            }

        }
    public static void main(String[] args){
        new BgChange();
    }
}
class EventExecuter implements ActionListener{
    // variables
    BgChange b;
    Color c;
    // functions
    EventExecuter(BgChange pB, Color pC){
        this.b = pB;
        this.c = pC;
    }
    public  void actionPerformed(ActionEvent e){
        b.setBackground(c);
        b.repaint();
    }
}

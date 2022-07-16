package reminder;
import java.awt.*;
import java.awt.event.*;

class GUIExample implements ActionListener{
    // variables
      int click = 0;
      Button b;
    // functions
    GUIExample(){
        Frame f = new Frame();
        f.setBounds(100,150,200,150);
        f.setVisible(true);
        b = new Button("A klikkek száma: " + click);
        f.add("South",b);
        b.addActionListener(this);
        f.validate();
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource().equals(b))
            b.setLabel("A klikkek száma: " + (++click));
    }
    
}



public class Reminder {

    public static void main(String[] args) {
        new GUIExample();
    }
    
}

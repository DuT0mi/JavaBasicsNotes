package reminder;
import java.awt.*;
import java.awt.event.*;

/**
 * This layout partition the windowfor 5 region (u can see it lower).
 * You can add 1-1 block to region
 * This layout makes the center region to be the biggest
 */

public class Reminder extends Frame {
    // variables
    
    //functions
    Reminder(){
        setLayout(new BorderLayout());
        add(new Button("1.nyomógomb"),BorderLayout.NORTH);
        add(new Button("2.nyomógomb"),BorderLayout.WEST);
        add(new Button("3.nyomógomb"),BorderLayout.EAST);
        add(new Button("4.nyomógomb"),BorderLayout.SOUTH);
        add(new Button("5.nyomógomb"),BorderLayout.CENTER);
        setBounds(100,100,500,140);
        setVisible(true);
        
    }
    
    public static void main(String[] args) {
      new Reminder();
    }
    
}

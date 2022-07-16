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
        setLayout(new GridLayout());
        add(new Button("1.nyomógomb"));
        add(new Button("2.nyomógomb"));
        add(new Button("3.nyomógomb"));
        add(new Button("4.nyomógomb"));
        add(new Button("5.nyomógomb"));
        setBounds(100,100,500,140);
        setVisible(true);
        
    }
    
    public static void main(String[] args) {
      new Reminder();
    }
    
}

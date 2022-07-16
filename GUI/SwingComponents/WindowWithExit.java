import java.awt.*;
import java.awt.event.WindowAdapter;
import javax.swing.*;
import java.awt.event.*;

    public class JFrameExample {
        public static void main(String[] args){
            JFrame f = new JFrame("Test Swing frame");
                f.setBounds(100,100,400,120);
                Container content = f.getContentPane();
                    content.setBackground(Color.white);
                    content.setLayout(new FlowLayout());
                    content.add(new JButton("1."));
                    content.add(new JButton("2."));
                    content.add(new JButton("3."));
                    f.addWindowListener(new ExitListener()); // *** if we dont use this than after we close the window (alias our program) wont die
                    f.setVisible(true);
        }
}
    // Utility class for finish the app
     class ExitListener extends WindowAdapter{
        public void windowClosing(WindowEvent e){
            System.exit(0);
        }
    }

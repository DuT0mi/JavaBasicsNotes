import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/* Quick example of using internal frame*/
// There is also a picture after a program's ran, here: https://github.com/DuT0mi/Container/blob/main/Demo/iframe.png
public class JInternalFrame extends JFrame {

    public JInternalFrame(){
        super("Multiple Document Interface");
        Container content = getContentPane();
        content.setBackground(Color.white);
        JDesktopPane desktop = new JDesktopPane();
        desktop.setBackground(Color.white);
        content.add(desktop,BorderLayout.CENTER);
        setSize(450,400);
        // Creating 5 windows
        for(int i = 0; i < 5; i++){
            javax.swing.JInternalFrame frame = new javax.swing.JInternalFrame((i + ". internal frame"),true,true,true,true);
            frame.setLocation(i * 50 + 10,i * 50 + 10);
            frame.setSize(200,150);
            frame.setBackground(Color.white);
            frame.setVisible(true);
            desktop.add(frame);
            frame.moveToFront();
        }
        setVisible(true);


    }
    public  static void main(String[] args){
        new JInternalFrame();
    }
}

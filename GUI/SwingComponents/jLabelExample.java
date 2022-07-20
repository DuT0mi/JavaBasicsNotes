import java.awt.*;
import javax.swing.*;

    public class jLabelExample extends JFrame{

        public static void main(String[] args){
            new jLabelExample();
        }
        // Created the Label's, you can watch it here: https://github.com/DuT0mi/Container/blob/main/Demo/plain.png
        public jLabelExample(){
              super("Using HTML in JLabel");
              Container content = getContentPane();
              Font font = new Font("Serif",Font.PLAIN,30);
              content.setFont(font);
              String labelText =
                      "<html><FONT COLOR = WHITE>white</FONT> and " +
                      "<FONT COLOR = GRAY>gray</FONT> TEXT </html>";
              JLabel coloredLabel = new JLabel(labelText,JLabel.CENTER);
              coloredLabel.setBorder(BorderFactory.createTitledBorder("Mixed colors"));
              content.add(coloredLabel,BorderLayout.NORTH);
              labelText = "<html><B>BOLD</B> and <I>Italic</I> text </html>";
              JLabel boldLabel = new JLabel(labelText,JLabel.CENTER);
              boldLabel.setBorder(BorderFactory.createTitledBorder("Mixed fonts"));
              content.add(boldLabel,BorderLayout.CENTER);
              labelText =
                      "<html>Fruits" +
                      "<P> " +
                      "Some of them:" +
                      "<UL>" +
                      "<LI>Apple" +
                      "<LI>Pear" +
                      "<LI>Watermelon" +
                      "</UL>" +
                      "</html>";
              JLabel fancyLabel = new JLabel(labelText,JLabel.CENTER);
              fancyLabel.setBorder(BorderFactory.createTitledBorder("Formatted with HTML"));
              content.add(fancyLabel,BorderLayout.SOUTH);
              pack();
              setVisible(true);
        }

    }

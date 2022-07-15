package reminder;
import java.awt.*;
import java.awt.event.*;

public class Reminder extends Frame implements ActionListener {
    // variables
    
    //functions
    Reminder(){
    this.setLayout(new FlowLayout());
        for(int i = 0; i < 6; i++){
        Button b = new Button(i + ".nyomógomb");
        this.add(b);
            b.addActionListener(this);
        }
        this.setBounds(100,100,200,100);
        this.setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        for(int i = 0; i < 6; i++){
            Button bt = (Button)e.getSource();
                if(bt.getLabel().equals(i + ".nyomógomb")){
                bt.setLabel("Button " + i);
                this.validate();                        // after the changed button we must to call the validate() method
                break;
                }
           if(bt.getLabel().equals("Button" + i)){
            bt.setLabel(i + ". nyomógomb");
            this.validate();
            break;
            }
        }
    }
    
    public static void main(String[] args) {
      new Reminder();
    }
    
}

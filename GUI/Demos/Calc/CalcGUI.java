package calculator;
import java.awt.*;
/** STANDART CALCULATOR FOR THAT PROJECT
         *  Y\X
         *  (0,0) (0,1) (0,2) (0,3) <- HERE IS THE TEXT FIELD (opposite of the normal matrix)
         *  (1,0) (1,1) (1,2) (1,3)
         *  (2,0) (2,1) (2,2) (2,3)
         *  (3,0) (3,1) (3,2) (3,3)
         *  (4,0) (4,1) (4,2) (4,3)
         *  (5,0) (5,1) (5,2) (5,3)
         *  I did this but u can change the code easily
         *  text field
         *  C = / *
         *  7 8 9 -                              ___
         *  4 5 6 +                             | = |
         *  1 2 3 =*                =* means:   |___|
         *  0*  .                   0* means:   00           
         */ 

class Constants{
    public static final int DEFAULT_HEIGHT = 1;
    public static final int DEFAULT_WIDTH = 1;
    public static final int DEFAULT_TEXT_FIELD_DIGITS = 12;
    public static final int DEFAULT_TEXT_FIELD_WIDTH = 4;
    public static final int DEFAULT_INSET = 3;
}

public class Calculator  extends Frame{
    private void addTextField(GridBagLayout pGb, int pGridx, int pGridy,Constants c){
        TextField display = new TextField(c.DEFAULT_TEXT_FIELD_DIGITS);
        // Specific the cells for the display
            GridBagConstraints GBC_display = new GridBagConstraints();
                GBC_display.gridx = pGridx;
                GBC_display.gridy = pGridy;
                GBC_display.gridwidth = c.DEFAULT_TEXT_FIELD_WIDTH;
                GBC_display.gridheight = c.DEFAULT_HEIGHT;
         // This is specific
                GBC_display.fill = GridBagConstraints.HORIZONTAL;
        // Add to the GBL
            pGb.setConstraints(display, GBC_display);
            this.add(display);
                
    }
    private void addButton(GridBagLayout pGb, int pGridx, int pGridy,int pGridWidth,int pGridHeight, String symbol,Constants c,String fillType){
       GridBagConstraints GBC_param = new GridBagConstraints();
        GBC_param.gridx = pGridx;
        GBC_param.gridy = pGridy;
        GBC_param.gridheight = pGridHeight;
        GBC_param.gridwidth = pGridWidth;
            switch(fillType)
            {                
                case "HORIZONTAL":  GBC_param.fill = GridBagConstraints.HORIZONTAL; break;
                case "VERTICAL":    GBC_param.fill = GridBagConstraints.VERTICAL;break;
                case "BOTH":        GBC_param.fill = GridBagConstraints.BOTH;break;
                default:            GBC_param.fill = GridBagConstraints.NONE;break;
            }
            GBC_param.insets = new Insets(c.DEFAULT_INSET,c.DEFAULT_INSET,c.DEFAULT_INSET,c.DEFAULT_INSET);
        // Button
            Button b = new Button(symbol);
            pGb.setConstraints(b, GBC_param);
                this.add(b);
        }
    Calculator(){       
        Constants c = null;
        GridBagLayout gb = new GridBagLayout();
        this.setLayout(gb);
        // Add textField
         addTextField(gb,0,0,c);
         // Add buttons
            String[] symbols = {"C","=","/","*","7","8","9","-","4","5","6","+"};
            String[] syms = {"1","2","3","=","0","."};
            // First row C = / -
            int j = 0;
            for(int k = 1; k < 4; k++){                  
                for(int i = 0; i < 4; i++){                   
                    addButton(gb,i,k,c.DEFAULT_WIDTH,c.DEFAULT_HEIGHT,symbols[j],c,"BOTH");
                    j++;
                }
            }
            j = 0;
            for(int k = 0; k < 3; k++){
                addButton(gb,k,4,c.DEFAULT_WIDTH,c.DEFAULT_HEIGHT,syms[j],c,"BOTH");
                j++;
            }                          
            addButton(gb,3,4,c.DEFAULT_WIDTH,c.DEFAULT_HEIGHT*2,"=",c,"VERTICAL");
            for(int t = 0; t < 3; t++){
                if(t%2==0){
                    switch(t){
                        case 0: addButton(gb,t,5,c.DEFAULT_WIDTH * 2,c.DEFAULT_HEIGHT,syms[j],c,"BOTH");j++;break;
                        case 2: addButton(gb,t,5,c.DEFAULT_WIDTH,c.DEFAULT_HEIGHT,syms[j],c,"BOTH");j++;break;
                    }
                }
            }                    
        // visible
        setBounds(750,250,200,250);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        new Calculator();
    }
    
}

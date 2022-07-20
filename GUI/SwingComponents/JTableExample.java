import java.awt.*;
import javax.swing.*;

    public class JTableExample extends JFrame{
        // variables
        private final int COLUMNS = 4;
        private final int ROWS = 15;
        private JTable sampleTable;
        // functions
        public JTableExample(){
            super("Making JTable");
            Container content = getContentPane();
            String[] columnNames = buildColumnNames(COLUMNS);
            String[][] tableCells = buildTableCells(ROWS,COLUMNS);
            sampleTable = new JTable(tableCells,columnNames);
            JScrollPane tablePane = new JScrollPane(sampleTable);
            content.add(tablePane,BorderLayout.CENTER);
            setSize(450,150);
            setVisible(true);
        }
        private String[] buildColumnNames(int pColumn){
           String[] header = new String[pColumn];
           for(int j = 0; j < pColumn; j++){
               header[j] = "" + j + ". column";
           }
           return  header;
        }
        private String[][] buildTableCells(int pRow,int pColumn){
            String[][] cells = new String[pRow][pColumn];
            for(int i = 0; i < pRow; i++){
                for(int k = 0; k < pColumn; k++){
                    cells[i][k] = "Row " + i + ", Column " + k;
                }
            }
            return cells;
        }
        public  static void main(String[] args){
            new JTableExample();
        }

}

import java.awt.*;
import java.text.DecimalFormat;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

    public class JTableEvents extends  JFrame{
        // variables
        private final int COL_COST = 1;
        private final int COL_QTY = 2;
        private final int COL_TOTAL = 3;
        private final int ROW_LAST = 5;
        private DecimalFormat df = new DecimalFormat("####.##");
        private JTable sampleJTable;
        private DefaultTableModel tableModel;
        public static void main(String[] args){
            new JTableEvents();
        }
        // functions
            public JTableEvents(){
                super("Using TableEvents");
                Container content = getContentPane();
                String[] columnNames = {"Book","Price [huf]","Quantity","SumPrice [huf]"};
            final Object[][] data = {
                                        {"What to do?","800","0","0"},
                                        {"Live on the Mars","1400","0","0"},
                                        {"Insane Book 2","3200","0","0"},
                                        {"Programming in C","1000","0","0"},
                                        {"Chad programmers only work with assembly","1000","0","0"},
                                        {null,null,"Sum:","0"}
                                    };
                tableModel = new DefaultTableModel(data,columnNames);
                tableModel.addTableModelListener(
                        new TableModelListener() {
                            int row,col;
                            int quantity;
                            float cost,subTotal,grandTotal;
                            @Override
                            public void tableChanged(TableModelEvent e) {
                                row = e.getFirstRow();
                                col = e.getColumn();
                                // update the table
                                    if(col == COL_QTY){
                                       try{
                                           cost = getFormattedCellValue(row,COL_COST);
                                           quantity = (int)getFormattedCellValue(row,COL_QTY);
                                           subTotal = quantity * cost;
                                           // update sum
                                           tableModel.setValueAt(df.format(subTotal),row,COL_TOTAL);
                                           // the whole row's update
                                           grandTotal = 0;
                                           for(int row = 0; row < data.length - 1; row++){
                                               grandTotal += getFormattedCellValue(row,COL_TOTAL);
                                           }
                                           tableModel.setValueAt(df.format(grandTotal),ROW_LAST,COL_TOTAL);
                                           tableModel.fireTableDataChanged();
                                       } catch (NumberFormatException nfe){
                                           JOptionPane.showMessageDialog(JTableEvents.this,"Illegal value");
                                       }
                                    }
                            }
                            private float getFormattedCellValue(int pRow,int pColumn){
                                String value = (String)tableModel.getValueAt(pRow,pColumn);
                                    return(Float.parseFloat(value));
                            }
                        }
                                                );
                sampleJTable = new JTable(tableModel);
                setColumnAlignment(sampleJTable.getColumnModel());
                JScrollPane tablePane = new JScrollPane(sampleJTable);
                content.add(tablePane,BorderLayout.CENTER);
                setSize(460,150);
                setVisible(true);
            }
            private void setColumnAlignment(TableColumnModel tcm){
                TableColumn column;
                DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
                for(int i = 1; i < tcm.getColumnCount(); ++i){
                    column = tcm.getColumn(i);
                    renderer.setHorizontalAlignment(SwingConstants.RIGHT);
                    column.setCellRenderer(renderer);
                }
            }

}

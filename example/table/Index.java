package table;

import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import org.javabrain.util.data.JSON;



/**
 *
 * @author QualtopGroup
 */
public class Index extends javax.swing.JFrame {

    public Index() {
        initComponents();
        JSON json = new JSON();
        json.read("components.json");
        
        JSON array = json.getJSONArray("result").getJSONArray(0).getJSON("columns");
        JSON array2 = json.getJSONArray("result");
        DefaultTableModel model = new DefaultTableModel();
        Vector<Object> objects = new Vector<>();
        
        for (Object col : array.getKeys()) {
            objects.add(col.toString());
            model.addColumn(array.getString(col.toString()));
        }
        
        for (JSON col : array2.exclude(0)) {
            Vector<Object> obj = new Vector<>();
                for (Object object1 : objects) {
                    obj.add(col.getString(object1.toString()));
                }
            model.addRow(obj);
        }
        
        jTable1.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.getTableHeader().setResizingAllowed(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}

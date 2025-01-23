package POTS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class stock_update extends javax.swing.JFrame {
    
    private DefaultTableModel tableModel;
    
    public stock_update() {
        setTitle("Update Stock Levels"); //setting title for the form
        initComponents();
        tableModel = (DefaultTableModel) stockTable.getModel(); //initialize table model

        tableModel.setRowCount(0); //clear initial empty rows

        loadStockFromFile(); //load stock data from file

        updateButton.addActionListener(e -> updateSelectedStock()); //action for update button

        backButton.addActionListener(e -> dispose()); //action for back button
    }
    
    //update selected stock
    private void updateSelectedStock() {
        int selectedRow = stockTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select an item to update.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        //get the new stock quantity from the input
        String stockQuantityStr = JOptionPane.showInputDialog(this, "Enter new stock quantity:", 
                tableModel.getValueAt(selectedRow, 2));

        //validate input
        if (stockQuantityStr == null || stockQuantityStr.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Stock quantity cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //check if the stock quantity is a valid number
        int stockQuantity;
        try {
            stockQuantity = Integer.parseInt(stockQuantityStr.trim());
            if (stockQuantity <= 0) {
                JOptionPane.showMessageDialog(this, "Stock quantity must be a positive integer.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter a valid integer for stock quantity.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //update the table with the new stock quantity
        String itemId = (String) tableModel.getValueAt(selectedRow, 0);
        tableModel.setValueAt(String.valueOf(stockQuantity), selectedRow, 2);

        //update the file with the new stock quantity
        try (BufferedReader reader = new BufferedReader(new FileReader("stock_data.txt"))) {
            ArrayList<String> stocks = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith(itemId + ",")) {
                    String[] stockData = line.split(",");
                    stockData[2] = String.valueOf(stockQuantity); //update stock quantity
                    stocks.add(String.join(",", stockData));
                } else {
                    stocks.add(line);
                }
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter("stock_data.txt"))) {
                for (String stock : stocks) {
                    writer.write(stock);
                    writer.newLine();
                }
            }
            JOptionPane.showMessageDialog(this, "Stock updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error updating stock file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadStockFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("stock_data.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] stockData = line.split(",");
                if (stockData.length == 4) { //validating proper structure of data
                    tableModel.addRow(stockData);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading stock file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        stockTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        backButton.setBackground(new java.awt.Color(255, 204, 0));
        backButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        backButton.setText("BACK");

        updateButton.setBackground(new java.awt.Color(153, 153, 153));
        updateButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        updateButton.setForeground(new java.awt.Color(255, 255, 255));
        updateButton.setText("UPDATE STOCK");

        stockTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Item ID", "Item Name", "Stock Quantity", "Reorder At"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(stockTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(176, 176, 176))
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(stock_update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(stock_update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(stock_update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(stock_update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new stock_update().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable stockTable;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}

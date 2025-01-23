package POTS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class item_edit extends javax.swing.JFrame {
    
    private DefaultTableModel tableModel;

    public item_edit() {
        setTitle("Edit Existing Item"); //setting a title for the form
        
        initComponents();
        
        tableModel = (DefaultTableModel) itemTable.getModel(); //initialize table model

        tableModel.setRowCount(0); //clearing any empty rows

        loadItemsFromFile(); //loading items from item file

        editButton.addActionListener(e -> editSelectedItem()); //action for edit button

        backButton.addActionListener(e -> dispose()); //action for back button
    }

    //edit selected item
    private void editSelectedItem() {
        int selectedRow = itemTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select an item to edit.", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        //get inputs from text fields
        String itemId = (String) tableModel.getValueAt(selectedRow, 0);
        String newName = itemNameTextField.getText().trim();
        String newQuantity = itemQuantityTextField.getText().trim();
        String newPrice = itemPriceTextField.getText().trim();

        //validate inputs
        if (!validateInputs(newName, newQuantity, newPrice)) {
            return; //stop the operation if validation fails
        }

        //update the table with the new values
        tableModel.setValueAt(newName, selectedRow, 1);
        tableModel.setValueAt(newQuantity, selectedRow, 2);
        tableModel.setValueAt(newPrice, selectedRow, 3);

        //update the file
        try (BufferedReader reader = new BufferedReader(new FileReader("item_inventory.txt"))) {
            ArrayList<String> items = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                //if the line starts with the itemId, replace it with the new values
                if (line.startsWith(itemId + ",")) {
                    String updatedItem = itemId + "," + newName + "," + newQuantity + "," + newPrice;
                    items.add(updatedItem);
                } else {
                    items.add(line);
                }
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("item_inventory.txt"))) {
                for (String item : items) {
                    writer.write(item);
                    writer.newLine();
                }
            }
            JOptionPane.showMessageDialog(this, "Item updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error updating inventory file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    //validate input fields
    private boolean validateInputs(String name, String quantity, String price) {
        //validate Item Name
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Item Name is required.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!name.matches("[a-zA-Z\\s]+")) {
            JOptionPane.showMessageDialog(this, "Item Name should contain only letters and spaces.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        //validate Quantity
        if (quantity.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Quantity is required.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!quantity.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "Quantity should be numeric.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (Integer.parseInt(quantity) <= 0) {
            JOptionPane.showMessageDialog(this, "Quantity must be greater than zero.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        //validate Price
        if (price.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Price is required.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!price.matches("\\d+(\\.\\d{1,2})?")) {
            JOptionPane.showMessageDialog(this, "Price should be a valid number.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (Double.parseDouble(price) <= 0) {
            JOptionPane.showMessageDialog(this, "Price must be greater than zero.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    //method to load items from the file
    private void loadItemsFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("item_inventory.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] itemData = line.split(",");
                if (itemData.length == 4) { // Ensure correct data format
                    tableModel.addRow(itemData);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading inventory file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        editButton = new javax.swing.JButton();
        itemNameTextField = new javax.swing.JTextField();
        nameLabel = new javax.swing.JLabel();
        itemQuantityTextField = new javax.swing.JTextField();
        itemPriceTextField = new javax.swing.JTextField();
        qtyLabel = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        itemTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        editButton.setBackground(new java.awt.Color(153, 153, 153));
        editButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        editButton.setForeground(new java.awt.Color(255, 255, 255));
        editButton.setText("EDIT");

        itemNameTextField.setToolTipText("");
        itemNameTextField.setActionCommand("<Not Set>");

        nameLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        nameLabel.setText("Item Name:");

        qtyLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        qtyLabel.setText("Quantity:");

        priceLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        priceLabel.setText("Price:");

        backButton.setBackground(new java.awt.Color(255, 204, 0));
        backButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        backButton.setText("BACK");

        itemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Item ID", "Item Name", "Quantity", "Price"
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
        jScrollPane1.setViewportView(itemTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(priceLabel)
                            .addComponent(nameLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(itemNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(qtyLabel)
                                .addGap(18, 18, 18)
                                .addComponent(itemQuantityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(itemPriceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 642, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameLabel)
                    .addComponent(qtyLabel)
                    .addComponent(itemQuantityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priceLabel)
                    .addComponent(itemPriceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
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
            java.util.logging.Logger.getLogger(item_edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(item_edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(item_edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(item_edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new item_edit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton editButton;
    private javax.swing.JTextField itemNameTextField;
    private javax.swing.JTextField itemPriceTextField;
    private javax.swing.JTextField itemQuantityTextField;
    private javax.swing.JTable itemTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JLabel qtyLabel;
    // End of variables declaration//GEN-END:variables
}

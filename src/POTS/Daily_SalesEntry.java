package POTS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Saniah
 */
public class Daily_SalesEntry extends javax.swing.JFrame {
    public Daily_SalesEntry() {
       setTitle("Adding Daily Item-wise Sales Entry");
        initComponents();
        prefillDate();
        populateDropdowns();
        setupListeners();

    }

    private void prefillDate() {
        DateOfSoldTXT.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MMM-yyyy")));
    }

    private void populateDropdowns() {
        // Populate Item Sold dropdown
        ItemSoldCB.setModel(new DefaultComboBoxModel<>(new String[]{
            "102/Microwave Oven", "104/Washing Machine", "105/Ceiling Fan", "103/LED Television",
            "109/Air Conditioner", "110/LED Light Bulbs", "101/Electric Kettle",
            "106/Refrigerator", "108/Rice Cooker", "107/Bluetooth Speaker"
        }));

        // Populate Item Category dropdown
        ItemCB.setModel(new DefaultComboBoxModel<>(new String[]{
            "Household Appliance", "Home Essentials", "Electronics"
        }));
    }

    private void saveSalesEntry() {
        String item = (String) ItemSoldCB.getSelectedItem();
        String[] itemParts = item.split("/"); // Assuming format "Code/Name"
        String itemCode = itemParts[0];
        String category = (String) ItemCB.getSelectedItem();
        String quantityStr = QuantityTXT.getText();
        String pricePerItem = PriceTXT.getText();
        String date = DateOfSoldTXT.getText();
        String saleValue = SalesValueTXT.getText();

        if (item.isEmpty() || category.isEmpty() || quantityStr.isEmpty() || pricePerItem.isEmpty() || saleValue.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int quantity = Integer.parseInt(quantityStr);

            // Save sales entry to file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("sales_entries.txt", true))) {
                String data = date + "," + item + "," + quantity + "," + category + "," + pricePerItem + "," + saleValue;
                writer.write(data);
                writer.newLine();
            }

            // Update stock in stocks file
            updateStock(itemCode, quantity);

            JOptionPane.showMessageDialog(this, "Sales entry saved and stock updated successfully!");
            resetForm();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid quantity or price format!", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving sales entry: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateStock(String itemCode, int quantitySold) {
    String fileName = "stocks.txt"; // File containing stock data
    StringBuilder updatedContent = new StringBuilder();

    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] data = line.split(","); // Split the line into columns
            if (data[0].equals(itemCode)) { // Match item code
                // Remove non-numeric characters and parse integers
                int currentStock = Integer.parseInt(data[2].replaceAll("\\D+", "").trim());
                int reorderLevel = Integer.parseInt(data[3].replaceAll("\\D+", "").trim());
                int newStock = currentStock - quantitySold;

                if (newStock < 0) {
                    JOptionPane.showMessageDialog(this, "Insufficient stock for item: " + itemCode, "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Update current stock and status
                data[2] = newStock + " units"; // Append "units" back to the value
                data[4] = (newStock < reorderLevel) ? "Needs Reorder" : "Available"; // Update status based on stock level

                line = String.join(",", data); // Rebuild the line with updated values
            }
            updatedContent.append(line).append("\n");
        }

        // Rewrite the file with updated stock levels
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(updatedContent.toString());
        }

    } catch (IOException | NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Error updating stock: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
    
    private void resetForm() {
        ItemSoldCB.setSelectedIndex(0);
        ItemCB.setSelectedIndex(0);
        QuantityTXT.setText("");
        PriceTXT.setText("");
        prefillDate();
        SalesValueTXT.setText("");
    }

    private void calculateTotalSalesValue() {
        try {
            int quantity = Integer.parseInt(QuantityTXT.getText());
            double pricePerItem = Double.parseDouble(PriceTXT.getText());
            double totalSalesValue = quantity * pricePerItem;
            SalesValueTXT.setText(String.valueOf(totalSalesValue));
        } catch (NumberFormatException e) {
            SalesValueTXT.setText(""); // Clear the field if input is invalid
        }
    }

    private void setupListeners() {
        QuantityTXT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                calculateTotalSalesValue();
            }
        });

        PriceTXT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                calculateTotalSalesValue();
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ItemSoldCB = new javax.swing.JComboBox<>();
        QuantityTXT = new javax.swing.JTextField();
        DateOfSoldTXT = new javax.swing.JTextField();
        SalesValueTXT = new javax.swing.JTextField();
        ViewDailySalesBTN = new javax.swing.JButton();
        BackBTN = new javax.swing.JButton();
        SubmitBTN = new javax.swing.JButton();
        ResetBTN = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        ItemCB = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        PriceTXT = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Item Sold:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Quantity Sold:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Item Category:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Total Sales Value:");

        ItemSoldCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        DateOfSoldTXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DateOfSoldTXTActionPerformed(evt);
            }
        });

        SalesValueTXT.setEditable(false);

        ViewDailySalesBTN.setBackground(new java.awt.Color(153, 153, 153));
        ViewDailySalesBTN.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ViewDailySalesBTN.setForeground(new java.awt.Color(255, 255, 255));
        ViewDailySalesBTN.setText("View Daily Sales Entry");
        ViewDailySalesBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewDailySalesBTNActionPerformed(evt);
            }
        });

        BackBTN.setBackground(new java.awt.Color(255, 204, 0));
        BackBTN.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BackBTN.setText("Back");
        BackBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackBTNActionPerformed(evt);
            }
        });

        SubmitBTN.setBackground(new java.awt.Color(153, 153, 153));
        SubmitBTN.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SubmitBTN.setForeground(new java.awt.Color(255, 255, 255));
        SubmitBTN.setText("Submit");
        SubmitBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitBTNActionPerformed(evt);
            }
        });

        ResetBTN.setBackground(new java.awt.Color(153, 153, 153));
        ResetBTN.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ResetBTN.setForeground(new java.awt.Color(255, 255, 255));
        ResetBTN.setText("Reset");
        ResetBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetBTNActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Date of Sold:");

        ItemCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Price per Item:");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel.setText("Add Daily Item-wise Sales Entry ");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POTS/1.1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel)
                .addGap(31, 31, 31))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(DateOfSoldTXT)
                            .addComponent(ItemSoldCB, 0, 392, Short.MAX_VALUE)
                            .addComponent(QuantityTXT)
                            .addComponent(ItemCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PriceTXT)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SalesValueTXT)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(ResetBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(SubmitBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89)
                .addComponent(ViewDailySalesBTN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addComponent(BackBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(DateOfSoldTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ItemSoldCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(QuantityTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(ItemCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(PriceTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(SalesValueTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ViewDailySalesBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BackBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(SubmitBTN, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ResetBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DateOfSoldTXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DateOfSoldTXTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DateOfSoldTXTActionPerformed

    private void ViewDailySalesBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewDailySalesBTNActionPerformed
        // TODO add your handling code here:
        ViewDailySalesEntry vr = new ViewDailySalesEntry();
        vr.show();

        dispose();
    }//GEN-LAST:event_ViewDailySalesBTNActionPerformed

    private void BackBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBTNActionPerformed
        // TODO add your handling code here:
        new TotalSalesEntry().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackBTNActionPerformed

    private void SubmitBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitBTNActionPerformed
        saveSalesEntry();
    }//GEN-LAST:event_SubmitBTNActionPerformed

    private void ResetBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetBTNActionPerformed
        ItemSoldCB.setSelectedIndex(0); // Reset the item dropdown to the first option
        QuantityTXT.setText(""); // Clear the quantity text field
        DateOfSoldTXT.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"))); // Reset the date field to today's date
        SalesValueTXT.setText(""); // Clear the sales value text field
    }//GEN-LAST:event_ResetBTNActionPerformed

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
            java.util.logging.Logger.getLogger(Daily_SalesEntry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Daily_SalesEntry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Daily_SalesEntry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Daily_SalesEntry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Daily_SalesEntry().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackBTN;
    private javax.swing.JTextField DateOfSoldTXT;
    private javax.swing.JComboBox<String> ItemCB;
    private javax.swing.JComboBox<String> ItemSoldCB;
    private javax.swing.JTextField PriceTXT;
    private javax.swing.JTextField QuantityTXT;
    private javax.swing.JButton ResetBTN;
    private javax.swing.JTextField SalesValueTXT;
    private javax.swing.JButton SubmitBTN;
    private javax.swing.JButton ViewDailySalesBTN;
    private javax.swing.JLabel jLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}

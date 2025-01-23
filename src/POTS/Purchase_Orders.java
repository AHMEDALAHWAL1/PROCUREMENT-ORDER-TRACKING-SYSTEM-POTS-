package POTS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Purchase_Orders extends javax.swing.JFrame {

    /**
     * Creates new form Purchase_Orders
     */
    public Purchase_Orders() {
        initComponents();
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
        btn_approve = new javax.swing.JButton();
        btn_reject = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_pos = new javax.swing.JTable();
        lbl_title = new javax.swing.JLabel();
        btn_close = new javax.swing.JButton();
        btn_viewpo = new javax.swing.JButton();
        logo = new javax.swing.JButton();
        txt_iteamid = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btn_search = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txt_poid = new javax.swing.JTextField();
        btn_clear = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(0, 102, 102));

        btn_approve.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_approve.setText("Approve");
        btn_approve.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_approve.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_approve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_approveActionPerformed(evt);
            }
        });

        btn_reject.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_reject.setText("Reject");
        btn_reject.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_reject.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_reject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_rejectActionPerformed(evt);
            }
        });

        tbl_pos.setBorder(new javax.swing.border.MatteBorder(null));
        tbl_pos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "PO_ID", "Item_Code", "Quantity", "Order_Date", "Status"
            }
        ));
        jScrollPane1.setViewportView(tbl_pos);

        lbl_title.setBackground(new java.awt.Color(102, 102, 102));
        lbl_title.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lbl_title.setText("View Purchase Orders");

        btn_close.setBackground(new java.awt.Color(204, 153, 0));
        btn_close.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_close.setText("Close");
        btn_close.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_closeActionPerformed(evt);
            }
        });

        btn_viewpo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_viewpo.setText("View");
        btn_viewpo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_viewpo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_viewpo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_viewpoActionPerformed(evt);
            }
        });

        logo.setBorder(null);

        txt_iteamid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_iteamidActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Iteam ID");

        btn_search.setText("Search");
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("PO ID");

        txt_poid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_poidActionPerformed(evt);
            }
        });

        btn_clear.setText("Clear");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POTS/purchase_11744345 (1).png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(121, 121, 121)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txt_iteamid, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(98, 98, 98)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(btn_search)
                                .addGap(32, 32, 32)
                                .addComponent(btn_clear))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txt_poid, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btn_close, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btn_approve, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btn_reject, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btn_viewpo, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_title, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(logo)
                            .addComponent(jLabel3)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_title, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_poid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_iteamid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_clear)
                            .addComponent(btn_search))))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(btn_viewpo, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_approve, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_reject, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_close, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(73, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 489, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_approveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_approveActionPerformed
        // Get the selected row index
        int selectedRow = tbl_pos.getSelectedRow();

        if (selectedRow != -1) { // If a row is selected
            // Get the table model
            DefaultTableModel model = (DefaultTableModel) tbl_pos.getModel();

            // Get the current status of the selected row
            String currentStatus = (String) model.getValueAt(selectedRow, 4); // Assuming status is in the 5th column (index 4)

            // Check if the status is already "Approved"
            if (!"Approved".equals(currentStatus)) {
                // Update the status to 'Approved'
                model.setValueAt("Approved", selectedRow, 4); // Assuming status is in the 5th column

                // Now save the updated status back to the file
                String filePath = "PurchaseOrders.txt"; // Updated to use a relative file path
                try {
                    File file = new File(filePath);
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    StringBuilder fileContent = new StringBuilder();
                    String line;

                    // Read the file line by line and update the status of the selected PO
                    while ((line = reader.readLine()) != null) {
                        String[] data = line.split(",");
                        if (data[0].equals(model.getValueAt(selectedRow, 0))) { // Compare PO_ID
                            data[4] = "Approved"; // Update the status column
                        }
                        fileContent.append(String.join(",", data)).append("\n");
                    }

                    // Close the reader
                    reader.close();

                    // Write the updated content back to the file
                    BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                    writer.write(fileContent.toString());
                    writer.close();

                    // Show a success message
                    JOptionPane.showMessageDialog(this, "Purchase Order " + model.getValueAt(selectedRow, 0) + " has been approved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

                } catch (IOException e) {
                    // Handle file read/write errors
                    JOptionPane.showMessageDialog(this, "An error occurred while updating the file.", "Error", JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
                }

            } else {
                // If the status is already "Approved", show a message
                JOptionPane.showMessageDialog(this, "This purchase order is already approved.", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            // No row selected, show an error message
            JOptionPane.showMessageDialog(this, "Please select a purchase order to approve.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_approveActionPerformed

    private void btn_rejectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_rejectActionPerformed
        // Reject button action
        int selectedRow = tbl_pos.getSelectedRow();

        if (selectedRow != -1) { // If a row is selected
            // Get the table model
            DefaultTableModel model = (DefaultTableModel) tbl_pos.getModel();

            // Get the current status of the selected row
            String currentStatus = (String) model.getValueAt(selectedRow, 4); // Assuming status is in the 5th column (index 4)

            // Check if the status is already "Rejected"
            if (!"Rejected".equals(currentStatus)) {
                // Update the status to 'Rejected'
                model.setValueAt("Rejected", selectedRow, 4); // Update the table model

                // Save the updated status back to the file
                String filePath = "PurchaseOrders.txt"; // Use relative path for file

                try {
                    File file = new File(filePath);
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    StringBuilder fileContent = new StringBuilder();
                    String line;

                    // Read the file line by line and update the status of the selected PO
                    while ((line = reader.readLine()) != null) {
                        String[] data = line.split(",");
                        if (data[0].equals(model.getValueAt(selectedRow, 0))) { // Compare PO_ID
                            data[4] = "Rejected"; // Update the status column to "Rejected"
                        }
                        fileContent.append(String.join(",", data)).append("\n");
                    }

                    // Close the reader
                    reader.close();

                    // Write the updated content back to the file
                    BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                    writer.write(fileContent.toString());
                    writer.close();

                    // Show a success message
                    JOptionPane.showMessageDialog(this, "Purchase Order " + model.getValueAt(selectedRow, 0) + " has been rejected successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

                } catch (IOException e) {
                    // Handle file read/write errors
                    JOptionPane.showMessageDialog(this, "An error occurred while updating the file.", "Error", JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
                }

            } else {
                // If the status is already "Rejected", show a message
                JOptionPane.showMessageDialog(this, "This purchase order is already rejected.", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            // No row selected, show an error message
            JOptionPane.showMessageDialog(this, "Please select a purchase order to reject.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btn_rejectActionPerformed

    private void btn_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_closeActionPerformed
        FinanceManager mainDashboard = new FinanceManager();
        mainDashboard.setVisible(true);

        // Close the current Purchase Orders window
        this.dispose();
    }//GEN-LAST:event_btn_closeActionPerformed

    private void btn_viewpoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_viewpoActionPerformed
        // Define the file path (relative or absolute)
        String filePath = "PurchaseOrders.txt";

        try {
            // Create a File object for the file
            File file = new File(filePath);

            // Check if the file exists
            if (file.exists()) {
                // Create a BufferedReader to read the file line by line
                BufferedReader reader = new BufferedReader(new FileReader(file));

                // Get the table model from tbl_pos
                DefaultTableModel model = (DefaultTableModel) tbl_pos.getModel();
                model.setRowCount(0);  // Clear existing rows before adding new ones

                String line;
                boolean inPurchaseOrderSection = false; // Flag to track the relevant section

                // Read each line from the file
                while ((line = reader.readLine()) != null) {
                    line = line.trim(); // Remove any leading or trailing whitespace

                    // Check if the line indicates the start of the `# Purchase Orders` section
                    if (line.equals("# Purchase Orders")) {
                        inPurchaseOrderSection = true; // Enter the purchase orders section
                        continue; // Skip the section header itself
                    }

                    // Check if the line indicates the end of the section
                    if (inPurchaseOrderSection && line.equals("-----------------------------------")) {
                        inPurchaseOrderSection = false; // Exit the purchase orders section
                        continue;
                    }

                    // Process lines within the `# Purchase Orders` section
                    if (inPurchaseOrderSection) {
                        // Split the line into components (assuming comma-separated values)
                        String[] data = line.split(",");

                        // Ensure the data format is correct
                        if (data.length >= 5) {
                            // Add the purchase order data to the table
                            model.addRow(data);
                        }
                    }
                }

                // Close the BufferedReader
                reader.close();
            } else {
                // If the file doesn't exist, show an error message
                JOptionPane.showMessageDialog(this, "File not found!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException e) {
            // If there is an error reading the file, show an error message
            JOptionPane.showMessageDialog(this, "An error occurred while reading the file.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();  // Print the error stack trace (optional)
        }
    }//GEN-LAST:event_btn_viewpoActionPerformed

    private void txt_iteamidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_iteamidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_iteamidActionPerformed

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        String filePath = "PurchaseOrders.txt"; // Use a relative path for the file

try {
    BufferedReader reader = new BufferedReader(new FileReader(filePath));
    String line;
    boolean inPaymentsSection = false;
    List<String[]> paymentData = new ArrayList<>();

    // Read lines from the file and parse the payment data
    while ((line = reader.readLine()) != null) {
        if (line.trim().equalsIgnoreCase("# Payments")) {
            inPaymentsSection = true;
            continue;
        }
        if (line.startsWith("#") && inPaymentsSection) break;

        // Process the lines after # Payments and split by commas
        if (inPaymentsSection && !line.trim().isEmpty()) {
            String[] columns = line.split(",");

            // Skip rows with less than 2 columns (i.e., missing POID or ItemID)
            if (columns.length < 2) {
                System.out.println("Skipping malformed line (less than 2 columns): " + line);
                continue;
            }

            paymentData.add(columns);
        }
    }
    reader.close();

    // Get search terms from the text fields
    String searchPOID = txt_poid.getText().trim();
    String searchItemID = txt_iteamid.getText().trim();

    // Validate that at least one search term is provided
    if (searchPOID.isEmpty() && searchItemID.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter POID or ItemID to search.",
                                      "Input Error", JOptionPane.WARNING_MESSAGE);
        return;
    }

    // Filter data based on POID or ItemID
    List<String[]> filteredData = new ArrayList<>();
    for (String[] row : paymentData) {
        // Trim and compare POID and ItemID
        boolean matchesPOID = !searchPOID.isEmpty() && row[0].trim().equalsIgnoreCase(searchPOID);
        boolean matchesItemID = !searchItemID.isEmpty() && row[1].trim().equalsIgnoreCase(searchItemID);

        // Add the row to filteredData if either POID or ItemID matches
        if (matchesPOID || matchesItemID) {
            filteredData.add(row);
        }
    }

    // Display filtered data in the table
    if (!filteredData.isEmpty()) {
        String[] columnNames = {"POID", "ItemID", "SupplierID", "Quantity", "Date", "Status"};
        String[][] tableData = filteredData.toArray(new String[0][]);

        DefaultTableModel tableModel = (DefaultTableModel) tbl_pos.getModel();
        tableModel.setRowCount(0);  // Clear existing rows

        // Add the filtered rows to the table
        for (String[] rowData : tableData) {
            tableModel.addRow(rowData);
        }
    } else {
        JOptionPane.showMessageDialog(this, "No matching records found.", 
                                      "Search Result", JOptionPane.INFORMATION_MESSAGE);
    }

} catch (IOException e) {
    JOptionPane.showMessageDialog(this, "Error reading the file: " + e.getMessage(),
                                  "File Error", JOptionPane.ERROR_MESSAGE);
}


    }//GEN-LAST:event_btn_searchActionPerformed

    private void txt_poidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_poidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_poidActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        // Check if the text fields are already empty
        if (txt_poid.getText().isEmpty() && txt_iteamid.getText().isEmpty()) {
            // Show a navigation message if the fields are empty
            JOptionPane.showMessageDialog(this, "The text fields are already empty!",
                "Information", JOptionPane.INFORMATION_MESSAGE);
        } else {
            // Clear the text fields
            txt_poid.setText("");
            txt_iteamid.setText("");

            // Optionally, clear the table data
            DefaultTableModel tableModel = (DefaultTableModel) tbl_pos.getModel();
            tableModel.setRowCount(0);

            // Show a confirmation message
            JOptionPane.showMessageDialog(this, "Inputs cleared successfully!",
                "Clear", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_clearActionPerformed

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
            java.util.logging.Logger.getLogger(Purchase_Orders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Purchase_Orders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Purchase_Orders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Purchase_Orders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Purchase_Orders().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_approve;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_close;
    private javax.swing.JButton btn_reject;
    private javax.swing.JButton btn_search;
    private javax.swing.JButton btn_viewpo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_title;
    private javax.swing.JButton logo;
    private javax.swing.JTable tbl_pos;
    private javax.swing.JTextField txt_iteamid;
    private javax.swing.JTextField txt_poid;
    // End of variables declaration//GEN-END:variables
}

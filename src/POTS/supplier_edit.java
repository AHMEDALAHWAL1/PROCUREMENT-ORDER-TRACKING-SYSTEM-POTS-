package POTS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class supplier_edit extends javax.swing.JFrame {
    
    private DefaultTableModel tableModel;

    public supplier_edit() {
        setTitle("Edit Supplier Details"); //setting the title of the form
        initComponents();
        tableModel = (DefaultTableModel) supplierTable.getModel(); //initialize the table model

        tableModel.setRowCount(0); //setting the table count when loading to 0 to avoid empty rows

        loadSuppliersFromFile(); //loading supplier details from the file created

        editButton.addActionListener(e -> updateSupplier()); //action for edit button

        backButton.addActionListener(e -> dispose()); //action for back button
    }
    
    private void loadSuppliersFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("supplier_data.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] supplierData = line.split(",");
                if (supplierData.length == 5) {
                    tableModel.addRow(supplierData);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading supplier data file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateSupplier() {
        String supplierID = supplierIDTextField.getText().trim();
        String supplierName = supplierNameTextField.getText().trim();
        String contactNumber = contactNumberTextField.getText().trim();
        String personalEmail = emailTextField.getText().trim();
        String companyEmail = companyEmailTextField.getText().trim();

        //validation for empty fields
        if (supplierID.isEmpty() || supplierName.isEmpty() || contactNumber.isEmpty() || personalEmail.isEmpty() || companyEmail.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required.", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        //validate Supplier ID
        if (!isNumeric(supplierID)) {
            JOptionPane.showMessageDialog(this, "Supplier ID must be numeric.", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        //validate Contact Number
        if (!isNumeric(contactNumber)) {
            JOptionPane.showMessageDialog(this, "Invalid contact number. The phone number assumes +6 as country code.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //validate Email
        if (!isValidEmail(personalEmail)) {
            JOptionPane.showMessageDialog(this, "Invalid personal email format.", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (!isValidEmail(companyEmail)) {
            JOptionPane.showMessageDialog(this, "Invalid company email format.", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        ArrayList<String> suppliers = new ArrayList<>();
        boolean updated = false;

        try (BufferedReader reader = new BufferedReader(new FileReader("supplier_data.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] supplierData = line.split(",");
                if (supplierData[0].equals(supplierID)) {
                    // Update the supplier details in the list
                    suppliers.add(supplierID + "," + supplierName + "," + contactNumber + "," + personalEmail + "," + companyEmail);
                    updated = true;
                } else {
                    suppliers.add(line);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!updated) {
            JOptionPane.showMessageDialog(this, "Supplier ID not found.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("supplier_data.txt"))) {
            for (String supplier : suppliers) {
                writer.write(supplier);
                writer.newLine();
            }
            JOptionPane.showMessageDialog(this, "Supplier updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error writing to file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isValidContactNumber(String contactNumber) {
        String regex = "^[a-zA-Z0-9]*$"; 
        return contactNumber.matches(regex);  
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        supplierIDLabel = new javax.swing.JLabel();
        emailTextField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        supplierTable = new javax.swing.JTable();
        contactNumberTextField = new javax.swing.JTextField();
        supplierNameTextField = new javax.swing.JTextField();
        contactNumberLabel = new javax.swing.JLabel();
        personalEmailLabel = new javax.swing.JLabel();
        companyEmailTextField = new javax.swing.JTextField();
        supplierNameLabel = new javax.swing.JLabel();
        companyEmailLabel = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        supplierIDTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        supplierIDLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        supplierIDLabel.setText("Supplier ID:");

        supplierTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Supplier ID", "Supplier Name", "Contact Number", "Personal Email", "Company Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(supplierTable);

        contactNumberLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        contactNumberLabel.setText("Contact Number:");

        personalEmailLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        personalEmailLabel.setText("Personal Email:");

        companyEmailTextField.setToolTipText("");
        companyEmailTextField.setActionCommand("<Not Set>");

        supplierNameLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        supplierNameLabel.setText("Supplier Name:");

        companyEmailLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        companyEmailLabel.setText("Company Email:");

        backButton.setBackground(new java.awt.Color(255, 204, 0));
        backButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        backButton.setText("BACK");

        editButton.setBackground(new java.awt.Color(153, 153, 153));
        editButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        editButton.setForeground(new java.awt.Color(255, 255, 255));
        editButton.setText("EDIT");

        supplierIDTextField.setToolTipText("");
        supplierIDTextField.setActionCommand("<Not Set>");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(supplierNameLabel)
                            .addComponent(supplierIDLabel)
                            .addComponent(contactNumberLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(supplierIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(40, 40, 40)
                                    .addComponent(personalEmailLabel)
                                    .addGap(18, 18, 18)
                                    .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(supplierNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(8, 8, 8)))
                                    .addGap(40, 40, 40)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(companyEmailLabel)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(companyEmailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(contactNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(supplierIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(supplierIDLabel))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(personalEmailLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(supplierNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(supplierNameLabel))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(companyEmailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(companyEmailLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(contactNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contactNumberLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(supplier_edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(supplier_edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(supplier_edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(supplier_edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new supplier_edit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel companyEmailLabel;
    private javax.swing.JTextField companyEmailTextField;
    private javax.swing.JLabel contactNumberLabel;
    private javax.swing.JTextField contactNumberTextField;
    private javax.swing.JButton editButton;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel personalEmailLabel;
    private javax.swing.JLabel supplierIDLabel;
    private javax.swing.JTextField supplierIDTextField;
    private javax.swing.JLabel supplierNameLabel;
    private javax.swing.JTextField supplierNameTextField;
    private javax.swing.JTable supplierTable;
    // End of variables declaration//GEN-END:variables
}

package POTS;

import POTS.supplier_menu;
import POTS.stock_menu;
import POTS.item_menu;

public class InventoryManager extends javax.swing.JFrame {

   
    public InventoryManager() {
        setTitle("Inventory Management Menu"); //setting a title for the main form
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        supplier_management_menu = new javax.swing.JButton();
        item_management_menu = new javax.swing.JButton();
        stock_management_menu = new javax.swing.JButton();
        welcome_label = new javax.swing.JLabel();
        exit_button = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        supplier_management_menu.setBackground(new java.awt.Color(153, 153, 153));
        supplier_management_menu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        supplier_management_menu.setForeground(new java.awt.Color(255, 255, 255));
        supplier_management_menu.setText("Supplier Management");
        supplier_management_menu.setActionCommand("jButton2");
        supplier_management_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplier_management_menuActionPerformed(evt);
            }
        });
        getContentPane().add(supplier_management_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 278, 171, 36));

        item_management_menu.setBackground(new java.awt.Color(153, 153, 153));
        item_management_menu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        item_management_menu.setForeground(new java.awt.Color(255, 255, 255));
        item_management_menu.setText("Item Management");
        item_management_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_management_menuActionPerformed(evt);
            }
        });
        getContentPane().add(item_management_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 230, 171, 36));

        stock_management_menu.setBackground(new java.awt.Color(153, 153, 153));
        stock_management_menu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        stock_management_menu.setForeground(new java.awt.Color(255, 255, 255));
        stock_management_menu.setText("Stock Management");
        stock_management_menu.setActionCommand("jButton3");
        stock_management_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stock_management_menuActionPerformed(evt);
            }
        });
        getContentPane().add(stock_management_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 332, 171, 36));

        welcome_label.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        welcome_label.setForeground(new java.awt.Color(255, 255, 255));
        welcome_label.setText("Welcome! ");
        getContentPane().add(welcome_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        exit_button.setBackground(new java.awt.Color(255, 204, 0));
        exit_button.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        exit_button.setText("Logout");
        exit_button.setActionCommand("jButton4");
        exit_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(exit_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 10, 90, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Inventory Manager");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 340, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POTS/inventory, pic.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void supplier_management_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplier_management_menuActionPerformed
        new supplier_menu().setVisible(true); //to open the supplier management menu
        this.dispose(); //to close the main menu
    }//GEN-LAST:event_supplier_management_menuActionPerformed

    private void item_management_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_management_menuActionPerformed
        new item_menu().setVisible(true); //to open the item management menu
        this.dispose(); //to close the main menu
    }//GEN-LAST:event_item_management_menuActionPerformed

    private void stock_management_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stock_management_menuActionPerformed
        new stock_menu().setVisible(true); //to open the stock management menu
        this.dispose(); //to close the main menu
    }//GEN-LAST:event_stock_management_menuActionPerformed

    private void exit_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_buttonActionPerformed
        this.dispose();//closing the current form
        new MainMenu().setVisible(true);//opening the MainMenu form
    }//GEN-LAST:event_exit_buttonActionPerformed

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
            java.util.logging.Logger.getLogger(InventoryManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InventoryManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InventoryManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InventoryManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InventoryManager().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exit_button;
    private javax.swing.JButton item_management_menu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JButton stock_management_menu;
    private javax.swing.JButton supplier_management_menu;
    private javax.swing.JLabel welcome_label;
    // End of variables declaration//GEN-END:variables
}

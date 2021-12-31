/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package application;

import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dai Phuc
 */
public class SortPanel extends javax.swing.JPanel {

    DefaultTableModel tableModel;
    List <Product> ProductList;
    
    public SortPanel() {
        initComponents();
        tableModel = (DefaultTableModel) tblProductSort.getModel();
        
        showProduct();
    }

    public void showProduct(){
        List <Product> ProductList = Application.findAll();
        
        tableModel.setRowCount(0);
        
        ProductList.forEach(Product -> { 
            tableModel.addRow(new Object[] { Product.getProductID(),
                Product.getProductName(), Product.getOriginPrice(), Product.getPrice(), Product.getAmount()});
        });
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProductSort = new javax.swing.JTable();
        CheckNumber = new javax.swing.JCheckBox();
        CheckName = new javax.swing.JCheckBox();
        CheckPrice = new javax.swing.JCheckBox();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(811, 427));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(680, 403));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 782, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        tblProductSort.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Product ID", "Product Name", "Origin Price", "Price", "Number"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
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
        tblProductSort.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblProductSort);
        if (tblProductSort.getColumnModel().getColumnCount() > 0) {
            tblProductSort.getColumnModel().getColumn(0).setResizable(false);
            tblProductSort.getColumnModel().getColumn(1).setResizable(false);
            tblProductSort.getColumnModel().getColumn(2).setResizable(false);
            tblProductSort.getColumnModel().getColumn(3).setResizable(false);
            tblProductSort.getColumnModel().getColumn(4).setResizable(false);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 811, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(197, 197, 197)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        CheckNumber.setBackground(new java.awt.Color(255, 255, 255));
        CheckNumber.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        CheckNumber.setText("Number");
        CheckNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckNumberActionPerformed(evt);
            }
        });

        CheckName.setBackground(new java.awt.Color(255, 255, 255));
        CheckName.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        CheckName.setText("Name");
        CheckName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckNameActionPerformed(evt);
            }
        });

        CheckPrice.setBackground(new java.awt.Color(255, 255, 255));
        CheckPrice.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        CheckPrice.setText("Price");
        CheckPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckPriceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 811, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(204, 204, 204)
                .addComponent(CheckName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CheckPrice)
                .addGap(123, 123, 123)
                .addComponent(CheckNumber)
                .addGap(69, 69, 69))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CheckPrice)
                    .addComponent(CheckName)
                    .addComponent(CheckNumber))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

  
    private void CheckNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckNameActionPerformed
        // TODO add your handling code here:
        tableModel.setRowCount(0);           
        if (CheckName.isSelected()){
            CheckPrice.setSelected(false);
            CheckNumber.setSelected(false);
            ProductList = Application.sort(1);
            ProductList.forEach(Product -> { 
            tableModel.addRow(new Object[] { Product.getProductID(),
                Product.getProductName(), Product.getOriginPrice(), Product.getPrice(), Product.getAmount()});
            });
        } else {
            showProduct();
        }
    }//GEN-LAST:event_CheckNameActionPerformed

    private void CheckPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckPriceActionPerformed
        // TODO add your handling code here:
        tableModel.setRowCount(0);           
        if (CheckPrice.isSelected()){
            CheckName.setSelected(false);
            CheckNumber.setSelected(false);
            ProductList = Application.sort(2);
            ProductList.forEach(Product -> { 
            tableModel.addRow(new Object[] { Product.getProductID(),
                Product.getProductName(), Product.getOriginPrice(), Product.getPrice(), Product.getAmount()});
            });
        } else {
            showProduct();
        }
    }//GEN-LAST:event_CheckPriceActionPerformed

    private void CheckNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckNumberActionPerformed
        // TODO add your handling code here:
        tableModel.setRowCount(0);           
        if (CheckNumber.isSelected()){
            CheckName.setSelected(false);
            CheckPrice.setSelected(false);
            ProductList = Application.sort(3);
            ProductList.forEach(Product -> { 
            tableModel.addRow(new Object[] { Product.getProductID(),
                Product.getProductName(), Product.getOriginPrice(), Product.getPrice(), Product.getAmount()});
            });
        } else {
            showProduct();
        }
    }//GEN-LAST:event_CheckNumberActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox CheckName;
    private javax.swing.JCheckBox CheckNumber;
    private javax.swing.JCheckBox CheckPrice;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblProductSort;
    // End of variables declaration//GEN-END:variables
}

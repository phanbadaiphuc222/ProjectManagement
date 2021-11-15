/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package application;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Dai Phuc
 */
public class ExcelPanel extends javax.swing.JPanel {

    DefaultTableModel tableModel;
    List <Product> ProductList;
    
    public ExcelPanel() {
        
        initComponents();
        tableModel = (DefaultTableModel) tblProductExcel.getModel();
        showProduct();
        
    }

    public void showProduct(){
        
        ProductList = Application.findAll();
        
        tableModel.setRowCount(0);
                
        ProductList.forEach(Product -> { 
            tableModel.addRow(new Object[] { Product.getProductID(),
                Product.getProductName(), Product.getOriginPrice(), Product.getPrice(), Product.getAmount()});
        });
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new keeptoo.KGradientPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductExcel = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(811, 427));

        tblProductExcel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
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
                "ProductID", "Product Name", "Origin Price", "Price", "Number"
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
        jScrollPane1.setViewportView(tblProductExcel);
        if (tblProductExcel.getColumnModel().getColumnCount() > 0) {
            tblProductExcel.getColumnModel().getColumn(0).setResizable(false);
            tblProductExcel.getColumnModel().getColumn(1).setResizable(false);
            tblProductExcel.getColumnModel().getColumn(2).setResizable(false);
            tblProductExcel.getColumnModel().getColumn(4).setResizable(false);
        }

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 787, Short.MAX_VALUE)
                .addContainerGap())
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    
    public void excel(){
       
        JFileChooser excelFile = new JFileChooser("C:\\Users\\Dai Phuc\\Desktop");
        int excelChooser = excelFile.showSaveDialog(null);
        
        if (excelChooser == JFileChooser.APPROVE_OPTION){
            
            XSSFWorkbook excel = new XSSFWorkbook();
            XSSFSheet excelSheet = excel.createSheet("Product");
                                
            XSSFRow excelRow = null;
            XSSFCell excelCell = null;
            
            excelRow = excelSheet.createRow(0);
            
//            excelCell = excelRow.createCell(0, CellType.STRING);
            excelRow.createCell(0).setCellValue("Product ID");
            
//            excelRow = excelRow.createCell(1, CellType.STRING);
            excelRow.createCell(1).setCellValue("Product Name");
            
//            excelCell = excelRow.createCell(2, CellType.STRING);
            excelRow.createCell(2).setCellValue("Origin Price");
            
//            excelCell = excelRow.createCell(3, CellType.STRING);
            excelRow.createCell(3).setCellValue("Price");
            
//            excelCell = excelRow.createCell(4, CellType.STRING);
            excelRow.createCell(4).setCellValue("Amount");
                           
            for (int i=0; i < tableModel.getRowCount(); i++){
                
                excelRow = excelSheet.createRow(i+1);
                
                for (int j=0; j < tableModel.getColumnCount(); j++){
                    
                    excelCell = excelRow.createCell(j);
                    excelCell.setCellValue(tableModel.getValueAt(i, j).toString());
                    
                }
            }
            
            FileOutputStream excelaFIS;
            BufferedOutputStream excelBOU;
            
            try {
                excelaFIS = new FileOutputStream(excelFile.getSelectedFile() + ".xlsx");
                excelBOU = new BufferedOutputStream(excelaFIS);
                excel.write(excelBOU);
                excelBOU.close();
                excel.close();
                JOptionPane.showMessageDialog(null, "Succesfully Exported");
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JTable tblProductExcel;
    // End of variables declaration//GEN-END:variables
}

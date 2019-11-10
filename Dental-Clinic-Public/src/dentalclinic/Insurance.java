/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dentalclinic;

import java.awt.Font;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TimeZone;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Miit
 */
public class Insurance extends javax.swing.JFrame {

     Connection conn;
    String col, sql, search;
    int row;
    PreparedStatement stmt;
    ResultSet result;
    TableRowSorter<DefaultTableModel> tableRow;
    
    /**
     * Creates new form Insurance
     */
    public Insurance() {
       
        initComponents();
        showTableData();
        updateTableData();
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)insuranceTable.getDefaultRenderer(Object.class);
        renderer.setHorizontalAlignment( JLabel.CENTER);
        insuranceTable.getTableHeader().setFont(new Font("Segoe UI", Font.PLAIN, 15));
        insuranceTable.getColumnModel().getColumn(0).setPreferredWidth(50);
        insuranceTable.getColumnModel().getColumn(1).setPreferredWidth(230);
    }
    
    public void showTableData()
    {
        try
        {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dentalclinic?serverTimezone=" + TimeZone.getDefault().getID(),"root","");
            sql = "SELECT id AS 'Insurance ID', company_name AS 'Company Name', company_contact AS 'Contact', insurance_type AS 'Insurance Type', total_amount AS 'Total Amount', amount_paid AS 'Amount Paid', balance AS 'Balance' FROM insurancedetails";
            stmt = conn.prepareStatement(sql);
            result= stmt.executeQuery();
            insuranceTable.setModel(DbUtils.resultSetToTableModel(result));
        }

        catch( SQLException | HeadlessException ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
        
        finally
        {
            try
            {
                result.close();
                stmt.close();
            }
            
            catch (SQLException | HeadlessException ex) 
            {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
        
        updateTableData();
        
    }
    
    public void updateTableData()
    {
        try
        {
            sql = "SELECT id AS 'Insurance ID', company_name AS 'Company Name', company_contact AS 'Contact', insurance_type AS 'Insurance Type', total_amount AS 'Total Amount', amount_paid AS 'Amount Paid', balance AS 'Balance' FROM insurancedetails";           
            stmt = conn.prepareStatement(sql);
            result = stmt.executeQuery();
            insuranceTable.setModel(DbUtils.resultSetToTableModel(result));
        }
        
        catch( SQLException | HeadlessException ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
        
        finally
        {
            try
            {
                result.close();
                stmt.close();
            }

            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null, ex);
            }
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

        jPanel1 = new javax.swing.JPanel();
        deleteBtn = new javax.swing.JButton();
        LabelNo = new javax.swing.JLabel();
        companyTxt = new javax.swing.JTextField();
        labelcompany = new javax.swing.JLabel();
        labelcontact = new javax.swing.JLabel();
        contactTxt = new javax.swing.JTextField();
        labelcontact1 = new javax.swing.JLabel();
        typeTxt = new javax.swing.JTextField();
        invoiceScrollPane = new javax.swing.JScrollPane();
        insuranceTable = new javax.swing.JTable();
        idTxt = new javax.swing.JTextField();
        addBtn = new javax.swing.JButton();
        Insurancelbl = new javax.swing.JLabel();
        updateBtn = new javax.swing.JButton();
        signoutBtn = new javax.swing.JButton();
        exitLbl = new javax.swing.JLabel();
        minimizeLbl = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();
        labeltotal = new javax.swing.JLabel();
        labelpaid = new javax.swing.JLabel();
        TotalTxt = new javax.swing.JTextField();
        PaidTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        deleteBtn.setBackground(new java.awt.Color(102, 51, 153));
        deleteBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        deleteBtn.setForeground(new java.awt.Color(255, 255, 255));
        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        LabelNo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        LabelNo.setText("Insurance ID       :");

        companyTxt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        companyTxt.setForeground(new java.awt.Color(153, 153, 153));
        companyTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                companyTxtActionPerformed(evt);
            }
        });

        labelcompany.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelcompany.setText("Company Name :");

        labelcontact.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelcontact.setText("Contact              :");

        contactTxt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        contactTxt.setForeground(new java.awt.Color(153, 153, 153));
        contactTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactTxtActionPerformed(evt);
            }
        });

        labelcontact1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelcontact1.setText("Insurance Type   :");

        typeTxt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        typeTxt.setForeground(new java.awt.Color(153, 153, 153));
        typeTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeTxtActionPerformed(evt);
            }
        });

        insuranceTable.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        insuranceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Insurance Id", "Company Name", "Contact", "Insurance Type", "Total Amount", "Amount Paid", "Balance"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        insuranceTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        invoiceScrollPane.setViewportView(insuranceTable);

        idTxt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        idTxt.setForeground(new java.awt.Color(153, 153, 153));
        idTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idTxtActionPerformed(evt);
            }
        });

        addBtn.setBackground(new java.awt.Color(102, 51, 153));
        addBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        addBtn.setForeground(new java.awt.Color(255, 255, 255));
        addBtn.setText("Add");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        Insurancelbl.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        Insurancelbl.setText("Insurance's Section");

        updateBtn.setBackground(new java.awt.Color(102, 51, 153));
        updateBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        updateBtn.setForeground(new java.awt.Color(255, 255, 255));
        updateBtn.setText("Update");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        signoutBtn.setBackground(new java.awt.Color(102, 51, 153));
        signoutBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        signoutBtn.setForeground(new java.awt.Color(255, 255, 255));
        signoutBtn.setText("Sign Out");
        signoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signoutBtnActionPerformed(evt);
            }
        });

        exitLbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        exitLbl.setForeground(new java.awt.Color(204, 0, 0));
        exitLbl.setText("X");
        exitLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitLblMouseClicked(evt);
            }
        });

        minimizeLbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        minimizeLbl.setText("-");
        minimizeLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeLblMouseClicked(evt);
            }
        });

        backBtn.setBackground(new java.awt.Color(102, 51, 153));
        backBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        backBtn.setForeground(new java.awt.Color(255, 255, 255));
        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        labeltotal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labeltotal.setText("Total Amount     :");

        labelpaid.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelpaid.setText("Amount Paid      :");

        TotalTxt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TotalTxt.setForeground(new java.awt.Color(153, 153, 153));
        TotalTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TotalTxtActionPerformed(evt);
            }
        });

        PaidTxt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        PaidTxt.setForeground(new java.awt.Color(153, 153, 153));
        PaidTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PaidTxtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(backBtn)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(LabelNo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(idTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(labelcompany, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(labelpaid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(labeltotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(labelcontact1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(labelcontact, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(companyTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(contactTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(typeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(TotalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(PaidTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(120, 120, 120))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Insurancelbl)
                        .addGap(228, 228, 228)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(minimizeLbl)
                        .addGap(18, 18, 18)
                        .addComponent(exitLbl))
                    .addComponent(signoutBtn)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 120, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(invoiceScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 735, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(updateBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(290, 290, 290))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(exitLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(minimizeLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 10, Short.MAX_VALUE)
                        .addComponent(Insurancelbl)))
                .addGap(11, 11, 11)
                .addComponent(invoiceScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelNo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(companyTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelcompany, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelcontact, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contactTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelcontact1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(typeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labeltotal, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TotalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelpaid, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PaidTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBtn)
                    .addComponent(deleteBtn)
                    .addComponent(updateBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backBtn)
                    .addComponent(signoutBtn)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed

        row = insuranceTable.getSelectedRow();
        col = insuranceTable.getModel().getValueAt(row, 0).toString();

        try
        {
            sql = "DELETE FROM insurancedetails WHERE id =" + col;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dentalclinic?serverTimezone=" + TimeZone.getDefault().getID(),"root","");
            stmt = conn.prepareStatement(sql);
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Data deleted succesfully");
        }

        catch( SQLException | HeadlessException ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }

        updateTableData();
        showTableData();
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void companyTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_companyTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_companyTxtActionPerformed

    private void contactTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contactTxtActionPerformed

    private void typeTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_typeTxtActionPerformed

    private void idTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idTxtActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed

        try
        {
            sql = "INSERT INTO insurancedetails(id, company_name, company_contact, insurance_type, total_amount, amount_paid, balance ) VALUES (?,?,?,?,?,?,total_amount - amount_paid)";
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dentalclinic?serverTimezone=" + TimeZone.getDefault().getID(),"root","");
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, idTxt.getText());
            stmt.setString(2, companyTxt.getText());
            stmt.setString(3, contactTxt.getText());
            stmt.setString(4, typeTxt.getText());
            stmt.setString(5, TotalTxt.getText());
            stmt.setString(6, PaidTxt.getText());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data succesfully added");
        }

        catch (SQLException | HeadlessException ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }

        updateTableData();
        showTableData();
    }//GEN-LAST:event_addBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed

        try
        {
            sql = "UPDATE insurancedetails SET id=?, company_name=?, company_contact=?, insurance_type=?, total_amount=?, amount_paid=?, balance=total_amount-amount_paid WHERE id=?";
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dentalclinic?serverTimezone=" + TimeZone.getDefault().getID(),"root","");
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, idTxt.getText());
            stmt.setString(2, companyTxt.getText());
            stmt.setString(3, contactTxt.getText());
            stmt.setString(4, typeTxt.getText());
            stmt.setString(5, TotalTxt.getText());
            stmt.setString(6, PaidTxt.getText());
            
            stmt.setString(8, idTxt.getText());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data updated succesfully");
        }

        catch (SQLException | HeadlessException ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }

        updateTableData();
        showTableData();
    
    }//GEN-LAST:event_updateBtnActionPerformed

    private void minimizeLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeLblMouseClicked
        setState(ICONIFIED);
    }//GEN-LAST:event_minimizeLblMouseClicked

    private void exitLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitLblMouseClicked
        System.exit(0);
    }//GEN-LAST:event_exitLblMouseClicked

    private void signoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signoutBtnActionPerformed

        dispose();
        new LogIn().setVisible(true);
    }//GEN-LAST:event_signoutBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        dispose();
        new Dashboard().setVisible(true);
    }//GEN-LAST:event_backBtnActionPerformed

    private void TotalTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TotalTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TotalTxtActionPerformed

    private void PaidTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PaidTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PaidTxtActionPerformed

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
            java.util.logging.Logger.getLogger(Insurance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Insurance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Insurance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Insurance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Insurance().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Insurancelbl;
    private javax.swing.JLabel LabelNo;
    private javax.swing.JTextField PaidTxt;
    private javax.swing.JTextField TotalTxt;
    private javax.swing.JButton addBtn;
    private javax.swing.JButton backBtn;
    private javax.swing.JTextField companyTxt;
    private javax.swing.JTextField contactTxt;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JLabel exitLbl;
    private javax.swing.JTextField idTxt;
    private javax.swing.JTable insuranceTable;
    private javax.swing.JScrollPane invoiceScrollPane;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelcompany;
    private javax.swing.JLabel labelcontact;
    private javax.swing.JLabel labelcontact1;
    private javax.swing.JLabel labelpaid;
    private javax.swing.JLabel labeltotal;
    private javax.swing.JLabel minimizeLbl;
    private javax.swing.JButton signoutBtn;
    private javax.swing.JTextField typeTxt;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.mycompany.edusys.UI;

import com.mycompany.edusys.DAO.KhoaHocDAO;
import com.mycompany.edusys.DAO.ThongKeDAO;
import com.mycompany.edusys.Entity.KhoaHoc;
import com.mycompany.edusys.Utils.Auth;
import com.mycompany.edusys.Utils.XDate;
import com.mycompany.edusys.Utils.XImage;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author ADMIN
 */
public class ThongKeJDialog extends javax.swing.JDialog {
     KhoaHocDAO khdao  = new KhoaHocDAO();
    ThongKeDAO tkdao = new ThongKeDAO();
   
    /**
     * Creates new form ThongKeJDialog
     */
    public ThongKeJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        init();
    }
    
    void init(){
        setIconImage(XImage.getAppIcon());
        setLocationRelativeTo(null);
        fillComboBoxKhoaHoc();
        fillComboBoxNam();
        fillTableNguoiHoc();
        fillTableDiemChuyenDe();
        selectTab(0);
        tabs.setEnabledAt(3, Auth.isManager());
        
    }
    
    void fillComboBoxKhoaHoc(){
        
        DefaultComboBoxModel model =(DefaultComboBoxModel) cboKhoaHoc.getModel();
        model.removeAllElements();
        
        List<KhoaHoc> list = khdao.selectAll();
        for (KhoaHoc kh : list) {
            model.addElement(kh);
        }
        cboKhoaHoc.setSelectedIndex(0);
     }
    
    void fillComboBoxNam(){
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboNam.getModel();
        model.removeAllElements();
        List<Integer> list = khdao.selectYear();
        for (Integer ys : list) {
            model.addElement(ys);
        }
    }
    
    void fillTableBangDiem(){
        DefaultTableModel model = (DefaultTableModel) tblBangDiem.getModel();
        model.setRowCount(0);
        
        KhoaHoc kh = (KhoaHoc) cboKhoaHoc.getSelectedItem();
        List<Object[]> list = tkdao.getBangDiem(kh.getMaKH());
        for (Object[] ob : list) {
            double diem = (double) ob[2];
            Object[] row = {ob[0],ob[1],diem,getXepLoai(diem)};
            model.addRow(row);
        }
    }
    
    void fillTableNguoiHoc(){
        DefaultTableModel model = (DefaultTableModel) tblNguoiHoc.getModel();
        List<Object[]> list = tkdao.getLuongNguoiHoc();
        for (Object[] ob : list) {
            Object[] row = {ob[0],ob[1],XDate.toString((Date) ob[2], "dd-MM-yyyy"),XDate.toString((Date) ob[3], "dd-MM-yyyy")};
            model.addRow(row);
        }
    }
    
    void fillTableDiemChuyenDe(){
        DefaultTableModel model = (DefaultTableModel) tblDiem.getModel();
        List<Object[]> list = tkdao.getDiemChuyenDe();
        for (Object[] ob : list) {
            model.addRow(ob);
        }
    }
    
    void fillTableDoanhThu(){
        DefaultTableModel model = (DefaultTableModel) tblDoanhThu.getModel();
        model.setRowCount(0);
        int year = (int) cboNam.getSelectedItem();
        
        List<Object[]> list = tkdao.getDoanhThu(year);
        for (Object[] ob : list) {
            model.addRow(ob);
        }
    }
    
    String getXepLoai(double diem){
        if(diem == -1){
            return "Chưa nhập điểm";
        }
        if(diem < 5){
            return "Chưa đạt";
        }
        if(diem< 6.5){
            return "Trung bình";
        }
        if(diem < 7.5){
            return "Khá";
        }
        if(diem<9){
            return "Giỏi";
        }
        return  "Xuất sắc";
    }
    
    void selectTab(int s){
        tabs.setSelectedIndex(s);
    }
    
     public JFreeChart chartLuongNguoi() {
        JFreeChart barChart = ChartFactory.createBarChart(
                "BIỂU ĐỒ SỐ LƯỢNG NGƯỜI HỌC",
                "Năm", "Số người",
                setDatasetNguoi(), PlotOrientation.VERTICAL, false, false, false);
        return barChart;
    }

    public CategoryDataset setDatasetNguoi() {
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        List<Object[]> list = tkdao.getLuongNguoiHoc();
        for (Object[] ob : list) {

            dataset.addValue((int) ob[1], "Số người", String.valueOf(ob[0]));
        }

        return dataset;
    }

    void fillChartNguoi() {
        ChartPanel Chart = new ChartPanel(chartLuongNguoi());
        pnlChart.removeAll();
        pnlChart.add(Chart);
        pnlChart.updateUI();

    }
    
    public JFreeChart chartDiem() {
        JFreeChart barChart = ChartFactory.createBarChart(
                "BIỂU ĐỒ ĐIỂM TB TỪNG CHUYÊN ĐỀ",
                "Chyuên đề", "Điểm",
                setDataDiem(), PlotOrientation.VERTICAL, false, false, false);
        return barChart;
    }
    
    public CategoryDataset setDataDiem() {
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        List<Object[]> list = tkdao.getDiemChuyenDe();
        for (Object[] ob : list) {

            dataset.addValue((double) ob[4], "Chuyên đề", String.valueOf(ob[0]));
        }

        return dataset;
    }
    
    void fillChartDiem() {
        ChartPanel Chart = new ChartPanel(chartDiem());
        pnlChart.removeAll();
        pnlChart.add(Chart);
        pnlChart.updateUI();

    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tabs = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBangDiem = new javax.swing.JTable();
        cboKhoaHoc = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblNguoiHoc = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDiem = new javax.swing.JTable();
        pnlDoanThu = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblDoanhThu = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        cboNam = new javax.swing.JComboBox<>();
        pnlTabBieuDo = new javax.swing.JPanel();
        btnSoLuong = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        pnlChart = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("EduSys-Thống kê tổng hợp");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("TỔNG HỢP THỐNG KÊ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("KHÓA HỌC");

        tblBangDiem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MÃ NH", "HỌ VÀ TÊN", "ĐIỂM", "XẾP LOẠI"
            }
        ));
        jScrollPane1.setViewportView(tblBangDiem);

        cboKhoaHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboKhoaHocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 827, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(cboKhoaHoc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cboKhoaHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabs.addTab("BẢNG ĐIỂM", jPanel4);

        tblNguoiHoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NĂM", "SỐ NH", "ĐK SỚM NHẤT", "ĐK MUỘN NHẤT"
            }
        ));
        jScrollPane2.setViewportView(tblNguoiHoc);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 827, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabs.addTab("NGƯỜI HỌC", jPanel1);

        tblDiem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CHUYÊN ĐỀ", "SL HV", "ĐIỂM TN", "ĐIỂM CN", "ĐIỂM TB"
            }
        ));
        jScrollPane3.setViewportView(tblDiem);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 827, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabs.addTab("ĐIỂM CHUYÊN ĐỀ", jPanel2);

        tblDoanhThu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CHUYÊN ĐỀ", "SỐ KHÓA", "SỐ HV", "DOANH THU", "HỌC PHÍ CAO NHẤT", "HỌC PHÍ THẤP NHẤT", "HỌC PHÍ TRUNG BÌNH"
            }
        ));
        jScrollPane4.setViewportView(tblDoanhThu);

        jLabel3.setText("NĂM:");

        cboNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboNamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDoanThuLayout = new javax.swing.GroupLayout(pnlDoanThu);
        pnlDoanThu.setLayout(pnlDoanThuLayout);
        pnlDoanThuLayout.setHorizontalGroup(
            pnlDoanThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDoanThuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDoanThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 827, Short.MAX_VALUE)
                    .addGroup(pnlDoanThuLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(cboNam, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlDoanThuLayout.setVerticalGroup(
            pnlDoanThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDoanThuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDoanThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cboNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabs.addTab("DOANH THU", pnlDoanThu);

        btnSoLuong.setText("Người học");
        btnSoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSoLuongActionPerformed(evt);
            }
        });

        jButton2.setText("Điểm CD");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        pnlChart.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlChart.setLayout(new javax.swing.BoxLayout(pnlChart, javax.swing.BoxLayout.LINE_AXIS));

        javax.swing.GroupLayout pnlTabBieuDoLayout = new javax.swing.GroupLayout(pnlTabBieuDo);
        pnlTabBieuDo.setLayout(pnlTabBieuDoLayout);
        pnlTabBieuDoLayout.setHorizontalGroup(
            pnlTabBieuDoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTabBieuDoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTabBieuDoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlTabBieuDoLayout.createSequentialGroup()
                        .addComponent(btnSoLuong)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addGap(0, 651, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlTabBieuDoLayout.setVerticalGroup(
            pnlTabBieuDoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTabBieuDoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTabBieuDoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSoLuong)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabs.addTab("BIỂU ĐỒ", pnlTabBieuDo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabs)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tabs)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboKhoaHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboKhoaHocActionPerformed
        fillTableBangDiem();
    }//GEN-LAST:event_cboKhoaHocActionPerformed

    private void cboNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboNamActionPerformed
        fillTableDoanhThu();
    }//GEN-LAST:event_cboNamActionPerformed

    private void btnSoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSoLuongActionPerformed
        fillChartNguoi();
    }//GEN-LAST:event_btnSoLuongActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        fillChartDiem();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(ThongKeJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThongKeJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThongKeJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThongKeJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ThongKeJDialog dialog = new ThongKeJDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSoLuong;
    private javax.swing.JComboBox<String> cboKhoaHoc;
    private javax.swing.JComboBox<String> cboNam;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel pnlChart;
    private javax.swing.JPanel pnlDoanThu;
    private javax.swing.JPanel pnlTabBieuDo;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tblBangDiem;
    private javax.swing.JTable tblDiem;
    private javax.swing.JTable tblDoanhThu;
    private javax.swing.JTable tblNguoiHoc;
    // End of variables declaration//GEN-END:variables
}

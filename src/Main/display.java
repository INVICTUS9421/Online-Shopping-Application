package Main;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class display extends javax.swing.JFrame {
    public display() {
        initComponents();
        table.setLayout(new GridLayout(0,4,10,10));
        
        try
        {            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/application","root","");
            
            String s = "SELECT * FROM admindata";
            Statement st  = con.createStatement();
            ResultSet rs = st.executeQuery(s);
            while(rs.next())
            {
                printProducts(rs);
            }
            table.setVisible(true);
        }
        catch(HeadlessException | ClassNotFoundException | SQLException e)
        {
          JOptionPane.showMessageDialog(null,"Not Connected");
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        back2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JInternalFrame();
        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setFocusable(false);
        setMaximumSize(new java.awt.Dimension(940, 715));
        setMinimumSize(new java.awt.Dimension(940, 715));
        getContentPane().setLayout(null);

        back2.setBackground(new java.awt.Color(0, 0, 0));
        back2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        back2.setForeground(new java.awt.Color(255, 255, 255));
        back2.setText("BACK");
        back2.setAutoscrolls(true);
        back2.setOpaque(true);
        back2.setPreferredSize(null);
        back2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back2ActionPerformed(evt);
            }
        });
        getContentPane().add(back2);
        back2.setBounds(70, 10, 121, 41);

        table.setMinimumSize(new java.awt.Dimension(800, 600));
        table.setVisible(true);

        javax.swing.GroupLayout tableLayout = new javax.swing.GroupLayout(table.getContentPane());
        table.getContentPane().setLayout(tableLayout);
        tableLayout.setHorizontalGroup(
            tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 930, Short.MAX_VALUE)
        );
        tableLayout.setVerticalGroup(
            tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 595, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(table);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(40, 70, 867, 643);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/now(2).jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 940, 750);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void back2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back2ActionPerformed
        MainPage m = new MainPage();
        m.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_back2ActionPerformed
    
    private void nextPage(String str1)
    {
        System.out.println(str1);
        Payment p = new Payment(str1);
        p.setVisible(true);
        this.dispose();
    }
    
    public static void main(String args[]) 
    {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) 
        {
            java.util.logging.Logger.getLogger(display.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new display().setVisible(true);
        });
    }
    public void  printProducts(ResultSet rs)
    {
        String name;
        byte[] img1,img2;
        try 
        {
            name = rs.getString("pname");
            img1 = rs.getBytes("pimage");
            img2 = rs.getBytes("pspec");
            String code = rs.getString("pname");
            
            ImageIcon ic = new ImageIcon(img1);
            Image i1 = ic.getImage();
            Image i2 = i1.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            ImageIcon mainImg = new ImageIcon(i2);
            
            JLabel lname = new JLabel();
            lname.setText(name);
            lname.setVisible(true);
            table.add(lname);
            lname.setHorizontalAlignment(JLabel.RIGHT);
            
            JLabel limg = new JLabel();
            limg.setIcon(mainImg);
            limg.setVisible(true);
            table.add(limg);
            limg.setHorizontalAlignment(JLabel.RIGHT);
            
            ImageIcon ic2 = new ImageIcon(img2);
            Image i3 = ic2.getImage();
            Image i4 = i3.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            ImageIcon mainImg2 = new ImageIcon(i4);
            
            JLabel limg2 = new JLabel();
            limg2.setIcon(mainImg2);
            limg2.setVisible(true);
            table.add(limg2);
            limg2.setHorizontalAlignment(JLabel.RIGHT);

            JButton select = new JButton();
            select.setText("SELECT");
            select.setFont(new Font("Serif",Font.ITALIC,12));
            select.setSize(150,50);
            select.setVisible(true);
            select.addActionListener(evt->{nextPage(code);});
            table.add(select);
            select.setHorizontalAlignment(JLabel.RIGHT);
            

        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(display.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back2;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JInternalFrame table;
    // End of variables declaration//GEN-END:variables
    JScrollPane scrollpane = null;
}

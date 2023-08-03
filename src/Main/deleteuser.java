package Main;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import java.sql.*;

public class deleteuser extends javax.swing.JFrame {
    public deleteuser() {
        initComponents();
        /*try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/application","root","");
            //JOptionPane.showMessageDialog(null,"Connected");        
        }
        catch(Exception e)
        {
          JOptionPane.showMessageDialog(null,"Not Connected");
        }*/
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        t1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        t2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        t3 = new javax.swing.JTextField();
        back = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(870, 690));
        setMinimumSize(new java.awt.Dimension(870, 690));
        getContentPane().setLayout(null);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ENTER USERNAME:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(190, 130, 140, 44);

        t1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        t1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t1ActionPerformed(evt);
            }
        });
        getContentPane().add(t1);
        t1.setBounds(400, 130, 187, 44);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ENTER PASSWORD:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(190, 210, 155, 44);

        t2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        t2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t2ActionPerformed(evt);
            }
        });
        getContentPane().add(t2);
        t2.setBounds(400, 210, 187, 44);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ENTER EMAIL ID:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(190, 300, 155, 44);

        t3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        t3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t3ActionPerformed(evt);
            }
        });
        getContentPane().add(t3);
        t3.setBounds(400, 300, 274, 44);

        back.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        back.setText("BACK");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back);
        back.setBounds(190, 420, 155, 36);

        delete.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        delete.setText("DELETE");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        getContentPane().add(delete);
        delete.setBounds(400, 420, 149, 40);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("DELETE USER");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(310, 40, 171, 42);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/now(2).jpg"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 0, 840, 610);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        Admin m = new Admin();
        m.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backActionPerformed

    private void t1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t1ActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/application","root","");
            Statement stmt = con.createStatement(); 
            String s1 = t1.getText(); String s2 = t2.getText();
            int ret = userid(s1,s2);
            //System.out.println(s1+s2);
            if(ret==1)
            {
                PreparedStatement pst = con.prepareStatement("DELETE FROM signup WHERE emailid = '"+ t3.getText() + "'");
                pst.executeUpdate();
                String q1 = "DELETE FROM signup where emailid="+t3.getText()+"'"; 
                stmt.executeUpdate(q1);
                JOptionPane.showMessageDialog(null,"Deleted");
            }
        }
        catch(HeadlessException | ClassNotFoundException | SQLException e)
        {
            JOptionPane.showMessageDialog(this,e);
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void t2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t2ActionPerformed

    private void t3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t3ActionPerformed
    static int userid(String s1, String s2)
    {
        int flag = 0;
        try 
        {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/application","root","");
            Statement stmt = con.createStatement();
            String s = "SELECT * FROM signin";
            ResultSet rs = stmt.executeQuery(s);
            
            while(rs.next())
            {
                if(s1.equals(rs.getString("username")) && s2.equals(rs.getString("password")))
                {
                    
                    PreparedStatement pst = con.prepareStatement("DELETE FROM signin WHERE password = '"+ s2 + "'");
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Deleted");
                    flag =1;System.out.println("value:"+flag);
                }
            }
            //System.out.println("here");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return flag;
    }
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
            java.util.logging.Logger.getLogger(deleteuser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(deleteuser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(deleteuser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(deleteuser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new deleteuser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton delete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField t1;
    private javax.swing.JTextField t2;
    private javax.swing.JTextField t3;
    // End of variables declaration//GEN-END:variables
}

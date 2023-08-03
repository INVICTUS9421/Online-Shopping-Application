package Main;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.HeadlessException;
import java.awt.Image;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class receipt extends javax.swing.JFrame {
    public receipt() {
        initComponents();
        try
        {            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/application","root","");
            JOptionPane.showMessageDialog(null,"Connected");        
        }
        catch(HeadlessException | ClassNotFoundException | SQLException e)
        {
          JOptionPane.showMessageDialog(null,"Not Connected");
        }
    }
    receipt(String n) throws SQLException 
    {
        initComponents();
        try{
        t = n;
        String s = "SELECT * FROM admindata";
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/application","root","");
        Statement st  = con.createStatement();
        ResultSet rs = st.executeQuery(s);
        System.out.println(t);
        while(rs.next())
        {
            if(rs.getString("pname").equals(t))
            {
                copyp1 = rs.getBytes("pimage");
                copyp2 = rs.getBytes("pspec");
            }
        }
        ImageIcon icon1 = new ImageIcon(copyp1);
        Image i1 = icon1.getImage();
        Image a = i1.getScaledInstance(400,500,Image.SCALE_SMOOTH);
        main = new ImageIcon(a);
        disp1.setIcon(main);

        ImageIcon icon2 = new ImageIcon(copyp2);
        Image i2 = icon2.getImage();
        Image b = i2.getScaledInstance(400,500,Image.SCALE_SMOOTH);
        main2 = new ImageIcon(b);
        disp2.setIcon(main2);
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        receipt = new javax.swing.JButton();
        back = new javax.swing.JButton();
        disp2 = new javax.swing.JLabel();
        disp1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("THANKYOU   FOR   SHOPPING");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(303, 303, 303))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        receipt.setBackground(new java.awt.Color(0, 0, 0));
        receipt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        receipt.setForeground(new java.awt.Color(255, 255, 255));
        receipt.setText("DOWNLOAD RECEIPT");
        receipt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receiptActionPerformed(evt);
            }
        });

        back.setBackground(new java.awt.Color(0, 0, 0));
        back.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        back.setForeground(new java.awt.Color(255, 255, 255));
        back.setText("BACK");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(326, 326, 326)
                .addComponent(receipt, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(82, Short.MAX_VALUE)
                .addComponent(disp1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(disp2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(disp2, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(disp1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(receipt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        display m = new display();
        m.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backActionPerformed
    static String procode()
    {
        String calpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random r = new Random();
        char[] procode = new char[8];
        for(int j=0; j<8;j++)
        {
            procode[j] = calpha.charAt(r.nextInt(calpha.length()));
        }
        String r2 = new String(procode);
        return r2;
    }
    static String tid()
    {
        String num = "0123456789";
        Random r = new Random();
        char[] tid = new char[16];
        for(int j=0; j<16;j++)
        {
            tid[j] = num.charAt(r.nextInt(num.length()));
        }
        String r1 = new String(tid);return r1;
    }
       static String days()
    {
        String num = "1234";
        Random r = new Random();
        char[] tid = new char[1];
        tid[0] = num.charAt(r.nextInt(num.length()));
        String r1 = new String(tid);return r1;
    }
    private void receiptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receiptActionPerformed
        String path = "";
        JFileChooser j = new JFileChooser();
        int x = j.showSaveDialog(this);
        if(x==JFileChooser.APPROVE_OPTION)
            path = j.getSelectedFile().getPath();
        Document doc = new Document();
        try {
            PdfWriter.getInstance(doc, new FileOutputStream(path+"ZONE.pdf"));
            doc.open();
            
            Font f = new Font();
            f.setStyle(Font.BOLD);
            f.setSize(20);
            
            String a = procode();
            String b = tid();
            String c = days();
            
            Paragraph head = new Paragraph();
            head.add("DETAILS\n");
            
            Paragraph p = new Paragraph();
            p.add("-----------------------------------------------------------------\n");
            p.add("PRODUCT CODE:"+a+"\n");
            p.add("TRANSACTION ID:"+b+"\n");
            p.add("PRODUCT WILL ARRIVE AT:"+c+"\n");
            p.add("-----------------------------------------------------------------\n");
            
            Paragraph p2 = new Paragraph();
            //p2.add(main,Image.SCALE_SMOOTH);
            //p2.add(main2);
            p2.add("THANKYOU FOR PURCHASING:");
            
            doc.add(new Paragraph("--------TECHZONE--------",f));
            doc.add(head);
            doc.add(p);            
            doc.add(p2);
        }
        catch(FileNotFoundException e){
            JOptionPane.showMessageDialog(null,e);
        } catch (DocumentException ex) {
            Logger.getLogger(receipt.class.getName()).log(Level.SEVERE, null, ex);
        }
        doc.close();
    }//GEN-LAST:event_receiptActionPerformed
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
            java.util.logging.Logger.getLogger(receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        java.awt.EventQueue.invokeLater(() -> {
            new receipt().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JLabel disp1;
    private javax.swing.JLabel disp2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton receipt;
    // End of variables declaration//GEN-END:variables
    ImageIcon main = null;
    ImageIcon main2 = null;
    byte[] copyp1 = null;
    byte[] copyp2 = null;
    String t = null;
}

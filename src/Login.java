
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Faiqoh
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tpass = new javax.swing.JTextField();
        tnama = new javax.swing.JTextField();
        btnin = new javax.swing.JButton();
        btnup = new javax.swing.JButton();
        btnexit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("PASSWORD");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(160, 140, 80, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("USERNAME");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(160, 50, 80, 30);
        getContentPane().add(tpass);
        tpass.setBounds(100, 180, 190, 40);
        getContentPane().add(tnama);
        tnama.setBounds(100, 90, 190, 40);

        btnin.setText("Sign In");
        btnin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btninActionPerformed(evt);
            }
        });
        getContentPane().add(btnin);
        btnin.setBounds(270, 240, 80, 30);

        btnup.setText("Sign Up");
        btnup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupActionPerformed(evt);
            }
        });
        getContentPane().add(btnup);
        btnup.setBounds(40, 240, 80, 30);

        btnexit.setText("Exit");
        btnexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexitActionPerformed(evt);
            }
        });
        getContentPane().add(btnexit);
        btnexit.setBounds(150, 240, 80, 30);

        setBounds(0, 0, 416, 339);
    }// </editor-fold>//GEN-END:initComponents

    private void btnupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupActionPerformed
        // TODO add your handling code here:
        String username= tnama.getText();
        String password = tpass.getText();
        
        try{
            try(Statement statement = (Statement) file_koneksi.GetConnection().createStatement()){
                statement.executeUpdate("insert into tb_akun(username,password) VALUES('"+username+"','"+password+"');");
            }
            JOptionPane.showMessageDialog(null,"Selamat! anda Berhasil sign Up");
        }catch(Exception t){
            JOptionPane.showMessageDialog(null,"Mohon Maaf, ulangi lagi prosedur");
        }
    }//GEN-LAST:event_btnupActionPerformed

    private void btninActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btninActionPerformed
        // TODO add your handling code here:
        Connection connection;
        PreparedStatement ps;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_testkoneksi?zeroDateTimeBehavior=convertToNull","root","");
            ps = connection.prepareStatement("SELECT username, password FROM tb_akun WHERE username = ? AND password= ?");
            ps.setString(1, tnama.getText());
            ps.setString(2, tpass.getText());
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                new frmMain().show();
                this.dispose();
            }
            else{
                JOptionPane.showMessageDialog(rootPane,"salah!");
                tpass.setText("");
                tnama.requestFocus();
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(rootPane, "gagal");
            
        }
    }//GEN-LAST:event_btninActionPerformed

    private void btnexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnexitActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnexit;
    private javax.swing.JButton btnin;
    private javax.swing.JButton btnup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField tnama;
    private javax.swing.JTextField tpass;
    // End of variables declaration//GEN-END:variables
}

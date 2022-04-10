package cabboking1;

public class adminhome extends javax.swing.JFrame {

    /**
     * Creates new form adminlogin
     * n
     */
    
    String email;
    public adminhome(String email) {
        initComponents();
        setSize(500,500);
        setVisible(true);
        this.email = email;
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chngepswrd = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        mngcarsbtn = new javax.swing.JButton();
        btnviewcars = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        chngepswrd.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        chngepswrd.setText("Change password");
        chngepswrd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chngepswrdActionPerformed(evt);
            }
        });
        getContentPane().add(chngepswrd);
        chngepswrd.setBounds(127, 28, 170, 50);

        jButton1.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        jButton1.setText("Logout");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(150, 210, 100, 29);

        mngcarsbtn.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        mngcarsbtn.setText("manage cars");
        mngcarsbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mngcarsbtnActionPerformed(evt);
            }
        });
        getContentPane().add(mngcarsbtn);
        mngcarsbtn.setBounds(130, 90, 160, 40);

        btnviewcars.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        btnviewcars.setText("view cars");
        btnviewcars.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnviewcarsActionPerformed(evt);
            }
        });
        getContentPane().add(btnviewcars);
        btnviewcars.setBounds(130, 150, 160, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chngepswrdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chngepswrdActionPerformed
        // TODO add your handling code here:
        adminchangepaswrd obj = new adminchangepaswrd(email);
    }//GEN-LAST:event_chngepswrdActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
        adminform obj = new adminform();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void mngcarsbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mngcarsbtnActionPerformed
       managecars obj =new managecars();
    }//GEN-LAST:event_mngcarsbtnActionPerformed

    private void btnviewcarsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnviewcarsActionPerformed
        viewcars obj =new viewcars();
    }//GEN-LAST:event_btnviewcarsActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new adminhome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnviewcars;
    private javax.swing.JButton chngepswrd;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton mngcarsbtn;
    // End of variables declaration//GEN-END:variables
}

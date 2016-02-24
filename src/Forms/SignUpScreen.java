/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import Resources.LocalizationUtil;
import Users.RegularUser;
import java.awt.event.WindowEvent;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Anael
 */
public class SignUpScreen extends javax.swing.JFrame {
    WelcomeScreen previous = null;
    private boolean[] inputValidation = new boolean[4];
    String language = "";
    /**
     * Creates new form SignUpScreen
     */
    public SignUpScreen() {

        initComponents();
    }
    
    public SignUpScreen(WelcomeScreen previous) {
        this();
        this.previous = previous;
    }
    
    public SignUpScreen(WelcomeScreen previous,String language) {
        this(previous);
        this.language = language;
        if (language.equals("iw"))
        {
          changeToHebrew();
        }
    }
    
    public final void changeToHebrew()
    {
          LocalizationUtil.localizedResourceBundle = ResourceBundle.getBundle("Resources.UiSignUp_iw", new Locale("iw"));
          updateCaptions();
          initHebrew();
    }
    
    public void initHebrew()
    {
        labFirstName.setBounds(300, 130, 90, 20);
        rdbFemale.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        rdbFemale.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        rdbMale.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        rdbMale.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        labLastName.setBounds(300, 170, 90, 20);
        labGender.setBounds(300, 210, 40, 20);
        labUserName.setBounds(300, 250, 100, 20);
        labPassword.setBounds(300, 290, 60, 20); 
        txtFirstName.setHorizontalAlignment(SwingConstants.RIGHT);
        txtLastName.setHorizontalAlignment(SwingConstants.RIGHT);
        txtUserName.setHorizontalAlignment(SwingConstants.RIGHT);
        txtPassword.setHorizontalAlignment(SwingConstants.RIGHT);

    }
    
       public void updateCaptions()
   {
        labTitle.setText(LocalizationUtil.localizedResourceBundle.getString("labTitle"));
        labUserName.setText(LocalizationUtil.localizedResourceBundle.getString("labUserName"));
        labPassword.setText(LocalizationUtil.localizedResourceBundle.getString("labPassword"));
        labGender.setText(LocalizationUtil.localizedResourceBundle.getString("labGender"));
        btnSignUp.setText(LocalizationUtil.localizedResourceBundle.getString("btnSignUp"));
        rdbFemale.setText(LocalizationUtil.localizedResourceBundle.getString("rdbFemale"));
        rdbMale.setText(LocalizationUtil.localizedResourceBundle.getString("rdbMale"));
        labFirstName.setText(LocalizationUtil.localizedResourceBundle.getString("labFirstName"));
        labLastName.setText(LocalizationUtil.localizedResourceBundle.getString("labLastName"));
   }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupGender = new javax.swing.ButtonGroup();
        labTitle = new javax.swing.JLabel();
        labLastName = new javax.swing.JLabel();
        labFirstName = new javax.swing.JLabel();
        labGender = new javax.swing.JLabel();
        labUserName = new javax.swing.JLabel();
        labPassword = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        txtLastName = new javax.swing.JTextField();
        txtUserName = new javax.swing.JTextField();
        txtPassword = new javax.swing.JTextField();
        rdbFemale = new javax.swing.JRadioButton();
        rdbMale = new javax.swing.JRadioButton();
        btnSignUp = new javax.swing.JButton();
        labSignture = new javax.swing.JLabel();
        labValidFirstName = new javax.swing.JLabel();
        labValidLastName = new javax.swing.JLabel();
        labValidUserName = new javax.swing.JLabel();
        labBack = new javax.swing.JLabel();
        labValidPassword = new javax.swing.JLabel();
        labBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        labTitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        labTitle.setForeground(new java.awt.Color(51, 51, 51));
        labTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labTitle.setText("Sign Up");
        getContentPane().add(labTitle);
        labTitle.setBounds(110, 70, 180, 40);

        labLastName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labLastName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labLastName.setText("Last Name:");
        getContentPane().add(labLastName);
        labLastName.setBounds(80, 170, 90, 17);

        labFirstName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labFirstName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labFirstName.setText("First Name:");
        getContentPane().add(labFirstName);
        labFirstName.setBounds(80, 130, 90, 17);

        labGender.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labGender.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labGender.setText("Gender:");
        getContentPane().add(labGender);
        labGender.setBounds(90, 210, 70, 17);

        labUserName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labUserName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labUserName.setText("User Name:");
        getContentPane().add(labUserName);
        labUserName.setBounds(80, 250, 90, 17);

        labPassword.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labPassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labPassword.setText("Password:");
        getContentPane().add(labPassword);
        labPassword.setBounds(90, 290, 80, 17);

        txtFirstName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFirstNameKeyReleased(evt);
            }
        });
        getContentPane().add(txtFirstName);
        txtFirstName.setBounds(180, 130, 110, 20);

        txtLastName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtLastNameKeyReleased(evt);
            }
        });
        getContentPane().add(txtLastName);
        txtLastName.setBounds(180, 170, 110, 20);

        txtUserName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUserNameKeyReleased(evt);
            }
        });
        getContentPane().add(txtUserName);
        txtUserName.setBounds(180, 250, 110, 20);

        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPasswordKeyReleased(evt);
            }
        });
        getContentPane().add(txtPassword);
        txtPassword.setBounds(180, 290, 110, 20);

        btnGroupGender.add(rdbFemale);
        rdbFemale.setText("Female");
        rdbFemale.setHideActionText(true);
        rdbFemale.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        getContentPane().add(rdbFemale);
        rdbFemale.setBounds(170, 210, 59, 23);

        btnGroupGender.add(rdbMale);
        rdbMale.setText("Male");
        getContentPane().add(rdbMale);
        rdbMale.setBounds(240, 210, 60, 23);

        btnSignUp.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSignUp.setText("Sign Up");
        btnSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignUpActionPerformed(evt);
            }
        });
        getContentPane().add(btnSignUp);
        btnSignUp.setBounds(130, 380, 170, 40);

        labSignture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/signature.png"))); // NOI18N
        getContentPane().add(labSignture);
        labSignture.setBounds(430, 10, 64, 64);

        labValidFirstName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labValidFirstName.setText("*");
        labValidFirstName.setMinimumSize(new java.awt.Dimension(7, 60));
        getContentPane().add(labValidFirstName);
        labValidFirstName.setBounds(120, 150, 200, 15);

        labValidLastName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labValidLastName.setText("*");
        getContentPane().add(labValidLastName);
        labValidLastName.setBounds(110, 190, 200, 15);

        labValidUserName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labValidUserName.setText("*");
        getContentPane().add(labValidUserName);
        labValidUserName.setBounds(110, 270, 200, 15);

        labBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/back2.png"))); // NOI18N
        labBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labBackMouseClicked(evt);
            }
        });
        getContentPane().add(labBack);
        labBack.setBounds(10, 450, 64, 64);

        labValidPassword.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labValidPassword.setText("*");
        getContentPane().add(labValidPassword);
        labValidPassword.setBounds(110, 320, 200, 15);

        labBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ACE222.jpg"))); // NOI18N
        getContentPane().add(labBackground);
        labBackground.setBounds(0, 0, 500, 530);

        setSize(new java.awt.Dimension(516, 568));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignUpActionPerformed
        for (boolean b : inputValidation)
        {
            if (b == false)
            {
             JOptionPane.showMessageDialog(null, "Invalid Information", "Error", JOptionPane.ERROR_MESSAGE);        
             return;
            }
        }
        if (!rdbFemale.isSelected() && !rdbMale.isSelected())
        {
           JOptionPane.showMessageDialog(null, "Please choose gender", "Error", JOptionPane.ERROR_MESSAGE);        
           return;
        }
        
        String firstName = txtFirstName.getText();
        String lastName = txtLastName.getText();
        String userName = txtUserName.getText();
        String password = txtPassword.getText();
        String gender = "";
        if (rdbFemale.isSelected())
             gender = rdbFemale.getText();
        else if (rdbMale.isSelected())
            gender = rdbMale.getText();
        RegularUser u = new RegularUser();
        u.signUp(firstName, lastName, gender, userName, password);
        this.dispose();
        previous.setVisible(true);
    }//GEN-LAST:event_btnSignUpActionPerformed

    private void txtFirstNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFirstNameKeyReleased

        String firstName = txtFirstName.getText();
        labValidFirstName.setText(InputValidation.checkFirstName(firstName));
        if (labValidFirstName.getText().equals(""))
            inputValidation[0] = new Boolean(true);
    }//GEN-LAST:event_txtFirstNameKeyReleased

    private void txtLastNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLastNameKeyReleased
      String lastName = txtLastName.getText();
      labValidLastName.setText(InputValidation.checkLastName(lastName));
      if (labValidLastName.getText().equals(""))
            inputValidation[1] = new Boolean(true);
    }//GEN-LAST:event_txtLastNameKeyReleased

    private void txtUserNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserNameKeyReleased
        String userName = txtUserName.getText();
        labValidUserName.setText(InputValidation.checkUserName(userName));
        if (labValidUserName.getText().equals(""))
            inputValidation[2] = new Boolean(true);
    }//GEN-LAST:event_txtUserNameKeyReleased

    private void txtPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyReleased
        String password = txtPassword.getText();
        labValidPassword.setText(InputValidation.checkPassword(password));
        if (labValidPassword.getText().equals(""))
            inputValidation[3] = new Boolean(true);
    }//GEN-LAST:event_txtPasswordKeyReleased

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int confirmed = JOptionPane.showConfirmDialog(null, 
        "Are you sure you want to exit the program?", "Exit Program",
        JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);

    if (confirmed == JOptionPane.YES_OPTION) {
      System.exit(0);
    }
    }//GEN-LAST:event_formWindowClosing

    private void labBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labBackMouseClicked
        this.dispose();
        previous.setVisible(true);
    }//GEN-LAST:event_labBackMouseClicked

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
            java.util.logging.Logger.getLogger(SignUpScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignUpScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignUpScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignUpScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignUpScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnGroupGender;
    private javax.swing.JButton btnSignUp;
    private javax.swing.JLabel labBack;
    private javax.swing.JLabel labBackground;
    private javax.swing.JLabel labFirstName;
    private javax.swing.JLabel labGender;
    private javax.swing.JLabel labLastName;
    private javax.swing.JLabel labPassword;
    private javax.swing.JLabel labSignture;
    private javax.swing.JLabel labTitle;
    private javax.swing.JLabel labUserName;
    private javax.swing.JLabel labValidFirstName;
    private javax.swing.JLabel labValidLastName;
    private javax.swing.JLabel labValidPassword;
    private javax.swing.JLabel labValidUserName;
    private javax.swing.JRadioButton rdbFemale;
    private javax.swing.JRadioButton rdbMale;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables


}

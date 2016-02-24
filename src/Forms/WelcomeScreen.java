package Forms;


import Users.User;
import blackjack.DB;
import blackjack.DB;
import Forms.Game;
import Resources.LocalizationUtil;
import Resources.GameUtil;
import java.awt.Component;
import java.awt.Dimension;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.GroupLayout.Alignment.CENTER;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.JTextComponent;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nadav
 */
public class WelcomeScreen extends javax.swing.JFrame {

      DB db = DB.getInstance();
      String language = "en";
    /**
     * Creates new form NewJFrame
     */
    public WelcomeScreen() {
        initComponents();
          try {
              db.initUsers();
          } catch (Exception ex) {
              ex.printStackTrace();
          }
        initMyComponents();
        
        
    }
    
    public void initMyComponents()
    {
        btnHebrew.setOpaque(false);
        btnHebrew.setContentAreaFilled(false);
        btnHebrew.setBorderPainted(false);
        btnHebrew.setActionCommand("iw");
        
        btnEnglish.setOpaque(false);
        btnEnglish.setContentAreaFilled(false);
        btnEnglish.setBorderPainted(false);
        btnEnglish.setActionCommand("en");
        
       GameUtil.setIcon(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labPassword = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        btnSignUp = new javax.swing.JButton();
        btnLogin = new javax.swing.JButton();
        labBlackjack = new javax.swing.JLabel();
        btnGuest = new javax.swing.JButton();
        labUserName = new javax.swing.JLabel();
        btnHebrew = new javax.swing.JButton();
        btnEnglish = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();
        labBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setMaximumSize(null);
        setPreferredSize(new java.awt.Dimension(620, 418));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        labPassword.setFont(new java.awt.Font("Aharoni", 1, 14)); // NOI18N
        labPassword.setText("Password : ");
        labPassword.setName("labPassword"); // NOI18N
        getContentPane().add(labPassword);
        labPassword.setBounds(10, 120, 90, 20);

        txtUserName.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtUserName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUserName.setText("Enter your user name here");
        txtUserName.setName("txtUserName"); // NOI18N
        txtUserName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtUserNameMouseClicked(evt);
            }
        });
        getContentPane().add(txtUserName);
        txtUserName.setBounds(100, 80, 160, 25);
        txtUserName.getAccessibleContext().setAccessibleName("txtUserName");

        btnSignUp.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnSignUp.setText("Sign Up");
        btnSignUp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSignUp.setName("btnSignUp"); // NOI18N
        btnSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignUpActionPerformed(evt);
            }
        });
        getContentPane().add(btnSignUp);
        btnSignUp.setBounds(180, 160, 80, 30);
        btnSignUp.getAccessibleContext().setAccessibleName("btnSignUp");

        btnLogin.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnLogin.setText("Login");
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.setMaximumSize(new java.awt.Dimension(73, 25));
        btnLogin.setMinimumSize(new java.awt.Dimension(73, 25));
        btnLogin.setName("btnLogin"); // NOI18N
        btnLogin.setPreferredSize(new java.awt.Dimension(73, 25));
        btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLoginMouseClicked(evt);
            }
        });
        getContentPane().add(btnLogin);
        btnLogin.setBounds(100, 160, 80, 30);

        labBlackjack.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        labBlackjack.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labBlackjack.setText("BlackJack");
        getContentPane().add(labBlackjack);
        labBlackjack.setBounds(40, 10, 280, 50);

        btnGuest.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnGuest.setText("Play as a Guest");
        btnGuest.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuest.setMaximumSize(new java.awt.Dimension(57, 23));
        btnGuest.setMinimumSize(new java.awt.Dimension(57, 23));
        btnGuest.setPreferredSize(new java.awt.Dimension(60, 30));
        btnGuest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuestActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuest);
        btnGuest.setBounds(110, 200, 140, 30);

        labUserName.setFont(new java.awt.Font("Aharoni", 0, 14)); // NOI18N
        labUserName.setText("User Name : ");
        labUserName.setName("labUserName"); // NOI18N
        getContentPane().add(labUserName);
        labUserName.setBounds(10, 80, 90, 20);

        btnHebrew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Israel.png"))); // NOI18N
        btnHebrew.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHebrew.setPreferredSize(new java.awt.Dimension(70, 70));
        btnHebrew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHebrewActionPerformed(evt);
            }
        });
        getContentPane().add(btnHebrew);
        btnHebrew.setBounds(10, 340, 50, 50);

        btnEnglish.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/United States.png"))); // NOI18N
        btnEnglish.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEnglish.setMaximumSize(new java.awt.Dimension(83, 59));
        btnEnglish.setMinimumSize(new java.awt.Dimension(83, 59));
        btnEnglish.setPreferredSize(new java.awt.Dimension(83, 59));
        btnEnglish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnglishActionPerformed(evt);
            }
        });
        getContentPane().add(btnEnglish);
        btnEnglish.setBounds(60, 340, 50, 50);

        txtPassword.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPassword.setText("*****");
        txtPassword.setToolTipText("");
        txtPassword.setName("txtPassword"); // NOI18N
        txtPassword.setPreferredSize(new java.awt.Dimension(140, 23));
        txtPassword.setScrollOffset(0);
        txtPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPasswordMouseClicked(evt);
            }
        });
        getContentPane().add(txtPassword);
        txtPassword.setBounds(100, 120, 160, 25);

        labBackground.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        labBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/PokerChips.jpg"))); // NOI18N
        labBackground.setMaximumSize(null);
        labBackground.setMinimumSize(null);
        labBackground.setName("labBackground"); // NOI18N
        labBackground.setPreferredSize(new java.awt.Dimension(620, 390));
        getContentPane().add(labBackground);
        labBackground.setBounds(0, 0, 620, 390);
        labBackground.getAccessibleContext().setAccessibleName("labBackground");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtUserNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUserNameMouseClicked
        txtUserName.setText("");
    }//GEN-LAST:event_txtUserNameMouseClicked

    private void btnLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseClicked
        String userName = txtUserName.getText().toString();
        String password = txtPassword.getText().toString();
        User player = db.login(userName, password);
        if (player!= null)
        {
        clearComponents();
        this.setVisible(false);
        if (player.getPermission() == 2)
        {
            UserHome userHome = null;
            if (this.language.equals("iw"))
            {
              userHome = new UserHome(player,this,language);  
            }
            else{
             userHome = new UserHome(player,this);
            }
            userHome.setVisible(true);
        }
        else if (player.getPermission() == 1) {//admin
            AdminHome adminHome = null;
            if (this.language.equals("iw"))
            {
            adminHome = new AdminHome(player,this,this.language);
            }
            else{
                adminHome = new AdminHome(player,this);
            }
            adminHome.setVisible(true);
        }
        else{
           JOptionPane.showMessageDialog(null, "User doesn't exist", "Error", JOptionPane.INFORMATION_MESSAGE);   
         clearComponents();
        }
        }
    }//GEN-LAST:event_btnLoginMouseClicked

    private void clearComponents() {
        
        txtUserName.setText("");
        txtPassword.setText("");
    }
    
    private void btnGuestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuestActionPerformed
        Game game;
          game = new Game();
            game.initializeGUI();
           this.initComponents();
        this.setVisible(false);
    }//GEN-LAST:event_btnGuestActionPerformed

    private void btnSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignUpActionPerformed
        SignUpScreen signUpScreen = null;
        if (language.equals("iw"))
        {
           signUpScreen = new SignUpScreen(this,"iw"); 
        }
        else{
         signUpScreen = new SignUpScreen(this);
        }
        this.setVisible(false);
        signUpScreen.setVisible(true);
    }//GEN-LAST:event_btnSignUpActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int confirmed;
        if(this.language.equals("iw"))
        {
            confirmed = LocalizationUtil.exitDialog();
        }
        else{
        confirmed = JOptionPane.showConfirmDialog(null, 
        "Are you sure you want to exit the program?", "Exit Program",
        JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
        }
    if (confirmed == JOptionPane.YES_OPTION) {
      System.exit(0);
    }
    }//GEN-LAST:event_formWindowClosing

    private void btnEnglishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnglishActionPerformed
        String selectedLanguage = btnEnglish.getActionCommand();
        LocalizationUtil.localizedResourceBundle = LocalizationUtil.getBundleWelcomeScreenEN();
        updateCaptions();  
        initEnglish();
        language = "en";
    }//GEN-LAST:event_btnEnglishActionPerformed

    private void btnHebrewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHebrewActionPerformed
        String selectedLanguage = btnHebrew.getActionCommand();
        LocalizationUtil.localizedResourceBundle = LocalizationUtil.getBundleWelcomeScreenIW();
        updateCaptions();  
        initHebrew();
        language = "iw";
    }//GEN-LAST:event_btnHebrewActionPerformed

    private void txtPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPasswordMouseClicked
        txtPassword.setText("");
    }//GEN-LAST:event_txtPasswordMouseClicked

    public void initHebrew()
    {
        labUserName.setBounds(270, 80, 80, 20);
        labUserName.setFont(new java.awt.Font("Arial", 1, 13)); 
        labPassword.setBounds(270, 120, 40, 20);
        labPassword.setFont(new java.awt.Font("Arial", 1, 13));
        labBlackjack.setFont(new java.awt.Font("Arial", 1, 36));
        LocalizationUtil.changeOptionPane_iw();
        
    }
    
        public void initEnglish()
    {
        labUserName.setBounds(10, 80, 90, 20);
        labUserName.setFont(new java.awt.Font("Aharoni", 0, 14)); 
        labPassword.setBounds(10, 120, 90, 20);
        labPassword.setFont(new java.awt.Font("Aharoni", 0, 14)); 
        labBlackjack.setFont(new java.awt.Font("Arial Black", 0, 36));
        LocalizationUtil.changeOptionPane_en();
    }
    
   public void updateCaptions()
   {
        labUserName.setText(LocalizationUtil.localizedResourceBundle.getString("labUserName"));
        txtUserName.setText(LocalizationUtil.localizedResourceBundle.getString("txtUserName"));
        labPassword.setText(LocalizationUtil.localizedResourceBundle.getString("labPassword"));
        txtPassword.setText(LocalizationUtil.localizedResourceBundle.getString("txtPassword"));
        btnSignUp.setText(LocalizationUtil.localizedResourceBundle.getString("btnSignUp"));
        btnLogin.setText(LocalizationUtil.localizedResourceBundle.getString("btnLogin"));
        labBlackjack.setText(LocalizationUtil.localizedResourceBundle.getString("labBlackjack"));
        btnGuest.setText(LocalizationUtil.localizedResourceBundle.getString("btnGuest"));
   }
    
    
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
            java.util.logging.Logger.getLogger(WelcomeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WelcomeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WelcomeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WelcomeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                WelcomeScreen welcomeScreen = new WelcomeScreen();
                welcomeScreen.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnglish;
    private javax.swing.JButton btnGuest;
    private javax.swing.JButton btnHebrew;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnSignUp;
    private javax.swing.JLabel labBackground;
    private javax.swing.JLabel labBlackjack;
    private javax.swing.JLabel labPassword;
    private javax.swing.JLabel labUserName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}

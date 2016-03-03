
package Forms;

import Resources.GameUtil;
import Resources.LocalizationUtil;
import Users.User;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author ANI
 */
public class UserHome extends javax.swing.JFrame {

    User player = null;
    WelcomeScreen previous = null;
    String language = "";

    /**
     * Creates new form UserHome
     */
    public UserHome() {
        initComponents();
        GameUtil.setIcon(this);
    }

    public UserHome(WelcomeScreen previous) {
        this();
        this.previous = previous;
    }

    public UserHome(User player, WelcomeScreen previous) {
        this(previous);
        this.player = player;
        labWelcomeUser.setText(labWelcomeUser.getText() + player.getFirstName()
                + " " + player.getLastName());
    }

    public UserHome(User player, WelcomeScreen previous, String lang) {
        this(player, previous);
        this.language = lang;
        if (lang.equals("iw")) {
            changeToHebrew();
        }
    }

    public void changeToHebrew() {
        LocalizationUtil.localizedResourceBundle = 
                LocalizationUtil.getBundleHomeIW();
        updateCaptions();
        LocalizationUtil.changeOptionPane_iw();
    }

    public void updateCaptions() {
        btnPlay.setText(LocalizationUtil.localizedResourceBundle
                .getString("btnPlay"));
        btnScoreTable.setText(LocalizationUtil.localizedResourceBundle
                .getString("btnScoreTable"));
        labWelcomeUser.setText(LocalizationUtil.localizedResourceBundle
                .getString("labWelcomeUser"));
        labWelcomeUser.setText(labWelcomeUser.getText() + player
                .getFirstName() + " " + player.getLastName());
        mnuAccount.setText(LocalizationUtil.localizedResourceBundle
                .getString("mnuAccount"));
        mnuItmAbout.setText(LocalizationUtil.localizedResourceBundle
                .getString("mnuItmAbout"));
        mnuItmChangePassword.setText(LocalizationUtil.localizedResourceBundle
                .getString("mnuItmChangePassword"));
        mnuItmRemoveAccount.setText(LocalizationUtil.localizedResourceBundle
                .getString("mnuItmRemoveAccount"));
        mnuItemGameRules.setText(LocalizationUtil.localizedResourceBundle
                .getString("mnuItemGameRules"));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnPlay = new javax.swing.JButton();
        btnScoreTable = new javax.swing.JButton();
        labWelcomeUser = new javax.swing.JLabel();
        labBack = new javax.swing.JLabel();
        labBackground = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        mnuAccount = new javax.swing.JMenu();
        mnuItmAbout = new javax.swing.JMenuItem();
        mnuItmChangePassword = new javax.swing.JMenuItem();
        mnuItmRemoveAccount = new javax.swing.JMenuItem();
        mnuItemGameRules = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        btnPlay.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnPlay.setText("Play Blackjack");
        btnPlay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayActionPerformed(evt);
            }
        });
        getContentPane().add(btnPlay);
        btnPlay.setBounds(20, 130, 200, 30);

        btnScoreTable.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnScoreTable.setText("Show Score Table");
        btnScoreTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnScoreTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnScoreTableActionPerformed(evt);
            }
        });
        getContentPane().add(btnScoreTable);
        btnScoreTable.setBounds(20, 180, 200, 30);

        labWelcomeUser.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labWelcomeUser.setForeground(new java.awt.Color(255, 255, 255));
        labWelcomeUser.setText("Welcome ");
        labWelcomeUser.setToolTipText("");
        getContentPane().add(labWelcomeUser);
        labWelcomeUser.setBounds(50, 50, 290, 30);

        labBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/back.png"))); // NOI18N
        labBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labBackMouseClicked(evt);
            }
        });
        getContentPane().add(labBack);
        labBack.setBounds(10, 280, 64, 70);

        labBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cardBackground.jpg"))); // NOI18N
        labBackground.setMaximumSize(null);
        labBackground.setMinimumSize(null);
        labBackground.setPreferredSize(null);
        getContentPane().add(labBackground);
        labBackground.setBounds(0, -30, 632, 435);

        mnuAccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/account.png"))); // NOI18N
        mnuAccount.setText("My Account");
        mnuAccount.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        mnuItmAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/about.png"))); // NOI18N
        mnuItmAbout.setText("Profile");
        mnuItmAbout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mnuItmAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItmAboutActionPerformed(evt);
            }
        });
        mnuAccount.add(mnuItmAbout);

        mnuItmChangePassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/password.png"))); // NOI18N
        mnuItmChangePassword.setText("Change Password");
        mnuItmChangePassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mnuItmChangePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItmChangePasswordActionPerformed(evt);
            }
        });
        mnuAccount.add(mnuItmChangePassword);

        mnuItmRemoveAccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/removeAccount.png"))); // NOI18N
        mnuItmRemoveAccount.setText("Remove My Account");
        mnuItmRemoveAccount.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mnuItmRemoveAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItmRemoveAccountActionPerformed(evt);
            }
        });
        mnuAccount.add(mnuItmRemoveAccount);

        mnuItemGameRules.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/info-round-button_1.png"))); // NOI18N
        mnuItemGameRules.setText("Game Rules");
        mnuItemGameRules.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mnuItemGameRules.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItemGameRulesActionPerformed(evt);
            }
        });
        mnuAccount.add(mnuItemGameRules);

        menuBar.add(mnuAccount);

        setJMenuBar(menuBar);

        setSize(new java.awt.Dimension(632, 435));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public JMenuBar getMenu() {
        return menuBar;
    }

//protected void removeListeners(){
//    this.mnuItmAbout.removeActionListener(this);
//    this.mnuItmChangePassword.removeActionListener(this);
//    this.mnuItmRemoveAccount.removeActionListener(this);
//}

    private void btnPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayActionPerformed
        this.setVisible(false);
        Game game;
        if (this.language.equals("iw")) {
            game = new Game(player, this, this.language);
        } else {
            game = new Game(player, this);
        }
        game.initializeGUI();
    }//GEN-LAST:event_btnPlayActionPerformed

    private void btnScoreTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnScoreTableActionPerformed
        this.setVisible(false);
        ScoreTable scoreTable;
        if (this.language.equals("iw")) {
            scoreTable = new ScoreTable(this, player, this.language);
        } else {
            scoreTable = new ScoreTable(this, player);
        }
        scoreTable.setVisible(true);
    }//GEN-LAST:event_btnScoreTableActionPerformed

    private void mnuItmChangePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItmChangePasswordActionPerformed
        JTextField oldPassword = new JTextField();
        JTextField newPassword = new JPasswordField();
        Object[] message = {
            "Old Password:", oldPassword,
            "New Password:", newPassword
        };

        if (this.language.equals("iw")) {
            boolean choice = LocalizationUtil.changePaswword_iw(message);
            if (oldPassword.getText() == null || newPassword.getText() == null){

            } else if (player.changePassword(oldPassword.getText(),
                    newPassword.getText())) {
                JOptionPane.showMessageDialog(null, "הסיסמא שונתה בהצלחה!");
                this.dispose();
                previous.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "הסיסמא שגויה!");
            }
        } else {
            int option = JOptionPane.showConfirmDialog(null, message, "Change Password",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if (option == JOptionPane.OK_OPTION) {
                if (oldPassword.getText() == null || newPassword.getText() == null) {

                } else if (player.changePassword(oldPassword.getText(), newPassword.getText())) {
                    JOptionPane.showMessageDialog(null, "Password Changed Successfully");
                    this.dispose();
                    previous.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorecct Password!");
                }
            }
    }//GEN-LAST:event_mnuItmChangePasswordActionPerformed
    }
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int confirmed;
        if (this.language.equals("iw")) {
            confirmed = LocalizationUtil.exitDialog();
        } else {
            confirmed = JOptionPane.showConfirmDialog(null,
                    "Are you sure you want to exit the program?", "Exit Program",
                    JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        }
        if (confirmed == JOptionPane.YES_OPTION) {
            System.exit(0);
        }

    }//GEN-LAST:event_formWindowClosing

    private void mnuItmAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItmAboutActionPerformed

        int per = player.getPermission();
        String about = "";
        String type = (per == 1 ? "Admin" : "User");

        if (this.language.equals("iw")) {
            if (type.equals("Admin")) {
                type = "אדמין";
            } else {
                type = "משתמש";
            }
            about = "סוג חשבון: " + type + "\nאודות " +
                    player.getUserName() + "\n\nשם: "
                    + player.getFirstName() + " " + player.getLastName() 
                    + "\nמין: " + player.getGender() + "\n";
            JOptionPane.showMessageDialog(null, about);
        } else {

            about = "Account Type: " + type + "\nAbout " + player.getUserName()
                    + "\n\nName: "
                    + player.getFirstName() + " " + player.getLastName()
                    + "\nGender: " + player.getGender() + "\n";
            JOptionPane.showMessageDialog(null, about);
        }
    }//GEN-LAST:event_mnuItmAboutActionPerformed

    private void mnuItmRemoveAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItmRemoveAccountActionPerformed
        int confirmed;

        if (this.language.equals("iw")) {
            confirmed = JOptionPane.showConfirmDialog(null,
                    "האם אתה בטוח שברצונך למחוק את החשבון?", "מחיקת חשבון",
                    JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        } else {
            confirmed = JOptionPane.showConfirmDialog(null,
                    "Are you sure you want to remove your account?",
                    "Remove Account",
                    JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        }

        if (confirmed == JOptionPane.YES_OPTION) {
            if (this.language.equals("iw")) {
                JOptionPane.showMessageDialog(null, 
                        "מקווים לראותך שוב בקרוב!!");
            } else {
                JOptionPane.showMessageDialog(null, 
                        "Hope to see you soon!");
            }
            player.removeAccount(player);
            this.dispose();
            previous.setVisible(true);
        }
    }//GEN-LAST:event_mnuItmRemoveAccountActionPerformed

    private void labBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labBackMouseClicked
        this.dispose();
        previous.setVisible(true);
    }//GEN-LAST:event_labBackMouseClicked

    private void mnuItemGameRulesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItemGameRulesActionPerformed
        if (this.language.equals("iw"))
           new TableRules(language).setVisible(true);
        else
        new TableRules().setVisible(true);
    }//GEN-LAST:event_mnuItemGameRulesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton btnPlay;
    protected javax.swing.JButton btnScoreTable;
    protected javax.swing.JLabel labBack;
    protected javax.swing.JLabel labBackground;
    protected javax.swing.JLabel labWelcomeUser;
    protected javax.swing.JMenuBar menuBar;
    protected javax.swing.JMenu mnuAccount;
    protected javax.swing.JMenuItem mnuItemGameRules;
    protected javax.swing.JMenuItem mnuItmAbout;
    protected javax.swing.JMenuItem mnuItmChangePassword;
    protected javax.swing.JMenuItem mnuItmRemoveAccount;
    // End of variables declaration//GEN-END:variables
}

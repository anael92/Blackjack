package Forms;

import Resources.GameUtil;
import Resources.LocalizationUtil;
import Users.User;
import DataBase.DB;
import DataBase.DBUtils;
import blackjack.Score;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ANI
 */
public class ScoreTable extends javax.swing.JFrame {

    UserHome previous = null;
    User player = null;
    String language = "";
    DefaultTableModel dtm;
    List<Score> scores = new ArrayList<Score>();

    /**
     * Creates new form ScoreTable
     */
    public ScoreTable() {
        initComponents();
        initTable();
        transparentButtons();
    }
    // Initialize ScoreTable with the previous form, and the current player

    public ScoreTable(UserHome previous, User player) {
        this();
        this.previous = previous;
        this.player = player;
    }
    // If a language is choosen

    public ScoreTable(UserHome previous, User player, String lang) {
        initComponents();
        this.previous = previous;
        this.player = player;
        this.language = lang;
        initTable();
        if (this.language.equals("iw")) {
            LocalizationUtil.changeOptionPane_iw();
            LocalizationUtil.localizedResourceBundle = LocalizationUtil.getBundleScoreTableIW();
            updateCaption();
        }
        transparentButtons();
    }

    // if hebrew was choosen
    private void updateCaption() {
        Vector columnsName = new Vector();
        columnsName.addElement(LocalizationUtil.localizedResourceBundle
                .getString("UserName"));
        columnsName.addElement(LocalizationUtil.localizedResourceBundle
                .getString("Wins"));
        columnsName.addElement(LocalizationUtil.localizedResourceBundle
                .getString("Balance"));
        dtm.setColumnIdentifiers(columnsName);
        labHighScore.setText(LocalizationUtil.localizedResourceBundle
                .getString("labHighScore"));
        jrdbWins.setText(LocalizationUtil.localizedResourceBundle
                .getString("jrdbWins"));
        jrdbBalance.setText(LocalizationUtil.localizedResourceBundle
                .getString("jrdbBalance"));

    }

    private void transparentButtons() {
        jrdbWins.setOpaque(false);
        jrdbWins.setContentAreaFilled(false);
        jrdbWins.setBorderPainted(false);

        ImageIcon im = new ImageIcon("./src/img/radioButton.png");
        jrdbWins.setIcon(im);
        jrdbBalance.setIcon(im);

        jrdbBalance.setOpaque(false);
        jrdbBalance.setContentAreaFilled(false);
        jrdbBalance.setBorderPainted(false);
    }

    // intialize table by importing data from the database
    private void initTable() {
        GameUtil.setIcon(this);
        DB db = DB.getInstance();
        String sql = "SELECT * FROM APP.SCORE";
        try {
            Class.forName(DBUtils.DbDriverClass);
            Connection connection = DriverManager.getConnection(
                    DBUtils.DbUrl, DBUtils.DbUser, DBUtils.DbPassword);

            Statement stat = connection.createStatement();
            ResultSet resultSet = stat.executeQuery(sql);
            ResultSetMetaData rsmd = resultSet.getMetaData();

            dtm = new DefaultTableModel();
            Vector columnsName = new Vector();

            columnsName.addElement("User Name");
            columnsName.addElement("Wins");
            columnsName.addElement("Balance");
            dtm.setColumnIdentifiers(columnsName);

            // Adding all information to Score list
            while (resultSet.next()) {
                Score s;
                int userId = resultSet.getInt("USERID");
                int wins = resultSet.getInt("WINS");
                int balance = resultSet.getInt("BALANCE");

                String userName = "";
                for (User u : db.getUsers()) {
                    if (u.getId() == userId) {
                        userName = u.getUserName();
                        break;
                    }
                }
                s = new Score(userName, wins, balance);
                scores.add(s);
            }
            // Sorting list by balance
            Collections.sort(scores);
            for (Score curr : scores) {
                Vector dataRows = new Vector();
                dataRows.addElement(curr.getUserName());
                dataRows.addElement(curr.getWins());
                dataRows.addElement(curr.getBalance());
                dtm.addRow(dataRows);
            }
            scoreTable.setModel(dtm);

        } catch (Exception e) {
            System.out.println(e.getCause());
        }

        scoreTable.setEnabled(false);
        scoreTable.getTableHeader().setReorderingAllowed(false);
        this.getContentPane().setBackground(Color.BLACK);
        scoreTable.setBackground(new java.awt.Color(204, 204, 255));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupSort = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        scoreTable = new javax.swing.JTable();
        labBack = new javax.swing.JLabel();
        labHighScore = new javax.swing.JLabel();
        jrdbBalance = new javax.swing.JRadioButton();
        jrdbWins = new javax.swing.JRadioButton();
        labBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("BlackJack ANI");
        setForeground(java.awt.Color.black);
        setName("scoreTable"); // NOI18N
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        scoreTable.setBackground(new java.awt.Color(51, 204, 255));
        scoreTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        scoreTable.setSelectionForeground(new java.awt.Color(240, 240, 240));
        jScrollPane1.setViewportView(scoreTable);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 70, 440, 390);

        labBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/specialBack.png"))); // NOI18N
        labBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labBackMouseClicked(evt);
            }
        });
        getContentPane().add(labBack);
        labBack.setBounds(410, 10, 42, 55);

        labHighScore.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        labHighScore.setForeground(new java.awt.Color(255, 255, 255));
        labHighScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labHighScore.setText("High Score");
        labHighScore.setMaximumSize(new java.awt.Dimension(227, 44));
        labHighScore.setMinimumSize(new java.awt.Dimension(227, 44));
        labHighScore.setPreferredSize(new java.awt.Dimension(227, 44));
        getContentPane().add(labHighScore);
        labHighScore.setBounds(120, 10, 251, 44);

        btnGroupSort.add(jrdbBalance);
        jrdbBalance.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jrdbBalance.setForeground(new java.awt.Color(255, 255, 255));
        jrdbBalance.setText("By Balance");
        jrdbBalance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrdbBalanceActionPerformed(evt);
            }
        });
        getContentPane().add(jrdbBalance);
        jrdbBalance.setBounds(0, 10, 120, 23);

        btnGroupSort.add(jrdbWins);
        jrdbWins.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jrdbWins.setForeground(new java.awt.Color(255, 255, 255));
        jrdbWins.setText("By Wins");
        jrdbWins.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrdbWinsActionPerformed(evt);
            }
        });
        getContentPane().add(jrdbWins);
        jrdbWins.setBounds(0, 40, 120, 23);

        labBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/scoreTableBackground.jpg"))); // NOI18N
        getContentPane().add(labBackground);
        labBackground.setBounds(-6, -6, 470, 480);

        setSize(new java.awt.Dimension(470, 500));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int confirmed = JOptionPane.NO_OPTION;
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

    private void labBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labBackMouseClicked
        this.dispose();
        previous.setVisible(true);
    }//GEN-LAST:event_labBackMouseClicked

    private void jrdbBalanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrdbBalanceActionPerformed
        // Sorting list by balance
        clearTable();
        Collections.sort(scores);
        for (Score curr : scores) {
            Vector dataRows = new Vector();
            dataRows.addElement(curr.getUserName());
            dataRows.addElement(curr.getWins());
            dataRows.addElement(curr.getBalance());
            dtm.addRow(dataRows);
        }
        scoreTable.setModel(dtm);
    }//GEN-LAST:event_jrdbBalanceActionPerformed

    private void jrdbWinsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrdbWinsActionPerformed
        clearTable();
        Collections.sort(scores, new Comparator<Score>() {
            @Override
            public int compare(Score o1, Score o2) {
                return o2.getWins() - o1.getWins();
            }

        });
        for (Score curr : scores) {
            Vector dataRows = new Vector();
            dataRows.addElement(curr.getUserName());
            dataRows.addElement(curr.getWins());
            dataRows.addElement(curr.getBalance());
            dtm.addRow(dataRows);
        }
        scoreTable.setModel(dtm);
    }//GEN-LAST:event_jrdbWinsActionPerformed

    private void clearTable() {
        DefaultTableModel model = (DefaultTableModel) scoreTable.getModel();

        while (model.getRowCount() > 0) {
            for (int i = 0; i < model.getRowCount(); ++i) {
                model.removeRow(i);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnGroupSort;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton jrdbBalance;
    private javax.swing.JRadioButton jrdbWins;
    private javax.swing.JLabel labBack;
    private javax.swing.JLabel labBackground;
    private javax.swing.JLabel labHighScore;
    private javax.swing.JTable scoreTable;
    // End of variables declaration//GEN-END:variables
}

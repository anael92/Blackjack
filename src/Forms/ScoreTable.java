/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import Resources.GameUtil;
import Resources.LocalizationUtil;
import Users.User;
import DataBase.DB;
import DataBase.DBUtils;
import blackjack.Score;
import java.awt.Color;
import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.apache.derby.impl.sql.execute.AggregatorInfoList;

/**
 *
 * @author ANI
 */
public class ScoreTable extends javax.swing.JFrame {
    UserHome previous = null;
    User player = null;
    String language = "";
    DefaultTableModel dtm;
    /**
     * Creates new form ScoreTable
     */
    public ScoreTable() {
        initComponents();
        initTable();
    }
        // Initialize ScoreTable with the previous form, and the current player
        public ScoreTable(UserHome previous,User player) {
            this();
            this.previous = previous;
            this.player = player;
    }
        // If a language is choosen
        public ScoreTable(UserHome previous,User player,String lang) {
            initComponents();
            this.previous = previous;
            this.player = player;
            this.language = lang;
            initTable();
            if (this.language.equals("iw"))
            {
                LocalizationUtil.changeOptionPane_iw();
                LocalizationUtil.localizedResourceBundle = LocalizationUtil.getBundleScoreTableIW();
                updateCaption();
            }
    }
        
    private void updateCaption()
    {
         Vector columnsName = new Vector();
        columnsName.addElement(LocalizationUtil.localizedResourceBundle.getString("UserName"));
        columnsName.addElement(LocalizationUtil.localizedResourceBundle.getString("Wins"));
        columnsName.addElement(LocalizationUtil.localizedResourceBundle.getString("Balance"));
        dtm.setColumnIdentifiers(columnsName);
        labHighScore.setText(LocalizationUtil.localizedResourceBundle.getString("labHighScore"));
    }
    
    private void initTable()
    {
         GameUtil.setIcon(this);
        DB db = DB.getInstance();
        String sql = "SELECT * FROM APP.SCORE";
       try{
        Class.forName(DBUtils.DbDriverClass);
       Connection connection = DriverManager.getConnection(
                 DBUtils.DbUrl, DBUtils.DbUser, DBUtils.DbPassword );
       
       Statement stat = connection.createStatement();
       ResultSet resultSet = stat.executeQuery(sql);
       ResultSetMetaData rsmd = resultSet.getMetaData();

        dtm = new DefaultTableModel();
       Vector columnsName = new Vector();

        columnsName.addElement("User Name");
        columnsName.addElement("Wins");
        columnsName.addElement("Balance");
       dtm.setColumnIdentifiers(columnsName);
       
        List<Score> scores = new ArrayList<Score>();
        Score s = new Score();
       while (resultSet.next())
       {
           int userId = resultSet.getInt("USERID");
            int wins = resultSet.getInt("WINS");
            int balance = resultSet.getInt("BALANCE");
            
            String userName = "";
            for (User u : db.getUsers())
            {
                if (u.getId() == userId)
                {
                    userName = u.getUserName();
                    break;
                }
           }
           s = new Score(userName,wins,balance);
           scores.add(s);
       }
        Collections.sort(scores);
       for (Score curr : scores)
       {
           Vector dataRows = new Vector();
           dataRows.addElement(curr.getUserName());
           dataRows.addElement(curr.getWins());
           dataRows.addElement(curr.getBalance());
           dtm.addRow(dataRows); 
       }
       
       
       scoreTable.setModel(dtm);
       }catch(Exception e)
       {
           System.out.println(e.getCause());
       }
        
       scoreTable.setEnabled(false);
   //    scoreTable.setBackground(new java.awt.Color(204, 204, 255));
       scoreTable.getTableHeader().setReorderingAllowed(false);
       this.getContentPane().setBackground(Color.BLACK);
       scoreTable.setBackground(new java.awt.Color(204, 204, 255));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        scoreTable = new javax.swing.JTable();
        labBack = new javax.swing.JLabel();
        labHighScore = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BlackJack ANI");
        setForeground(java.awt.Color.black);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

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

        labBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/specialBack.png"))); // NOI18N
        labBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labBackMouseClicked(evt);
            }
        });

        labHighScore.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        labHighScore.setForeground(new java.awt.Color(255, 255, 255));
        labHighScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labHighScore.setText("High Score");
        labHighScore.setMaximumSize(new java.awt.Dimension(227, 44));
        labHighScore.setMinimumSize(new java.awt.Dimension(227, 44));
        labHighScore.setPreferredSize(new java.awt.Dimension(227, 44));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labHighScore, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(labBack, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labHighScore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(labBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setSize(new java.awt.Dimension(461, 434));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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

    private void labBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labBackMouseClicked
        this.dispose();
        previous.setVisible(true);
    }//GEN-LAST:event_labBackMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labBack;
    private javax.swing.JLabel labHighScore;
    private javax.swing.JTable scoreTable;
    // End of variables declaration//GEN-END:variables
}

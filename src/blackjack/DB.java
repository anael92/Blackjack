/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import Forms.Score;
import Users.Admin;
import Users.RegularUser;
import Users.User;
import blackjack.Utils.ACCOUNTTYPE;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author IBM
 */
public class DB {
    
     private List<User> users = new ArrayList<User>();
     protected static DB instance = new DB();
     public static int lastId;
     Connection connection = null;
     Statement statement = null;

    public static int getLastId() {
        return lastId;
    }
     
     private DB() {
         checkIfTableExist();
     }
     
     private void checkIfTableExist()
    {
        boolean found = false;
        createConnection();
        try{
        DatabaseMetaData dbm = connection.getMetaData();
            ResultSet tables = dbm.getTables(null, null, "USERS", null);
            if (!tables.next()) {
                closeConnection();
                initUsersTable();
            }

        }catch(SQLException e)
        {
            System.out.println(e.getCause());
        }
        System.out.println("\n\n\n\n");
        found = false;
        createConnection();
        try{
        DatabaseMetaData dbm = connection.getMetaData();
        ResultSet tables = dbm.getTables(null, null, "SCORE", null);
        if (!tables.next()) {
         closeConnection();
         initScoreTable();
        }
        }catch(SQLException e)
        {
            System.out.println(e.getCause());
        }
     }
     
     private void initUsersTable()
     {
         String createUsersTable = "CREATE TABLE APP.USERS (" +
    " ID INTEGER generated by default as identity (start with 1, increment by 1) not null," +
    " FIRSTNAME VARCHAR(20) NOT NULL," +
    "LASTNAME VARCHAR(20) NOT NULL," +
    " GENDER VARCHAR(10) NOT NULL," +
    "USERNAME VARCHAR(20) NOT NULL," +
    " PASSWORD VARCHAR(20) NOT NULL," +
    "PERMISSION INTEGER NOT NULL," +
    "CONSTRAINT USERS_PK_ID PRIMARY KEY (ID))";
         createConnection();
          try{
         statement = connection.createStatement();
         statement.executeUpdate(createUsersTable);
         }catch(Exception e)
         {
             System.out.println(e.getMessage());
         }
         closeConnection();
          fillUsers();
     }
     
     private void initScoreTable()
     {
        String createUsersTable = "CREATE TABLE APP.SCORE (" +
        " ID INTEGER generated by default as identity (start with 1, increment by 1) not null," +
        " USERID INTEGER NOT NULL," +
        "WINS INTEGER NOT NULL," +
        " BALANCE INTEGER NOT NULL," +
        "CONSTRAINT SCORE_PK_ID PRIMARY KEY (ID)," +
        "CONSTRAINT USERS_FK_USERID FOREIGN KEY (USERID) REFERENCES APP.USERS(ID))";
         createConnection();
          try{
         statement = connection.createStatement();
         statement.executeUpdate(createUsersTable);
         }catch(Exception e)
         {
             System.out.println(e.getMessage());
         }
        closeConnection();
        fillScore();
     }
     
     private void fillScore()
     {
         createConnection();
         String fillScoreTable = "INSERT INTO APP.SCORE (USERID,WINS,BALANCE)"
                 + " VALUES(?,?,?)";
         try{
         PreparedStatement stat = connection.prepareStatement(fillScoreTable);
         stat.setInt(1, 1);
         stat.setInt(2, 20);
         stat.setInt(3, 14500);
         stat.executeUpdate();
         }catch(Exception e)
         {
             System.out.println(e.getMessage());
         }
         try{
         PreparedStatement stat = connection.prepareStatement(fillScoreTable);
         stat.setInt(1, 2);
         stat.setInt(2, 24);
         stat.setInt(3, 25500);
         stat.executeUpdate();
         }catch(Exception e)
         {
             System.out.println(e.getMessage());
         }
         closeConnection();
     }
     
     private void fillUsers()
     {
         PreparedStatement stat = null;
         createConnection();
         String fillUsersTable = "INSERT INTO APP.USERS (FIRSTNAME,LASTNAME"
                 + ",GENDER,USERNAME,PASSWORD,PERMISSION) VALUES(?,?,?,?,?,?)";
         try{
         stat = connection.prepareStatement(fillUsersTable);
         stat.setString(1, "Anael");
         stat.setString(2, "Shomrai");
         stat.setString(3, "Female");
         stat.setString(4, "anael");
         stat.setString(5, "123456");
         stat.setInt(6, 1);
         stat.executeUpdate();
         }catch(Exception e)
         {
             System.out.println(e.getMessage());
         }
         try{
         stat = connection.prepareStatement(fillUsersTable,stat.RETURN_GENERATED_KEYS);
         stat.setString(1, "Nadav");
         stat.setString(2, "Zalman");
         stat.setString(3, "Male");
         stat.setString(4, "nadav");
         stat.setString(5, "123456");
         stat.setInt(6, 2);
         int result = stat.executeUpdate();
         if (result ==0)
         {
             System.out.println("Failed in inserting users");
         }
          ResultSet generatedKeys = stat.getGeneratedKeys();
           if (generatedKeys.next())
                 {
                     lastId = generatedKeys.getInt(1);
                 }
                 else{
                     System.out.println("NO ID OBTAINED");
                 }
         }catch(Exception e)
         {
             System.out.println(e.getMessage());
         }
         closeConnection();
         
}
     public static DB getInstance()
     {
         return instance;
     }

    public List<User> getUsers() {
        return users;
    }
    
    public void createConnection()
    {  
         try{
         Class.forName(DBUtils.DbDriverClass);
         connection = DriverManager.getConnection(
                 DBUtils.DbUrl, DBUtils.DbUser, DBUtils.DbPassword );
         }catch(Exception e)
         {
             System.out.println(e.getMessage());
         }
    }
    
    public void closeConnection(){
     try{
     if (connection!= null)
     connection.close();
     try{
     if (statement!= null)
     statement.close();
     }catch(SQLException e)
     {
         System.out.println("statement couldnt close");
     }
     }catch(SQLException e)
     {
         System.out.println("Connection didnt close");
     
        }
    }
    
    public void addUser(User u)
    {
         PreparedStatement stat = null;
         String updateUser = "INSERT INTO APP.USERS (FIRSTNAME,LASTNAME,GENDER"
                 + ",USERNAME,PASSWORD,PERMISSION) VALUES (?,?,?,?,?,?)";
         createConnection();
         try{
             stat = connection.prepareStatement(updateUser,stat.RETURN_GENERATED_KEYS);
             stat.setString(1, u.getFirstName());
             stat.setString(2, u.getLastName());
             stat.setString(3, u.getGender());
             stat.setString(4, u.getUserName());
             stat.setString(5, u.getPassword());
             stat.setInt(6, u.getPermission());
             int result = stat.executeUpdate();
         if (result ==0)
         {
             System.out.println("Failed in inserting users");
         }
          ResultSet generatedKeys = stat.getGeneratedKeys();
           if (generatedKeys.next())
                 {
                     lastId = generatedKeys.getInt(1);
                 }
                 else{
                     System.out.println("NO ID OBTAINED");
                 }
          u.setId(lastId);
          users.add(u);
         }catch(SQLException e)
         {
             System.out.println("error in add user");
             System.out.println(e.getSQLState());
             System.out.println(e.getCause());
         }
         this.createWinsNBalance(u.getId());
         closeConnection(); 
    }
    
    public void initBalanceAndWins()
    {
         ResultSet resultSet = null;
         this.createConnection();
         try{
         statement = connection.createStatement();
             resultSet = statement.executeQuery("SELECT * FROM APP.SCORE");
         }catch(Exception e)
         {
             System.out.println(e.getMessage());
         }
          try{
            while (resultSet.next())
            {
              int id = resultSet.getInt("USERID");
              int wins = resultSet.getInt("WINS"); 
              int balance = resultSet.getInt("BALANCE");
              
              for (User u: users)
              {
                  if (id == u.getId())
                  {
                      u.setWins(wins);
                      u.setBalance(balance);
                  }
              }
              
              
            }}catch(SQLException e)
            {
                System.out.println("Error in init users");
            }
            this.closeConnection();
    }
     
     public void initUsers(){
         ResultSet resultSet = null;
         this.createConnection();
         try{
         statement = connection.createStatement();
             resultSet = statement.executeQuery("SELECT * FROM APP.USERS");
         }catch(Exception e)
         {
             System.out.println(e.getMessage());
         }
            
         try{
            while (resultSet.next())
            {
                int id = resultSet.getInt("ID");
                String firstName = resultSet.getString("FIRSTNAME");
                String lastName = resultSet.getString("LASTNAME");
                String gender = resultSet.getString("GENDER");
                String userName = resultSet.getString("USERNAME");
                String password = resultSet.getString("PASSWORD");
                int permission = resultSet.getInt("PERMISSION");
                if (permission == 1) // admin
                {
                    Admin a = new Admin(id,firstName, lastName, gender, userName, password);
                    users.add(a);
                }
                else if (permission == 2) // user
                {
                    RegularUser ru = new RegularUser(id,firstName, lastName, gender, userName, password);
                    users.add(ru);
                }
                       
                
            }}catch(SQLException e)
            {
                System.out.println("Error in init users");
            }
            this.closeConnection();
            initBalanceAndWins();
         
     }
     
     public void updateUser(int id, int wins, int balance)
     {
         for (User u : users)
         {
             if (u.getId() == id)
             {
                 u.setBalance(balance);
                 u.setWins(wins);
             }
         }
         updateUserInDB(id,wins,balance);
     }
     
     public void updateUserInDB(int userId, int wins,int balance)
     {
         PreparedStatement stat = null;
         String updateWinsNBalance = "UPDATE APP.SCORE SET WINS = ?,"
                 + "BALANCE = ? WHERE USERID = ?";
         this.createConnection();
         try{
             stat = connection.prepareStatement(updateWinsNBalance);
             stat.setInt(1, wins);
             stat.setInt(2, balance);
             stat.setInt(3, userId);
             int result = stat.executeUpdate();
         }catch(SQLException e)
         {
             System.out.println("Error in insert score and wins");
             System.out.println(e.getSQLState());
             System.out.println(e.getCause());
         }
         this.closeConnection();
     }
     
    public void createWinsNBalance(int userId)
     {
         PreparedStatement stat = null;
         String updateUser = "INSERT INTO APP.SCORE (USERID, WINS, BALANCE) "
                 + "VALUES (?, 0, 10000)";
         createConnection();
         try{
             stat = connection.prepareStatement(updateUser);
             stat.setInt(1, userId);
             stat.executeUpdate();
         }catch(SQLException e)
         {
             System.out.println("error in on sign up");
             System.out.println(e.getSQLState());
             System.out.println(e.getCause());
         }

         closeConnection();
     }
    
    public User login(String userName, String password)
    {
        User found = null;
        for (User u : users)
        {
            if (u.getUserName().equals(userName) && u.getPassword().equals(password))
            {
                found = u;
                break;
            }
        }
        return found;
    }   
    
    public void changePassword(String newPassword, int userId)
    {
        PreparedStatement stat = null;
        String updatePassword = "UPDATE APP.USERS SET PASSWORD = ? WHERE ID = ?";
         createConnection();
         try{
             stat = connection.prepareStatement(updatePassword);
             stat.setString(1, newPassword);
             stat.setInt(2, userId);
             stat.executeUpdate();
         }catch(SQLException e)
         {
             System.out.println(e.getCause());
         }
         closeConnection();
    }
    
    public void removeAccount(User u)
    {
      PreparedStatement stat = null;
         createConnection();
         try{
             users.remove(u);
             String deleteUser = "DELETE FROM APP.SCORE WHERE USERID = ?";
             stat = connection.prepareStatement(deleteUser);
             stat.setInt(1, u.getId());
             stat.executeUpdate();
             deleteUser = "DELETE FROM APP.USERS WHERE ID = ?";
             stat = connection.prepareStatement(deleteUser);
             stat.setInt(1, u.getId());
             stat.executeUpdate();

         }catch(SQLException e)
         {
             System.out.println(e.getCause());
         }
         closeConnection();
        
    }
    
    public User findUserById(int id)
    {
        for (User u: users)
        {
            if (u.getId() == id)
                return u;
        } 
        return null;
    }

    public void changePermission(int id) {
         String changePermission = "UPDATE APP.USERS SET PERMISSION = 1";
         this.createConnection();
         try{
             statement = connection.createStatement();
             statement.executeUpdate(changePermission);
         }catch(SQLException e)
         {
             System.out.println("Error in  change permission");
             System.out.println(e.getSQLState());
             System.out.println(e.getCause());
         }
         this.closeConnection();
    }
    
}

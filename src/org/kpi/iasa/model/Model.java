package org.kpi.iasa.model;

import java.sql.*;

public class Model {
  private Connection conn;

  public void connectToDb() {
    try {
      Class.forName("org.h2.Driver");
      conn = DriverManager.getConnection("jdbc:h2:~/testdb", "sa", "");
      if (conn.isValid(1000)) {
        System.out.println("Got H2 embedded DB connection...");
      }
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }
  }

  public void closeConnection() {
    try{
      conn.close();
      if (conn.isClosed()) {
        System.out.println("H2 embedded DB connection closed");
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

  public void seedDb() {
    String dropTableQ = "drop table users";
    String createTableQ = "create table if not exists users(id IDENTITY NOT NULL PRIMARY KEY, login varchar(20), password varchar(20))";
    String sql = "insert into users(login, password) values ('admin_test', 'adminadmin')";
    try {
      Statement stmt = conn.createStatement();
      stmt.executeUpdate(dropTableQ);
      stmt.executeUpdate(createTableQ);
      stmt.executeUpdate(sql);
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }


  public Boolean validateRecExistence(String columnName, String columnValue) {
    int found = 0;
    try {
      String sql = "select count(*) as count from users where " + columnName + "=" + "'" + columnValue + "'";
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(sql);
      //STEP 5: Extract data from result set
      while(rs.next()){
        //Retrieve by column name
        found  = rs.getInt("count");
      }
      rs.close();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return found > 0 ;
  }

  public Boolean validateLogin(String login) {
    return validateRecExistence("login", login);
  }

  public Boolean validatePassword(String password) {
    return validateRecExistence("password", password);
  }

}

package config;

import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StateMent {
    private Statement stateMent;
    public StateMent() {
        try {
            makeStat();
        } catch (SQLException e) {
             e.printStackTrace();
        }

    }
     private Statement makeStat() throws SQLException {
        Conect c = null;
        c = new Conect();
    Connection com = c.newConnection();
    stateMent=com.createStatement();
    return stateMent;
}

       public void selectALL() throws SQLException {
      ResultSet resultSet = stateMent.executeQuery("SELECT name FROM sys.hillel24 where id='2'");
      while (resultSet.next()){
          System.out.println(resultSet.getString("name"));
      }


}

    public void selectAdress() throws SQLException {
        ResultSet resultSet = stateMent.executeQuery("SELECT name  FROM sys.hillel24\n" +
                "where adress= 'Kiev' or adress='Odessa';");
        while (resultSet.next()){
            System.out.println(resultSet.getString("name"));
        }
    }
}

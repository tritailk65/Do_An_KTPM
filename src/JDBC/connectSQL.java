package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class connectSQL {
    String host;
    String username;
    String password;
    String database;
    
    Connection connect = null;
    Statement statement = null;
    ResultSet result = null;
        
    public connectSQL(String host, String username, String password, String database){
        this.host = host;
        this.username = username;
        this.password = password;
        this.database = database;
    }
    
    public Connection getConnect() throws Exception {
        if(this.connect == null){
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbUrl = "jdbc:sqlserver://"+this.host+":1433;databaseName="+this.database+";useUnicode=true;characterEncoding=UTF-8;trustServerCertificate=true";
            try{
                this.connect = DriverManager.getConnection(dbUrl, username, password);
            } catch(Exception e){
                System.out.println(e); 
            }
        }
        return this.connect;
    }
    
    public Statement getStatement() throws Exception{
        if(this.statement == null? true:this.statement.isClosed()){
            this.statement = this.getConnect().createStatement();
        }
        return this.statement;
    }
    
    public ResultSet executeQuery(String query){
        try{
            this.result = this.getStatement().executeQuery(query);
        }
        catch (Exception e){
            System.out.println(e);
        }
        return this.result;
    }
}
        
    
     

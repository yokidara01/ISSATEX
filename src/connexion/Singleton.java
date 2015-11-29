package connexion;

import java.sql.Connection;
import java.sql.DriverManager;


public class Singleton {
    private static Connection cn=null;
  
    private String localDB = "jdbc:mysql://localhost/issatex_jee";     
    private Singleton(){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        cn=DriverManager.getConnection(localDB,"root","130591");
        }catch(Exception e){
        	
        	e.printStackTrace();
        }
    }
    
    public static Connection getInstance(){
        if(cn==null){
            new Singleton();
        }
        return cn;
    }
} 
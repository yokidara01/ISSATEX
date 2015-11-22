package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpSession;

import beans.Client;

public class ClientDao {
	
	public int inscription(Client c)
	{
		int result = 0 ;
		
		if(!ClientExist(c))
		{
			Connection cn = connexion.Singleton.getInstance(); 
			
				try {
					cn.createStatement();
					Statement st = cn.createStatement() ;
					String req = "insert into client "; 
					ResultSet rs = st.executeQuery(req);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			result=addClient(c);
		}
		
		return result ; 
	}
	
	

	private int addClient(Client c) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

	private boolean ClientExist(Client c) {
		// TODO Auto-generated method stub
		Connection cn = connexion.Singleton.getInstance(); 
		try {
			cn.createStatement();
			Statement st = cn.createStatement() ;
			String req = "select * from client where idClient="+c.getIdClient(); 
		ResultSet rs = st.executeQuery(req);
		System.out.println("Query of ClientExist : "+req);
		if (rs!=null){
			return true ;
		}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	/*******************************/
	
	public Client login(String nom,String mdp)
	{
		if(matchPassword())
		{
			return getClient(nom,mdp) ;
			
			
		}
		return null;
		
		
	}



	private Client getClient(String nom, String mdp) {
		// TODO Auto-generated method stub
		return null;
	}



	private boolean matchPassword() {
		// TODO Auto-generated method stub
		return false;
	}
}

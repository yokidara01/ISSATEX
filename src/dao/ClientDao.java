package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpSession;

import connexion.Singleton;
import beans.Client;

public class ClientDao {
	
	public int inscription(Client c)
	{
		int result = 0 ;
		
	//	if(!ClientExist(c))
		{
			
			
			result=addClient(c);
		}
		
		return result ; 
	}
	
	

	private int addClient(Client c) {
		// TODO Auto-generated method stub
		int result =0 ;
		System.out.println("adding Client");
		Connection cn = connexion.Singleton.getInstance(); 
		
		try {
			cn.createStatement();
			Statement st = cn.createStatement() ;
			String req = "INSERT INTO `client`( `nom`, ` prenom`, `adresse`, `pays`, `tel`, `typeClient`, `refDouane`, `mdp`)"
					+ " VALUES ('"+c.getNom()+"',"
							+ "'"+c.getPrénom()+"',"
							+"'"+c.getAdresse()+"',"
							+"'"+c.getPays()+"',"
							+"'"+c.getTel()+"',"
							+"'"+"2"+"',"
							+"'"+c.getRefDouane()+"',"
							+"'"+c.getMdp()+"'"+
							")"; 
			System.out.println(req);
		result = st.executeUpdate(req);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
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
		if(matchPassword(nom,mdp))
		{
			System.out.println("client found!") ;
			return getClient(nom,mdp) ;
			
			
		}
		return null;
		
		
	}



	private Client getClient(String nom, String mdp) {
		// TODO Auto-generated method stub
		return null;
	}



	private boolean matchPassword(String nom, String mdp) {
		// TODO Auto-generated method stub
		ResultSet res =null ; 
		
		try {
			Connection cn = Singleton.getInstance() ;
			Statement st  =cn.createStatement() ;
			String req="select * from client where nom='"+nom+ "' and mdp='"+mdp+"'"  ;
			System.out.println(req) ;
			res =st.executeQuery(req);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(res.wasNull()){
				return false ;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true ;	
		
		}
}

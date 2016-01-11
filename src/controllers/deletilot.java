package controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class deletilot
 */
public class deletilot extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deletilot() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int codeilot= Integer.parseInt(request.getParameter("codeilot"));
		Connection cn = connexion.Singleton.getInstance(); 
		try {
			cn.createStatement();
			Statement st = cn.createStatement() ;
			String req = "DELETE FROM `ilot` WHERE codeIlot="+codeilot; 
		 st.executeUpdate(req);
		 
		 
		//System.out.println("Query of select all article : "+req);
		
	}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		
		
		
		try {
			cn.createStatement();
			Statement st = cn.createStatement() ;
			String req = "UPDATE `machine` SET `ilot`=0 where ilot ="+codeilot; 
		 st.executeUpdate(req);
		 
		 
		//System.out.println("Query of select all article : "+req);
		 
	}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		
		
		
		try {
			cn.createStatement();
			Statement st = cn.createStatement() ;
			String req = "UPDATE `employer` SET `ilot`=0 where ilot ="+codeilot; 
		 st.executeUpdate(req);
		 
		 
		//System.out.println("Query of select all article : "+req);
	
	}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		
		
		RequestDispatcher d=request.getRequestDispatcher("/admin/AdminPanel.jsp");
		d.forward(request, response);
	}
	}
	
	
	



package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.tools.ws.processor.model.Request;

import dao.ClientDao;

import beans.Client;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		
		Client c = new Client() ; 
		String nom =request.getParameter("nom");
		String mdp = request.getParameter("mdp"); 
		ClientDao cdao = new ClientDao() ; 
		c=cdao.login(nom, mdp); 
		java.io.PrintWriter out = response.getWriter();
		if (c==null){

			out.println("invalid client");	
			
		}else
		{
		request.getSession().setAttribute("client", c);
		out.println("client conneté ");
		}
	}

}

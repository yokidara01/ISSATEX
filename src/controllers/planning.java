package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OFDao;

/**
 * Servlet implementation class planning
 */
public class planning extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public planning() {
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
		
		int size = Integer.parseInt(request.getParameter("sizeof")) ; 
		
		ArrayList<ArrayList<Integer>> plan = new ArrayList<>(); 
		
		OFDao ofdao = new OFDao() ; 
		
		 for(int i = 1; i <= size; i++)
		 {
					 int refOf =  Integer.parseInt(request.getParameter("refof"+i)) ; 
					// System.out.println("ref of de i = "+i+" : "+request.getParameter("refof"+i));
					 ArrayList<Integer> teams = new ArrayList<>() ; 
					// System.out.println(ofdao.getMinTeamRequired(refOf)/60 + " ESTIMATED TEAMS **************************  ") ; 
								
					 
					 			for(int j = 1; j <= ofdao.getMinTeamRequired(refOf)/60; j++)
								 {
									// System.out.println("get parametre  ilotrefOF-j : "+"ilot"+refOf+"-"+j) ;
									teams.add(Integer.parseInt(request.getParameter("ilot"+refOf+"-"+j))) ; 
									
									 
					 			 }
					 			//System.out.println("-----------size of teams "+teams.size());
					 plan.add(teams) ;
		 }
		 
		 
	/*	int o ;
		 
		 for(int i = 1; i <= plan.size(); i++)
		 { o=0 ;
			 System.out.println("of "+i +" and it has these teams :");
			 for ( ArrayList<Integer> teams : plan)
			 { 
				 System.out.println(teams.get(o)); 
				 if(teams.size()!=1)
				 {
				 o++; 	
				 }
			 }
		 }
		 */
		 
		 
		 
		 
		 for(int i = 1; i <= size; i++)
		 { int refOf =  Integer.parseInt(request.getParameter("refof"+i)) ; 
		 System.out.println("refOF="+refOf);
				for(int j = 1; j <= ofdao.getMinTeamRequired(refOf)/60; j++)
				 {
					
					
					System.out.print("-"+plan.get(i-1).get(j-1));
					
				 }
				 System.out.println("---"); 
		 }
	}
	
	
	

}

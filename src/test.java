

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OFDao;

/**
 * Servlet implementation class test
 */
public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("/NewFile.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 System.out.println("in TEST SERVLET "); 
		
int size = Integer.parseInt(request.getParameter("sizeof")) ; 
		
		ArrayList<ArrayList<Integer>> plan = new ArrayList<>(); 
		
		OFDao ofdao = new OFDao() ; 
		 int refOf =  Integer.parseInt(request.getParameter("refof2")) ; 
		 System.out.println("refof de :"+refOf +" "+request.getAttribute("ilot5-1")+ "and "+ request.getAttribute("ilot5-2"));
		 System.out.println("refof de :"+refOf +" "+request.getParameter("ilot5-1")+ "and "+ request.getParameter("ilot5-2"));
			
		 
		 /*ArrayList<Integer> teams = new ArrayList<>() ; 
			teams.add((Integer) request.getAttribute("ilot5-1")) ; 
			teams.add((Integer) request.getAttribute("ilot5-2")) ; 
			 plan.add(teams) ;
			 
			 
			 
			 
			 for(int i = 1; i <= plan.size(); i++)
			 {
				 System.out.println("of "+i +" and it has these teams :");
				 for ( ArrayList<Integer> t : plan)
				 {
					 System.out.println(t.get(0)); 
				 }
			 }
			 */
	}

}

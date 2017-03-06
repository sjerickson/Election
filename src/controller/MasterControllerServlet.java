package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ElectionDAO;
import model.ElectionList;

/**
 * Servlet implementation class MasterControllerServlet
 */
@WebServlet("/MasterControllerServlet")
public class MasterControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MasterControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside Master Controller Servlet");
		String actionToPerform = request.getParameter("doThisToItem");
		ElectionDAO dao = new ElectionDAO();
		int tempID = Integer.parseInt(request.getParameter("id"));
		System.out.println(tempID);
		ElectionList selectedElection = dao.getAllElections().get(tempID);
		System.out.println(selectedElection);
		String tempElectionName = selectedElection.getElectionName();
		System.out.println(tempElectionName);
		request.setAttribute("electionName", tempElectionName);
		if(actionToPerform.equals("Vote Now")){
			getServletContext().getRequestDispatcher("/vote.jsp").forward(request, response);
		}else if(actionToPerform.equals("Display Results")){
			getServletContext().getRequestDispatcher("/display-results.jsp").forward(request, response);
		}
	}

}

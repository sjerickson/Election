package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ElectionDAO;

/**
 * Servlet implementation class SubmitVoteOrCancelServlet
 */
@WebServlet("/SubmitVoteOrCancelServlet")
public class SubmitVoteOrCancelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitVoteOrCancelServlet() {
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
		String actionToPerform = request.getParameter("doThisToItem");
		ElectionDAO dao = new ElectionDAO();
		if (actionToPerform.equals("Vote")){
			String tempElectionName = (String)request.getParameter("election");
			int candID = Integer.parseInt(request.getParameter("candidateID"));
			dao.addTally(tempElectionName, candID);
			request.setAttribute("sender", "newVote");
			getServletContext().getRequestDispatcher("/thank-you.jsp").forward(request, response);
		}else if (actionToPerform.equals("Cancel")){
			request.setAttribute("AllElections", dao.getAllElections());
			getServletContext().getRequestDispatcher("/choose-election.jsp").forward(request, response);
		}
	}

}

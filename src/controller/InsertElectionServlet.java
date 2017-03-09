package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ElectionDAO;

/**
 * Servlet implementation class InsertElectionServlet
 */
@WebServlet("/InsertElectionServlet")
public class InsertElectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertElectionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String actionToPerform = request.getParameter("doThisToItem");
		ElectionDAO dao = new ElectionDAO();
		if (actionToPerform.equals("ADD")) {
			String[] election = { (String) request.getParameter("election"), (String) request.getParameter("cand1"),
					(String) request.getParameter("cand2"), (String) request.getParameter("cand3") };
			dao.insertElection(election);
			request.setAttribute("sender", "newElection");
			request.setAttribute("election", (String)request.getParameter("election"));
			getServletContext().getRequestDispatcher("/thank-you.jsp").forward(request, response);
		} else if (actionToPerform.equals("Cancel")) {
			request.setAttribute("AllElections", dao.getAllElections());
			getServletContext().getRequestDispatcher("/choose-election.jsp").forward(request, response);
		}
	}

}

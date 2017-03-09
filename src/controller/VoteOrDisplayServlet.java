package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ElectionDAO;
import model.ElectionList;

/**
 * Servlet implementation class VoteOrDisplayServlet
 */
@WebServlet("/VoteOrDisplayServlet")
public class VoteOrDisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VoteOrDisplayServlet() {
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

		// System.out.println(tempID);

		if (actionToPerform.equals("Vote Now") || actionToPerform.equals("Display Results")) {

			int tempID = Integer.parseInt(request.getParameter("id"));
			ElectionList selectedElection = dao.getAllElections().get(tempID);
			System.out.println(selectedElection);
			String tempElectionName = selectedElection.getElectionName();
			System.out.println(tempElectionName);
			request.setAttribute("electionName", tempElectionName);
			ArrayList<String> candidates = dao.getCandidatesFromElection(tempElectionName);
			String[] tempCandidates = candidates.toArray(new String[3]);
			request.setAttribute("cand1", tempCandidates[0]);
			request.setAttribute("cand2", tempCandidates[1]);
			request.setAttribute("cand3", tempCandidates[2]);

			if (actionToPerform.equals("Vote Now")) {
				getServletContext().getRequestDispatcher("/vote.jsp").forward(request, response);
			} else if (actionToPerform.equals("Display Results")) {
				int[] tallies = dao.getTalliesFromElection(tempElectionName);
				request.setAttribute("cand1tally", tallies[0]);
				request.setAttribute("cand2tally", tallies[1]);
				request.setAttribute("cand3tally", tallies[2]);
				getServletContext().getRequestDispatcher("/display-results.jsp").forward(request, response);
			}
		} else if (actionToPerform.equals("Add New Election")) {
			getServletContext().getRequestDispatcher("/add-election.jsp").forward(request, response);
		}

	}
}

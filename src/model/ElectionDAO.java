package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;

public class ElectionDAO {
	Connection con = null;

	public ElectionDAO() {
		makeConnection();
	}

	public void makeConnection() {

		String url = "jdbc:mysql://localhost:3306/elections";
		String user = "root";
		String password = "DIAD2016";

		try {
			// Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			System.out.println("Connection made");

		} catch (Exception ex) {
			System.out.println("Sql Exception");
		}

	}

	public ArrayList<ElectionList> getAllElections() {
		ArrayList<ElectionList> allItems = new ArrayList<ElectionList>();

		String q = "SELECT * from current_elections";
		try {
			Statement st = (Statement) con.createStatement();
			ResultSet rs = st.executeQuery(q);

			while (rs.next()) {
				// String id = rs.getString(1);
				String electionName = rs.getString(2);
				String candidate1 = rs.getString(3);
				String candidate2 = rs.getString(4);
				String candidate3 = rs.getString(5);
				int cand1tally = Integer.parseInt(rs.getString(6));
				int cand2tally = Integer.parseInt(rs.getString(7));
				int cand3tally = Integer.parseInt(rs.getString(8));
				boolean finalized = Boolean.parseBoolean(rs.getString(9));

				ElectionList tempItem = new ElectionList(electionName, candidate1, candidate2, candidate3, cand1tally,
						cand2tally, cand3tally, finalized);
				allItems.add(tempItem);

				// System.out.println(id + " -- " + store + " -- " + item);
			}
		} catch (SQLException ex) {
			System.out.println("SQL error in getAllItems() method");
			System.out.println(ex.getStackTrace());
		}
		return allItems;

	}

	public HashSet<String> getUniqueElections() {
		ArrayList<String> allElections = new ArrayList<String>();
		for (ElectionList p : getAllElections()) {
			allElections.add(p.getElectionName());
		}
		HashSet<String> uniqueElections = new HashSet<String>(allElections);
		return uniqueElections;
	}

	public ArrayList<String> getCandidatesFromElection(String s) {
		ArrayList<String> allItemsFromSelectedElection = new ArrayList<String>();
		for (ElectionList p : getAllElections()) {
			if (p.getElectionName().equals(s)) {
				allItemsFromSelectedElection.add(p.getCandidate1());
				allItemsFromSelectedElection.add(p.getCandidate2());
				allItemsFromSelectedElection.add(p.getCandidate3());
			}
		}
		return allItemsFromSelectedElection;
	}

	public void insertElection(String[] newElection) {
		String electionName = newElection[0];
		String candidate1 = newElection[1];
		String candidate2 = newElection[2];
		String candidate3 = newElection[3];

		String query = "insert into current_elections (electionName, candidate1, candidate2, candidate3, cand1tally, cand2tally, cand3tally, finalized) "
				+ "values ('" + electionName + "','" + candidate1 + "','" + candidate2 + "','" + candidate3
				+ "', 0, 0, 0, false)";

		System.out.println(query);

		try {
			Statement st = (Statement) con.createStatement();

			st.executeUpdate(query);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addTally(String electionName, int userSelectionIndex) {
		String tempColumn = "cand" + (int) (userSelectionIndex + 1) + "tally";
		String query = "update current_elections set " + tempColumn + " = " + tempColumn + " + 1 where electionName = '"
				+ electionName + "'";
		System.out.println(query);
		try {
			Statement st = (Statement) con.createStatement();

			st.executeUpdate(query);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int[] getTalliesFromElection(String electionName) {
		int tallies[] = new int[3];
		String query = "select cand1tally, cand2tally, cand3tally from current_elections where electionName ='"
				+ electionName + "'";
		System.out.println(query);
		try {
			Statement st = (Statement) con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				tallies[0] = Integer.parseInt(rs.getString(1));
				tallies[1] = Integer.parseInt(rs.getString(2));
				tallies[2] = Integer.parseInt(rs.getString(3));
			}
		} catch (SQLException ex) {
			System.out.println("SQL error in getTalliesFromElection() method");
			System.out.println(ex.getStackTrace());
		}
		return tallies;
	}

	public void finalizeElection(String electionName) {
		String query = "update current_elections set finalized = true where electionName = '" + electionName + "'";
		System.out.println(query);
		try {
			Statement st = (Statement) con.createStatement();
			st.executeUpdate(query);
		} catch (SQLException e) {

		}
	}
	public boolean isFinalized(String election){
//		ArrayList<ListItem> allItems = new ArrayList<ListItem>();
		boolean isFinalized = true;
		
		for (ElectionList p : getAllElections()) {
			if (p.getElectionName().equals(election)) {
				isFinalized = p.isFinalized();
				System.out.println("Election: " + election + " isFinalized: " + isFinalized);
			}
		}
		return isFinalized;
		
	}

}

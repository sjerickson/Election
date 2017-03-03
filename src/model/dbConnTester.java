package model;
/*import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class dbConnTester {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/elections";
		String user = "root";
		String password = "DIAD2016";

		try {
			// Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("Connection made");

			String q = "SELECT * from current_elections";

			Statement st = (Statement) con.createStatement();
			ResultSet rs = st.executeQuery(q);
			ArrayList<ListItem> allItems = new ArrayList<ListItem>();
			while (rs.next()) {
				// String id = rs.getString(1);
				String electionName = rs.getString(2);
				String candidate1 = rs.getString(3);
				String candidate2 = rs.getString(4);
				String candidate3 = rs.getString(5);
				int cand1tally = Integer.parseInt(rs.getString(6));
				int cand2tally = Integer.parseInt(rs.getString(7));
				int cand3tally = Integer.parseInt(rs.getString(8));

				ListItem tempItem = new ListItem(electionName, candidate1, candidate2, candidate3, cand1tally,
						cand2tally, cand3tally);
				allItems.add(tempItem);
			}
			System.out.println(allItems.toString());
		} catch (Exception ex) {
			System.out.println("Sql Exception");
		}

	}

}*/

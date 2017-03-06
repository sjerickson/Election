package model;

import java.util.HashSet;

import javax.swing.JComboBox;

public class Election {
	private String userSelection;
	private int[] tallies;
	private int totalTally = 0;
	private String[] candidates;
	private String electionName;

	public Election(String userSelection, String[] candidates, String electionName) {
		super();
		this.electionName = electionName;
		this.userSelection = userSelection;
		this.candidates = candidates;
	}

	public String getUserSelection() {
		return userSelection;
	}

	public void setUserSelection(String userSelection) {
		this.userSelection = userSelection;
	}

	public int[] getTallies() {
		return tallies;
		
	}

	public void setTallies(int[] tallies) {
		this.tallies = tallies;
	}
	
	public int getTotalTally(){
		return totalTally;
	}

	public String[] getCandidates() {
		return candidates;
	}

	public void setCandidates(String[] candidates) {
		this.candidates = candidates;
	}
	
	public void tally(){
		System.out.println("inside tally()");
		for(int i=0; i<candidates.length; i++){
			if(userSelection.equals(candidates[i])){
				System.out.println("inside tally() if statement");
				ElectionDAO dao = new ElectionDAO();
				dao.addTally(electionName, i);
			}
		}
	}

	public String displayTallies(){
		String message = "The current tallies are: \n";
		ElectionDAO dao = new ElectionDAO();
		int[] tempTallies = dao.getTalliesFromElection(electionName);		
		for(int i = 0; i<tempTallies.length; i++){
			message += candidates[i] + ": " + tempTallies[i] + " \n";
			totalTally += tempTallies[i];
		}
		message += "Total Votes: " + totalTally;
		return message;
	}
	
	
	//from here on down was copied from votingMachine - will have to be redone
	public void populateElectionList() {
		ElectionDAO dao = new ElectionDAO();
		HashSet<String> abc = dao.getUniqueElections();
		String[] electionsList = new String[abc.size()];
		abc.toArray(electionsList);
//		elections = new JComboBox(electionsList);
	}

	public void getCurrentCandidatesList() {
		selectedElection = elections.getSelectedItem().toString();
		ElectionDAO dao = new ElectionDAO();
		currentCandidates = dao.getCandidatesFromElection(selectedElection);
		String[] tempCandidates = currentCandidates.toArray(new String[3]);
		choice1.setText(tempCandidates[0]);
		choice2.setText(tempCandidates[1]);
		choice3.setText(tempCandidates[2]);
	}

	public boolean addNewElection() {
		String tempElectionName = newElectionName.getText();
		String tempCand1 = newCandidate1.getText();
		String tempCand2 = newCandidate2.getText();
		String tempCand3 = newCandidate3.getText();
		if (!tempElectionName.equals("") && !tempCand1.equals("") && !tempCand2.equals("") && !tempCand3.equals("")) {
			ElectionDAO dao = new ElectionDAO();
			String[] electionArray = { tempElectionName, tempCand1, tempCand2, tempCand3 };
			dao.insertElection(electionArray);
		} else {
			return false;
		}
		return true;
	}

	public void finalizeCurrentElection() {
		ElectionDAO dao = new ElectionDAO();
		selectedElection = elections.getSelectedItem().toString();
		dao.finalizeElection(selectedElection);
	}

	public boolean checkIfFinalized() {
		ElectionDAO dao = new ElectionDAO();
		selectedElection = elections.getSelectedItem().toString();
		return dao.isFinalized(selectedElection);
	}

}

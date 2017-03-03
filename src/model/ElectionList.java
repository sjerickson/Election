package model;

public class ElectionList {
	private int electionID;
	private String electionName;
	private String candidate1;
	private String candidate2;
	private String candidate3;
	private int cand1tally;
	private int cand2tally;
	private int cand3tally;
	private boolean finalized;
	
	public ElectionList(String electionName, String candidate1, String candidate2, String candidate3,
			int cand1tally, int cand2tally, int cand3tally, boolean finalized) {
		super();
		//this.electionID = electionID;
		this.electionName = electionName;
		this.candidate1 = candidate1;
		this.candidate2 = candidate2;
		this.candidate3 = candidate3;
		this.cand1tally = cand1tally;
		this.cand2tally = cand2tally;
		this.cand3tally = cand3tally;
		this.finalized = finalized;
	}


	public int getElectionID() {
		return electionID;
	}


	public void setElectionID(int electionID) {
		this.electionID = electionID;
	}


	public String getElectionName() {
		return electionName;
	}


	public void setElectionName(String electionName) {
		this.electionName = electionName;
	}


	public String getCandidate1() {
		return candidate1;
	}


	public void setCandidate1(String candidate1) {
		this.candidate1 = candidate1;
	}


	public String getCandidate2() {
		return candidate2;
	}


	public void setCandidate2(String candidate2) {
		this.candidate2 = candidate2;
	}


	public String getCandidate3() {
		return candidate3;
	}


	public void setCandidate3(String candidate3) {
		this.candidate3 = candidate3;
	}


	public int getCand1tally() {
		return cand1tally;
	}


	public void setCand1tally(int cand1tally) {
		this.cand1tally = cand1tally;
	}


	public int getCand2tally() {
		return cand2tally;
	}


	public void setCand2tally(int cand2tally) {
		this.cand2tally = cand2tally;
	}


	public int getCand3tally() {
		return cand3tally;
	}


	public void setCand3tally(int cand3tally) {
		this.cand3tally = cand3tally;
	}


	public boolean isFinalized() {
		return finalized;
	}


	public void setFinalized(boolean finalized) {
		this.finalized = finalized;
	}
	

	public String toString(){
		return this.electionName + ": " + this.candidate1 + " votes: " + this.cand1tally + " - "+ this.candidate2 + " votes: " + this.cand2tally + " - "+ this.candidate3 + " votes: " + this.cand3tally;
	}
}

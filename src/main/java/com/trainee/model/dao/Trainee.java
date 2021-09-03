package com.trainee.model.dao;

public class Trainee {
	private int traineeID;
	private String traineeName;
	private String Branch;
	private double Percentage;
	
	public Trainee() {}
	public Trainee(String traineeName, String branch, double percentage) {
		this.traineeName = traineeName;
		Branch = branch;
		Percentage = percentage;
	}
	public Trainee(int traineeID, String traineeName, String branch, double percentage) {
		this.traineeID = traineeID;
		this.traineeName = traineeName;
		Branch = branch;
		Percentage = percentage;
	}
	public int getTraineeID() {
		return traineeID;
	}
	public void setTraineeID(int traineeID) {
		this.traineeID = traineeID;
	}
	public String getTraineeName() {
		return traineeName;
	}
	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}
	public String getBranch() {
		return Branch;
	}
	public void setBranch(String branch) {
		Branch = branch;
	}
	public double getPercentage() {
		return Percentage;
	}
	public void setPercentage(double percentage) {
		Percentage = percentage;
	}
	@Override
	public String toString() {
		return "Trainee [traineeID=" + traineeID + ", traineeName=" + traineeName + ", Branch=" + Branch
				+ ", Percentage=" + Percentage + "]";
	}
	
}

package work03;

import java.io.Serializable;
import java.io.SerializablePermission;

import work04.Task1;

public class Task implements Serializable{
	
	private String taskID;
	private int arrivalTime;
	private int startingTime;
	private int serviceTime;
	private int finishingTime;
	private int turnAroundTime;
	private double weightTurnAround;
	
	public Task() {};
	public Task(String taskID,int serviceTime,int arriveTime){
		this.taskID = taskID;
		this.serviceTime = serviceTime;
		this.arrivalTime = arriveTime;
	}
	
	public void setTaskMeber(Task t){
		this.taskID = t.taskID;
		this.serviceTime = t.serviceTime;
		this.arrivalTime = t.arrivalTime;
		this.startingTime = t.startingTime;
		this.finishingTime = t.finishingTime;
		this.turnAroundTime = t.turnAroundTime;
		this.weightTurnAround = t.weightTurnAround;
	}
	
	public String getTaskID() {
		return taskID;
	}
	public void setTaskID(String taskID) {
		this.taskID = taskID;
	}
	public int getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public int getStartingTime() {
		return startingTime;
	}
	public void setStartingTime(int startingTime) {
		this.startingTime = startingTime;
	}
	public int getServiceTime() {
		return serviceTime;
	}
	public void setServiceTime(int serviceTime) {
		this.serviceTime = serviceTime;
	}
	public int getFinishingTime() {
		return finishingTime;
	}
	public void setFinishingTime(int finishingTime) {
		this.finishingTime = finishingTime;
	}
	public int getTurnAroundTime() {
		return turnAroundTime;
	}
	public void setTurnAroundTime(int turnAroundTime) {
		this.turnAroundTime = turnAroundTime;
	}
	public double getWeightTurnAround() {
		return weightTurnAround;
	}
	public void setWeightTurnAround(double d) {
		this.weightTurnAround = d;
	}
	@Override
	public String toString() {
		return "Task [taskID=" + taskID + ", arrivalTime=" + arrivalTime + ", startingTime=" + startingTime
				+ ", serviceTime=" + serviceTime + ", finishingTime=" + finishingTime + ", turnAroundTime="
				+ turnAroundTime + ", weightTurnAround=" + weightTurnAround + "]";
	}

}

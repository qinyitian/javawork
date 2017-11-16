package work04;

import java.io.Serializable;
import java.io.SerializablePermission;

public class Task1 implements Serializable{
	
	private String taskID = "";
	private int arrivalTime = 0;//到达时间
	private int startingTime = 0;//开始时间
	private int serviceTime = 0;//服务时间
	private int finishingTime = 0;//结束时间
	private int turnAroundTime = 0;//周转时间
	private float weightTurnAround = 0;//带权周转时间
	
	public void setTaskMeber(Task1 t){
		this.taskID = t.taskID;
		this.serviceTime = t.serviceTime;
		this.arrivalTime = t.arrivalTime;
		this.startingTime = t.startingTime;
		this.finishingTime = t.finishingTime;
		this.turnAroundTime = t.turnAroundTime;
		this.weightTurnAround = t.weightTurnAround;
	}
	
	public Task1(String taskID,int serviceTime){
		this.taskID = taskID;
		this.serviceTime = serviceTime;
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
	public float getWeightTurnAround() {
		return weightTurnAround;
	}
	public void setWeightTurnAround(float weightTurnAround) {
		this.weightTurnAround = weightTurnAround;
	}
	@Override
	public String toString() {
		return "Task [taskID=" + taskID + ", arrivalTime=" + arrivalTime + ", startingTime=" + startingTime
				+ ", serviceTime=" + serviceTime + ", finishingTime=" + finishingTime + ", turnAroundTime="
				+ turnAroundTime + ", weightTurnAround=" + weightTurnAround + "]";
	}
}

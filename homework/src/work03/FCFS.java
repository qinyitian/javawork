package work03;


import java.util.ArrayList;
import java.util.Random;

public class FCFS {
	private Task[] task = new Task[100];
	private ArrayList<Task> alist = new ArrayList<Task>(); 
	private int[] arr = {6,2,1,3,9};	
	private static String path = "d:\\task.txt";
	private FileSaveAndRead dofile = new FileSaveAndRead();
	//保存任务至文件
	
	//创建任务100
	private void createFile(){
		Random r = new Random();
		int x = 0;
		String taskID = null;
		for(int i=0;i<100;i++){
			x =r.nextInt(4);
			//{6,2,1,3,9}
			taskID = "task_"+String.valueOf(i);
			Task ta = new Task(taskID,arr[x],i);
				
			task[i] = ta;
			
			//Task temp = new Task(taskID,arr[x]);
			
			//dofile.saveTask(temp,path);			
		}
	}
	
	public void print(){
		for(int i=0;i<100;i++){
			if(i%10 == 0){
				System.out.println(task[i].toString());
			}
		}
	}
	//执行任务
	private void dowork(){
		int count = 0;
		int lastcount = count;
		int i = 0;
		
		while(count < 10000)//设置10000防止陷入死循环
		{
			//循环判断是否有满足时间的可加入任务,有则加入有序任务队列
			for(i=0;i<100;i++){
				if(task[i].getArrivalTime() == count){
					alist.add(task[i]);
					task[i].setArrivalTime(count);
					System.out.println(task[i].getTaskID() +" arrive"+" time is "+count);
				}
			}
			//判断当前时间是否等于上个任务完成后的时间，才能进入下一个任务
			if(count == lastcount){
				if(alist.isEmpty() != true){
					Task t = alist.remove(0);
					lastcount = count + t.getServiceTime();
					t.setStartingTime(count);
					System.out.println(t.getTaskID() +" ++++++starting"+" time is "+ count);
				}
				else{
					break;
				}
			}
			count++;
		}
		
	}
	
	//计算权值等属性
	private void account(){
		for(int i=0;i<100;i++){
			task[i].setFinishingTime(task[i].getStartingTime()+task[i].getServiceTime());
			task[i].setTurnAroundTime(task[i].getFinishingTime()-task[i].getArrivalTime());
			task[i].setWeightTurnAround(task[i].getServiceTime()*1.0/task[i].getTurnAroundTime());
			System.out.println(task[i].getTaskID()+": "+task[i].getWeightTurnAround());
		}
	}
	
	public static void main(String[] agr){
		FCFS fc = new FCFS();
		
		fc.createFile();
		//fc.dofile.readTask(fc.task, path);
		
		fc.dowork();
		fc.account();
		fc.print();
		
	}
}

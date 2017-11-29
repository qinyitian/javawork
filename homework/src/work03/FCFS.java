package work03;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class FCFS {
	private Task[] task;
	private ArrayList<Task> alist = new ArrayList<Task>(); 
	private static String path = "d:\\task.txt";
	private FileSaveAndRead dofile = new FileSaveAndRead();

	
	public void print(){
		System.out.println("TaskID      "+"ArriveTime      "+"startingTime    "+"serviceTime     "+"finishingTime   "+"turnAroundTime  "+"weightTurnAround");
		for(int i=0;i<100;i++){
			 
				System.out.printf("%-16s %-16d",task[i].getTaskID(),task[i].getArrivalTime());
				System.out.printf("%-16d %-16d",task[i].getStartingTime(),task[i].getServiceTime());
				System.out.printf("%-16d %-16d",task[i].getFinishingTime(),task[i].getTurnAroundTime());
				System.out.println(task[i].getWeightTurnAround());
			
		}
	}
	//ִ������

	
	private void dowork1(int n){
		int count = 0;

		int i = 0;
		ArrayList<Task> dolist = new ArrayList<Task>();
		
		while(count < 10000)
		{

			if(count<100){
				alist.add(task[count]);
			}
 			if(dolist.size()<n){
 				//System.out.println("工作队列未满");
				if(alist.isEmpty() != true){
					Task t = alist.remove(0);
					
					t.setStartingTime(count);
					dolist.add(t);
					System.out.println(t.getTaskID() +" ++++++starting"+" time is "+ count);
				}
				else{
					break;
				}
			}
			
			for(i=0;i<dolist.size();i++){
				if((dolist.get(i).getStartingTime()+dolist.get(i).getServiceTime())==count){
					Task t = dolist.remove(i);
					System.out.println(t.getTaskID()+" over");
				}
			}
			//System.out.println(count);
			count++;
		}

	}
	
	
	private void dowork2(int n){
		int count = 0;

		int i = 0;
		ArrayList<Task> dolist = new ArrayList<Task>();
		
		while(count < 10000)
		{

			if(count<100){
				alist.add(task[count]);
				Collections.sort(alist,new SortByServiceTime());
				//System.out.println(alist);
			}
 			if(dolist.size()<n){
 				//System.out.println("工作队列未满");
				if(alist.isEmpty() != true){
					Task t = alist.remove(0);
					
					t.setStartingTime(count);
					dolist.add(t);
					System.out.println(t.getTaskID() +" ++++++starting"+" time is "+ count+" servicetime is "+t.getServiceTime());

				}
				else{
					break;
				}
			}
			
			for(i=0;i<dolist.size();i++){
				if((dolist.get(i).getStartingTime()+dolist.get(i).getServiceTime())==count){
					Task t = dolist.remove(i);
					System.out.println(t.getTaskID()+" over");
				}
			}
			//System.out.println(count);
			count++;
		}

	}


	
	private void account(){
		for(int i=0;i<100;i++){
			task[i].setFinishingTime(task[i].getStartingTime()+task[i].getServiceTime());
			task[i].setTurnAroundTime(task[i].getFinishingTime()-task[i].getArrivalTime());
			task[i].setWeightTurnAround(task[i].getServiceTime()*1.0/task[i].getTurnAroundTime());
			//System.out.println(task[i].getTaskID()+": "+task[i].getWeightTurnAround());
		}
	}
	
	public static void main(String[] agr){
		FCFS fc = new FCFS();
		
	
		fc.task = fc.dofile.readData("d:\\input.txt");
		

		
		//fc.dowork1(2);
		fc.dowork2(5);
		fc.account();
		fc.print();
		
	}
}

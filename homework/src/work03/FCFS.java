package work03;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class FCFS {
	private Task[] task = new Task[100];
	private ArrayList<Task> alist = new ArrayList<Task>(); 
	private int[] arr = {6,2,1,3,9};	
	private static String path = "d:\\task.txt";
	private FileSaveAndRead dofile = new FileSaveAndRead();
	//�����������ļ�
	
	//��������100
	private void createFile(){
		Random r = new Random();
		int x = 0;
		String taskID = null;
		for(int i=0;i<100;i++){
			x =r.nextInt(arr.length);
			//{6,2,1,3,9}
			taskID = "task_"+String.valueOf(i);
			Task ta = new Task(taskID,arr[x],i);
				
			task[i] = ta;
			
			//Task temp = new Task(taskID,arr[x]);
			
			//dofile.saveTask(temp,path);			
		}
	}
	
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
	private void dowork(){
		int count = 0;
		int lastcount = count;
		int i = 0;
		
		while(count < 10000)//����10000��ֹ������ѭ��
		{
			//ѭ���ж��Ƿ�������ʱ��Ŀɼ�������,������������������
			for(i=0;i<100;i++){
				if(task[i].getArrivalTime() == count){
					alist.add(task[i]);
					task[i].setArrivalTime(count);
					System.out.println(task[i].getTaskID() +" arrive"+" time is "+count);
				}
			}
			//�жϵ�ǰʱ���Ƿ�����ϸ�������ɺ��ʱ�䣬���ܽ�����һ������
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
	
	private void dowork2(){
		int count = 0;
		int lastcount = count;
		int lastcount2 = count; 
		int i = 0;
		
		while(count < 10000)
		{

			for(i=0;i<100;i++){
				if(task[i].getArrivalTime() == count){
					alist.add(task[i]);
					
					task[i].setArrivalTime(count);
					System.out.println(task[i].getTaskID() +" arrive"+" time is "+count);
				}
			}

			if(count == lastcount){
				if(alist.isEmpty() != true){
					Task t = alist.remove(0);
					lastcount2 = count + t.getServiceTime();
					t.setStartingTime(count);
					System.out.println(t.getTaskID() +" ++++++starting"+" time is "+ count);
				}
				else{
					break;
				}
			}
			
			if(count == lastcount2){
				if(alist.isEmpty() != true){
					Task t = alist.remove(0);
					lastcount2 = count + t.getServiceTime();
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

	private void dowork3(){
		int count = 0;
		int lastcount = count;
		int i = 0;
		
		while(count < 10000)
		{
			for(i=0;i<100;i++){
				if(task[i].getArrivalTime() == count){
					alist.add(task[i]);
					Collections.sort(alist,new SortByServiceTime());
					task[i].setArrivalTime(count);
					System.out.println(task[i].getTaskID() +" arrive"+" time is "+count);
				}
			}
			//点数
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

	
	private void dowork4(){
		int count = 0;
		int lastcount = count;
		int lastcount2 = count; 
		int i = 0;
		
		while(count < 10000)//����10000��ֹ������ѭ��
		{
			//ѭ���ж��Ƿ�������ʱ��Ŀɼ�������,������������������
			for(i=0;i<100;i++){
				if(task[i].getArrivalTime() == count){
					alist.add(task[i]);
					Collections.sort(alist,new SortByServiceTime());
					task[i].setArrivalTime(count);
					System.out.println(task[i].getTaskID() +" arrive"+" time is "+count);
				}
			}
			//�жϵ�ǰʱ���Ƿ�����ϸ�������ɺ��ʱ�䣬���ܽ�����һ������
			if(count == lastcount){
				if(alist.isEmpty() != true){
					Task t = alist.remove(0);
					lastcount2 = count + t.getServiceTime();
					t.setStartingTime(count);
					System.out.println(t.getTaskID() +" ++++++starting"+" time is "+ count);
				}
				else{
					break;
				}
			}
			
			if(count == lastcount2){
				if(alist.isEmpty() != true){
					Task t = alist.remove(0);
					lastcount2 = count + t.getServiceTime();
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
		
		//fc.dowork();
		//fc.dowork2();
		//fc.dowork3();
		fc.dowork4();
		
		fc.account();
		fc.print();
		
	}
}

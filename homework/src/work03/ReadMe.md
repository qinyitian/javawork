代码 
=======================
<1>读取文件内容到对象数组
---------------------------------------------
```java
public Task[] readData(String path){
		File f = new File(path);
		Integer[] arr = new Integer[3];
		String encoding = "utf-8";
		Task[] t = new Task[100];
		String text = null;
		try {
			InputStreamReader read =  new InputStreamReader(new FileInputStream(f),encoding);
			int i = 0;
			int j = 0;
			BufferedReader bread = new BufferedReader(read);

			while((text = bread.readLine()) != null){
				String[] s = text.split("\\s+");
				for(i=0;i<3;i++){
					arr[i] = Integer.parseInt(s[i]);
				}	
				Task ta = new Task(arr[0],arr[2],arr[1]);
				t[j] = new Task(ta);
				j++;
			}
			read.close();
			bread.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}
```
<2>先来先服务对象调度，传入参数决定工作队列数量
---------------------------------------------------------------------
```java
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
			count++;
		}
	}
```
<3>短作业优先对象调度，定义比较器
-----------------------------------------------------------
```java
public class SortByServiceTime implements Comparator {
	public int compare(Object o1,Object o2){
		Task t1 = (Task)o1;
		Task t2 = (Task)o2;
		if(t1.getServiceTime() > t2.getServiceTime())
			return 1;
		else if(t1.getServiceTime() == t2.getServiceTime()){
			return 0;
		}
		return -1;
	}
	
}
```
<4>短作业优先对象调度，传入参数决定工作队列数量
---------------------------------------------------
```java
private void dowork2(int n){
		int count = 0;
		int i = 0;
		ArrayList<Task> dolist = new ArrayList<Task>();
		
		while(count < 10000)
		{
			if(count<100){
				alist.add(task[count]);
				Collections.sort(alist,new SortByServiceTime());
			}
 			if(dolist.size()<n){
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
				if((dolist.get(i).getStartingTime()+
dolist.get(i).getServiceTime())==count){
					Task t = dolist.remove(i);
					System.out.println(t.getTaskID()+" over");
				}
			}
			count++;
		}

	}
```
实验结果截图
=============================================
先来先服务对象调度，一个工作队列（前后截取20个任务）
------------------------------------------------------
![result picture1](https://github.com/qinyitian/javawork/raw/master/img/f11.JPG)<br>
![result picture1](https://github.com/qinyitian/javawork/raw/master/img/12.JPG)<br>
先来先服务对象调度，两个工作队列（前后截取20个任务）
------------------------------------------------------
![result picture1](https://github.com/qinyitian/javawork/raw/master/img/21.JPG)<br>
![result picture1](https://github.com/qinyitian/javawork/raw/master/img/22.JPG)<br>

短作业优先对象调度，一个工作队列（前后截取20个任务）
------------------------------------------------------
![result picture1](https://github.com/qinyitian/javawork/raw/master/img/31.JPG)<br>
![result picture1](https://github.com/qinyitian/javawork/raw/master/img/32.JPG)<br>

短作业优先对象调度，两个工作队列（前后截取20个任务）
------------------------------------------------------
![result picture1](https://github.com/qinyitian/javawork/raw/master/img/41.JPG)<br>
![result picture1](https://github.com/qinyitian/javawork/raw/master/img/42.JPG)<br>

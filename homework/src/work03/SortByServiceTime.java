package work03;

import java.util.Comparator;

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

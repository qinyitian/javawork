package getandsavestudent;

import java.util.Comparator;

public class SortByNum implements Comparator {
	public int compare(Object o1,Object o2){
		Student t1 = (Student)o1;
		Student t2 = (Student)o2;
		if(t1.getNum().compareTo(t2.getNum()) > 0)
			return 1;
		else if(t1.getNum().compareTo(t2.getNum()) == 0){
			return 0;
		}
		return -1;
	}
	
}

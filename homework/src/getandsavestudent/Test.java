package getandsavestudent;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Test {

	public void print(Student[] stu){
		int i = 0;
		while(stu[i]!=null){
			System.out.println(stu[i].toString());
			i++;
		}
	}
	public void printList(ArrayList<Student> alist){
		for(Student i : alist){
			System.out.println(i);
		}
	}
	
	
	public void getMember(ArrayList<Student> alist,Student[] stu){
		int i = 0;
		while(stu[i]!=null){
			alist.add(stu[i]);
			i++;
		}
	}
	
	public static void main(String[] agr) throws FileNotFoundException{
		GetStudent gs = new GetStudent();
		Student[] stu;
		stu = gs.getStudent("d:\\list.txt");
		ArrayList<Student> slist = new ArrayList<Student>();
		Test t = new Test();
		//t.print(stu);
		t.getMember(slist, stu);
		Collections.sort(slist,new SortByNum());
		t.printList(slist);
		
		gs.saveStudent(slist, "d:\\Sortlist.txt");
		
	}
}

package getandsavestudent;

import java.io.FileNotFoundException;

public class Test {

	public static void main(String[] agr) throws FileNotFoundException{
		GetStudent gs = new GetStudent();
		Student[] stu= new Student[100];
		gs.getStudent("d:\\list.txt", stu);
	}
}

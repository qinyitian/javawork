package getandsavestudent;

import java.io.Serializable;

public class Student implements Serializable{
	
	private String num;
	private String name;
	private String sex;
	
	public Student(String Num,String Name,String Sex){
		this.num = Num;
		this.name = Name;
		this.sex = Sex;
	}
	
	public Student(Student s) {
		this.num = s.num;
		this.name = s.name;
		this.sex = s.sex;
	}

	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "Student [num=" + num + ", name=" + name + ", sex=" + sex + "]";
	}
	
}

package getandsavestudent;

import java.io.Serializable;

public class Student implements Serializable{
	
	private String num;
	private String name;
	private String sex;
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

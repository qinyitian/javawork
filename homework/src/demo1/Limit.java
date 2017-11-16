package demo1;

public class Limit {
	public int age;
	private String name;
	int high;
	protected int wight;
	
	public void printPub() {
		System.out.println("This is public method");
	} 
	
	@SuppressWarnings("unused")
	private void printPriv(){
		System.out.println("This is private method");
	}
	
	void printDef(){
		System.out.println("This is default method");
	}
	
	protected void printPro(){
		System.out.println("This is product method");
	}
	
	
}

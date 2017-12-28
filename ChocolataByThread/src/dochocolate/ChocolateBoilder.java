package dochocolate;

public class ChocolateBoilder {

	private static ChocolateBoilder uniqueChocolateBoilder;
	private boolean empty = true;
	private boolean boilder = false;
	
	public ChocolateBoilder(){}
	
	public static ChocolateBoilder getInstance(){
		if(uniqueChocolateBoilder == null){
			uniqueChocolateBoilder = new ChocolateBoilder();
		}
		return uniqueChocolateBoilder;
	}
	public boolean isEmpty(){
		return empty;
	}
	
	public boolean isBoiled(){
		return boilder;
	}
	
	public void fill(){
		if(isEmpty()){
			System.out.println("fill Chocolate and milk");
			empty = false;
		}
	}	
	
	public void boil(){
		if(!isEmpty() && !isBoiled()){
			System.out.println("ChocolateBoilder boil...");
			boilder = true;
		}
	}
	
	public void drain(){
		if(!isEmpty() && isBoiled()){
			System.out.println("drain chocolate and milk");
			empty = true;
			boilder = false;
		}
	}


}

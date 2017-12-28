Make Chocolate By three thread
=================
the chocolate object
------------------------
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
the chocolate fill thread
------------------------
public class Thread1 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<5;i++)
		{	
			ChocolateBoilder.getInstance().fill();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
the chocolate boil thread
------------------------
public class Thread2 implements Runnable {

	@Override
	public void run() {		
		// TODO Auto-generated method stub
		for(int i=0;i<5;i++)
		{	
			ChocolateBoilder.getInstance().boil();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.err.println("123");
			}
		}
	}
}
the chocolate drain thread
------------------------
public class Thread3 implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<5;i++)
		{	
			ChocolateBoilder.getInstance().drain();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.err.println("123");
			}
		}
	}
}


package dochocolate;

public class Test {
	ChocolateBoilder choco = ChocolateBoilder.getInstance();
	public static void main(String[] args){
		new Thread(new Thread1()).start();
		new Thread(new Thread2()).start();
		new Thread(new Thread3()).start();
		
	}
}

package demo02;

public class Thread2 implements Runnable {

	@Override
	public void run() {
		
		// TODO Auto-generated method stub
		for(int i=0;i<5;i++)
		{	
			ChocolateBoilder.getInstance().boil();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.err.println("123");
			}
		}
	}


}

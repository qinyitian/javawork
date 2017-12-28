package dochocolate;

public class Thread3 implements Runnable {

	private ChocolateBoilder choco;
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

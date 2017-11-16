package work04;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MyObjectOutputStream extends ObjectOutputStream {

	public MyObjectOutputStream() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public MyObjectOutputStream(OutputStream out) throws IOException{
		super(out);
	}
	@Override
	protected void writeStreamHeader() throws IOException{
		return;
	}
	
}

package work03;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 * 2017.11.6
 * @author zhuzhongce
 *重写Object ObjectOutputStream，防止写入时未判断文件为新，将头写入，若不写会导致读取第二个对象时出错
 */
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

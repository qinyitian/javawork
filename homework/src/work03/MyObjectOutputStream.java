package work03;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 * 2017.11.6
 * @author zhuzhongce
 *��дObject ObjectOutputStream����ֹд��ʱδ�ж��ļ�Ϊ�£���ͷд�룬����д�ᵼ�¶�ȡ�ڶ�������ʱ����
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

package cstest1;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.*;

public class MyClien extends JFrame { // ������̳�JFrame��
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PrintWriter writer; // ����PrintWriter�����
	Socket socket; // ����Socket����
	private JTextArea ta = new JTextArea(); // ����JtextArea����
	private JTextField tf = new JTextField(); // ����JtextField����
	Container cc; // ����Container����
	
	private BufferedReader reader; // ����BufferedReader����
	
	public MyClien(String title) { // ���췽��
		super(title); // ���ø���Ĺ��췽��
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cc = this.getContentPane(); // ʵ��������

		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new BevelBorder(BevelBorder.RAISED));
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		scrollPane.setViewportView(ta);
		cc.add(tf, "South"); // ���ı�����ڴ�����²�
		tf.addActionListener(new ActionListener() {
			// ���¼�
			public void actionPerformed(ActionEvent e) {
				// ���ı�������Ϣд����
				writer.println(tf.getText());
				// ���ı�������Ϣ��ʾ���ı�����
				ta.append(getSysTime() + "**����** ��\n");
				ta.append("************" +tf.getText() + '\n');
				ta.setSelectionEnd(ta.getText().length());
				tf.setText(""); // ���ı������
			}
		});
	}
	
	public static String getSysTime(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
		return df.format(new Date());// new Date()Ϊ��ȡ��ǰϵͳʱ��	
	}
	
	
	private void connect() { // �����׽��ַ���
		ta.append("��������\n"); // �ı�������ʾ��Ϣ
		try { // ��׽�쳣
			socket = new Socket("192.168.146.1", 8900); // ʵ����Socket����
			writer = new PrintWriter(socket.getOutputStream(), true);
			reader = new BufferedReader(new InputStreamReader(socket
					.getInputStream())); // ʵ����BufferedReader����			
			ta.append("�������\n"); // �ı�������ʾ��Ϣ
			getServerMessage();
		} catch (Exception e) {
			e.printStackTrace(); // ����쳣��Ϣ
		}
	}
	
	private void getServerMessage() {
		writer.println("ipΪ��"+getHostAddress()+" �Ŀͻ������ӳɹ�"+"\n");
		try {
			while (true) { // ����׽���������״̬
				if (reader.ready()) {
					// ��ÿͻ�����Ϣ
					ta.append(getSysTime()+" from ������: \n");
					ta.append("++++++++++"+reader.readLine()+"\n");
				}
			}
		} catch (Exception e) {
			e.printStackTrace(); // ����쳣��Ϣ
		}
		try {
			if (reader != null) {
				reader.close(); // �ر���
			}
			if (socket != null) {
				socket.close(); // �ر��׽���
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getHostAddress(){
		InetAddress ip;
		String localhost = null;
		try{
			
			ip = InetAddress.getLocalHost();
			localhost = ip.getHostAddress();
		}catch(Exception e){
			e.printStackTrace();
		}
		return localhost;
	}
	public static void main(String[] args) { // ������
		MyClien clien = new MyClien("�ͻ��˴���"); // ������������
		clien.setSize(300, 300); // ���ô����С
		clien.setVisible(true); // ��������ʾ
		clien.connect(); // �������ӷ���
	}
}

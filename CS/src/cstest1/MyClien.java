package cstest1;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.*;

public class MyClien extends JFrame { // 创建类继承JFrame类
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PrintWriter writer; // 声明PrintWriter类对象
	Socket socket; // 声明Socket对象
	private JTextArea ta = new JTextArea(); // 创建JtextArea对象
	private JTextField tf = new JTextField(); // 创建JtextField对象
	Container cc; // 声明Container对象
	
	private BufferedReader reader; // 创建BufferedReader对象
	
	public MyClien(String title) { // 构造方法
		super(title); // 调用父类的构造方法
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cc = this.getContentPane(); // 实例化对象

		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new BevelBorder(BevelBorder.RAISED));
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		scrollPane.setViewportView(ta);
		cc.add(tf, "South"); // 将文本框放在窗体的下部
		tf.addActionListener(new ActionListener() {
			// 绑定事件
			public void actionPerformed(ActionEvent e) {
				// 将文本框中信息写入流
				writer.println(tf.getText());
				// 将文本框中信息显示在文本域中
				ta.append(getSysTime() + "**本机** ：\n");
				ta.append("************" +tf.getText() + '\n');
				ta.setSelectionEnd(ta.getText().length());
				tf.setText(""); // 将文本框清空
			}
		});
	}
	
	public static String getSysTime(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		return df.format(new Date());// new Date()为获取当前系统时间	
	}
	
	
	private void connect() { // 连接套接字方法
		ta.append("尝试连接\n"); // 文本域中提示信息
		try { // 捕捉异常
			socket = new Socket("192.168.146.1", 8900); // 实例化Socket对象
			writer = new PrintWriter(socket.getOutputStream(), true);
			reader = new BufferedReader(new InputStreamReader(socket
					.getInputStream())); // 实例化BufferedReader对象			
			ta.append("完成连接\n"); // 文本域中提示信息
			getServerMessage();
		} catch (Exception e) {
			e.printStackTrace(); // 输出异常信息
		}
	}
	
	private void getServerMessage() {
		writer.println("ip为："+getHostAddress()+" 的客户机连接成功"+"\n");
		try {
			while (true) { // 如果套接字是连接状态
				if (reader.ready()) {
					// 获得客户端信息
					ta.append(getSysTime()+" from 服务器: \n");
					ta.append("++++++++++"+reader.readLine()+"\n");
				}
			}
		} catch (Exception e) {
			e.printStackTrace(); // 输出异常信息
		}
		try {
			if (reader != null) {
				reader.close(); // 关闭流
			}
			if (socket != null) {
				socket.close(); // 关闭套接字
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
	public static void main(String[] args) { // 主方法
		MyClien clien = new MyClien("客户端窗口"); // 创建本例对象
		clien.setSize(300, 300); // 设置窗体大小
		clien.setVisible(true); // 将窗体显示
		clien.connect(); // 调用连接方法
	}
}

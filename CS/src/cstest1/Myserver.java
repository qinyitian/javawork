package cstest1;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

public class Myserver extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 11L;
	private PrintWriter writer; // 声明PrintWriter类对象
	Socket socket; // 声明Socket对象
	private JTextArea ta = new JTextArea(); // 创建JtextArea对象
	private JTextField tf = new JTextField(); // 创建JtextField对象
	Container cc; // 声明Container对象
	
	private BufferedReader reader; // 创建BufferedReader对象
	private ServerSocket server; // 创建ServerSocket对象
	
	public Myserver(String title) { // 构造方法
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
				ta.append(getSysTime()+"**本机** ： \n");
				ta.append("************"+tf.getText() + '\n');
				ta.setSelectionEnd(ta.getText().length());
				tf.setText(""); // 将文本框清空
			}
		});
	}
	public static String getSysTime(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		return df.format(new Date());// new Date()为获取当前系统时间	
	}
	

	
	void getserver() {
		try {
			server = new ServerSocket(8900); // 实例化Socket对象
			System.out.println("服务器套接字已经创建成功"); // 输出信息
			ta.append("服务器套接字已经创建成功\n");
			while (true) { // 如果套接字是连接状态
				System.out.println("等待客户机的连接"); // 输出信息
				ta.append("等待客户机的连接....\n");
				socket = server.accept(); // 实例化Socket对象
				reader = new BufferedReader(new InputStreamReader(socket
						.getInputStream())); // 实例化BufferedReader对象
				writer = new PrintWriter(socket.getOutputStream(), true);
				
				getClientMessage(); // 调用getClientMessage()方法
			}
		} catch (Exception e) {
			e.printStackTrace(); // 输出异常信息
		}
	}
	
	private void getClientMessage() {
		try {
			while (true) { // 如果套接字是连接状态
				if (reader.ready()) {
					// 获得客户端信息
					ta.append(getSysTime()+" from 客户端: \n");
					ta.append("++++++++++++"+reader.readLine()+"\n");
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
	
	
	public static void main(String[] args) { // 主方法
		Myserver server = new Myserver("服务器窗口"); // 创建本例对象
		server.setSize(400, 400); // 设置窗体大小
		server.setVisible(true); // 将窗体显示
		server.getserver(); // 调用连接方法
	}
}

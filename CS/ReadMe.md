Chat By Socket
=================
server recieve connect
-----------------------------
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
 
get client message
-------------------------
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
	

client connect
-----------------------------
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
 
get server message 
--------------------------------------
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
 
result picture
==========================
client get connection 
-------------------
![result picture1](https://github.com/qinyitian/javawork/raw/master/img/cs1.JPG)<br>

client and server introduce 
------------------------------
![result picture2](https://github.com/qinyitian/javawork/raw/master/img/cs2.JPG)<br>

client and server chat 
------------------------------
![result picture2](https://github.com/qinyitian/javawork/raw/master/img/cs3.JPG)<br>

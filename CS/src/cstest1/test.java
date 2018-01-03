package cstest1;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test {
	
	public static void main(String[] args) { // 主方法
		InetAddress ip;
		try{
			
			ip = InetAddress.getLocalHost();
			String localhost = ip.getHostAddress();
			System.out.println(getSysTime());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static String getSysTime(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		return df.format(new Date());// new Date()为获取当前系统时间	
	}
}

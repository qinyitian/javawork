package FileIO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestBufferAndNormalIO {

	public static String inpath = "d:\\testtime.txt";
	public static String outpath = "d:\\recive.txt";

	public static void copyFileByBuffered(){
		File inf = new File(inpath); 
		File outf = new File(outpath);
		
		try{
			FileInputStream ios = new FileInputStream(inf);
			FileOutputStream oos = new FileOutputStream(outf);
			BufferedInputStream bios = new BufferedInputStream(ios);
			BufferedOutputStream boos = new BufferedOutputStream(oos);
			
			byte[] b = new byte[100];
			
			while((bios.read(b)) != -1 ){
				boos.write(b);
			}
			ios.close();
			oos.close();
		}catch(IOException e){
			System.err.println(e);
		}
	
		
	}
	
	public static void copyFileByNormal(){
		File inf = new File(inpath); 
		File outf = new File(outpath);
		
		try{
			FileInputStream ios = new FileInputStream(inf);
			FileOutputStream oos = new FileOutputStream(outf);
			byte[] b = new byte[100];
			
			while((ios.read(b)) != -1 ){
				oos.write(b);
			}
			ios.close();
			oos.close();
		}catch(IOException e){
			System.err.println(e);
		}
	
		
	}
	
	
	public static long countNormalTime(){
		
		long begintime = System.currentTimeMillis();
		
		copyFileByNormal();
		
		long endtime = System.currentTimeMillis();
		
		return endtime-begintime;
	}
	
	public static long countBufferedTime(){
		
		long begintime = System.currentTimeMillis();
		
		copyFileByBuffered();
		
		long endtime = System.currentTimeMillis();
		
		return endtime-begintime;
	}

	public static void main(String[] agr){
		File inf = new File(inpath);
		System.out.println("文件大小为  :"+inf.length());
		
		System.out.println("不带缓冲的文件拷贝"+countNormalTime()+" 毫秒");
		
		System.out.println("不带缓冲的文件拷贝"+countBufferedTime()+" 毫秒");
	} 
}

package getandsavestudent;


import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class GetStudent {

	public void getStudent(String path,Student[] stu) throws FileNotFoundException{

		File inf = new File(path);  
		
		FileInputStream ios = new FileInputStream(inf);
		DataInputStream dios = new DataInputStream(ios);

		try{
			
			String[] str = new String[1000];
			StringBuffer sb = null;
			StringBuffer sex = null;
			int count = 0;
			long num = 0l;
			char c;
			char d;
			
			num = dios.readLong();
			while((c = dios.readChar()) != 32){
				sb.append(c);
			}
			while((d = dios.readChar()) != '\n'){
				sex.append(d);
			}
			System.out.println(num+" "+sb+" "+sex);
			ios.close();
			dios.close();
		}catch(IOException e){
			e.printStackTrace();
			System.out.println("123");
		}
		
			

	}
}

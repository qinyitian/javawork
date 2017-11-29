package getandsavestudent;


import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import work03.Task;

public class GetStudent {

	public Student[] getStudent(String path){

			int count;
			File f = new File(path);
			String[] arr = new String[3];
			String encoding = "utf-8";
			Student[] stu = new Student[100];
			Student[] student;
			String text = null;
			try {
				InputStreamReader read =  new InputStreamReader(new FileInputStream(f),encoding);
				int i = 0;
				int j = 0;
				BufferedReader bread = new BufferedReader(read);

				while((text = bread.readLine()) != null){
					String[] s = text.split("\\s+");
					for(i=0;i<3;i++){
						arr[i] = s[i];
					}	
					Student tempstu = new Student(arr[0],arr[2],arr[1]);
					stu[j] = new Student(tempstu);
					j++;
				}
				
				read.close();
				bread.close();
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return stu;
		}
	
	public void saveStudent(ArrayList<Student> stu,String path){
		
		File f = new File(path);
		try {
			FileOutputStream out = new FileOutputStream(f);
			ObjectOutputStream dout;
			try {
				dout = new ObjectOutputStream(out);
				
				dout.writeObject(stu);	
				out.close();
				dout.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}

package work03;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class FileSaveAndRead {


	
	public Task[] readData(String path){
		File f = new File(path);
		Integer[] arr = new Integer[3];
		String encoding = "utf-8";
		Task[] t = new Task[100];
		String text = null;
		try {
			InputStreamReader read =  new InputStreamReader(new FileInputStream(f),encoding);
			int i = 0;
			int j = 0;
			BufferedReader bread = new BufferedReader(read);

			while((text = bread.readLine()) != null){
				String[] s = text.split("\\s+");
				for(i=0;i<3;i++){
					arr[i] = Integer.parseInt(s[i]);
				}	
				Task ta = new Task(arr[0],arr[2],arr[1]);
				t[j] = new Task(ta);
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
		return t;
	}
}

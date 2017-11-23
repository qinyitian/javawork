package work03;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import work04.MyObjectOutputStream;

public class FileSaveAndRead {

	//���ļ���ȡ��100����
	public void readTask(Task[] t, String path){  
        FileInputStream fis = null;  
        ObjectInputStream ois = null;     
        File f = new File(path);  
        try {  
            fis = new FileInputStream(f);  
            ois = new ObjectInputStream(fis);  
            Task task;
            int count = 0;
            while((t[count] = (Task)ois.readObject()) != null){
            	count++;
            }

        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } catch (ClassNotFoundException e) {  
            e.printStackTrace();  
        }finally{  
            try {  
                ois.close();  
                fis.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
    }  
	//����һ���������ļ���
	public void saveTask(Task t,String path){
        FileOutputStream fos = null;  
        ObjectOutputStream oos = null;  
          
        try {  
        	File f = new File(path);	
            fos = new FileOutputStream(f,true);
            if(f.length()<1){
            	oos = new ObjectOutputStream(fos);
            }
            else {
            	oos = new MyObjectOutputStream(fos);	
            }
              
            oos.writeObject(t);    
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }finally{  
            try {  
                oos.close();  
                fos.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
	}
}

package work04;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import work04.Task1;

public class Test {

	public static String path = "d:\\task01.txt";
	private Task1 ta;
	private Task1[] ta1;
	
	private void readTask(String path){  
        FileInputStream fis = null;  
        ObjectInputStream ois = null;     
        File f = new File(path);  
        try {  
            fis = new FileInputStream(f);  
            ois = new ObjectInputStream(fis);
            int count = 0;
            
            	ta = (Task1)ois.readObject();
            	//ta1[count].setTaskMeber(ta);
            	//System.out.println(ta1[2].toString());
            	//	count++;
            	
            	//count++;
     
            //ta[1] = (Task)ois.readObject();
            //强制类型转换  

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
	
	public void saveTask(Task1 t){
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
              
            oos.writeObject(t);    //括号内参数为要保存java对象  
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test t = new Test();
		Task1 task = new Task1("task_055",3);
		
		t.saveTask(task);
		
		t.readTask(path);
		
		System.out.println();
		
	}

}

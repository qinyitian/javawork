package catalog;

import java.io.File;

public class GetCatalog {
	
	static String pre = "";
	
	public static void addTab(File dir){
		if(dir.getParent() != null){
			addTab(dir.getParentFile());
			System.out.print("  ");
		}
		else
			System.out.print("  ");
	} 

	public static void showDir(File dir,int count){
		
		for(int i=0;i<count;i++){
			pre += "\t";
		}
		System.out.println(dir);
		File[] files = dir.listFiles();
		for(File file:files){
			if(file.isDirectory())
				showDir(file,count+1);
			else{
				System.out.println(pre+file);
			}
		}
	}

	public static void main(String[] agr){
		File f = new File("d:\\BaiduYunDownload");
		showDir(f,1);
	}
	
}

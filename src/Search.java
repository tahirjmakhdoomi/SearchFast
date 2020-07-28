import java.io.File;
import java.util.Scanner;

public class Search {
	static int frequency = 0;

	public static void main(String[] args) {
		System.out.println("Enter path: ");
		Scanner s = new Scanner(System.in);
		String path = s.nextLine();
		File master = new File(path);
	
		if(master.exists()) 
		{
			
			System.out.println("Enter File To be searched: ");
			String file = s.nextLine();
			scan(master,file);
			if(frequency==0) {
				System.out.println("No File Found");
			}
			else {
				System.out.println("Frequency: "+frequency);
			}
			
		}else {
			System.out.println("Enter valid path");
		}
	}
	 static void scan(File list,String name) {
		File[] get= list.listFiles();
		
		
		for (int i = 0; i < get.length; i++) {
			
			if(get[i].isFile()&&get[i].getName().equalsIgnoreCase(name)) 
			{
				
				System.out.println(get[i].getAbsolutePath());
				frequency++;
				
				
			}
			if(get[i].isDirectory()) {
				
				File temp = new File(get[i].getAbsolutePath());
				if(!get[i].canRead()) {
					get[i].setReadable(true);
					System.out.println(get[i].getName());
				}
				scan(temp, name);
			}
		}
		
	}

}

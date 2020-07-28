import java.io.File;
import java.util.Date;
import java.util.Scanner;

public class SearchFiles {

	public static void main(String[] args) {
		System.out.print("Please enter a path: ");
		Scanner s = new Scanner(System.in);
		String path = s.nextLine();
		File master = new File(path);

		if(master.exists()) {
		
		System.out.println("####DETAILS OF "+"\""+path+"\""+"###");
		
		File[] list = master.listFiles();
		int noofdir=0;
		int nooffiles=0;
		for (int i = 0; i < list.length; i++) {
			System.out.println("S.No : "+(i+1));
			System.out.println("Resource Name: "+(list[i].getName()));
			 
			if(list[i].isDirectory()) {
				System.out.println("Type : Directory");
				System.out.print("Subdirectory: ");
				
				
				boolean subd = false;
				String named = "";
				
				File sub = new File(list[i].getAbsolutePath());
				File[] submaster = sub.listFiles();
				
				for (int j = 0; j < submaster.length; j++) {
					if(submaster[j].isDirectory()) {
						subd = true;
							named = submaster[j].getName();
							break;
						}						
					}
				if(subd) {
					System.out.println("Yes"+"("+named+")");
				}else {
					System.out.println("No");
				}
				noofdir++;
					
				}
				
			
			if(list[i].isFile()) {
				System.out.println("Type : File");
				long size = list[i].length();
				System.out.println("Size(Bytes): "+size+" Size(KB): "+((double)size/1024));
				long modified = list[i].lastModified();
				Date mod = new Date(modified);
				System.out.println("Modified: "+mod);
				System.out.print("Hidden: ");
				if(list[i].isHidden()) {
					System.out.println("Yes");
				}
				else {
					System.out.println("No");
			
				}
				nooffiles++;
				
			}
			
			System.out.println("-----------------------------------------------");
			System.out.println();
			
		}
		System.out.println("****************************************");
		System.out.println();;
		System.out.println("Total No Of Files"+nooffiles);
		System.out.println("Total No Of Dirs"+noofdir);
		System.out.println("Total Resource: "+(noofdir+nooffiles));
		}
		else {
			System.out.println("Path not valid");
		}
	}
}

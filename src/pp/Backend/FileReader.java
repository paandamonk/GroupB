
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FileReader {
	private String fname;
	private String lname;
	private String age;
	private String sex;
	private File file;
	private int type;
	
	public FileReader(File file, int type) throws FileNotFoundException {
		switch(type) {
		case 0: {
			
			break;
		}
		case 1: {
			
			break;
		}
		case 2: {
			
			break;
		}
		case 3: {
			
			break;
		}
		case 4: {
			
			break;
		}
		case 5: {
			
			break;
		}
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		File names = new File("C:/Users/theme/Desktop/names.txt");
		String line;
		String[] tokens;
		Scanner info = new Scanner(names);

		line=info.nextLine();
	
		while(line!=null)
		{
			tokens = line.split(",");
			System.out.println("First: " + tokens[0] + "Last" + tokens[1]);
	
			line = info.nextLine();
		}
		info.close();
	}
	
	FileReader(){};

	

}

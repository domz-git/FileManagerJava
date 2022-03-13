import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {

	Scanner scanner = new Scanner(System.in);
	public boolean trigger = true;
	public String path = "";
	
	
	public void ReadFile() throws FileNotFoundException {
		
		System.out.println("Welcome to FileManager!");
		
		while(trigger) {
			
			System.out.println("Please enter the path to your file, with including separators.");
			String path = scanner.nextLine();
			
			File file = new File(path);
			String word = "";
			String findWord = "";
			int count = 0;
			
			
			
			if (file.exists()) {
				
				System.out.println("The file has been found!");
				System.out.println("Contents of the file are as follows:");
				System.out.println("-----------------------------------------------------------------------------------------");
				
					String text = "";
				    try {
					    text = new String(Files.readAllBytes(Paths.get("filename.txt")));
					    text = text.replace("\n", "").replace("\r", "");
					    System.out.println(text);
				    } catch (IOException e) {
				    	e.printStackTrace();
				    }
				
					ArrayList<String> mylist = new ArrayList<String>();
					int j = 0;
					
					for (int i = 0; i < text.length(); i++) {
						 
						if(text.charAt(i) != ' ' && text.charAt(i) != ',' && text.charAt(i) != '.') {
							{
								char ch = text.charAt(i);
								word += ch;
							}
							
						}else if( word != "") {
							mylist.add(word);
							word = "";
						}
						
						
			            
			        }
					
					System.out.print(text);
					
			    
					for (String word2 : mylist) 
					{ 
					    System.out.println(word2);
					}
					
					for (int i = 0; i < mylist.size(); i++) {
						findWord = mylist.get(i);
						for (int k = 1; k < mylist.size(); k++) {
							if (mylist.get(k)==findWord) {
								count++;
							}
						}
					}
				
				
			trigger = false;
			}else {
				System.out.println("An error has occured, the file has not been found!");
			}
			
		}
		
		
		
	}
	
}

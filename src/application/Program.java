package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {	
	

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);			
		

		System.out.print("Enter the full path of the file: " );
		
		String absolutePath = new File("").getAbsolutePath();
		String path = absolutePath + File.separator  + "\\src\\application\\votes.csv";
		
		// String path = input.nextLine();		
		
		// order by natural order of adding the elements to the Map
		Map<String, Integer> votes = new LinkedHashMap<String, Integer>();

		System.out.println("\n");
		
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {

			String line = bufferedReader.readLine();
			while (line != null) {
				String[] fields = line.split(",");
				String userName = fields[0];
				Integer count = Integer.valueOf(fields[1]);

				if (votes.containsKey(userName) == true) {
					int volesUntilNow = votes.get(userName);
					votes.put(userName, count + volesUntilNow);
				}
				// in case it is a new username 
				else {
					votes.put(userName, count);
				}

				line = bufferedReader.readLine();
			}
			
			for(String userName : votes.keySet()) {
				System.out.println(userName + ": " + votes.get(userName));
			}

		} catch (IOException error) {
			System.out.println("Error: " + error.getLocalizedMessage());
		}

		input.close();

	}

}
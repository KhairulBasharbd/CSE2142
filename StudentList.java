import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {

	static String read(){
		String a = null;
		try {
			BufferedReader s = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
			a = s.readLine();
		} catch(Exception e){}
		return a;
	}

	static void write(String w){

		try {
			BufferedWriter s = new BufferedWriter(new FileWriter("students.txt", true));
			Date d = new Date();
			String df = "dd/mm/yyyy-hh:mm:ss a";
			DateFormat dateFormat = new SimpleDateFormat(df);
			String fd = dateFormat.format(d);
			s.write(", " + w + "\nList last updated on " + fd);
			s.close();
		} catch(Exception e){}

	}
		





	public static void main(String[] args) {

		// Check arguments
		if (args[0].equals("a")) {

			System.out.println("Loading data ...");
			String fileText = read();
			String student[] = fileText.split(",");

			for (String j : student) {
				System.out.println(j);
			}
			System.out.println("Data Loaded.");
		} 

		
		else if (args[0].equals("r")) {

			System.out.println("Loading data ...");

				String fileText  = read();
				//System.out.println(fileText );
				String student[] = fileText .split(",");
				Random x = new Random();
				int y = x.nextInt(student.length);
				System.out.println(student[y]);
			

			System.out.println("Data Loaded.");
		} 

		
		else if (args[0].contains("+")) {

			System.out.println("Loading data ...");
			String newStudent = args[0].substring(1);
			write(newStudent);
			System.out.println("Data Loaded.");
		} 
		
		
		else if (args[0].contains("?")) {

			System.out.println("Loading data ...");

				String fileText =read();
				String student[] = fileText.split(",");
				boolean done = false;
				String searchStudent = args[0].substring(1);

				for (int idx = 0; idx < student.length && !done; idx++) {

					if (student[idx].equals(searchStudent)) {
						System.out.println("We found it!");
						done = true;
					}
				}

			System.out.println("Data Loaded.");
		} 
		
		
		else if (args[0].contains("c")) {

			System.out.println("Loading data ...");

				String fileText = read();
				char a[] = fileText.toCharArray();
				boolean in_word = false;
				int count = 0;

				for (char c : a) {

					if (c == ' ') {

						if (!in_word) {
							count++;
							in_word = true;
						} 
						
						else {
							in_word = false;
						}
					}
				}
				System.out.println(count + " word(s) found " + a.length);

			System.out.println("Data Loaded.");
		}


		else {
			System.out.println(" You enter a wrong argument");
			return;
		}
	}
}
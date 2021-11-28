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

	

		
		if (args[0].equals("a") || args[0].equals("r") ||  args[0].contains("+") || args[0].contains("?") || args[0].contains("c")){
			System.out.println("Enter Correct argument..");
			//return 0;
			System.exit(0);

		}
			
		Constants cons = new Constants();

		// Check arguments
		if (args[0].equals("a")) {

			System.out.println(cons.a);
			String student[] = read().split(",");

			for (String j : student) {
				System.out.println(j);
			}
			System.out.println(cons.b);
		} 

		
		else if (args[0].equals("r")) {

			System.out.println(cons.a);

				String student[] = read().split(",");
				Random x = new Random();
				int y = x.nextInt(student.length);
				System.out.println(student[y]);
			
				System.out.println(cons.b);
		} 

		
		else if (args[0].contains("+")) {

			System.out.println(cons.a);
			write(args[0].substring(1));
			System.out.println(cons.b);
		} 
		
		
		else if (args[0].contains("?")) {

			System.out.println(cons.a);

				String student[] = read().split(",");
				//boolean done = false;
				for (int idx = 0; idx < student.length; idx++) {

					if (student[idx].trim().equals(args[0].substring(1))) {
						System.out.println("We found it!");
						break;
					}
				}

				System.out.println(cons.b);
		} 
		
		
		else if (args[0].contains("c")) {

			System.out.println(cons.a);

			String student[] = read().split(",");
			
			System.out.println(student.length + " word(s) found ");
			System.out.println(cons.b);
		}


		// else {
		// 	System.out.println(" You enter a wrong argument. please Run Again..");
		// 	return;
		// }
	}
}
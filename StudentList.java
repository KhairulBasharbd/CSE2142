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
	}//This function is used to read a text file as string.

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

	}//This function is used to write a string in text file.
		





	public static void main(String[] args) {

	

		
		if (args[0].equals("a") || args[0].equals("r") ||  args[0].contains("+") || args[0].contains("?") || args[0].contains("c")){
			System.out.println("Enter Correct argument..");
			System.exit(0);

		}//checking argument
			
		Constants cons = new Constants();//creating object of Constants class.

		
		if (args[0].equals("a")) {

			System.out.println(cons.a);
			String student[] = read().split(",");//spliting the text of file as single student.

			for (String j : student) {
				System.out.println(j);
			}//printing all single student in text file.

			System.out.println(cons.b);
		} //checking argument

		
		else if (args[0].equals("r")) {

			System.out.println(cons.a);

				String student[] = read().split(",");//spliting the text of file as single student.
				Random x = new Random();//creating object of random class.
				int y = x.nextInt(student.length);//generate random number.
				System.out.println(student[y]);//printing random student from text file.
			
				System.out.println(cons.b);
		} //checking argument

		
		else if (args[0].contains("+")) {

			System.out.println(cons.a);
			write(args[0].substring(1));//calling write function to write any student in text file.
			System.out.println(cons.b);
		} //checking argument
		
		
		else if (args[0].contains("?")) {

			System.out.println(cons.a);

				String student[] = read().split(",");//spliting the text of file as single student.
			
				for (int idx = 0; idx < student.length; idx++) {

					if (student[idx].trim().equals(args[0].substring(1))) {
						System.out.println("We found it!");
						break;
					}
				}//searching a student in text file.

				System.out.println(cons.b);
		} //checking argument
		
		
		else if (args[0].contains("c")) {

			System.out.println(cons.a);

			String student[] = read().split(",");//spliting the text of file as single student.
			
			System.out.println(student.length + " word(s) found ");//print the number of single student.
			System.out.println(cons.b);
		}//checking argument

	}
}
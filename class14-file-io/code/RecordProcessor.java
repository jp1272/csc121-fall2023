
import java.io.*;     //    IO = input/output
import java.util.*;   //    Scanner

public class RecordProcessor {

	public static void main(String[] args) {
		// standard output    ===== "console/terminal" display on the user's screen
		System.out.println("Processing Temperature Data");
		
		boolean isSuccess = false;
		while ( ! isSuccess ) {
			try {
				isSuccess = processFile();	
			} catch (FileNotFoundException exc) {
				//exc.printStackTrace();
				System.out.println("Could not find file: " + exc.getMessage());
			}
		}
	}
	
	
	public static boolean processFile() throws FileNotFoundException {
		BasicDailyRecord bdr = new BasicDailyRecord();

		System.out.println("Enter a file name: ");
		
		// standard input    ===== user's keyboard input
		Scanner kb = new Scanner(System.in);
		String filename = kb.nextLine();

		// open the data file
		Scanner sc = new Scanner(new File(filename));

		// open an output file
		PrintWriter pw = new PrintWriter(new File("output.txt"));
		
		// read in lines of the file and record in bdr
		
		while ( sc.hasNextInt() ) {
			int hour = sc.nextInt();
			int temp = sc.nextInt();
			bdr.recordTemp(hour, temp);
		}
		
		// write out summary of high, low, average data to the output file
		pw.println("High: " + bdr.getHigh());
		pw.println("Low:  " + bdr.getLow());
		pw.println("Avg:  " + bdr.getAverage());
		pw.println("-----");
		
		/*  for ( initialization ; condition ; update ) { ... }   */
		for ( int hour = 0 ; hour < 24 ; hour++ ) {  /*  hour = hour + 1    ====    hour += 1    =====    hour++   */
			if (bdr.hasTemp(hour)) {
				pw.println(hour + ": " + bdr.getTemp(hour));
			}
		}
		
		/*
		int hour = 0;				// <--- initialization 
		while (hour < 24) 			// <--- condition
			if (bdr.hasTemp(hour)) {
				pw.println(hour + ": " + bdr.getTemp(hour));
			}
			hour = hour + 1;		// <--- update
		}
		*/

		// close/save files
		sc.close();
		pw.close();	
		
		return true;
	}

}

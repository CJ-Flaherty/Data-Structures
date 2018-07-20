import java.util.Scanner;
import java.io.*;
import java.util.Arrays;
public class DecodeDriver {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Message[] messages = new Message[6];
		for(int i=0; i < args.length;i++) {
		System.out.println("Reading and Decoding encoded" + i + ".txt");
		String code = getCode(args[i]);
		Message msg = new Message(code);
		Integer[] freqs = Decode.getfreq(code);
		String decoded = Decode.Replace(code, freqs);
		msg.setdecoded(decoded);
		String outfile = "decoded" + i +".txt";
		BufferedWriter out = new BufferedWriter(new FileWriter(outfile));
		out.write(msg.getdecoded());
		out.close();
		messages[i] = msg;
		System.out.println("Message in decoded" + i + ".txt: " + msg.getdecoded());
		}
		
		


		
		
		
		
	}
	
	public static String getCode(String file) throws FileNotFoundException { //not really sure about this throws thing but eclipse did it for me so
			//reads in each encoded file, returning a string (Maybe could be in decode?)
			Scanner reader = new Scanner(new FileInputStream(file));
			 String code = reader.useDelimiter("\\A").next(); //found this on stackoverflow
			 reader.close();                                //to read file to string
			 return code;
	
	
		
	}
		
	}

/*  1. Preamble to the declaration of independence
 * 
 * 2. Alice's adventures in wonderland
 * 
 * 3. Sherlock Holmes
 * 
 * 4. Adventures of Huckleberry Finn
 * 
 * 5. Pride and Prejudice??
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */

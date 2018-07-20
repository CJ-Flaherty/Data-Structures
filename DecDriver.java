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
	
	public static String getCode(String file) throws FileNotFoundException { 
			//reads in each encoded file, returning a string (Maybe could be in decode?)
			Scanner reader = new Scanner(new FileInputStream(file));
			 String code = reader.useDelimiter("\\A").next(); //found this on stackoverflow
			 reader.close();                                //to read file to string
			 return code;
	
	
		
	}
		
	}



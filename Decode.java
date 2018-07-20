import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
public class Decode {
	
	public static Integer[] getfreq(String code) {
	 //gets the frequencies of each character in the string passed as argument
	 Integer[] codefrequencies = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}; //had to declare explicitly because default
	 																					//Integer object is null
	 
	 for(char i = 'a'; i<= 'z'; i++) {

		for(int j = 0; j < code.length(); j++) {
			 if(code.charAt(j) == i) {
				 codefrequencies[i  - 97]++;
			 }
		 }
		 
		 
	 }
	 return codefrequencies;
	}
	
	public static String Replace(String code, Integer[] freq) {
		//replaces the most frequently occurring character in string with most frequently occurring character in english
		//see readme for an explanation of this
		int replaceindex = 0;
		char[] standardfrequencies = {'e','t', 'a', 'o', 'i', 'n', 's' ,'h', 'r','d','l','u','c', 'm', 'f', 'w', 'y', 'p', 'v', 'b', 'g', 'k', 'q','j','x','z'};
		char[] chars = code.toCharArray();
		char[] decode = new char[chars.length];
		for(int i = 0; i < standardfrequencies.length; i++) {
			int[] arr = getMax(freq);
			char ascii = (char)(arr[1] + 97);
			
			for(int j = 0; j < chars.length;j++) {
				if (chars[j] == ascii) {
					decode[j] = standardfrequencies[replaceindex];
				}
				if (Character.isLetter(chars[j]) == false) {
					decode[j] = chars[j];
				}
				
			}
			replaceindex++;
			freq[arr[1] ] = 0;
				}
		
		String decodestring = new String(decode);
				
			
		return decodestring;
		
	}
	
	
	public static int[] getMax(Integer[] freq) {
		//returns how many times the most frequent character occurs, and its index
		//see readme for why this is needed
		int[] answer = {0,0};
		int max = 0;
		for(int j = 0; j <freq.length;j++) { //get the max from freq 
			if (freq[j] > max) {
				max = freq[j];
				int maxindex = j;
				answer[0] = max;
				answer[1] = maxindex;
				}

			}
	return answer;
	}
}



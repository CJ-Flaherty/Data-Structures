import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.LineNumberReader;

public class SpellChecker {

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		String name = args[0];
		File dict = new File(name);
		QuadraticProbingHashTable<String> dictable = add(dict);
		System.out.println("Please enter a file to spell check>>");
		String docname = scan.nextLine();
		File doc = new File(docname);
		System.out.println("Print words (p), enter new file (f), or quit (q) ?");
		String choice = scan.next();
		QuadraticProbingHashTable<Word> mwords = new QuadraticProbingHashTable<Word>();
		if(choice.equals("p")) {
			mwords = addmisspelled(doc, dictable);
			interact(doc, mwords, dictable);
		}
		if(choice.equals("f")) {
			docname = scan.nextLine();
			doc = new File(docname);
			mwords = addmisspelled(doc, dictable);
			interact(doc, mwords, dictable);
			write(doc, docname, mwords, dictable);
		}
		if(choice.equals("q")) {
			System.exit(0);
		}
		
		write(doc, docname, mwords, dictable);
		writeorder(doc, docname, mwords, dictable);
		scan.close();
		
		
		
		

	}
	
	public static QuadraticProbingHashTable<String> add(File f) throws FileNotFoundException{ //adds dictionary to hashtable
		QuadraticProbingHashTable<String> table = new QuadraticProbingHashTable<String>();
		Scanner sc = new Scanner(f);
		while(sc.hasNext()) {
		String seq = sc.next();
		seq = clean(seq);
		if(seq != "") {
			table.insert(seq);
			}
			}
		sc.close();
		return table;
	}

	public static String clean(String str) {
		//gets rid of non digit or letter chars
		String cleaned = "";
		char[] strarr = str.toCharArray();
		for(int i=0; i < strarr.length;i++) {
			if(Character.isLetterOrDigit(strarr[i]))
				cleaned += strarr[i];
			
		}
		
		cleaned = cleaned.toLowerCase();
		
		return cleaned;
	}
	
	public static QuadraticProbingHashTable<Word> addmisspelled(File f, QuadraticProbingHashTable<String> t)
	throws FileNotFoundException{
		//adds misspelled words to hashtable
		QuadraticProbingHashTable<Word> table = new QuadraticProbingHashTable<Word>();
		Scanner sc = new Scanner(f);
		sc.useDelimiter(" ");
		int linenum = 0;
		while(sc.hasNext()) {
		String seq = sc.next();
		String newline = System.getProperty("line.separator");
		if(seq.contains(newline)) {
			linenum++;
		}
		seq = clean(seq);
		if(seq != "" && t.contains(seq) == false) {
			Word w = new Word(seq);
			if(table.contains(w) == false) {
			getSuggestions(w, t);
			w.setLineNumber(linenum);
			table.insert(w);
			}
			}
		}
		sc.close();
		return table;
	}
	
	public static void getSuggestions(Word w, QuadraticProbingHashTable<String> dict) {
		//generates suggestions for misspelled words
		String seq0 = clean(w.getWord());
		char[] seq = seq0.toCharArray();
		String seq1 = w.getWord();
		swap(seq0, w, dict);
		delete(seq0, w, dict);
		replace(seq0, w, dict);
		insert(seq0, w, dict);
		split(seq0, w, dict);
		
		
		
		
	}
	
	public static void swap(String seq, Word w, QuadraticProbingHashTable<String> dict) {	
		for(int i=0; i <seq.length() -1 ;i++) { //swaps
			char[] seq2 = seq.toCharArray();
			char temp = seq2[i+1];
			seq2[i+1] = seq2[i];
			seq2[i] = temp;
			String check = new String(seq2);
			deleter(check, w, dict);
			replacer(check, w, dict);
			insertr(check, w, dict);
			splitr(check, w, dict);
			
			if( dict.contains(check)){
				w.addSuggestion(check);
				
			}
		}
			
			
			
		}
	
	public static void delete(String seq1, Word w, QuadraticProbingHashTable<String> dict){
		for(int i = 0; i <seq1.length();i++) { // deletes 
			String s = seq1.substring(0,i) + seq1.substring(i+1, seq1.length());
			swapr(s, w, dict);
			replacer(s, w, dict);
			insertr(s, w, dict);
			splitr(s, w, dict);
			
			if(dict.contains(s)) {
				w.addSuggestion(s);
			}
		}
	}
		public static void replace(String seq0, Word w, QuadraticProbingHashTable<String> dict) {
		for(int i = 0; i < seq0.length(); i++) { //replacements
			for(char c = 'a'; c <= 'z';c++) {
				char[] seq2 = seq0.toCharArray();
				seq2[i] = c;
				String check = new String(seq2);
				swapr(check, w, dict);
				deleter(check, w, dict);
				insertr(check, w, dict);
				splitr(check, w, dict);
				
				if( dict.contains(check)){
					w.addSuggestion(check);
				}
				
			}
		}
	}
		public static void insert(String seq1, Word w, QuadraticProbingHashTable<String> dict) {
		for(int i = 0; i <seq1.length() +1 ; i++) { //insertions
			for(char c = 'a'; c <= 'z'; c++) {
				String s = seq1.substring(0,i) + c + seq1.substring(i, seq1.length());
				swapr(s, w, dict);
				deleter(s, w, dict);
				replacer(s, w, dict);
				splitr(s, w, dict);
				
				if(dict.contains(s)) {
					w.addSuggestion(s);
				}
				
			}
		}
	}
		
		public static void split(String seq1, Word w, QuadraticProbingHashTable<String> dict) {
		for(int i = 0; i <seq1.length();i++) { // splits 
			String s = seq1.substring(0,i);
			String t = seq1.substring(i, seq1.length());
			String sug = s + " " + t;
			swapr(sug, w, dict);
			deleter(sug, w, dict);
			replacer(sug, w, dict);
			insertr(sug, w, dict);
			splitr(sug, w, dict);
			
			if(dict.contains(s) && dict.contains(t)) {
				
				w.addSuggestion(sug);
			}
		}
	}
		//all these "-r" methods are used to prevent infinite loops
		
		public static void swapr(String seq, Word w, QuadraticProbingHashTable<String> dict) {	
			for(int i=0; i <seq.length() -1 ;i++) { //swaps
				char[] seq2 = seq.toCharArray();
				char temp = seq2[i+1];
				seq2[i+1] = seq2[i];
				seq2[i] = temp;
				String check = new String(seq2);
				
				if( dict.contains(check)){
					w.addSuggestion(check);
					
				}
			}
		}
		
		public static void deleter(String seq1, Word w, QuadraticProbingHashTable<String> dict){
			for(int i = 0; i <seq1.length();i++) { // deletes 
				String s = seq1.substring(0,i) + seq1.substring(i+1, seq1.length());
				
				if(dict.contains(s)) {
					w.addSuggestion(s);
				}
			}
		}
		
		public static void replacer(String seq0, Word w, QuadraticProbingHashTable<String> dict) {
		for(int i = 0; i < seq0.length(); i++) { //replacements
			for(char c = 'a'; c <= 'z';c++) {
				char[] seq2 = seq0.toCharArray();
				seq2[i] = c;
				String check = new String(seq2);
				
				if( dict.contains(check)){
					w.addSuggestion(check);
				}
				
			}
		}
	}
		
		public static void insertr(String seq1, Word w, QuadraticProbingHashTable<String> dict) {
		for(int i = 0; i <seq1.length() +1 ; i++) { //insertions
			for(char c = 'a'; c <= 'z'; c++) {
				String s = seq1.substring(0,i) + c + seq1.substring(i, seq1.length());
				
				if(dict.contains(s)) {
					w.addSuggestion(s);
				}
				
			}
		}
		}
		
		public static void splitr(String seq1, Word w, QuadraticProbingHashTable<String> dict) {
		for(int i = 0; i <seq1.length();i++) { // splits 
			String s = seq1.substring(0,i);
			String t = seq1.substring(i, seq1.length());
			String sug = s + " " + t;
			
			if(dict.contains(s) && dict.contains(t)) {
				
				w.addSuggestion(sug);
			}
		}
	}
	
				
				
				
			
		
		
		
		
			
			
			
		
		
		


	
	
	public static void interact(File doc, QuadraticProbingHashTable<Word> m, QuadraticProbingHashTable<String> d) throws IOException {
		//gets users input for each misspelled word
		Scanner sc = new Scanner(doc);
		Scanner scan = new Scanner(System.in);
		sc.useDelimiter(" ");
		LineNumberReader num = new LineNumberReader(new FileReader(doc));
		int linenum = 0;
		while(sc.hasNext()) {
		String seq = sc.next();
		String newline = System.getProperty("line.separator");
		if(seq.contains(newline)) {
			linenum++;
		}
		seq = clean(seq);
		if(!d.contains(seq)) {
			Word w = new Word(seq);
			Word w1 = m.get(w);
			if(!w1.getIgnore() && w1.getReplace() == null) {
				System.out.println("--" +w1.getWord() + " " + linenum);
				System.out.println("ignore all (i), replace all (r), next(n), or quit (q)?");
				String choice = scan.next(); 
				if(choice.equals("\n")) {
				}
				if(choice.equals("i")) {
					w1.setIgnore(true);
				}
				if(choice.equals("r")) {
					int i = 0;
					while(w1.getReplaceOptions()[i] != null) {
						System.out.println("replace with: " + "(" + i + ")" +w1.getReplaceOptions()[i]);
						i++;
					}
					if(w1.getReplaceOptions()[0] == null) {
						System.out.println("There's nothing to replace it with.");
					}
					if(w1.getReplaceOptions()[0] != null) {
					int r = scan.nextInt();
					w1.setReplace(w1.getReplaceOptions()[r]);
					}
				}
				if(choice.equals("n"))
				
				if(choice.equals("q")) {
					System.out.println("Goodbye!");
					System.exit(0);
			}
			
		}
			
		}
	}
		
		System.out.println("Spell Check Complete!");
		sc.close();
		scan.close();
		num.close();


		
	}
	
	public static void write(File doc, String name,  QuadraticProbingHashTable<Word> m,  QuadraticProbingHashTable<String> d) throws IOException {
		//writes the corrected file
		Scanner sc = new Scanner(doc);
		String outfile = name.replace(".txt", "_corrected.txt");
		BufferedWriter out= new BufferedWriter(new FileWriter(outfile));
		sc.useDelimiter(" ");
		while(sc.hasNext()) {
			String s = sc.next();
			s = clean(s);
			if(!d.contains(s)) {
				Word w = new Word(s);
				Word w1 = m.get(w);
				s = w1.getReplace();
				if(s == null) {
					s = w1.getDefReplace();
				}

				
			}
			out.write(s);
			out.write(" ");
			
			
			
		}
		
		sc.close();
		out.flush();
		out.close();
		
		
	}
	
	public static void writeorder(File doc, String name,  QuadraticProbingHashTable<Word> m,  QuadraticProbingHashTable<String> d) throws IOException {
		//writes the order file
		Scanner sc = new Scanner(doc);
		String outfile = name.replace(".txt", "_order.txt");
		BufferedWriter out= new BufferedWriter(new FileWriter(outfile));
		LineNumberReader num = new LineNumberReader(new FileReader(doc));
		while(sc.hasNext()) {
			String s = sc.next();
			s = clean(s);
			Word w = new Word(s);
			Word w1 = m.get(w);
			if(!d.contains(s) && w1 != null) {
				out.write(w1.getWord() + " " + w1.getLineNumber());
				out.newLine();
			}
				
			}
		out.flush();
		out.close();
		sc.close();
		num.close();
	}
}




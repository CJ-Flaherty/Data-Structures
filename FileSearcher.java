import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class FileSearcher {

	public static void main(String[] args) throws FileNotFoundException {
		BinarySearchTree<Word> tree = new BinarySearchTree<Word>();
		String name = args[0];
		File folder = new File(name);
		scanFiles(folder, tree);
		Scanner scan = new Scanner(System.in);
		String choice = "";
		while(choice != "q") {
		System.out.println("Please enter a command (a, s, or q)>>");
		choice = scan.next();
		if(choice.equals("q"))
			System.exit(0);
		if(choice.equals("a")) {
			BinaryNode<Word> root = tree.root;
			inorder(root);
		}
		if(choice.equals("s")) {
			System.out.println("Word to find>> ");
			String w = scan.next();
			Word temp = new Word(w);
			if(tree.contains(temp)) {
				Word wo = tree.find(temp);
				String files = "";
				for(int i = 0; i <wo.getfiles().length; i++) {
					String fi = wo.getfiles()[i];
					if(fi != null) {
					fi += " ";
					files += fi;
					}
				}
				System.out.println("Files containing " + wo.getword() + ": " + files);
			}	

			else {
				System.out.println(w + " is not found");
			}
		}
		

		}
		
		
		
		scan.close();
		System.exit(0);
		
		
		

	}
	
	public static void scanFiles(File folder, BinarySearchTree<Word> tree ) throws FileNotFoundException {
		//for a given folder and tree, adds all words in the folder and sub
		//directories of folder to the bst, and adds files to each words files data field
		File[] list = folder.listFiles();
		for(int i=0; i <list.length; i++) {
			File file = list[i];
			if(!file.isHidden()) {
				if(file.isDirectory()) {
					scanFiles(file, tree);
				}
				if(file.isFile()) {
					Scanner sc = new Scanner(file);
					sc.useDelimiter(" ");
					while(sc.hasNext()) {
					String seq = sc.next();
					seq = clean(seq);
					if(seq != "") {
						Word w = new Word(seq);
						if(tree.contains(w)) {
							Word ourword = tree.find(w);
							String fname = file.getName();
							ourword.add(fname);
						}
					
					
						if(!tree.contains(w)) {
							tree.insert(w);
							String fname = file.getName();
							w.add(fname);
						}
					}
					
						
					}
					sc.close();
					
				}
				
				
			}
			
		}

	}
	public static String clean(String str) {
		//gets rid of non digit or letter chars
		String cleaned = "";
		char[] strarr = str.toCharArray();
		for(int i=0; i < strarr.length;i++) {
			if(Character.isLetterOrDigit(strarr[i]))
				cleaned += strarr[i];
			
		}
		
		return cleaned;
	}
	
	public static void inorder(BinaryNode<Word> root) {
		//traverses the tree in order, printing for each element its files data field
		if(root==null)
			return;
		inorder(root.left);
		String files = "";
		for(int i = 0; i < root.element.getfiles().length;i++) {
			String f =  root.element.getfiles()[i];
			if(f!= null) {
				f += " ";
				files += f;
			}
		}
		System.out.println("files containing " + root.element.getword() +": " + files);
		inorder(root.right);
		}
		
}



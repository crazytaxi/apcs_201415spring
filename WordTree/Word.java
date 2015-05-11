import java.io.*;

public class Word {
	public static void main (String[] args) {
		WordTree index = new WordTree ();
		try{
			BufferedReader read = new BufferedReader (new FileReader(args[0]));
			String line;
			while ((line = read.readLine()) != null) {
				index.add(line + "\0", index);
			}
			read.close();
			System.out.println("The height of this tree is: " + index.height());
			System.out.println("A random word from the tree: " + index.getRandomWord());
			System.out.println("The total number of words in the tree: " + index.getCount());
			System.out.println("Number of words with the prefix (ze): " + index.checkPrefix("ze"));
			System.out.println("Longest word: " + index.getLongest());
			System.out.println("ArrayList returned for prefix (ze): " + index.getPrefix("ze"));
		}
		catch (IOException e) {}
	}
}

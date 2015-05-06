public class Word {
	public static void main (String[] args) {
		WordTree index = new WordTree ();
		BufferedReader read = new BufferedReader (new FileReader(args[0]));
		String line;
		while ((line = read.readLine()) != null) {
			index.add(line, index);
		}
		read.close();
	}
}

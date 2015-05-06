import java.util.*;

public class WordTree {
	private ArrayList al;		//arraylist of common prefix
	private Character x;		//character of node
	private HashMap b;
	private WordTree p;

	public WordTree () {
		this.al = new ArrayList<String> ();
		this.x = new Character('\0');
		this.b = new HashMap<Character, WordTree> ();
		this.p = null;
	}
	public WordTree (Character s, WordTree wt) {
		this.al = new ArrayList<String> ();
		this.x = new Character(s);
		this.b = new HashMap<Character, WordTree> ();
		this.p = wt;
	}
	public HashMap<Character, WordTree> getHash () {
		return this.b;
	}
	public void add (String s, WordTree m) {
		WordTree t1 = new WordTree(new Character(s.toCharArray()[0]), m);
		if (m.getHash().get(new Character(s.toCharArray()[0])) == null) {
			m.getHash().put((new Character(s.toCharArray()[0])), new WordTree(new Character(s.toCharArray()[0]), m));
		}
		else {
			t1 = m.getHash().get(new Character(s.toCharArray()[0]));
		}
		WordTree t2 = t1;
		for (int i = 1; i < s.toCharArray().length; i++) {
			WordTree t3 = new WordTree(s.toCharArray()[i], t2);
		}
	}
}

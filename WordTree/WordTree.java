import java.util.*;

public class WordTree {
	private ArrayList al;		//arraylist of common prefix
	private Character x;		//character of node
	private HashMap<Character, WordTree> b;
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
		if (m.getHash().get(new Character(s.toCharArray()[0])) == null) {	//does this character exist already?
			m.getHash().put((new Character(s.toCharArray()[0])), t1);
		}
		else {
			t1 = m.getHash().get(new Character(s.toCharArray()[0]));
		}
		WordTree t2 = t1;
		for (int i = 1; i < s.toCharArray().length; i++) {
			t1 = new WordTree(new Character(s.toCharArray()[i]), t2);
			if (t2.getHash().get(new Character(s.toCharArray()[i])) == null) {	//does this character exist already?
				t2.getHash().put((new Character(s.toCharArray()[i])), t1);
			}
			else {
				t2 = t1.getHash().get(new Character(s.toCharArray()[i]));
			}
			t2 = t1;
		}
	}
	
	public int height (WordTree wt) {
		if (wt.getHash().size() == 0) {
			return 0;
		}
		int max = height(((wt.getHash().values().toArray(new WordTree[0])))[0]);
		for (int i = 1; i < ((wt.getHash().values().toArray(new WordTree[0]))).length; i++) {
			max = Math.max(max, height(((wt.getHash().values().toArray(new WordTree[0])))[i]));
		}
		return 1 + max;
	}
}

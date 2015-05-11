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
				t1 = t2.getHash().get(new Character(s.toCharArray()[i]));
			}
			t2 = t1;
		}
	}

	public int checkPrefix(String s) {
		if (this.getHash().get(new Character(s.toCharArray()[0])) == null) {	//the first letter doesn't even appear
			return 0;
		}
		else {
			WordTree t1 = this.getHash().get(new Character(s.toCharArray()[0]));

			for (int i = 1; i < s.toCharArray().length; i++) {
				if (t1.getHash().get(new Character(s.toCharArray()[i])) == null) {
					return 0;
				}
				t1 = t1.getHash().get(new Character(s.toCharArray()[i]));
			}
			return this.getCount(t1);
		}
	}

	public int getCount() {
		return this.getCount(this);
	}

	public int getCount (WordTree wt) {
		if (wt.getHash().size() == 0) {
			return 1;
		}
		int max = 0;
		for (int i = 0; i < ((wt.getHash().values().toArray(new WordTree[0]))).length; i++) {
			max = max + this.getCount(((wt.getHash().values().toArray(new WordTree[0])))[i]);
		}
		return max;
	}

	public ArrayList<String> getPrefix(String s) {
		if (this.getHash().get(new Character(s.toCharArray()[0])) == null) {	//the first letter doesn't even appear
			return (new ArrayList<String>());
		}
		else {
			WordTree t1 = this.getHash().get(new Character(s.toCharArray()[0]));
        	
			for (int i = 1; i < s.toCharArray().length; i++) {
				if (t1.getHash().get(new Character(s.toCharArray()[i])) == null) {
					return (new ArrayList<String>());
				}
				t1 = t1.getHash().get(new Character(s.toCharArray()[i]));
			}
			//return this.getPrefix(t1);
			ArrayList<String> tmp = new ArrayList<String> ();
			String prefix;
			if (!s.equals("")) {
				prefix = s.substring(0,(s.length() - 1));
			}
			else {
				prefix = s;
			}
			this.getW(t1, tmp, prefix);
			return tmp;
		}
	}

	public void getW (WordTree wt, ArrayList<String> a, String b) {
		if (wt.getHash().size() == 0) {
			a.add(new String(b + wt.getChar()));
		}
		String l;
		for (int i = 0; i < ((wt.getHash().values().toArray(new WordTree[0]))).length; i++) {
			this.getW(((wt.getHash().values().toArray(new WordTree[0])))[i], a, b + wt.getChar());
		}
	}

	public Character getChar () {
		return this.x;
	}

	public String getLongest() {
		return this.getLongest(this);
	}

	public String getLongest(WordTree wt) {
		if (wt.getHash().size() == 0) {
			return "" + wt.getChar();
		}
		int max = (this.getLongest(((wt.getHash().values().toArray(new WordTree[0])))[0])).length();
		String l = "" + wt.getChar() + this.getLongest(((wt.getHash().values().toArray(new WordTree[0])))[0]);
		int old = max;
		for (int i = 1; i < ((wt.getHash().values().toArray(new WordTree[0]))).length; i++) {
			max = Math.max(max, (this.getLongest(((wt.getHash().values().toArray(new WordTree[0])))[i])).length());
			if (old != max) {
				l = "" + wt.getChar() + this.getLongest(((wt.getHash().values().toArray(new WordTree[0])))[i]);
				old = max;
			}
		}
		return l;
	}

	public int height () {
		return this.height(this);
	}

	public int height (WordTree wt) {
		if (wt.getHash().size() == 0) {
			return -1;
		}
		int max = this.height(((wt.getHash().values().toArray(new WordTree[0])))[0]);
		for (int i = 1; i < ((wt.getHash().values().toArray(new WordTree[0]))).length; i++) {
			max = Math.max(max, this.height(((wt.getHash().values().toArray(new WordTree[0])))[i]));
		}
		return 1 + max;
	}

	public String getRandomWord() {
		return this.getRandomWord(this);
	}

	public String getRandomWord(WordTree wt) {
		if (wt.getHash().size() == 0) {
			return "";
		}
		WordTree n = ((wt.getHash().values().toArray(new WordTree[0])))[((int)(Math.floor(((wt.getHash().values().toArray(new WordTree[0]))).length * Math.random())))];
		return "" + n.getChar() + this.getRandomWord(n);
	}
}

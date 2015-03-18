/*	Michael Jin
	HW #8
	This merge sort source code uses linked lists and has a method that accepts an argument of an integer array as specified in the homework.
	There is no need for merge sort as static method as it is part of the object.
*/

public class MMList {
	public Integer e;
	public MMList next;

	public MMList () {
		this.next = null;
		this.e = null;
	}
	public MMList (int i) {
		this.next = null;
		this.e = new Integer(i);
	}
	public int length () {
		if (this.e == 0) {
			return 0;
		}
		else {
			int l = 1;
			MMList ref = this;
			while ((ref = ref.getNext()) != null) {
				++l;
			}
			return l;
		}
	}
	public String toString() {
		String str = new String("");
		MMList ref = this;
		int initial_bounds = this.length();
		for (int i = 0; i < initial_bounds; i++) {
			str = str + ref.getE() + " => ";
			ref = ref.getNext();
		}
		str = str + "null";
		return str;
	}
	public void setE (int i) {
		this.e = new Integer(i);
	}
	public void setNext(MMList n) {
		this.next = n;
	}
	public Integer getE () {
		return this.e;
	}
	public MMList getNext() {
		return this.next;
	}
	
	public MMList mergeSort(int[] f) {
		MMList srtd = new MMList();
		if (f.length > 0) {
			srtd.setE(f[0]);
		}
		MMList ta, t;
		ta = srtd;
		for (int i = 1; i < f.length; i++) {
			//System.out.println(srtd);
			t = new MMList(f[i]);
			ta.setNext(t);
			ta = ta.getNext();
		}
		//new List!!!
		System.out.println("length of ll: " + srtd.length());
		return srtd;
	}
	public MMList mSort(MMList m) {
		if (m.length() <= 1) {
			return m;
		}
		MMList l = m;
		MMList r;
		int mid = m.length() / 2;
		MMList it = l;
		for (int i = 1; i < (mid - 1); i++) {
			it = it.getNext();
		}
		r = it.getNext();
		it.setNext(null);
		l = mSort(l);
		r = mSort(r);
		return merge(l,r);
	}

	public MMList merge (MMList l, MMList r) {
		MMList it;
		MMList fin = new MMList();
		MMList init_fin = fin;
		while ((l.length() > 0) && (r.length() > 0)) {
			if (l.getE() <= r.getE()) {
				fin.setNext(l);
				l = l.getNext();
				fin = fin.getNext();
				fin = fin.setNext(null);
			}
			else {
				fin.setNext(r);
				r = r.getNext();
				fin = fin.getNext();
				fin = fin.setNext(null);
			}
		}
		while (l.length() > 0) {
			fin.setNext(l);
			l = l.getNext();
			fin = fin.getNext();
			fin = fin.setNext(null);
		}
		while (r.length() > 0) {
			fin.setNext(r);
			r = r.getNext();
			fin = fin.getNext();
			fin = fin.setNext(null);
		}
		init_fin = init_fin.getNext();
		return init_fin;
	}
				

	public static void main (String[] args) {
		int[] fakelist = new int[10];
		MMList obj = new MMList();
		for (int i = 0; i < fakelist.length; i++) {
			fakelist[i] = (int)(Math.ceil(Math.random() * 100));
		}
		System.out.println(obj.mergeSort(fakelist));
	}
}

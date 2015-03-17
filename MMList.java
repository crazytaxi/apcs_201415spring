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
			MMList ref;
			while ((ref = this.next) != null) {
				++l;
			}
			return l;
		}
	}
	public String toString() {
		String str = new String("");
		MMList ref = this.e;
		for (int i = 0; i < this.length(); i++) {
			str = str + ref + " => ";
			ref = ref.next;
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
			t = new MMList(f[i]);
			ta.setNext(t);
			ta = ta.setNext(t);
		}
		//new List!!!
		System.out.println("length of ll: " + srtd.length());
		return srtd;
	}
			
	public static void main (String[] args) {
		int[] fakelist = new int[10];
		for (int i = 0; i < fakelist.length; i++) {
			fakelist[i] = (int)(Math.ceil(Math.random() * 100));
		}
		System.out.println(mergeSort(fakelist));
	}
}

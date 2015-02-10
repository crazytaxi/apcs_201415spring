/*	Qijia (Michael) Jin
	HW #0 2/6/2015
*/

import java.util.*;

public class hw_00 {
	
	public static void main(String[] args) {
		System.out.println(factorial(5));
		System.out.println(fib(5, new ArrayList<Integer>()));
		System.out.println(sqrtg(81, 1));
		System.out.println(permute("fight"));
	}

	public static double factorial(int i) {
		if (i == 0) {
			return 1;
		}
		else {
			return i * factorial(i - 1);
		}
	}

	public static Integer fib (int n, ArrayList<Integer> l) {
		if (l.size() == 0) {
			l.add(new Integer(1));
			l.add(new Integer(1));
		}
		if (n <= l.size()) {
			return ((Integer)l.get(n-1)).intValue();
		}
		else {
			l.add(new Integer(l.get(l.size()-1).intValue() + l.get(l.size()-2).intValue()));
			return fib(n,l);
		}
	}

	public static double sqrtg (double i, double g) {
		if ((g * g) < i + .001 && (g * g) > i - .001) {
			return g;	
		}
		else {
			return sqrtg(i, ((i/g) + g) * .5);
		}	
	}

	public static HashMap<String, Boolean> permute(String s, int i, HashMap<String, Boolean> strs) {
		if (i == s.length()) {
			return strs;
		}
		else {
			boolean dup = false;
			for (int k = 0; k < s.length() && k != i; k++) {
				if (s.toCharArray()[k] == s.toCharArray()[i]) {
					dup = true;
					break;
				}
			}
			if (!dup) {
				for (int k = 0; k < s.length(); k++) {
					if (!strs.containsKey(swap(s,i,k))) {
						strs.put(swap(s,i,k), (new Boolean(true)));
						s = swap(s,i,k);
						permute(s,i,strs);
					}
				}
			}
		}
		return permute(s,i+1,strs);
	}

	public static ArrayList<String> permute (String s) {
		Object[] perm = permute(s, 0, (new HashMap<String, Boolean>())).keySet().toArray();
		ArrayList<String> buff = new ArrayList<String> ();
		for (int i = 0; i < perm.length; i++) {
			buff.add((String)perm[i]);
		}
		return buff;
	}

	public static String swap (String s, int a, int b) {
		char[] lol = s.toCharArray();
		lol[a] = lol[b];
		lol[b] = s.toCharArray()[a];
		return (new String(lol));
	}
}

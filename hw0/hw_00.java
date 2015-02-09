/*	Qijia (Michael) Jin
	HW #0 2/6/2015
*/

import java.util.*;

public class hw_00 {
	public static void main(String[] args) {
		System.out.println(factorial(5));
		System.out.println(fib(5, new ArrayList<Integer>()));
		System.out.println(sqrtg(81, 1));
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
}

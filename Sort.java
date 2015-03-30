/*========== Sort.java ==========

  Class used to test various sorting algorithms.
  The constructor will create an array of ints and then
  populate them with random values.
  
  The class also contains variables to keep track
  of the number of swaps and comparisons performed
  for a given sort.
=========================*/

import java.io.*;
import java.util.*;

public class Sort {

    public static int DEFAULT_SIZE = 1000;

    /*======== public void populate()) ==========
      Inputs: int[] list   
      Returns: 
      
      populates the list with random ints in the 
      range [0, list.length)
      ====================*/
    public static void populate( int[] list ) {

	Random r = new Random();
	for (int i=0; i<list.length; i++)
	    list[i] = r.nextInt() % list.length;
    }

    /*======== public void duplicate () ==========
      Inputs:  int[] a
      Returns: A new array of ints that is an exact
               duplicate of a      
      ====================*/
    public static int[] duplicate ( int[]  a ) {

	int[] n = new int[ a.length ];
    
	for (int i=0; i<a.length; i++)
	    n[i] = a[i];

	return n;
    }

    public static String show(int[] list) {
	String s = "";
	for (int i=0; i<list.length - 1; i++)
	    s = s + list[i] + ", ";
	return s + list[list.length-1];
    }


    /*======== public boolean isSorted()) ==========
      Inputs:   
      Returns: true if the list is sorted
               false if the list is unsorted

      ====================*/
    public static boolean isSorted(int[] list) {
	for (int i=0; i<list.length - 1; i++)
	    if (list[i] > list[i+1])
		return false;
	return true;
    }
 
    public static void insertionSort(int[] a) {
	int t, pos;
	for (int i=1; i < a.length; i++) {
	    pos = i;
	    t = a[pos];
	    while ( pos > 0 && a[pos - 1] > t ) {
		a[pos] = a[pos - 1];
		pos --;
	    }
	    a[pos] = t;
	}
    }
    

    /*======== public static int[] merge() ==========
      Inputs:  int[] a
               int[] b  
      Returns: A new sorted array containing the 
               combined elements of a and b
              
      This method must run in linear time.      
      ====================*/
    public static int[] merge( int[] a, int[] b )  {

    	int[] sorted = new int[ a.length + b.length ];
	int acount = 0;
	int bcount = 0;
	int scount = 0;

	while ( acount < a.length && bcount < b.length ) {

	    if ( a[acount] < b[bcount] ) {
		sorted[scount] = a[acount];
		acount++;
	    }
	    else {
		sorted[scount] = b[bcount];
		bcount++;
	    }
	    scount++;	    
	}

	while ( acount < a.length ) {
	    sorted[scount] = a[acount];
	    scount++;
	    acount++;
	}

	while ( bcount < b.length ) {
	    sorted[scount] = b[bcount];
	    scount++;
	    bcount++;
	}	    	
     	return sorted;
     }

    public static int[] mergeSort( int[] list ) {

	if ( list.length == 1 )
	    return list;

	else {
	    int mid = list.length / 2;
	    int[] a = new int [ mid ];
	    int[] b = new int [ list.length - mid ];
	    int i = 0;
	    for (; i < a.length; i++ )
		a[i] = list[i];
	    for (int j=0; j < b.length; j++)
		b[j] = list[ i + j ];

	    return merge( mergeSort(a), mergeSort(b) );
	}
    }
    


   /*======== public void swap() ==========
      Inputs:  int a
               int b  
      Returns: 
      
      Swaps the values at postitons a and b in list
      ====================*/    
    public static void swap(int a, int b, int[] list) {
	int c = list[a];
	list[a] = list[b];
	list[b] = c;
    }
    
    /*======== public static int partition() ==========
      Inputs:  int[] a
               int start
	       int end
      Returns: The index that marks the end of the first partition
      
      This method should select a pivot value, then split the
      array such that each element in the left side of the array
      is less than the pivot and every element in the right side 
      of the array is greater than or equal to the pivot.

      The return value should represent the last index of the
      left (smaller) side of the array
              
      This method must run in linear time.      
      ====================*/
    public static int partition(int[] a, int start, int end) {
        int i = start;
        int j = end + 1;
        int v = a[start];
        while (true) { 
		while (a[++i] < v) {
			if (i == end) {
				break;
			}
		}

		while (v < a[--j]) {
			if (j == start) {
				break;
			}
		}

		if (i >= j) break;
		swap(i,j,a);
        }
	swap(start,j,a);
        return j;
    }
    

    private static void sort(int[] a, int lo, int hi) { 
        if (hi <= lo) {
		return;
	}
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }    

    
    public static void main(String[] args) {

	//Testing mergeSort
	/*
	int[] a1 = new int[10];
	int[] a2 = new int[10];

	populate(a1);
	populate(a2);
	insertionSort(a1);
	insertionSort(a2);
	System.out.println( show(a1) );
	System.out.println( show(a2) );

	int[] merged = merge( a1, a2 );
	System.out.println( show( merged ) );

	int[] list = new int[10];
	populate(list);
	System.out.println( show( list ) );
	list = mergeSort(list);
	System.out.println( show( list ) );
	*/

	
    }
}

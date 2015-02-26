import java.io.*;
import java.util.*;

public class hw_02 {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int R = scan.nextInt();
		int C = scan.nextInt();
		int E = scan.nextInt();
		int N = scan.nextInt();
		String line = new String("");
		String[] sc;
		scan.nextLine();
		int[][] array = new int [R][C];
		for (int i = 0; i < R; i++) {
			line = scan.nextLine();
			sc = line.split(" ");
			for (int j = 0; j < C; j++) {
				array[i][j] = Integer.parseInt(sc[j]);
			}
		}
		/*
		for (int x = 0; x < R; x++) {
			for (int y = 0; y < C; y++) {
				System.out.print(array[x][y] + " ");
			}
			System.out.println();
		}
		*/
		while (scan.hasNextLine()) {
			line = scan.nextLine();
			sc = line.split(" ");
			int[] stump = new int [3];
			stump[0] = Integer.parseInt(sc[0]);
			stump[1] = Integer.parseInt(sc[1]);
			stump[2] = Integer.parseInt(sc[2]);
			int high = -1;
			for (int a = 0; a < 3; a++) {
				for (int b = 0; b < 3; b++) {
					if (array[a + stump[0] - 1][b + stump[1] - 1] > high) {
						high = array[a + stump[0] - 1][b + stump[1] - 1];
					}
				}
			}
			int nh = high - stump[2];
			for (int a = 0; a < 3; a++) {
				for (int b = 0; b < 3; b++) {
					if (array[a + stump[0] - 1][b + stump[1] - 1] > nh) {
						array[a + stump[0] - 1][b + stump[1] - 1] = nh;
					}
				}
			}
		}

		int total = 0;
		for (int a = 0; a < R; a++) {
			for (int b = 0; b < C; b++) {
				if (array[a][b] < E) {
					total = total + (E - array[a][b]);
				}
			}
		}
		System.out.println(total * 5184);

		/*
		for (int x = 0; x < R; x++) {
			for (int y = 0; y < C; y++) {
				System.out.print(array[x][y] + " ");
			}
			System.out.println();
		}
		*/
	}
}

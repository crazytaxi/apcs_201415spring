import java.io.*;
import java.util.*;

public class suslv {

	public static void main (String[] args) {
		int[][] puz = new int[9][9];
		Scanner scan = new Scanner(System.in);
		String line;
		int c = 0;
		while (scan.hasNextLine()) {
			line = scan.nextLine();
			char[] cz = line.toCharArray();
			for (int i = 0; i < cz.length; i++) {
				if (cz[i] != ' ') {	
					puz[c][i] = cz[i] - '0';
				}
				else {
					puz[c][i] = 0;
				}

			}
			++c;
		}
		/*
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(puz[i][j] + " ");
			}
			System.out.println();
		}
		chk(puz);
		*/
	}
	public static void start (int r, int c, int[][] doku) {
		boolean[] as = new boolean [9];
		for (int i = 0; i < 9; i++) {
			if (doku[i][c] != 0) {
				as[doku[i][c] - 1] = true;
			}
			if (doku[r][i] != 0) {
				as[doku[r][i] - 1] = true;
			}
		}
		for (int i = 0; i < 9; i++) {
			if (as[i]) {
				int[][] dokub = new int[9][9];
				for (int x = 0; x < 9; x++) {
					for (int y = 0; y < 9; y++) {
						dokub[x][y] = doku[x][y];
					}
				}
				dokub[r][c] = i;
				chk(dokub);
			}
		}
	}
	public static void chk (int[][] doku) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (doku[i][j] == 0) {
					start(i,j,doku);
					//break;
				}
			}
		}
	}
}

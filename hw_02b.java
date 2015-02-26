import java.io.*;
import java.util.*;

public class hw_02b {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int M = scan.nextInt();
		int T = scan.nextInt();
		System.out.println(N + " " + M + " " + T);
		String line = scan.nextLine();
		char[][] pasture = new char [N][M];
		for (int i = 0; i < N; i++) {
			line = scan.nextLine();
			char[] cs = line.toCharArray();
			for (int j = 0; j < M; j++) {
				pasture[i][j] = cs[j];
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(pasture[i][j] + " ");
			}
			System.out.println();
		}
		line = scan.nextLine();
		String[] cs2 = line.split(" ");
		int[] da = new int [4];
		for (int i = 0; i < da.length; i++) {
			da[i] = Integer.parseInt(cs2[i]);
		}
	}
}

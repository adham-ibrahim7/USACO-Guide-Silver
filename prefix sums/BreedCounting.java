import java.util.*;
import java.io.*;

public class BreedCounting {
	static int ni(StringTokenizer st) {
		return Integer.parseInt(st.nextToken());
	}

	static int ni(BufferedReader f) throws IOException {
		return Integer.parseInt(f.readLine());
	}

	static StringTokenizer nl(BufferedReader f) throws IOException {
		return new StringTokenizer(f.readLine());
	}

	static int[] nia(int N, BufferedReader f) throws IOException {
		StringTokenizer st = nl(f);
		int[] A = new int[N];
		for (int i = 0; i < N; i++)
			A[i] = ni(st);
		return A;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("bcount.in"));	
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("bcount.out")));

		//BufferedReader f = (new BufferedReader(new InputStreamReader(System.in)));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

		StringTokenizer st = nl(f);
		int N = ni(st), Q = ni(st);
		
		int[][] pre = new int[N+1][4];
		
		for (int i = 0; i < N; i++) {
			int k = ni(f);
			for (int j = 1; j < 4; j++) {
				pre[i+1][j] = pre[i][j] + (j == k ? 1 : 0);
			}
		}
		
		while (Q-- > 0) {
			st = nl(f);
			int L = ni(st), R = ni(st);
			
			for (int i = 1; i < 4; i++) {
				out.print(pre[R][i] - pre[L-1][i]);
				if (i < 3) out.print(" ");
			}
			out.println();
		}
		
		f.close();
		out.close();
	}
}
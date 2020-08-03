import java.util.*;
import java.io.*;

public class SevenSubsequence {
	public static void main(String[] args) throws IOException {
		setIO("div7");

		int[] first = new int[7];
		first[0] = -1;
		for (int i = 1; i < 7; i++) first[i] = -2;
		
		int N = ni();
		long s = 0;
		int ans = 0;
		for (int i = 0; i < N; i++) {
			s += ni();
			int m = (int) (s % 7);
			if (first[m] > -2) {
				ans = Math.max(ans, i - first[m]);
			} else {
				first[m] = i;
			}
		}
		
		out.println(ans);
		
		f.close();
		out.close();
	}

	static final int MOD = 1000000007;

	static BufferedReader f;
	static PrintWriter out;

	static int ni(StringTokenizer st) {
		return Integer.parseInt(st.nextToken());
	}

	static int ni() throws IOException {
		return Integer.parseInt(f.readLine());
	}

	static StringTokenizer nl() throws IOException {
		return new StringTokenizer(f.readLine());
	}

	static int[] nia(int N) throws IOException {
		StringTokenizer st = nl();
		int[] A = new int[N];
		for (int i = 0; i < N; i++)
			A[i] = ni(st);
		return A;
	}

	static void setIO(String s) throws IOException {
		f = new BufferedReader(new FileReader(s + ".in"));
		out = new PrintWriter(new FileWriter(s + ".out"));
	}

	static void setIO() {
		f = (new BufferedReader(new InputStreamReader(System.in)));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	}
}

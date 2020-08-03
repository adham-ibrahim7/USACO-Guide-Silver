import java.util.*;
import java.io.*;

public class HoofPaperScissors {
	public static void main(String[] args) throws IOException {
		setIO("hps");

		int N = ni();
		int[][] pre = new int[N+1][3];
		for (int i = 1; i <= N; i++) {
			String s = f.readLine();
			
			int k = 0;
			if (s.equals("P")) {
				k = 1;
			} else if (s.equals("S")) {
				k = 2;
			}
			
			for (int j = 0; j < 3; j++) {
				pre[i][j] = (j == k ? 1 : 0) + pre[i-1][j];
			}
		}
		
		int ans = 0;
		for (int i = 0; i <= N; i++) {
			int left = 0, right = 0;
			for (int j = 0; j < 3; j++) {
				left = Math.max(left, pre[i][j]);
				right = Math.max(right, pre[N][j]-pre[i][j]);
			}
			ans = Math.max(ans, left + right);
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

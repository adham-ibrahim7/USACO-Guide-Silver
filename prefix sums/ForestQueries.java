import java.util.*;
import java.io.*;

public class ForestQueries {
	public static void main(String[] args) throws IOException {
		setIO();

		StringTokenizer st = nl();
		int N = ni(st), Q = ni(st);
		int[][] pre = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			String s = f.readLine();
			for (int j = 1; j <= N; j++) {
				pre[i][j] = pre[i-1][j] + pre[i][j-1] - pre[i-1][j-1] + (s.charAt(j-1) == '*' ? 1 : 0);
			}
		}
		
		while (Q-- > 0) {
			st = nl();
			int a = ni(st), b = ni(st), A = ni(st), B = ni(st);
			out.println(pre[A][B] - pre[a-1][B] - pre[A][b-1] + pre[a-1][b-1]);
		}
		
		f.close();
		out.close();
	}

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

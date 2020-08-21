import java.util.*;
import java.io.*;

public class CountingRooms {
	public static void main(String[] args) throws IOException {
		setIO();

		st = nl();
		N = ni(st);
		M = ni(st);
		
		A = new char[N][M];
		
		for (int i = 0; i < N; i++) {
			A[i] = rl().toCharArray();
		}
		
		int ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (A[i][j] == '.') {
					dfs(i, j);
					ans++;
				}
			}
		}
		
		out.println(ans);
		
		f.close();
		out.close();
	}
	
	static int N, M;
	static char[][] A;
	
	static void dfs(int i, int j) {
		if (i < 0 || i >= N || j < 0 || j >= M || A[i][j] != '.') return;
		
		A[i][j] = '#';
		
		dfs(i-1, j);
		dfs(i+1, j);
		dfs(i, j-1);
		dfs(i, j+1);
	}
		
	static BufferedReader f;
	static PrintWriter out;
	static StringTokenizer st;

	static String rl() throws IOException {
		return f.readLine();
	}

	static int ni(StringTokenizer st) {
		return Integer.parseInt(st.nextToken());
	}

	static long nlg(StringTokenizer st) {
		return Long.parseLong(st.nextToken());
	}

	static int ni() throws IOException {
		return Integer.parseInt(rl());
	}

	static long nlg() throws IOException {
		return Long.parseLong(rl());
	}

	static StringTokenizer nl() throws IOException {
		return new StringTokenizer(rl());
	}

	static int[] nia(int N) throws IOException {
		StringTokenizer st = nl();
		int[] A = new int[N];
		for (int i = 0; i < N; i++)
			A[i] = ni(st);
		return A;
	}

	static void setIn(String s) throws IOException {
		f = new BufferedReader(new FileReader(s));
	}

	static void setOut(String s) throws IOException {
		out = new PrintWriter(new FileWriter(s));
	}

	static void setIn() {
		f = new BufferedReader(new InputStreamReader(System.in));
	}

	static void setOut() {
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	}

	static void setIO(String s) throws IOException {
		setIn(s + ".in");
		setOut(s + ".out");
	}

	static void setIO() {
		setIn();
		setOut();
	}
}

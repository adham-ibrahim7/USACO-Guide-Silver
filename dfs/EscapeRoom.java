import java.util.*;
import java.io.*;

public class EscapeRoom {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		setIO();

		int N = ni(), M = ni();
		
		adj = new LinkedList[N+1][M+1];
		
		for (int i = 1; i <= N; i++) {
			st = nl();
			for (int j = 1; j <= M; j++) {
				adj[i][j] = new LinkedList<>();
				
				int A = ni(st);
				
				double s = Math.sqrt(A);
				for (int k = 1; k <= s; k++) {
					if (A % k == 0) {
						int a = k, b = A / k;
						if (a <= N && b <= M) adj[i][j].add(new Pos(a, b));
						if (a < s && a <= M && b <= N) adj[i][j].add(new Pos(b, a));
					}
				}
			}
		}
		
		vis = new boolean[N+1][M+1];
		dfs(1, 1);
		out.println(vis[N][M] ? "yes" : "no");
		
		f.close();
		out.close();
	}
	
	static LinkedList<Pos>[][] adj;
	static boolean[][] vis;
	
	static void dfs(int i, int j) {
		if (vis[i][j]) return;
		vis[i][j] = true;
		for (Pos n : adj[i][j]) dfs(n.i, n.j);
	}
	
	static class Pos {
		int i, j;
		Pos(int i, int j) {this.i = i; this.j = j;}
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

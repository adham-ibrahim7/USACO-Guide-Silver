import java.util.*;
import java.io.*;

public class BirthdayParty {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		setIO();

		while (true) {
			st = nl();
			int N = ni(st), M = ni(st);
			if (N+M == 0) break;
			
			adj = new LinkedList[N];
			for (int i = 0; i < N; i++) adj[i] = new LinkedList<>();
			
			int[][] Q = new int[M][2];
			for (int i = 0; i < M; i++) {
				st = nl();
				int u = ni(st), v = ni(st);
				adj[u].add(v);
				adj[v].add(u);
				Q[i] = new int[] {u, v};
			}
			
			boolean verygood = true;
			for (int i = 0; i < M; i++) {
				vis = new boolean[N];
				
				dfs(0, Q[i][0], Q[i][1]);
				
				boolean good = true;
				for (boolean b : vis) {
					if (!b) {
						good = false;
						break;
					}
				}
				
				if (!good) {
					verygood = false;
					break;
				}
			}
			
			out.println(verygood ? "No" : "Yes");
		}
		
		f.close();
		out.close();
	}

	static LinkedList<Integer> adj[];
	static boolean[] vis;
	
	static void dfs(int u, int a, int b) {
		if (vis[u]) return;
		vis[u] = true;
		for (int v : adj[u]) {
			if (!(u == a && v == b || 
				u == b && v == a)) dfs(v, a, b);
		}
	}

	static BufferedReader f;
	static PrintWriter out;
	static StringTokenizer st;

	static int ni(StringTokenizer st) {
		return Integer.parseInt(st.nextToken());
	}

	static long nlg(StringTokenizer st) {
		return Long.parseLong(st.nextToken());
	}

	static int ni() throws IOException {
		return Integer.parseInt(f.readLine());
	}

	static long nlg() throws IOException {
		return Long.parseLong(f.readLine());
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

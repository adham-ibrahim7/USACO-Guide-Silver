import java.util.*;
import java.io.*;

public class ClosingTheFarm {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		setIO("closing");

		st = nl();
		N = ni(st); M = ni(st);
		adj = new LinkedList[N+1];
		for (int i = 1; i <= N; i++) adj[i] = new LinkedList<>();
		
		while (M-- > 0) {
			st = nl();
			int u = ni(st), v = ni(st);
			adj[u].add(v);
			adj[v].add(u);
		}
		
		perm = new boolean[N+1];
		
		for (int i = 0; i < N; i++) {
			vis = new boolean[N+1];
			for (int j = 1; j < N; j++) {
				if (!perm[j]) {
					dfs(j);
					break;
				}
			}
			
			String ans = "YES";
			for (int j = 1; j <= N; j++) {
				if (!vis[j] && !perm[j]) {
					ans = "NO";
					break;
				}
			}
			
			out.println(ans);
			
			int K = ni();
			perm[K] = true;
		}
		
		f.close();
		out.close();
	}
	
	static void dfs(int u) {
		if (vis[u] || perm[u]) return;
		vis[u] = true;
		for (int v : adj[u]) dfs(v);
	}
	
	static boolean[] vis, perm;
	static int N, M;
	static LinkedList<Integer> adj[];

	static BufferedReader f;
	static PrintWriter out;
	static StringTokenizer st;

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

import java.util.*;
import java.io.*;

public class Distance2 {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		setIO();

		N = ni();
		
		adj = new LinkedList[N+1];
		for (int i = 1; i <= N; i++) adj[i] = new LinkedList<>();
		
		for (int i = 0; i < N-1; i++) {
			st = nl();
			int u = ni(st), v = ni(st);
			adj[u].add(v);
			adj[v].add(u);
		}
		
		sum = new long[N+1];
		count = new long[N+1];
		
		dfs(1, 0, 0);
		solve(1, 0);
		
		for (int i = 1; i <= N; i++) {
			out.print(sum[i] + " ");
		}
		out.println();
		
		f.close();
		out.close();
	}
	
	static int N;
	static LinkedList<Integer> adj[];

	static long[] sum;
	static long[] count;
	
	static void dfs(int u, int e, int d) {
		sum[1] += d;
		count[u] = 1;
		for (int v : adj[u]) {
			if (v != e) {
				dfs(v, u, d+1);
				count[u] += count[v];
			}
		}
	}
	
	static void solve(int u, int e) {
		if (e > 0) sum[u] = sum[e] + N - 2 * count[u];
		for (int v : adj[u]) {
			if (v != e) {
				solve(v, u);
			}
		}
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

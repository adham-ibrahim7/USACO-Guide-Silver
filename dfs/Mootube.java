import java.util.*;
import java.io.*;

public class Mootube {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		setIO("mootube");

		st = nl();
		int N = ni(st), Q = ni(st);
		
		adj = new LinkedList[N+1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new LinkedList<>();
		}
		
		
		for (int i = 0; i < N-1; i++) {
			st = nl();
			int u = ni(st), v = ni(st), w = ni(st);
			adj[u].add(new Edge(v, w));
			adj[v].add(new Edge(u, w));
		}
		
		while (Q-- > 0) {
			st = nl();
			int K = ni(st), U = ni(st);
			vis = new boolean[N+1];
			count = 0;
			dfs(U, K, Integer.MAX_VALUE);
			out.println(count-1);
		}
		
		f.close();
		out.close();
	}
	
	static int count;
	static LinkedList<Edge> adj[];
	static boolean[] vis;
	
	static void dfs(int u, int k, int min) {
		if (vis[u]) return;
		vis[u] = true;
		if (min >= k) count++;
		for (Edge v : adj[u]) {
			dfs(v.to, k, Math.min(min, v.w));
		}
	}
	
	static class Edge {
		int to, w;
		Edge(int to, int w) {
			this.to = to;
			this.w = w;
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

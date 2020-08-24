import java.util.*;
import java.io.*;

public class Revegetation {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		setIO("revegetate");

		st = nl();
		N = ni(st); M = ni(st);
		
		adj = new LinkedList[N+1];
		for (int i = 1; i <= N; i++) adj[i] = new LinkedList<>();
		vis = new boolean[N+1];
		col = new boolean[N+1];
		
		while (M-- > 0) {
			st = nl();
			
			String s = st.nextToken();
			int a = ni(st), b = ni(st);
			
			boolean same = s.equals("S");
			adj[a].add(new Edge(b, same));
			adj[b].add(new Edge(a, same));
		}
		
		boolean good = true;
		int cc = 0;
		for (int i = 1; i <= N; i++) {
			if (!vis[i]) {
				if (dfs(i, true, true)) cc++;
				else {
					good = false;
					break;
				}
			}
		}
		
		if (good) {
			out.print(1);
			while (cc-- > 0) out.print(0);
		} else {
			out.println(0);
		}
		
		f.close();
		out.close();
	}
	
	static int N, M;
	static boolean[] vis;
	static boolean[] col;
	static LinkedList<Edge>[] adj;
	
	static boolean dfs(int u, boolean prev, boolean same) {
		if (vis[u]) return same ? col[u] == prev : col[u] != prev;
		
		vis[u] = true;
		
		col[u] = same ? prev : !prev;
		
		for (Edge e : adj[u]) {
			if (!dfs(e.to, col[u], e.same)) return false;
		}
		
		return true;
	}
	
	static class Edge {
		int to;
		boolean same;
		Edge(int to, boolean s) {
			this.to = to;
			this.same = s;
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

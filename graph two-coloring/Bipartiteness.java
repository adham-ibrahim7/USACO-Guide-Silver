import java.util.*;
import java.io.*;

public class Bipartiteness {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		setIO();

		N = ni();
		
		adj = new LinkedList[N+1];
		color = new boolean[N+1];
		
		for (int i = 0; i <= N; i++) adj[i] = new LinkedList<>();
		
		for (int i = 0; i < N-1; i++) {
			st = nl();
			int a = ni(st), b = ni(st);
			adj[a].add(b);
			adj[b].add(a);
		}
		
		r = b = 0;
		dfs(1, 0, false);
		
		long ans = 0;
		for (int i = 1; i <= N; i++) {
			ans += (color[i] ? b : r) - adj[i].size();
		}
		ans /= 2;
		out.println(ans);
		
		f.close();
		out.close();
	}
	
	static int N;
	static LinkedList<Integer> adj[];
	static boolean[] color;
	static int r, b;
	
	static void dfs(int u, int e, boolean c) {
		color[u] = c;
		if (c) r++; else b++;
		
		for (int v : adj[u]) {
			if (v != e) dfs(v, u, !c);
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

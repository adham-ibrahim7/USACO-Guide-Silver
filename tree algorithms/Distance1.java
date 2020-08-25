import java.util.*;
import java.io.*;

public class Distance1 {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		setIO();

		int N = ni();
		adj = new LinkedList[N+1];
		for (int i = 0; i <= N; i++) adj[i] = new LinkedList<>();
		
		for (int i = 0; i < N-1; i++) {
			st = nl();
			int a = ni(st), b = ni(st);
			adj[a].add(b);
			adj[b].add(a);
		}
		
		dfs(1, 0, 0, true);
		
		int a = farthest;
		
		d = 0;
		dfs(farthest, 0, 0, true);
		
		int b = farthest;
		
		ans = new int[N+1];
		
		dfs(a, 0, 0, false);
		dfs(b, 0, 0, false);
		
		for (int i = 1; i <= N; i++) out.println(ans[i]);
		
		f.close();
		out.close();
	}
	
	static LinkedList<Integer> adj[];
	
	static int farthest, d = 0;
	static int[] ans;
	
	static void dfs(int u, int e, int dist, boolean foo) {
		if (foo) {
			if (dist >= d) {
				d = dist;
				farthest = u;
			}
		} else {
			ans[u] = Math.max(ans[u], dist);
		}
		
		for (int v : adj[u]) {
			if (v != e) dfs(v, u, dist+1, foo);
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

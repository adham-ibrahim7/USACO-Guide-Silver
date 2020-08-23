import java.util.*;
import java.io.*;

public class FlightCheck {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		setIO();

		st = nl();
		N = ni(st);
		int M = ni(st);
		forward = new LinkedList[N+1];
		backward = new LinkedList[N+1];
		
		for (int i = 0; i < N+1; i++) {
			forward[i] = new LinkedList<>();
			backward[i] = new LinkedList<>();
		}
		
		while (M-- > 0) {
			st = nl();
			int u = ni(st), v = ni(st);
			forward[u].add(v);
			backward[v].add(u);
		}
		
		solve();
		
		f.close();
		out.close();
	}
	
	static void solve() {
		vis = new boolean[N+1];
		dfs(1, forward);
		for (int i = 2; i <= N; i++) {
			if (!vis[i]) {
				out.println("NO\n1 " + i);
				return;
			}
		}
		
		vis = new boolean[N+1];
		dfs(1, backward);
		for (int i = 2; i <= N; i++) {
			if (!vis[i]) {
				out.println("NO\n" + i + " 1");
				return;
			}
		}
		
		out.println("YES");
	}
	
	static int N;
	static LinkedList<Integer>[] forward, backward;
	static boolean vis[];
	
	static void dfs(int u, LinkedList<Integer>[] adj) {
		if (vis[u]) return;
		vis[u] = true;
		for (int v : adj[u]) dfs(v, adj);
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

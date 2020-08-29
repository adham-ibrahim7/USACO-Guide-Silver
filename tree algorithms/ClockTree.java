import java.util.*;
import java.io.*;

public class ClockTree {
	public static void main(String[] args) throws IOException {
		setIO();

		int N = ni();
		val = new int[N+1];
		st = nl();
		for (int i = 1; i <= N; i++) val[i] = ni(st);
		
		adj = new LinkedList[N+1];
		for (int i = 1; i <= N; i++) adj[i] = new LinkedList<>();
		
		for (int i = 0; i < N-1; i++) {
			st = nl();
			int u = ni(st), v = ni(st);
			adj[u].add(v);
			adj[v].add(u);
		}
		
		int ans = 0;
		for (int i = 1; i <= N; i++) {
			good = true;
			
			val[i]--;
			dfs(i, 0);
			val[i]++;
			
			if (good) ans++;
			out.println("-----");
		}
		
		out.println(ans);
		
		f.close();
		out.close();
	}
	
	static int[] val;
	static LinkedList<Integer>[] adj;

	static boolean good;
	
	static void dfs(int u, int e) {
		boolean leaf = true;
		int s = 0;
		for (int v : adj[u]) {
			if (v != e) {
				leaf = false;
				s += 12 - val[v];
				dfs(v, u);
			}
		}
		
		if (leaf) return;
		
		out.println(u + " " + s);
		
		s %= 12;
		if (12 - val[u] - 1 != s) good = false;
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

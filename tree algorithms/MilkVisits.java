import java.util.*;
import java.io.*;

public class MilkVisits {
	public static void main(String[] args) throws IOException {
		setIO("milkvisits");

		st = nl();
		int N = ni(st), M = ni(st);
		s = f.readLine().toCharArray();
		
		adj = new LinkedList[N+1];
		for (int i = 1; i <= N; i++) adj[i] = new LinkedList<>();
		
		for (int i = 0; i < N-1; i++) {
			st = nl();
			int u = ni(st), v = ni(st);
			adj[u].add(v);
			adj[v].add(u);
		}
		
		comp = new int[N+1];
		vis = new boolean[N+1];
		int cc = 0;
		for (int i = 1; i <= N; i++) {
			if (!vis[i]) dfs(i, ++cc);
		}
		
		while (M-- > 0) {
			st = nl();
			int u = ni(st), v = ni(st);
			char c = st.nextToken().charAt(0);
			
			out.print(comp[u] != comp[v] || s[u-1] == c ? '1' : '0');
		}
		out.println();
		
		f.close();
		out.close();
	}

	static char[] s;
	static int[] comp;
	static LinkedList<Integer>[] adj;
	static boolean[] vis;

	static void dfs(int u, int cc) {
		if (vis[u]) return;
		vis[u] = true;
		
		comp[u] = cc;
		
		for (int v : adj[u]) {
			if (s[u-1] == s[v-1]) dfs(v, cc);
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

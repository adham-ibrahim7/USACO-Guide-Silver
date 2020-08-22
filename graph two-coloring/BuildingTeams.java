import java.util.*;
import java.io.*;

public class BuildingTeams {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		setIO();

		st = nl();
		int N = ni(st), M = ni(st);
		
		adj = new LinkedList[N+1];
		for (int i = 0; i <= N; i++) adj[i] = new LinkedList<>();
		
		while (M-- > 0) {
			st = nl();
			int a = ni(st), b = ni(st);
			adj[a].add(b);
			adj[b].add(a);
		}
		
		boolean ans = true;
		mark = new int[N+1];
		for (int i = 1; i <= N; i++) {
			if (mark[i] == 0 &&!dfs(i, 1)) {
				ans = false;
				break;
			}
		}
		
		if (ans) {
			for (int i = 1; i <= N; i++) out.print(mark[i] + " ");
			out.println();
		} else {
			out.println("IMPOSSIBLE");
		}
		
		f.close();
		out.close();
	}
	
	static int N;
	static LinkedList<Integer> adj[];
	static int[] mark;
	
	static boolean dfs(int u, int c) {
		if (mark[u] != 0) return mark[u] == c;
		mark[u] = c;
		
		for (int v : adj[u]) {
			if (!dfs(v, c == 1 ? 2 : 1)) return false;
		}
		return true;
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

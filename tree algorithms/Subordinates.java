import java.util.*;
import java.io.*;

public class Subordinates {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		setIO();

		int N = ni();
		
		adj = new LinkedList[N+1];
		for (int i = 1; i <= N; i++) adj[i] = new LinkedList<>();
		
		st = nl();
		for (int u = 2; u <= N; u++) {
			int v = ni(st);
			
			adj[v].add(u);
		}
		
		ans = new int[N+1];
		dfs(1, 0);
		
		for (int u = 1; u <= N; u++) out.print(ans[u] + " ");
		out.println();
		
		f.close();
		out.close();
	}
	
	static LinkedList<Integer>[] adj;
	static int[] ans;
	
	static void dfs(int u, int e) {
		ans[u] = 0;
		for (int v : adj[u]) {
			dfs(v, u);
			ans[u] += 1 + ans[v];
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

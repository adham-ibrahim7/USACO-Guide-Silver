import java.util.*;
import java.io.*;

public class BearAndFriendship {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		setIO();

		st = nl();
		int N = ni(st), M = ni(st);
		adj = new LinkedList[N+1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new LinkedList<>();
		}
		
		while (M-- > 0) {
			st = nl();
			int u = ni(st), v = ni(st);
			adj[u].add(v);
			adj[v].add(u);
		}
		
		comp = new int[N+1];
		size = new int[N];
		Arrays.fill(comp, -1);
		
		int n = 0;
		for (int i = 1; i <= N; i++) {
			if (comp[i] == -1) dfs(i, n++);
		}
		
		String ans = "YES";
		for (int i = 1; i <= N; i++) {
			if (size[comp[i]] != adj[i].size()+1) {
				ans = "NO";
				break;
			}
		}
		
		out.println(ans);
		
		f.close();
		out.close();
	}
	
	static LinkedList<Integer> adj[];
	
	static int[] comp;
	static int[] size;
	static void dfs(int u, int n) {
		if (comp[u] > -1) return;
		comp[u] = n;
		size[n]++;
		for (int v : adj[u]) dfs(v, n);
	}

	static BufferedReader f;
	static PrintWriter out;
	static StringTokenizer st;

	static int ni(StringTokenizer st) {
		return Integer.parseInt(st.nextToken());
	}

	static int ni() throws IOException {
		return Integer.parseInt(f.readLine());
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

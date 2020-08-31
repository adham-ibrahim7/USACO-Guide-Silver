import java.util.*;
import java.io.*;

public class PlanetCycles {
	public static void main(String[] args) throws IOException {
		setIO();

		int N = ni();
		
		p = new int[N+1];
		st = nl();
		for (int i = 1; i <= N; i++) {
			p[i] = ni(st);
		}
		
		vis = new boolean[N+1];
		exploring = new boolean[N+1];
		cycle = new boolean[N+1];
		
		ans = new int[N+1];
		dist = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			if (!vis[i]) dfs(i, 1);
		}
		
		for (int i = 1; i <= N; i++) {
			out.print(ans[i] + " ");
		}
		out.println();
		
		f.close();
		out.close();
	}
	
	static int[] p;
	
	static boolean[] exploring; //still exploring current node u?
	static boolean[] cycle;
	static boolean[] vis; //node u visited at all?
	static int[] ans; //ans for each node
	static int[] dist;
	
	static int dfs(int u, int d) {
		if (!vis[u]) dist[u] = d;
		vis[u] = exploring[u] = true;
		
		if (exploring[p[u]]) { //cycle first created
			ans[u] = d - dist[p[u]] + 1;
			exploring[u] = false;
			exploring[p[u]] = false;
			cycle[u] = true;
			cycle[p[u]] = true;
			
			return ans[u]; //tell previous that cycle is created
		} else if (vis[p[u]]) {
			exploring[u] = false;
			return ans[u] = ans[p[u]] + 1;
		} else {
			int t = dfs(p[u], d+1);
			
			return ans[u] = (cycle[u] && cycle[p[u]] ? t : t+1);
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
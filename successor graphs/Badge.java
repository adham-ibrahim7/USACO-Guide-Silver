import java.util.*;
import java.io.*;

public class Badge {
	public static void main(String[] args) throws IOException {
		setIO();

		int N = ni();
		
		p = new int[N+1];
		st = nl();
		for (int i = 1; i <= N; i++) {
			p[i] = ni(st);
		}
		
		vis = new boolean[N+1];
		completed = new boolean[N+1];
		ans = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			if (!vis[i]) dfs(i);
		}
		
		for (int i = 1; i <= N; i++) {
			//if (ans[i] == 0) dfs(i);
		}
		
		for (int i = 1; i <= N; i++) {
			out.print(ans[i] + " ");
		}
		out.println();
		
		f.close();
		out.close();
	}
	
	static int[] p;
	
	static boolean[] completed;
	static boolean[] vis;
	static int[] ans;
	
	static void dfs(int u) {
		if (vis[u]) {
			int d = 1;
			int v = p[u];
			
			while (v != u) {
				v = p[v];
				d++;
			}
			
			completed[u] = true;
			ans[u] = d;
			
			v = p[u];
			while (v != u) {
				completed[v] = true;
				ans[v] = d;
				v = p[v];
			}
			
			return;
		}
		
		vis[u] = true;
		
		if (completed[p[u]]) {
			ans[u] = ans[p[u]] + 1;
			completed[u] = true;
		} else {
			dfs(p[u]);
			completed[u] = true;
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
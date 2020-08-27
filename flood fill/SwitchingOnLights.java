import java.util.*;
import java.io.*;

public class SwitchingOnLights {
	public static void main(String[] args) throws IOException {
		setIO("lightson");
		
		st = nl();
		N = ni(st);
		
		adj = new LinkedList[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				adj[i][j] = new LinkedList<>();
			}
		}
		
		int M = ni(st);
		while (M-- > 0) {
			st = nl();
			int i1 = ni(st), j1 = ni(st), i2 = ni(st), j2 = ni(st);
			adj[i1][j1].add(new Pos(i2, j2));
		}
		
		lit = new boolean[N+1][N+1];
		vis = new boolean[N+1][N+1];
		
		lit[1][1] = true;
		dfs(1, 1);
		
		int ans = 0;
		for (int i = 1; i <= N; i++)
			for (int j = 1; j <= N; j++)
				if (lit[i][j]) ans++;
		
		out.println(ans);
		
		f.close();
		out.close();
	}
	
	static int N;
	static LinkedList<Pos>[][] adj;

	static boolean[][] lit;
	static boolean[][] vis;

	static void dfs(int i, int j) {
		if (!lit[i][j] || vis[i][j]) return;
		
		vis[i][j] = true;
		
		for (Pos v : adj[i][j]) {
			lit[v.i][v.j] = true;
			if (v.i > 1 && vis[v.i-1][v.j] ||
				v.i < N && vis[v.i+1][v.j] ||
				v.j > 1 && vis[v.i][v.j-1] || 
				v.j < N && vis[v.i][v.j+1]) {
				dfs(v.i, v.j);
			}
		}
		
		if (i > 1) dfs(i-1, j);
		if (i < N) dfs(i+1, j);
		if (j > 1) dfs(i, j-1);
		if (j < N) dfs(i, j+1);
	}
	
	static class Pos {
		int i, j;
		Pos(int i, int j) {this.i = i; this.j = j;}
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

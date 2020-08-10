import java.util.*;
import java.io.*;

public class Moocast {
	public static void main(String[] args) throws IOException {
		setIO("moocast");

		int N = ni();
		Cow[] cow = new Cow[N];
		adj = new LinkedList[N];
		for (int i = 0; i < N; i++) {
			st = nl();
			int x = ni(st), y = ni(st), p = ni(st);
			cow[i] = new Cow(x, y, p);
			adj[i] = new LinkedList<>();
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j) continue;
				
				if (distsq(cow[i], cow[j]) <= cow[i].p * cow[i].p) {
					adj[i].add(j);
				}
			}
		}
		
		int ans = 0;
		for (int i = 0; i < N; i++) {
			vis = new boolean[N];
			count = 0;
			dfs(i);
			ans = Math.max(ans, count);
		}
		
		out.println(ans);
		
		f.close();
		out.close();
	}
	
	static int distsq(Cow a, Cow b) {
		return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
	}
	
	static LinkedList<Integer> adj[];
	
	static int count = 0;
	static boolean[] vis;
	
	static void dfs(int u) {
		if (vis[u]) return;
		vis[u] = true;
		count++;
		for (int v : adj[u]) dfs(v);
	}
	
	static class Cow {
		int x, y, p;
		Cow(int x, int y, int p) {
			this.x = x;
			this.y = y;
			this.p = p;
		}
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

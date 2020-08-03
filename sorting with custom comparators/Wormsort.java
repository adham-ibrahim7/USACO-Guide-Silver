import java.util.*;
import java.io.*;

public class Wormsort {
	static int ni(StringTokenizer st) {
		return Integer.parseInt(st.nextToken());
	}

	static int ni(BufferedReader f) throws IOException {
		return Integer.parseInt(f.readLine());
	}

	static StringTokenizer nl(BufferedReader f) throws IOException {
		return new StringTokenizer(f.readLine());
	}

	static int[] nia(int N, BufferedReader f) throws IOException {
		StringTokenizer st = nl(f);
		int[] A = new int[N];
		for (int i = 0; i < N; i++)
			A[i] = ni(st);
		return A;
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("wormsort.in"));	
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("wormsort.out")));

		//BufferedReader f = (new BufferedReader(new InputStreamReader(System.in)));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

		StringTokenizer st = nl(f);
		N = ni(st);
		int M = ni(st);
		P = new int[N];
		st = nl(f);
		for (int i = 0; i < N; i++) {
			P[i] = ni(st) - 1;
		}
		adj = new LinkedList[N];
		comp = new int[N];
		for (int i = 0; i < N; i++) adj[i] = new LinkedList<>();
		
		for (int i = 0; i < M; i++) {
			st = nl(f);
			int a = ni(st)-1, b = ni(st)-1, w = ni(st);
			adj[a].add(new Edge(b, w));
			adj[b].add(new Edge(a, w));
		}
		
		int MAX = (int) 1e9;
		
		int x = 0;
		for (int b = MAX / 2; b >= 1; b /= 2) {
			while (x + b < MAX && valid(x + b)) x += b;
		}
		
		out.println(x == MAX - 1 ? -1 : x);
		
		f.close();
		out.close();
	}
	
	static int N;
	static LinkedList<Edge> adj[];
	static int[] P;
	
	static class Edge {
		int u, w;
		Edge (int u, int w) {
			this.u = u;
			this.w = w;
		}
	}
	
	static int[] comp;
	
	static boolean valid(int minW) {
		Arrays.fill(comp, -1);
		
		int n = 0;
		for (int i = 0; i < N; i++) {
			if (comp[i] == -1) dfs(i, n++, minW);
		}
		
		for (int i = 0; i < N; i++) {
			if (comp[i] != comp[P[i]]) return false;
		}
		
		return true;
	}
	
	static void dfs(int i, int n, int min) {
		if (comp[i] > -1) return;
		comp[i] = n;
		for (Edge e : adj[i]) if (e.w >= min) dfs(e.u, n, min);
	}
}

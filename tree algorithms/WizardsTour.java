import java.util.*;
import java.io.*;

public class WizardsTour {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		setIO();

		st = nl();
		
		int N = ni(st), M = ni(st);
		
		adj1 = new LinkedList[N+1];
		for (int i = 1; i <= N; i++)
			adj1[i] = new LinkedList<>();
		
		for (int i = 0; i < M; i++) {
			st = nl();
			int u = ni(st), v = ni(st);
			adj1[u].add(v);
			adj1[v].add(u);
		}
		
		List<Integer> cc = new ArrayList<>(), size = new ArrayList<>();
		
		vis = new boolean[N+1];
		order = new int[N+1];
		for (int i = 1; i <= N; i++) {
			if (!vis[i]) {
				a = b = 0;
				dfs0(i);
				
				cc.add(i);
				size.add(a);
			}
		}
		
		out.println(Arrays.toString(order));
		
		for (int i = 0; i < cc.size(); i++) {
			d = 1;
			
			ts = new TreeSet<>();
			
			int K = size.get(i) / 2;
			
			node = new int[K+2];
			adj2 = new LinkedList[K+2];
			for (int j = 1; j <= K+1; j++)
				adj2[j] = new LinkedList<>();
			
			dfs1(cc.get(i));
			dfs2(cc.get(i), 0);
		}
		
		out.println(count + "\n" + ans);
		
		f.close();
		out.close();
	}
	
	static int a, b;
	static boolean[] vis;
	static int[] order;
	static void dfs0(int u) {
		if (vis[u]) return;
		vis[u] = true;
		order[u] = ++b;
		for (int v : adj1[u]) {
			a++;
			dfs0(v);
		}
	}
	
	static class Edge implements Comparable<Edge> {
		int a, b;
		Edge (int a, int b) {
			this.a = Math.min(a, b);
			this.b = Math.max(a, b);
		}
		
		public int compareTo(Edge o) {
			if (this.b == o.b) return Integer.compare(this.a, o.a);
			return Integer.compare(this.b, o.b);
		}
		
		public String toString() {
			return this.a + " " + this.b;
		}
	}

	static LinkedList<Integer>[] adj1;
	static TreeSet<Edge> ts;
	static int d;
	
	static int[] node;
	static LinkedList<Integer>[] adj2;
	
	static void dfs1(int u) {
		node[d] = u;
		int o = d;
		
		for (int v : adj1[order[u]]) {
			Edge e = new Edge(u, v);
			if (!ts.contains(e)) {
				ts.add(e);
				d++;
				adj2[o].add(d);
				adj2[d].add(o);
				dfs1(v);
			}
		}
	}
	
	static int count = 0;
	static StringBuffer ans = new StringBuffer();
	static void add(int a, int b, int c) {
		ans.append(node[a] + " " + node[b] + " " + node[c] + "\n");
		count++;
	}
	
	static boolean dfs2(int u, int e) {
		List<Integer> set = new ArrayList<>();
		
		for (int v : adj2[u]) {
			if (v != e && !dfs2(v, u)) set.add(v);
		}
		
		while (set.size() >= 2) {
			add(set.remove(0), u , set.remove(0));
		}
		
		if (set.size() == 1) {
			if (e > 0) add(e, u, set.remove(0));
			return true;
		} else return false;
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
/*
9 13
5 3
1 2
4 5
5 1
2 5
4 3
1 4
3 2
6 7
8 7
7 9
8 9
9 6

*/
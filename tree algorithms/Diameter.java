import java.util.*;
import java.io.*;
 
public class Diameter {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		setIO();
 
		int N = ni();
		adj = new LinkedList[N+1];
		for (int i = 0; i <= N; i++) adj[i] = new LinkedList<>();
		
		for (int i = 0; i < N-1; i++) {
			st = nl();
			int a = ni(st), b = ni(st);
			adj[a].add(b);
			adj[b].add(a);
		}
		
		dfs(1, 0, 0);
		
		farthestD = 0;
		dfs(farthest, 0, 0);
		
		out.println(farthestD);
		
		f.close();
		out.close();
	}
	
	static LinkedList<Integer> adj[];
	
	static int farthest, farthestD = 0;
	
	static void dfs(int u, int e, int d) {
		if (d > farthestD) {
			farthestD = d;
			farthest = u;
		}
		
		for (int v : adj[u]) {
			if (v != e) dfs(v, u, d+1);
		}
	}
	
	static BufferedReader f;
	static PrintWriter out;
	static StringTokenizer st;
 
	static int ni(StringTokenizer st) {
		return Integer.parseInt(st.nextToken());
	}
 
	static long nlg(StringTokenizer st) {
		return Long.parseLong(st.nextToken());
	}
 
	static int ni() throws IOException {
		return Integer.parseInt(f.readLine());
	}
 
	static long nlg() throws IOException {
		return Long.parseLong(f.readLine());
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
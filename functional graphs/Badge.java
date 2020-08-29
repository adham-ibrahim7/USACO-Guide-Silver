import java.util.*;
import java.io.*;

public class Badge {
	public static void main(String[] args) throws IOException {
		setIO();

		int N = ni();
		p = new int[N];
		st = nl();
		for (int i = 0; i < N; i++) {
			p[i] = ni(st)-1;
		}
		
		startLoop = new ArrayList<>();
		endCC = new ArrayList<>();
		
		vis = new boolean[N];
		order = new int[N];
		curr = 0;
		for (int i = 0; i < N; i++) {
			if (!vis[i]) {
				dfs(i, -1);
			}
		}
		
		int j = 0;
		for (int i = 0; i < N; i++) {
			if (order[i] < order[startLoop.get(j)]) {
				out.print(startLoop.get(j)+1 + " ");
			} else {
				out.print((i+1) + " ");
			}
			
			if (order[i] == order[endCC.get(j)]) j++;
		}
		out.println();
		
		f.close();
		out.close();
	}
	
	static List<Integer> startLoop;
	static List<Integer> endCC;
	static int[] p;
	static boolean[] vis;
	static int[] order;
	static int curr;

	static void dfs(int u, int e) {
		if (vis[u]) {
			startLoop.add(u);
			endCC.add(e);
			return;
		}
		
		order[u] = curr++;
		vis[u] = true;
		dfs(p[u], u);
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

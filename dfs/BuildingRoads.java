import java.util.*;
import java.io.*;
//https://cses.fi/problemset/task/1666
public class BuildingRoads {
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
		BufferedReader f = (new BufferedReader(new InputStreamReader(System.in)));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

		StringTokenizer st = nl(f);
		int N = ni(st), M = ni(st);
		adj = new LinkedList[N];
		for (int i = 0; i < N; i++) {
			adj[i] = new LinkedList<>();
		}
		vis = new boolean[N];
		
		for (int i = 0; i < M; i++) {
			st = nl(f);
			int a = ni(st)-1, b = ni(st)-1;
			
			adj[a].add(b);
			adj[b].add(a);
		}
		
		int k = 0;
		int[] ans = new int[N];
		Arrays.fill(ans, -1);
		for (int i = 0; i < N; i++) {
			if (!vis[i]) {
				ans[k++] = i+1;
				dfs(i);
			}
		}
		
		out.println(k-1);
		out.print(ans[0] + " ");
		for (int i = 1; i < k-1; i++) {
			out.print(ans[i] + "\n" + ans[i] + " ");
		}
		out.print(ans[k-1]);
		
		f.close();
		out.close();
	}
	
	static LinkedList<Integer>[] adj;
	static boolean[] vis;
	
	static void dfs(int i) {
		if (vis[i]) return;
		vis[i] = true;
		for (int u : adj[i]) dfs(u);
	}
}

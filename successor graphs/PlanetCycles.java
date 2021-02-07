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

		v = new boolean[N+1];
		u = new boolean[N+1];
		cycle = new int[N+1];

		for (int i = 1; i <= N; i++) {
			if (!v[i]) dfs1(i);
		}

		ans = new int[N+1];
		for (int i = 1; i <= N; i++) {
			if (cycle[i] == i && ans[i] == 0) dfs2(i, i, 0);
		}

		for (int i = 1; i <= N; i++) {
			if (ans[i] == 0) dfs3(i);
		}

		for (int i = 1; i <= N; i++) {
			out.print(ans[i] + " ");
		}
		out.println();

		f.close();
		out.close();
	}

	static int[] p;
	static boolean[] u;
	static boolean[] v;
	static int[] cycle;

	static int[] ans;

	static int dfs1(int n)
	{
		v[n]=u[n]=true;
		if(u[p[n]]) //Cycle created
		{
			cycle[n]=n;//Nodes in cycle point to themselves
			u[p[n]]=false;//remember where cycle started
			u[n]=false;
			return n != p[n] ? -1 : n;
		}
		else if(v[p[n]]) //You point into some already visited cycle
		{
			u[n]=false;
			return cycle[n]= cycle[p[n]];
		}
		else
		{
			int t= dfs1(p[n]); //t == -1 means you are in the cycle, and thus should point to yourself. Otherwise t is the node along the cycle that you point to
			if(t!=-1)
			{
				u[n]=false;
				return cycle[n]=t;
			}
			else if(u[n]) //You are part of the cycle, and so is the node that points to you.
			{
				u[n]=false;
				cycle[n]=n;
				return -1;
			}
			else //You are the start of the cycle. Whatever points to you is not part of the cycle anymore
				return cycle[n]=n;
		}
	}

	static void dfs2(int u, int r, int d) {
		if (u == r && d != 0) {
			ans[u] = d;
			return;
		}

		dfs2(p[u], r, d+1);
		ans[u] = ans[p[u]];
	}

	static void dfs3(int u) {
		if (ans[u] != 0) return;

		dfs3(p[u]);
		ans[u] = 1 + ans[p[u]];
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
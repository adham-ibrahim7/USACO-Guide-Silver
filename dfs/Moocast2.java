import java.util.*;
import java.io.*;

public class Moocast2 {
	public static void main(String[] args) throws IOException {
		setIO("moocast");

		N = ni();
		X = new int[N];
		Y = new int[N];
		for (int i = 0; i < N; i++) {
			st = nl();
			X[i] = ni(st);
			Y[i] = ni(st);
		}
		
		int MAX = (int) 1e9, K = MAX;
		for (int b = MAX / 2; b >= 1; b /= 2) {
			while (K-b >= 0 && valid(K-b)) K -= b;
		}
		
		out.println(K);
		
		f.close();
		out.close();
	}
	
	static int N;
	static int[] X, Y;
	
	static boolean valid(int K) {
		vis = new boolean[N];
		dfs(0, K);
		for (int i = 0; i < N; i++) {
			if (!vis[i]) return false;
		}
		return true;
	}
	
	static boolean[] vis;
	
	static void dfs(int i, int K) {
		if (vis[i]) return;
		vis[i] = true;
		for (int j = 0; j < N; j++) {
			if (j == i || (X[i]-X[j])*(X[i]-X[j]) + (Y[i]-Y[j])*(Y[i]-Y[j]) > K) continue;
			dfs(j, K);
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

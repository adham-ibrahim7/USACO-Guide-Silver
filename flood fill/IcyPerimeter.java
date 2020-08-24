import java.util.*;
import java.io.*;

public class IcyPerimeter {
	public static void main(String[] args) throws IOException {
		setIO("perimeter");

		N = ni();
		
		A = new char[N][N];
		for (int i = 0; i < N; i++) A[i] = rl().toCharArray();
		
		vis = new boolean[N][N];
		
		int bestArea = 0, bestPerimeter = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!vis[i][j] && A[i][j] == '#') {
					area = perimeter = 0;
					dfs(i, j);
					if (area > bestArea || area == bestArea && perimeter < bestPerimeter) {
						bestArea = area;
						bestPerimeter = perimeter;
					}
				}
			}
		}
		
		out.println(bestArea + " " + bestPerimeter);
		
		f.close();
		out.close();
	}
	
	static int N;
	static char[][] A;
	static boolean[][] vis;
	static int area, perimeter;
	
	static void dfs(int i, int j) {
		if (vis[i][j]) return;
		area++;
		vis[i][j] = true;
		if (i == 0 || A[i-1][j] == '.') perimeter++;
		else dfs(i-1, j);
		if (i == N-1 || A[i+1][j] == '.') perimeter++;
		else dfs(i+1, j);
		if (j == 0 || A[i][j-1] == '.') perimeter++;
		else dfs(i, j-1);
		if (j == N-1 || A[i][j+1] == '.') perimeter++;
		else dfs(i, j+1);
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

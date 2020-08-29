import java.util.*;
import java.io.*;

public class Mooyo {
	public static void main(String[] args) throws IOException {
		setIO("mooyomooyo");

		st = nl();
		N = ni(st);
		M = 10;
		K = ni(st);
		
		A = new char[N][M];
		for (int i = 0; i < N; i++) {
			A[i] = rl().toCharArray();
		}
		
		while (true) {
			boolean done = true;
			
			comp = new int[N][M];
			good = new TreeSet<>();
			
			int n = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					count = 0;
					
					if (comp[i][j] == 0 && A[i][j] != '0') {
						dfs(i, j, ++n);
						
						if (count >= K) {
							done = false;
							good.add(n);
						}
					}
				}
			}
			
			if (done) break;
			reset();
		}
		
		for (char[] c : A) {
			for (char d : c) out.print(d);
			out.println();
		}
		
		f.close();
		out.close();
	}
	
	static int N, M, K;
	static char[][] A;

	static int count;
	static int[][] comp;
	static TreeSet<Integer> good;
	
	static void dfs(int i, int j, int c) {
		if (comp[i][j] > 0) return;
		comp[i][j] = c;
		
		count++;
		
		if (i > 0 && A[i][j] == A[i-1][j]) dfs(i-1, j, c);
		if (i < N-1 && A[i][j] == A[i+1][j]) dfs(i+1, j, c);
		if (j > 0 && A[i][j] == A[i][j-1]) dfs(i, j-1, c);
		if (j < M-1 && A[i][j] == A[i][j+1]) dfs(i, j+1, c);
	}
	
	static void reset() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (good.contains(comp[i][j])) {
					A[i][j] = '0';
				}
			}
		}
		
		for (int n = 0; n < 50; n++) {
			for (int j = 0; j < M; j++) {
				int start = -1, end = -1;
				
				int i = 0;
				while (i < N && A[i][j] == '0') i++;
				
				while (i < N-1 && A[i+1][j] != '0') i++;
				start = i;
				
				while (i < N-1 && A[i+1][j] == '0') i++;
				end = i;
				
				//out.println(j + " " + start + " " + end);
				
				if (start == -1) continue;
				
				int d = end - start;
				for (i = end; i >= 0; i--) {
					if (i < N) A[i][j] = i >= d ? A[i-d][j] : '0';
				}
			}
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

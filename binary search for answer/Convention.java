import java.util.*;
import java.io.*;

public class Convention {
	public static void main(String[] args) throws IOException {
		setIO("convention");

		st = nl();
		N = ni(st); M = ni(st); C = ni(st);
		A = nia(N);
		Arrays.sort(A);
		
		int MAX = (int) 1e9;
		int x = MAX;
		for (int b = MAX / 2; b >= 1; b /= 2) {
			while (x - b >= 0 && valid(x-b)) x -= b;
		}
		
		out.println(x);
		
		f.close();
		out.close();
	}
	
	static int N, M, C;
	static int[] A;
	
	static boolean valid(int x) {
		int last = 0, count = 0;
		for (int i = 1; i <= N; i++) {
			if (i == N || i-last == C || A[i] - A[last] > x) {
				last = i;
				count++;
			}
		}
		
		return count <= M;
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

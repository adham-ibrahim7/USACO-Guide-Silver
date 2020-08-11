import java.util.*;
import java.io.*;

public class ArrayDivision {
	public static void main(String[] args) throws IOException {
		setIO();

		st = nl();
		N = ni(st); K = ni(st);
		A = nia(N);
		
		long MAX = (long) 1e18, x = MAX;
		for (long b = MAX / 2; b >= 1; b/= 2) {
			while(valid(x-b)) x-= b;
		}
		
		out.println(x);
		
		f.close();
		out.close();
	}
	
	static int N, K;
	static int[] A;

	static boolean valid(long x) {
		int k = 0;
		
		long s = 0, m = 0;
		for (int i = 0; i <= N; i++) {
			if (i == N || s + A[i] > x) {
				k++;
				s = 0;
				if (k > K) return false;
			}
			if (i < N) {
				s += A[i];
				if (A[i] > x) return false;
			}
		}
		
		return m <= x;
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

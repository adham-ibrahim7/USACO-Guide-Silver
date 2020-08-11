import java.util.*;
import java.io.*;

public class AngryCows {
	public static void main(String[] args) throws IOException {
		setIO("angry");

		st = nl();
		N = ni(st); K = ni(st);
		A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = ni();
		}
		Arrays.sort(A);
		
		int MAX = (int) 1e9, R = MAX;
		for (int b = MAX / 2; b >= 1; b /= 2) {
			while (R-b > 0 && valid(R-b)) R -= b;
		}
		
		out.println(R);
		
		f.close();
		out.close();
	}
	
	static int N, K;
	static int[] A;
	
	static boolean valid(int R) {
		int total = 0, first = A[0], last = A[0];
		for (int i = 1; i < N; i++) {
			if (i == N-1) last = A[i];
			if (i == N-1 || A[i] - first > 2 * R) {
				total += (last - first + 2 * R - 1) / (2 * R);
				first = A[i];
			}
			last = A[i];
		}
		return total <= K;
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

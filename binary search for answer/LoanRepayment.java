import java.util.*;
import java.io.*;

public class LoanRepayment {
	public static void main(String[] args) throws IOException {
		setIO("loan");

		st = nl();
		N = nlg(st); M = nlg(st); K = nlg(st);
		
		long MAX = (long) 1e12, X = 1;
		for (long b = MAX / 2; b >= 1; b /= 2) {
			while (X+b <= MAX && valid(X+b)) X += b;
		}
		
		out.println(X);
		
		f.close();
		out.close();
	}
	
	static long N, M, K;
	
	static boolean valid(long X) {
		long count = 0;
		
		long A = N;
		while (A > X * M) {
			A -= A / X;
			count++;
			if (count >= K) return true;
		}
		
		count += (A + M - 1) / M;
		
		return count <= K;
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

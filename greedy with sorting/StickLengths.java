import java.util.*;
import java.io.*;

public class StickLengths {
	public static void main(String[] args) throws IOException {
		setIO();

		int N = ni();
		int[] A = nia(N);
		Arrays.sort(A);
		int m = N % 2 == 1 ? A[N / 2] : (A[N / 2] + A[N / 2 - 1]) / 2;
		
		long ans = 0;
		for (int n : A) {
			ans += Math.abs(n - m);
		}
		
		out.println(ans);
		
		f.close();
		out.close();
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

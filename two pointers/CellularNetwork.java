import java.util.*;
import java.io.*;

public class CellularNetwork {
	public static void main(String[] args) throws IOException {
		setIO();

		st = nl();
		int N = ni(st), M = ni(st);
		int[] A = nia(N), B = nia(M);
		
		int j = 0, ans = 0;
		for (int i = 0; i < N; i++) {
			while (j < M-1 && A[i] > B[j+1]) {
				j++;
			}
			
			int left = j == M ? (int) 2e9 : Math.abs(A[i] - B[j]);
			int right = j == M-1 ? (int) 2e9 : Math.abs(B[j+1] - A[i]);
			
			ans = Math.max(ans, Math.min(left, right));
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

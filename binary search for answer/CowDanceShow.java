import java.util.*;
import java.io.*;

public class CowDanceShow {
	public static void main(String[] args) throws IOException {
		setIO("cowdance");

		st = nl();
		N = ni(st);
		T = ni(st);
		A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = ni();
		}
		
		int K = N;
		for (int b = N / 2; b >= 1; b /= 2) {
			while (K-b >= 1 && valid(K-b)) K -= b;
		}
		
		out.println(K);
		
		f.close();
		out.close();
	}
	
	static int N, T;
	static int[] A;
	
	static boolean valid(int K) {
		ms = new TreeMap<>();
		for (int i = 0; i < K; i++) {
			add(A[i]);
		}
		
		for (int i = K; i < N; i++) {
			int prev = delete(ms.firstKey());
			add(A[i] + prev);
		}
		
		return T >= ms.lastKey();
	}
	
	static TreeMap<Integer, Integer> ms;

	static void add(int x) {
		ms.put(x, ms.getOrDefault(x, 0) + 1);
	}

	static int delete(int x) {
		int c = ms.get(x);
		ms.put(x, --c);
		if (c == 0)
			ms.remove(x);
		return x;
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

import java.util.*;
import java.io.*;

public class HighCardLowCard {
	public static void main(String[] args) throws IOException {
		setIO("cardgame");

		int N = ni();
		TreeSet<Integer> ts = new TreeSet<>();
		for (int i = 1; i <= 2 * N; i++) ts.add(i);
		
		int[] Q = new int[N];
		for (int i = 0; i < N; i++) {
			Q[i] = ni();
			ts.remove(Q[i]);
		}
		
		TreeSet<Integer> big = new TreeSet<>(), small = new TreeSet<>();
		
		for (int i = 0; i < N / 2; i++) {
			big.add(ts.pollLast());
		}
		
		small = ts;
		
		int ans = 0;
		for (int i = 0; i < N / 2; i++) {
			if (big.higher(Q[i]) != null) {
				big.remove(big.higher(Q[i]));
				ans++;
			}
		}
		
		for (int i = N / 2; i < N; i++) {
			if (small.lower(Q[i]) != null) {
				small.remove(small.lower(Q[i]));
				ans++;
			}
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

	static long nlg(StringTokenizer st) {
		return Long.parseLong(st.nextToken());
	}

	static int ni() throws IOException {
		return Integer.parseInt(f.readLine());
	}

	static long nlg() throws IOException {
		return Long.parseLong(f.readLine());
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

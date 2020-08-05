import java.util.*;
import java.io.*;

public class SumOfThree {
	public static void main(String[] args) throws IOException {
		setIO();

		StringTokenizer st = nl();
		N = ni(st);
		X = ni(st);
		A = new Num[N];
		st = nl();
		for (int i = 0; i < N; i++) {
			A[i] = new Num(ni(st), i+1);
		}
		Arrays.sort(A);
		
		solve();
		
		f.close();
		out.close();
	}
	
	static class Num implements Comparable<Num> {
		int val, index;
		Num(int val, int index) {
			this.val = val;
			this.index = index;
		}
		
		public int compareTo(Num o) {
			return Integer.compare(this.val, o.val);
		}
	}
	
	static int N, X;
	static Num[] A;
	
	static Pair two(int k, int S) {
		int i = 0, j = N-1;
		while (i < j) {
			if (i == k) i++;
			if (j == k) j--;
			if (A[i].val + A[j].val < S) {
				i++;
			} else if (A[i].val + A[j].val > S) {
				j--;
			} else {
				return new Pair(i, j);
			}
		}
		
		return null;
	}
	
	static void solve() {
		for (int i = 0; i < N; i++) {
			Pair p = two(i, X - A[i].val);
			if (p != null) {
				out.println(A[i].index + " " + (A[p.first].index) + " " + (A[p.second].index));
				return;
			}
		}
		out.println("IMPOSSIBLE");
	}
	
	static class Pair {
		int first, second;
		Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
		
		public String toString() {
			return this.first + " " + this.second;
		}
	}

	static final int MOD = 1000000007;

	static BufferedReader f;
	static PrintWriter out;

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

	static void setIO(String s) throws IOException {
		f = new BufferedReader(new FileReader(s + ".in"));
		out = new PrintWriter(new FileWriter(s + ".out"));
	}

	static void setIO() {
		f = (new BufferedReader(new InputStreamReader(System.in)));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	}
}

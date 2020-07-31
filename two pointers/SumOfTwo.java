import java.util.*;
import java.io.*;
//https://cses.fi/problemset/task/1640
public class SumOfTwo {
	static int ni(StringTokenizer st) {
		return Integer.parseInt(st.nextToken());
	}

	static int ni(BufferedReader f) throws IOException {
		return Integer.parseInt(f.readLine());
	}

	static StringTokenizer nl(BufferedReader f) throws IOException {
		return new StringTokenizer(f.readLine());
	}

	static int[] nia(int N, BufferedReader f) throws IOException {
		StringTokenizer st = nl(f);
		int[] A = new int[N];
		for (int i = 0; i < N; i++)
			A[i] = ni(st);
		return A;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader f = (new BufferedReader(new InputStreamReader(System.in)));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		
		class Num implements Comparable<Num> {
			int e, i;
			Num(int e, int i) {
				this.e = e;
				this.i = i;
			}
			public int compareTo(Num o) {
				return Integer.compare(this.e, o.e);
			}
		}
		
		StringTokenizer st = nl(f);
		int N = ni(st), X = ni(st);
		st = nl(f);
		Num[] A = new Num[N];
		for (int i = 0; i < N; i++) A[i] = new Num(ni(st), i+1);
		Arrays.sort(A);
		int i = 0, j = N-1;
		while (i < j) {
			int s = A[i].e + A[j].e;
			if (s > X) {
				j--;
			} else if (s < X) {
				i++;
			} else {
				break;
			}
		}
		
		out.println(i == j ? "IMPOSSIBLE" : A[i].i + " " + A[j].i);
		
		f.close();
		out.close();
	}
}

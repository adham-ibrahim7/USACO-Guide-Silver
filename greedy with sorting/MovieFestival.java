import java.util.*;
import java.io.*;

public class MovieFestival {
	public static void main(String[] args) throws IOException {
		setIO();

		int N = ni();
		Movie[] M = new Movie[N];
		for (int i = 0; i < N; i++) {
			st = nl();
			int s = ni(st), e = ni(st);
			M[i] = new Movie(s, e);
		}
		Arrays.sort(M);
		
		int end = 0, ans = 0;
		for (int i = 0; i < N; i++) {
			if (M[i].s >= end) {
				end = M[i].e;
				ans++;
			}
		}
		
		out.println(ans);
		
		f.close();
		out.close();
	}
	
	static class Movie implements Comparable<Movie> {
		int s, e;
		Movie(int s, int e) {
			this.s = s;
			this.e = e;
		}
		
		public int compareTo(Movie o) {
			return Integer.compare(this.e, o.e);
		}
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

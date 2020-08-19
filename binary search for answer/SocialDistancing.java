import java.util.*;
import java.io.*;

public class SocialDistancing {
	public static void main(String[] args) throws IOException {
		setIO("socdist");
		
		st = nl();
		N = ni(st);
		M = ni(st);
		
		S = new Segment[M];
		for (int i = 0; i < M; i++) {
			st = nl();
			S[i] = new Segment(ni(st), ni(st));
		}
		
		Arrays.sort(S);
		
		long MAX = (long) 1e18, D = 1;
		for (long b = MAX / 2; b >= 1; b /= 2) {
			while (D + b < MAX && valid(D + b)) D += b;
		}
		
		out.println(D);

		f.close();
		out.close();
	}
	
	static class Segment implements Comparable<Segment> {
		long l, r;
		Segment(long l, long r) {
			this.l = l;
			this.r = r;
		}
		
		public int compareTo(Segment o) {
			return Long.compare(this.l, o.l);
		}
	}
	
	static int N, M;
	static Segment[] S;
	
	static boolean valid(long D) {
		long s = 0;
		
		long curr = 0;
		for (int i = 0; i < M; i++) {
			if (curr > S[i].r) continue;
			if (curr < S[i].l) curr = S[i].l;
			
			s++;
			
			long c = (S[i].r - curr) / D;
			s += c;
			curr += D * (c+1);
		}
		
		return s >= N;
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

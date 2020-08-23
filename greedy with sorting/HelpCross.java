import java.util.*;
import java.io.*;

public class HelpCross {
	public static void main(String[] args) throws IOException {
		setIO("helpcross");
		
		st = nl();
		int N = ni(st), M = ni(st);
		
		for (int i = 0; i < N; i++) {
			add(ni());
		}
		
		add(1000000001);
		
		Segment[] S = new Segment[M];
		for (int i = 0; i < M; i++) {
			st = nl();
			S[i] = new Segment(ni(st), ni(st));
		}
		Arrays.sort(S);
		
		int ans = 0;
		for (Segment s : S) {
			int c = ms.ceilingKey(s.l);
			if (c > s.r) continue;
			
			ans++;
			delete(c);
		}
		
		out.println(ans);

		f.close();
		out.close();
	}
	
	static TreeMap<Integer, Integer> ms = new TreeMap<>();

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
	
	static class Segment implements Comparable<Segment> {
		int l, r;
		Segment(int l, int r) {
			this.l = l;
			this.r = r;
		}
		
		public int compareTo(Segment o) {
			if (this.r == o.r) return -Integer.compare(this.l, o.l);
			return Integer.compare(this.r, o.r);
		}
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

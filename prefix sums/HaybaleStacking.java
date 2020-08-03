import java.util.*;
import java.io.*;

public class HaybaleStacking {
	public static void main(String[] args) throws IOException {
		setIO("stacking");

		StringTokenizer st = nl();
		int N = ni(st), K = ni(st);
		
		List<Event> ev = new ArrayList<>();
		for (int i = 0; i < K; i++) {
			st = nl();
			int a = ni(st), b = ni(st)+1;
			ev.add(new Event(a, 1));
			ev.add(new Event(b, -1));
		}
		
		Collections.sort(ev);
		
		int[] counts = new int[K+1];
		int c = 0;
		int j = 0;
		for (int i = 1; i <= N; i++) {
			while (j < 2 * K && ev.get(j).t == i) {
				c += ev.get(j++).delta;
			}
			
			counts[c]++;
		}
		
		int s = 0;
		int i;
		for (i = 0; i <= K; i++) {
			s += counts[i];
			if (s >= (N+1) / 2) break;
		}
		
		out.println(i);
		
		f.close();
		out.close();
	}
	
	static class Event implements Comparable<Event> {
		int t, delta;
		
		Event(int t, int delta) {
			this.t = t;
			this.delta = delta;
		}
		
		public int compareTo(Event o) {
			return Integer.compare(this.t, o.t);
		}
		
		public String toString() {
			return this.t + " " + this.delta;
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

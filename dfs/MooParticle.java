import java.util.*;
import java.io.*;

public class MooParticle {
	public static void main(String[] args) throws IOException {
		setIO("moop");

		int N = ni();
		
		Particle[] P = new Particle[N];
		for (int i = 0; i < N; i++) {
			st = nl();
			P[i] = new Particle(ni(st), ni(st));
		}
		
		Arrays.sort(P);
		
		int[] min = new int[N];
		min[0] = P[0].y;
		int[] max = new int[N];
		max[N-1] = P[N-1].y;
		
		for (int i = 1; i < N; i++) {
			min[i] = Math.min(min[i-1], P[i].y);
		}
		
		for (int i = N-2; i >= 0; i--) {
			max[i] = Math.max(max[i+1], P[i].y);
		}
		
		int ans = 1;
		for (int i = 0; i < N-1; i++) {
			if (min[i] > max[i+1]) ans++;
		}
		
		out.println(ans);
		
		f.close();
		out.close();
	}
	
	static class Particle implements Comparable<Particle> {
		int x, y;
		Particle(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public int compareTo(Particle o) {
			if (this.x == o.x) return Integer.compare(this.y, o.y);
			return Integer.compare(this.x, o.x);
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

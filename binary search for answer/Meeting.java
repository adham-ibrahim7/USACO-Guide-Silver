import java.util.*;
import java.io.*;

public class Meeting {
	public static void main(String[] args) throws IOException {
		setIO();

		N = ni();
		x = nia(N);
		v = nia(N);
		
		double MAX = (int) 1e9, t = MAX;
		for (double b = MAX / 2; b >= 0.0000001; b /= 2) {
			while (t-b >= 0 && valid(t-b)) t -= b;
		}
		
		out.println(t);
		
		f.close();
		out.close();
	}
	
	static class EndPoint implements Comparable<EndPoint> {
		double x;
		boolean open;
		EndPoint(double x, boolean open) {
			this.x = x;
			this.open = open;
		}
		
		public int compareTo(EndPoint o) {
			if (this.x == o.x) return Boolean.compare(this.open, o.open);
			return Double.compare(this.x, o.x);
		}
	}
	
	static int N;
	static int[] x;
	static int[] v;
	
	static boolean valid(double t) {
		EndPoint[] E = new EndPoint[2*N];
		for (int i = 0; i < N; i++) {
			E[2*i] = new EndPoint(x[i]-v[i]*t, true);
			E[2*i+1] = new EndPoint(x[i]+v[i]*t, false);
		}
		
		Arrays.sort(E);
		
		int count = 0;
		for (int i = 0; i < 2*N-1; i++) {
			if (E[i].open) {
				count++;
			} else {
				count--;
			}
			
			if (count == N) return true;
		}
		
		return false;
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

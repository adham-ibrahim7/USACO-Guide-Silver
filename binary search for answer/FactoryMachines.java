import java.util.*;
import java.io.*;

public class FactoryMachines {
	public static void main(String[] args) throws IOException {
		setIO();

		st = nl();
		N = ni(st); T = ni(st);
		A = nia(N);
		
		long t = (long) 1e18;
		for (long b = (long) 5e17; b >= 1; b /= 2) {
			while (t - b >= 0 && valid(t - b)) {
				t -= b;
			}
		}
		
		out.println(t);
		
		f.close();
		out.close();
	}
	
	static int N, T;
	static int[] A;
	
	static boolean valid(long t) {
		long s = 0;
		
		for (int n : A) {
			s += t / n;
			if (s >= T) return true;
		}
		
		return false;
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
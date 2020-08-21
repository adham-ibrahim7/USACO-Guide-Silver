import java.util.*;
import java.io.*;

public class MagicShip {
	public static void main(String[] args) throws IOException {
		setIO();

		st = nl();
		x = ni(st); y = ni(st);
		
		st = nl();
		x = ni(st) - x; y = ni(st) - y;
		
		N = ni();
		s = rl().toCharArray();
		
		dx = new int[N+1];
		dy = new int[N+1];
		
		for (int i = 0; i < N; i++) {
			dx[i+1] = dx[i] + (s[i] == 'L' ? -1 : s[i] == 'R' ? 1 : 0);
			dy[i+1] = dy[i] + (s[i] == 'D' ? -1 : s[i] == 'U' ? 1 : 0);
		}
		
		int MAX = (int) 2e9, k = MAX;
		for (int b = MAX / 2; b >= 1; b /= 2) {
			while (k-b >= 0 && valid(k-b)) k -= b;
		}
		
		out.println(k == MAX ? -1 : k);
		
		f.close();
		out.close();
	}
	
	static int x, y;
	static int N;
	static char[] s;
	static int[] dx, dy;
	
	static int query(int[] dz, int k) {
		return dz[N] * (k / N) + dz[k % N];
	}
	
	static boolean valid(int k) {
		return Math.abs(x - query(dx, k)) + Math.abs(y - query(dy, k)) <= k;
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

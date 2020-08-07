import java.util.*;
import java.io.*;

public class PaintingTheBarn {
	public static void main(String[] args) throws IOException {
		setIO("paintbarn");

		StringTokenizer st = nl();
		int N = ni(st), K = ni(st);
		final int MAX = 1001;
		int[][] dif = new int[MAX][MAX];
		while (N-- > 0) {
			st = nl();
			int x = ni(st), y = ni(st), X = ni(st), Y = ni(st);
			for (int i = y; i < Y; i++) {
				dif[i][x]++;
				dif[i][X]--;
			}
		}
		
		int ans = 0;
		for (int i = 0; i < MAX; i++) {
			int s = 0;
			for (int j = 0; j < MAX; j++) {
				s += dif[i][j];
				if (s == K) ans++;
			}
		}
		
		out.println(ans);
		
		f.close();
		out.close();
	}

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

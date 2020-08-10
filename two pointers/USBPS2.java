import java.util.*;
import java.io.*;

public class USBPS2 {
	public static void main(String[] args) throws IOException {
		setIO();

		st = nl();
		int a = ni(st), b = ni(st), c = ni(st);
		int m = ni();
		Mouse[] mouses = new Mouse[m];
		for (int i = 0; i < m; i++) {
			st = nl();
			int cost = ni(st), type = st.nextToken().equals("USB") ? 0 : 1;
			mouses[i] = new Mouse(type, cost);
		}
		
		Arrays.sort(mouses);
		
		long count = 0, ans = 0;
		for (int i = 0; i < m; i++) {
			if (mouses[i].type == 0) {
				if (a + c > 0) {
					count++; ans += mouses[i].cost;
				}
				if (a > 0) a--;
				else if (c > 0) c--;
			} else {
				if (b + c > 0) {
					count++; ans += mouses[i].cost;
				}
				if (b > 0) b--;
				else if (c > 0) c--;
			}
		}
		
		out.println(count + " " + ans);
		
		f.close();
		out.close();
	}
	
	static class Mouse implements Comparable<Mouse> {
		int type, cost;
		Mouse(int t, int c) {
			type = t;
			cost = c;
		}
		
		public int compareTo(Mouse o) {
			return Integer.compare(this.cost, o.cost);
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

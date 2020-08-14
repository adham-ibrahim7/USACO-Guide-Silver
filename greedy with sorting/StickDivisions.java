import java.util.*;
import java.io.*;

public class StickDivisions {
	public static void main(String[] args) throws IOException {
		setIO();

		st = nl();
		int X = ni(st), N = ni(st);
		ms = new TreeMap<Integer, Integer>();
		st = nl();
		for (int i = 0; i < N; i++) add(ni(st));
		
		long ans = 0;
		
		for (int i = 0; i < N-1; i++) {
			int s = delete(ms.firstKey()) + delete(ms.firstKey());
			ans += s;
			add(s);
		}
		
		out.println(ans);
		
		f.close();
		out.close();
	}
	
	static TreeMap<Integer, Integer> ms;

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

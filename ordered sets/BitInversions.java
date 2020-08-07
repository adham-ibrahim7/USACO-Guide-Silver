import java.util.*;
import java.io.*;
//https://cses.fi/problemset/task/1188
public class BitInversions {
	public static void main(String[] args) throws IOException {
		setIO();
		
		char[] s = f.readLine().toCharArray();
		N = s.length;
		
		ts = new TreeSet<>();
		ms = new TreeMap<>();
		
		for (int i = 0; i < N; i++) {
			if (i == 0 || s[i] != s[i-1]) ts.add(i);
			if (i == N-1 || s[i] != s[i+1]) ts.add(i+1);
		}
		
		for (int n : ts) {
			if (n > 0) add(n - ts.lower(n));
		}
		
		int Q = ni();
		StringTokenizer st = nl();
		while (Q-- > 0) {
			int x = ni(st);
			modify(x);
			modify(x-1);
			out.print(ms.lastKey() + " ");
		}
		out.println();
		
		f.close();
		out.close();
	}
	
	static int N;
	static TreeSet<Integer> ts;
	static TreeMap<Integer, Integer> ms;
	
	static void modify(int x) {
		if (x == 0 || x == N) return;
		int a = ts.lower(x), b = ts.higher(x);
		if (ts.contains(x)) {
			ts.remove(x);
			delete(x - a);
			delete(b - x);
			add(b - a);
		} else {
			ts.add(x);
			delete(b - a);
			add(x - a);
			add(b - x);
		}
	}
	
	static void add(int x) {
		ms.put(x, ms.getOrDefault(x, 0) + 1);
	}
	
	static void delete(int x) {
		if (x == 0) return;
		int c = ms.get(x);
		ms.put(x, --c);
		if (c == 0) ms.remove(x);
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

	static void setIO(String s) throws IOException {
		f = new BufferedReader(new FileReader(s + ".in"));
		out = new PrintWriter(new FileWriter(s + ".out"));
	}

	static void setIO() {
		f = (new BufferedReader(new InputStreamReader(System.in)));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	}
}

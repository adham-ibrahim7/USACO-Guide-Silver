import java.io.*;
import java.util.*;
//https://cses.fi/problemset/task/1091/
public class ConcertTickets {
	static int ni(StringTokenizer st) {
		return Integer.parseInt(st.nextToken());
	}

	static int ni(BufferedReader f) throws IOException {
		return Integer.parseInt(f.readLine());
	}

	static StringTokenizer nl(BufferedReader f) throws IOException {
		return new StringTokenizer(f.readLine());
	}

	static int[] nia(int N, BufferedReader f) throws IOException {
		StringTokenizer st = nl(f);
		int[] A = new int[N];
		for (int i = 0; i < N; i++)
			A[i] = ni(st);
		return A;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		
		StringTokenizer st = nl(f);
		int N = ni(st), M = ni(st);
		TreeMap<Integer, Integer> ts = new TreeMap<Integer, Integer>();
		
		st = nl(f);
		for (int i = 0; i < N; i++) {
			int t = ni(st);
			if (ts.containsKey(t)) {
				ts.put(t, ts.get(t) + 1);
			} else {
				ts.put(t, 1);
			}
		}
		
		st = nl(f);
		for (int i = 0; i < M; i++) {
			Integer t = ts.floorKey(ni(st));
			if (t == null) {
				out.println(-1);
			} else {
				out.println(t);
				ts.put(t, ts.get(t) - 1);
				if (ts.get(t) == 0) ts.remove(t);
			}
		}
		
		f.close();
		out.close();
	}
}
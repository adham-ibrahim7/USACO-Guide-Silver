import java.util.*;
import java.io.*;

public class SubarraySums2 {
	public static void main(String[] args) throws IOException {
		setIO();

		StringTokenizer st = nl();
		int N = ni(st), X = ni(st);
		int[] A = nia(N);
		
		HashMap<Long, Integer> map = new HashMap<>();
		map.put(0l, 1);
		
		long s = 0, ans = 0;
		for (int n : A) {
			s += n;
			long comp = s - X;
			ans += map.getOrDefault(comp, 0);
			map.put(s, map.getOrDefault(s, 0) + 1);
		}
		
		out.println(ans);
		
		f.close();
		out.close();
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

import java.util.*;
import java.io.*;

public class SubarraySums {
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
		BufferedReader f = (new BufferedReader(new InputStreamReader(System.in)));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

		StringTokenizer st = nl(f);
		int N = ni(st), X = ni(st);
		int[] A = nia(N, f);
		
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
}
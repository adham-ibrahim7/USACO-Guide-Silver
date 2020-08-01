import java.util.*;
import java.io.*;
//https://cses.fi/problemset/task/1619
public class RestaurantCustomers {
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
		
		long start = System.currentTimeMillis();
		
		int N = Integer.parseInt(f.readLine());
		TreeSet<EndPoint> set = new TreeSet<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(f.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			set.add(new EndPoint(a, true));
			set.add(new EndPoint(b, false));
		}
		
		int ans = 0;
		int count = 0;
		for (EndPoint u : set) {
			if (u.isStart) {
				count++;
			} else {
				count--;
			}
			ans = Math.max(ans, count);
		}
		
		out.println(ans);
		
		f.close();
		out.close();
	}
	
	static class EndPoint implements Comparable<EndPoint> {
		int p;
		boolean isStart;
		EndPoint(int p, boolean isStart) {
			this.p = p;
			this.isStart = isStart;
		}
		
		public int compareTo(EndPoint o) {
			return Integer.compare(this.p, o.p);
		}
	}
}

import java.util.*;
import java.io.*;
//http://www.usaco.org/index.php?page=viewproblem2&cpid=896
public class MountainView {
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
		BufferedReader f = new BufferedReader(new FileReader("mountains.in"));	
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mountains.out")));

		//BufferedReader f = (new BufferedReader(new InputStreamReader(System.in)));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		
		int N = ni(f);
		Seg[] seg = new Seg[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = nl(f);
			int x = ni(st), y = ni(st);
			seg[i] = new Seg(x - y, x + y);
		}
		Arrays.sort(seg);
		int maxr = Integer.MIN_VALUE;
		int ans = 0;
		for (int i = 0; i < N; i++) {
			if (maxr < seg[i].r) {
				ans++;
			}
			
			maxr = Math.max(seg[i].r, maxr);
		}

		out.println(ans);
		
		f.close();
		out.close();
	}
	
	static class Seg implements Comparable<Seg> {
		int l, r;
		Seg(int l, int r) {
			this.l = l;
			this.r = r;
		}
		
		public int compareTo(Seg o) {
			if (this.l == o.l) return -Integer.compare(this.r, o.r);
			return Integer.compare(this.l, o.l);
		}
	}
}

import java.util.*;
import java.io.*;

public class Triangles {
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
		//BufferedReader f = new BufferedReader(new FileReader("triangles.in"));	
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("triangles.out")));

		for (int i = 0; i < 20010; i++) {
			for (int j = 0; j < 20010; j++) {
				q[i][j] = 1;
			}
		}
		
		BufferedReader f = (new BufferedReader(new InputStreamReader(System.in)));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

		int N = ni(f);
		Point[] pt = new Point[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = nl(f);
			int x = ni(st) + 10000, y = ni(st) + 10000;
			pt[i] = new Point(x, y);
			out.println(x / 1321 + " " + y / 1321);
		}
		
		Arrays.sort(pt, Point.xComp());
		
		curr = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			curr.add(pt[i].y);
			if (i == N - 1 || pt[i].x != pt[i+1].x) {
				assign(pt[i].x, true);
				curr = new ArrayList<>();
			}
		}

		Arrays.sort(pt, Point.yComp());
		
		for (int i = 0; i < N; i++) {
			curr.add(pt[i].x);
			if (i == N - 1 || pt[i].y != pt[i+1].y) {
				assign(pt[i].y, false);
				curr = new ArrayList<>();
			}
		}
		
		long ans = 0;
		for (Point p : pt) {
			//out.println((p.x - 10000) + " " + (p.y - 10000) + " " + q[p.x][p.y]);
			ans = (ans + q[p.x][p.y]) % MOD;
		}
		
		out.println(ans);
		
		f.close();
		out.close();
	}
	
	static List<Integer> curr;
	static int[][] q = new int[20010][20010];
	
	static void assign(int x, boolean foo) {
		long s = 0;
		for (int n : curr) s += n - curr.get(0);
		if (foo) set(x, curr.get(0), s);
		else set(curr.get(0), x, s);
		
		for (int i = 1; i < curr.size(); i++) {
			s = s + (long) (2 * i - curr.size()) * (curr.get(i) - curr.get(i-1));
			if (foo) set(x, curr.get(i), s);
			else set(curr.get(i), x, s);
		}
	}
	
	static int MOD = 1000000007;
	
	static void set(int x, int y, long s) {
		q[x][y] = (int) (q[x][y] * s % MOD);
	}
	
	static class Point {
		int x, y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		static Comparator<Point> xComp() {
			return new Comparator<Point>() {
				public int compare(Point a, Point b) {
					if (a.x == b.x) return Integer.compare(a.y, b.y);
					return Integer.compare(a.x, b.x);
				}
			};
		}
		
		static Comparator<Point> yComp() {
			return new Comparator<Point>() {
				public int compare(Point a, Point b) {
					if (a.y == b.y) return Integer.compare(a.x, b.x);
					return Integer.compare(a.y, b.y);
				}
			};
		}
	}
}

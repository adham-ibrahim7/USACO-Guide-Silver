import java.util.*;
import java.io.*;
//http://www.usaco.org/index.php?page=viewproblem2&cpid=645
public class SplittingTheField {
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
		BufferedReader f = new BufferedReader(new FileReader("split.in"));	
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("split.out")));

		//BufferedReader f = (new BufferedReader(new InputStreamReader(System.in)));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

		N = ni(f);
		cows = new Cow[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = nl(f);
			int x = ni(st), y = ni(st);
			
			cows[i] = new Cow(x, y);
		}
		
		long ans = solve();
		for (int i = 0; i < N; i++) {
			cows[i] = new Cow(cows[i].y, cows[i].x);
		}
		ans = Math.max(ans, solve());
		out.println(ans);
		
		f.close();
		out.close();
	}
	
	static int N;
	static Cow[] cows;
	
	static long solve() {
		TreeSet<Cow> left = new TreeSet<>(Cow.ycomp()), right = new TreeSet<>(Cow.ycomp());
		for (Cow cow : cows) right.add(cow);
		
		Arrays.sort(cows, Cow.xcomp());
		
		long total = (long) (cows[N-1].x - cows[0].x) * (right.last().y - right.first().y);
		//System.out.println(total);
		
		long ans = Long.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			Cow curr = cows[i];
			left.add(curr);
			right.remove(curr);
			
			long leftarea = (long) (curr.x - cows[0].x) * (left.last().y - left.first().y);
			long rightarea = i == N-1 ? 0 : (long) (cows[N-1].x - cows[i+1].x) * (right.last().y - right.first().y);
			//out.println(curr.x + " " + curr.y);
			//System.out.println(leftarea + " " + rightarea);
			ans = Math.min(ans, leftarea + rightarea);
		}
		
		return total - ans;
	}
	
	static class Cow {
		int x, y;
		Cow (int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		static Comparator<Cow> xcomp() {
			return new Comparator<Cow>() {
				public int compare(Cow a, Cow b) {
					if (a.x == b.x) return Integer.compare(a.y, b.y);
					return Integer.compare(a.x, b.x);
				}
			};
		}
		
		static Comparator<Cow> ycomp() {
			return new Comparator<Cow>() {
				public int compare(Cow a, Cow b) {
					if (a.y == b.y) return Integer.compare(a.x, b.x);
					return Integer.compare(a.y, b.y);
				}
			};
		}
	}
}

import java.util.*;
import java.io.*;
//http://www.usaco.org/index.php?page=viewproblem2&cpid=859
public class Convention2 {
	static class Cow {
		int arrive, t, i;
		Cow(int arrive, int t, int i) {
			this.arrive = arrive;
			this.t = t;
			this.i = i;
		}
		
		static Comparator<Cow> arrive() {
			return new Comparator<Cow>() {
				public int compare(Cow a, Cow b) {
					return Integer.compare(a.arrive, b.arrive);
				}
			};
		}
		
		static Comparator<Cow> priority() {
			return new Comparator<Cow>() {
				public int compare(Cow a, Cow b) {
					return Integer.compare(a.i, b.i);
				}
			};
		}
		
		public String toString() {
			return this.arrive + " " + this.t + " " + this.i;
		}
	}

	public static void main(String[] args) throws IOException {
		setIO("convention2");

		int N = ni();
		Cow[] cow = new Cow[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = nl();
			int arrive = ni(st), t = ni(st);
			cow[i] = new Cow(arrive, t, i);
		}
		
		Arrays.sort(cow, Cow.arrive());
	
		Cow curr = cow[0];
		int count = 1, i = 1;
		int t = curr.arrive + curr.t;
		Queue<Cow> q = new PriorityQueue<>(Cow.priority());
		
		int ans = 0;
		while (count < N) {
			while (i < N && cow[i].arrive <= t) {
				q.add(cow[i++]);
			}
			
			count++;
			
			if (q.isEmpty()) {
				curr = cow[i];
				t = cow[i].arrive;
				i++;
			} else {
				curr = q.poll();
			}
			
			ans = Math.max(ans, t - curr.arrive);
			t += curr.t;
		}
		
		out.println(ans);
		
		f.close();
		out.close();
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

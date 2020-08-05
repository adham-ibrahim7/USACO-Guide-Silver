import java.util.*;
import java.io.*;
//http://www.usaco.org/index.php?page=viewproblem2&cpid=813
public class SnowBoots {
	public static void main(String[] args) throws IOException {
		setIO("snowboots");

		StringTokenizer st = nl();
		int N = ni(st), B = ni(st);
		TreeSet<Tile> ts = new TreeSet<>(Tile.depth());
		TreeSet<Tile> idx = new TreeSet<>(Tile.index());
		st = nl();
		for (int i = 0; i < N; i++) {
			int depth = ni(st);
			ts.add(new Tile(depth, i));
			idx.add(new Tile(depth, i));
		}
		Boot[] b = new Boot[B];
		for (int i = 0; i < B; i++) {
			st = nl();
			int depth = ni(st), stride = ni(st);
			b[i] = new Boot(depth, stride, i);
		}
		Arrays.sort(b, Boot.depth());
	
		ms = new TreeMap<>();
		ms.put(1, N-1);
		
		boolean[] ans = new boolean[B];
		for (int i = 0; i < B; i++) {
			Tile t = ts.first();
			while (t.depth > b[i].depth) {
				idx.remove(t);
				
				int j = t.index;
				
				boolean good = true;
				if (idx.lower(t) != null) {
					delete(j - idx.lower(t).index);
				} else good = false;
				if (idx.higher(t) != null) {
					delete(idx.higher(t).index - j);
				} else good = false;
				
				if (good) {
					add(idx.higher(t).index - idx.lower(t).index);
				}
				
				ts.remove(t);
				
				t = ts.first();
			}
			ans[b[i].index] = ms.lastKey() <= b[i].stride;
		}
		
		for (boolean boo : ans) out.println(boo ? "1" : "0");
		
		f.close();
		out.close();
	}
	
	static TreeMap<Integer, Integer> ms;
	
	static void add(int x) {
		ms.put(x, ms.getOrDefault(x, 0) + 1);
	}
	
	static void delete(int x) {
		int c = ms.get(x);
		ms.put(x, --c);
		if (c == 0) ms.remove(x);
	}
	
	static class Tile {
		int depth, index;
		Tile() {}
		Tile(int depth, int index) {
			this.depth = depth;
			this.index = index;
		}
		
		public static Comparator<Tile> depth() {
			return new Comparator<Tile>() {
				public int compare(Tile a, Tile b) {
					if (a.depth == b.depth) return Integer.compare(a.index, b.index);
					return -Integer.compare(a.depth, b.depth);
				}
			};
		}
		
		public static Comparator<Tile> index() {
			return new Comparator<Tile>() {
				public int compare(Tile a, Tile b) {
					return Integer.compare(a.index, b.index);
				}
			};
		}
	}
	
	static class Boot {
		int depth, stride, index;
		Boot(int depth, int stride, int index) {
			this.depth = depth;
			this.stride = stride;
			this.index = index;
		}
		
		public static Comparator<Boot> depth() {
			return new Comparator<Boot>() {
				public int compare(Boot a, Boot b) {
					if (a.depth == b.depth) return Integer.compare(a.index, b.index);
					return -Integer.compare(a.depth, b.depth);
				}
			};
		}
		
		public static Comparator<Boot> index() {
			return new Comparator<Boot>() {
				public int compare(Boot a, Boot b) {
					return Integer.compare(a.index, b.index);
				}
			};
		}
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

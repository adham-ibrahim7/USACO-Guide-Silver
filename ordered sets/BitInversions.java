import java.util.*;
import java.io.*;
//SKIPPED
public class BitInversions {
	public static void main(String[] args) throws IOException {
		setIO();
		
		char[] s = f.readLine().toCharArray();
		N = s.length;
		
		ts = new TreeSet<>();
		ms = new TreeMap<>();
		
		for (int i = 0; i < N; i++) {
			if (i == 0 || s[i] != s[i-1]) {
				ts.add(new Seg(i, 0));
			}
			if (i == N-1 || s[i] != s[i+1]) {
				ts.add(new Seg(i, 1));
				add(1 + i - ts.lower(close(i)).p);
			}
		}
		
		int Q = ni();
		StringTokenizer st = nl();
		while (Q-- > 0) {
			int x = ni(st)-1;
			modify(x);
			out.print(ms.lastKey() + " ");
		}
		out.println();
		
		f.close();
		out.close();
	}
	
	static int N;
	static TreeSet<Seg> ts;
	static TreeMap<Integer, Integer> ms;
	
	static void modify(int x) {
		Seg l = ts.lower(close(x)), r = ts.higher(open(x));
		
		int a = l.p, b = r.p;
		if (a == b) {
			if (x > 0) {
				ts.remove(close(x-1));
				a = ts.lower(open(x)).p;
				delete(x - a);
			}
			if (x < N-1) {
				ts.remove(open(x+1));
				b = ts.higher(close(x)).p;
				delete(b - x);
			}
			ts.remove(open(x));
			ts.remove(close(x));
			add(b - a + 1);
		} else if (r.p == x) {
			delete(x - a);
			add(x - a - 1);
			ts.remove(close(x));
			ts.add(close(x-1));
			if (x < N-1) {
				ts.remove(open(x+1));
				b = ts.higher(close(x)).p;
				delete(b - x);
				add(b - x + 1);
			} else {
				ts.add(close(x));
			}
			ts.add(open(x));
		} else if (l.p == x) {
			delete(b - x + 1);
			add(b - x);
			ts.remove(open(x));
			ts.add(open(x+1));
			if (x > 0) {
				ts.remove(close(x-1));
				a = ts.lower(open(x)).p;
				delete(x - a - 1);
				add(x - a);
			} else {
				ts.add(open(x));
			}
			ts.add(close(x));
		} else {
			delete(b - a + 1);
			if (x > 0) ts.add(close(x-1));
			if (x < N-1) ts.add(open(x+1));
			ts.add(open(x));
			ts.add(close(x));
			add(1);
			add(x - a - 1);
			add(b - x - 1);
		}
	}
	
	static void add(int x) {
		ms.put(x, 1 + ms.getOrDefault(x, 0));
	}
	
	static void delete(int x) {
		int c = ms.get(x);
		ms.put(x, --c);
		if (c == 0) ms.remove(x);
	}
	
	static Seg open(int x) {
		return new Seg(x, 0);
	}
	
	static Seg close(int x) {
		return new Seg(x, 1);
	}
	
	static class Seg implements Comparable<Seg> {
		 int p, z;
		 Seg(int p, int z) {
			 this.p = p;
			 this.z = z;
		 }
		 
		 public int compareTo(Seg o) {
			 if (this.p == o.p) return Integer.compare(this.z, o.z);
			 return Integer.compare(this.p, o.p);
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

import java.util.*;
import java.io.*;

public class DiamondCollector {
	public static void main(String[] args) throws IOException {
		setIO();

		long t = System.currentTimeMillis();
		
		st = nl();
		int N = ni(st), K = ni(st);
		int[] A = new int[N];
		for (int i = 0; i < N; i++) A[i] = ni();
		Arrays.sort(A);

		int i = 0, j = 1;
		
		List<Pair> list = new ArrayList<>();
		
		while (j < N) {
			if (A[j] - A[i] > K) {
				i++;
			} else {
				j++;
				list.add(new Pair(i, j));
			}
		}
		
		int ans = 0;
		for (i = 0; i < list.size(); i++) {
			ans = Math.max(ans, list.get(i).size);
			for (j = i+1; j < list.size(); j++) {
				if (list.get(i).second <= list.get(j).first || 
					list.get(j).second <= list.get(i).first) {
					ans = Math.max(ans, list.get(i).size + list.get(j).size);
				}
			}
		}
		
		f.close();
		out.close();
	}
	
	static class Pair {
		int first, second;
		int size;
		Pair(int f, int s) {
			first = f;
			second = s;
			size = second - first;
		}
		
		public String toString() {
			return first + " " + second;
		}
	}

	static BufferedReader f;
	static PrintWriter out;
	static StringTokenizer st;

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

	static void setIn(String s) throws IOException {
		f = new BufferedReader(new FileReader(s));
	}

	static void setOut(String s) throws IOException {
		out = new PrintWriter(new FileWriter(s));
	}

	static void setIn() {
		f = new BufferedReader(new InputStreamReader(System.in));
	}

	static void setOut() {
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	}

	static void setIO(String s) throws IOException {
		setIn(s + ".in");
		setOut(s + ".out");
	}

	static void setIO() {
		setIn();
		setOut();
	}
}

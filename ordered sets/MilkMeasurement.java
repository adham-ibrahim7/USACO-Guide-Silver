import java.util.*;
import java.io.*;

public class MilkMeasurement {
	public static void main(String[] args) throws IOException {
		setIO("measurement");

		st = nl();
		int N = ni(st), G = ni(st);
		Log[] logs = new Log[N];
		for (int i = 0; i < N; i++) {
			st = nl();
			int time = ni(st), cow = ni(st), diff = ni(st);
			logs[i] = new Log(time, cow, diff);
		}
		Arrays.sort(logs);
		
		ms.put(0, (int) 1e9);
		
		TreeMap<Integer, Integer> gallons = new TreeMap<>();
		
		int prevBest = 0, prevCount = (int) 1e9, ans = 0;
		for (Log log : logs) {
			int cow = log.cow, diff = log.diff;
			
			int prev = gallons.getOrDefault(cow, 0);
			boolean wasBest = ms.lastKey() == prev;
			
			delete(prev);
			gallons.put(cow, prev + diff);
			add(prev + diff);
			
			int best = ms.lastKey(), bestCount = ms.get(best);
			
			boolean isBest = best == prev+diff;
			if ((prevBest != best && !(wasBest && prevCount == 1 && isBest) || prevCount != bestCount)) {
				ans++;
			}
			prevBest = best; prevCount = bestCount;
		}
		
		out.println(ans);
		
		f.close();
		out.close();
	}
	
	static TreeMap<Integer, Integer> ms = new TreeMap<>();

	static void add(int x) {
		ms.put(x, ms.getOrDefault(x, 0) + 1);
	}

	static int delete(int x) {
		int c = ms.get(x);
		ms.put(x, --c);
		if (c == 0)
			ms.remove(x);
		return x;
	}
	
	static class Log implements Comparable<Log> {
		int time, cow, diff;
		Log(int t, int c, int d) {
			time = t;
			cow = c;
			diff = d;
		}
		
		public int compareTo(Log o) {
			return Integer.compare(this.time, o.time);
		}
	}

	static BufferedReader f;
	static PrintWriter out;
	static StringTokenizer st;

	static int ni(StringTokenizer st) {
		return Integer.parseInt(st.nextToken());
	}

	static long nlg(StringTokenizer st) {
		return Long.parseLong(st.nextToken());
	}

	static int ni() throws IOException {
		return Integer.parseInt(f.readLine());
	}

	static long nlg() throws IOException {
		return Long.parseLong(f.readLine());
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



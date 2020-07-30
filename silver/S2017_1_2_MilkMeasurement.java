/*
ID: adhamib1
LANG: JAVA
TASK: measurement
*/
import java.io.*;
import java.util.*;

class S2017_1_2_MilkMeasurement {
	static class InputReader {
		BufferedReader reader;
		StringTokenizer tokenizer = null;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream));
		}

		public InputReader(String stream) throws FileNotFoundException {
			reader = new BufferedReader(new FileReader(stream));
		}

		public String next() {
			if (tokenizer == null || !tokenizer.hasMoreTokens())
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			return tokenizer.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public void close() throws IOException {
			reader.close();
		}
	}

	public static void main(String[] args) throws IOException {
		InputReader sc = new InputReader("measurement.in");
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));

		int N = sc.nextInt(), G = sc.nextInt();
		
		class Log implements Comparable<Log> {
			int time, cow, diff;
			
			Log(int time, int cow, int diff) {
				this.time = time;
				this.cow = cow;
				this.diff = diff;
			}
			
			public int compareTo(Log o) {
				return this.time - o.time;
			}
		}
		
		Log[] logs = new Log[N];
		
		for (int i = 0; i < N; i++) {
			int time = sc.nextInt(), cow = sc.nextInt(), diff = sc.nextInt();
			
			logs[i] = new Log(time, cow, diff);
		}
		
		Arrays.sort(logs);
		
		HashMap<Integer, Integer> map = new HashMap<>();
		TreeMap<Integer, Integer> counts = new TreeMap<>();
		
		counts.put(G, (int) 1e6);
		
		int ans = 0;
		
		for (Log log : logs) {
			int cow = log.cow, diff = log.diff;
			
			int prev = map.getOrDefault(cow, G);
			
			boolean wasBest = prev == counts.lastKey();
			int wascount = counts.get(prev);
			counts.put(prev, counts.get(prev) - 1);
			if (counts.get(prev) == 0) counts.remove(prev);
			
			int curr = prev + diff;
			
			counts.put(curr, counts.getOrDefault(curr, 0) + 1);
			
			boolean isBest = curr == counts.lastKey();
			
			if (wasBest) {
				if (!isBest || wascount != 1 || counts.get(curr) != 1) {
					ans++;
				}
			} else if (isBest) {
				ans++;
			}
			
			map.put(cow, curr);
		}
		out.println(ans);
		
		sc.close();
		out.close();
	}
}
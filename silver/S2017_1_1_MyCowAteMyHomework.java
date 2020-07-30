/*
ID: adhamib1
LANG: JAVA
TASK: homework
*/
import java.io.*;
import java.util.*;

class S2017_1_1_MyCowAteMyHomework {
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
		InputReader f = new InputReader("homework.in");
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("homework.out")));

		int N = f.nextInt();
		
		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = f.nextInt();
		}
		
		double[] pref = new double[N];
		int prev = 0;
		
		int min = Integer.MAX_VALUE;
		for (int i = N-1; i >= 0; i--) {
			pref[i] = prev + A[i];
			prev += A[i];
			min = Math.min(min, A[i]);
			
			pref[i] -= min;
			
			pref[i] /= N - i - 1.0;
		}
		
		double best = 0;
		
		for (int i = 1; i < N - 1; i++) {
			best = Math.max(best, pref[i]);
		}
		
		//System.out.println(best);

		for (int i = 1; i < N - 1; i++) {
			if (Math.abs(pref[i] - best) < 1e-9) {
				out.println(i);
			}
		}
		
		//System.out.println(Arrays.toString(pref));
		
		f.close();
		out.close();
	}
}
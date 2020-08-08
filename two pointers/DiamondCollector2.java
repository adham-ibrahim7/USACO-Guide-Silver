import java.util.*;
import java.io.*;

public class DiamondCollector2 {
	public static void main(String[] args) throws IOException {
		setIO("diamond");

		st = nl();
		int N = ni(st);
		int K = ni(st);
		int[] A = new int[N];
		for (int i = 0; i < N; i++) A[i] = ni();
		Arrays.sort(A);
		
		int[] left = new int[N];
		int j = 0;
		for (int i = 0; i < N; i++) {
			while (A[i] - A[j] > K) {
				j++;
			}
			
			left[i] = i - j + 1;
		}
		
		int[] right = new int[N];
		j = N-1;
		for (int i = N-1; i >= 0; i--) {
			while (A[j] - A[i] > K) {
				j--;
			}
			
			right[i] = j - i + 1;
		}
		
		int[] bestLeft = new int[N];
		for (int i = 0; i < N; i++) {
			bestLeft[i] = left[i];
			if (i > 0) bestLeft[i] = Math.max(bestLeft[i], bestLeft[i-1]);
		}
		
		int[] bestRight = new int[N];
		for (int i = N-1; i >= 0; i--) {
			bestRight[i] = right[i];
			if (i < N-1) bestRight[i] = Math.max(bestRight[i], bestRight[i+1]);
		}
		
		int ans = 0;
		for (int i = 0; i < N-1; i++) {
			ans = Math.max(ans, bestLeft[i] + bestRight[i+1]);
		}
		
		//out.println(Arrays.toString(left) + Arrays.toString(right));
		
		out.println(ans);
		
		f.close();
		out.close();
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

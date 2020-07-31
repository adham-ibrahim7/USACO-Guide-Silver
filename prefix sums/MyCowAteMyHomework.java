/*
ID: adhamib1
LANG: JAVA
TASK: homework
*/
import java.io.*;
import java.util.*;

class MyCowAteMyHomework {
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
		BufferedReader f = new BufferedReader(new FileReader("homework.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("homework.out")));

		int N = ni(f);
		
		StringTokenizer st = nl(f);
		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = ni(st);
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
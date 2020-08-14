import java.util.*;
import java.io.*;

public class SleepyCowHerding {
	public static void main(String[] args) throws IOException {
		setIO("herding");

		int N = ni();
		int[] A = new int[N];
		for (int i = 0; i < N; i++) A[i] = ni();
		Arrays.sort(A);
		
		int min;
		if (A[N-2]-A[0] == N-2 && A[N-1]-A[N-2]>2) min = 2;
		if (A[N-1]-A[1] == N-2 && A[1]-A[0]>2) min = 2;
		else {
			int i, j=0, best=0;
			for (i=0; i<N; i++) {
				while (j<N-1 && A[j+1]-A[i]<=N-1) j++;
				best = Math.max(best, j-i+1);
			}
			min = N - best;
		}
		int max = Math.max(A[N-2]-A[0], A[N-1]-A[1]) - (N-2);
		
		out.println(min + "\n" + max);
		
		f.close();
		out.close();
	}
	
	static int range(int[] A, int L, int R) {
		int N = A.length;
		
		int i = 0, j = N-1;
		for (int b = N / 2; b >= 1; b /= 2) {
			while (i+b < N && A[i+b] <= L) i += b;
			while (j-b >= 0 && A[j-b] >= R) j -= b;
		}
		
		if (A[i] < L) i++;
		if (A[j] > R) j--;
		
		return j - i + 1;
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

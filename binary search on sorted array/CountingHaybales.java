import java.util.*;
import java.io.*;
//http://www.usaco.org/index.php?page=viewproblem2&cpid=666
public class CountingHaybales {
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
		BufferedReader f = new BufferedReader(new FileReader("haybales.in"));	
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("haybales.out")));

		//BufferedReader f = (new BufferedReader(new InputStreamReader(System.in)));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

		StringTokenizer st = nl(f);
		int N = ni(st), Q = ni(st);
		int[] A = nia(N, f);
		Arrays.sort(A);
		while (Q-- > 0) {
			st = nl(f);
			int L = ni(st), R = ni(st);
			
			out.println(range(A, L, R));
		}
		
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
}

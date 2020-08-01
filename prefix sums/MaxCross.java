import java.util.*;
import java.io.*;
//http://www.usaco.org/index.php?page=viewproblem2&cpid=715
public class MaxCross {
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
		BufferedReader f = new BufferedReader(new FileReader("maxcross.in"));	
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("maxcross.out")));

		//BufferedReader f = (new BufferedReader(new InputStreamReader(System.in)));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		
		StringTokenizer st = nl(f);
		int N = ni(st), K = ni(st), B = ni(st);
		boolean[] broken = new boolean[N];
		for (int i = 0; i < B; i++) {
			broken[ni(f)-1] = true;
		}
		
		int count = 0;
		for (int i = 0; i < K; i++) {
			if (broken[i]) count++;
		}
		
		int ans = count;
		for (int i = K; i < N; i++) {
			if (broken[i-K]) count--;
			if (broken[i]) count++;
			ans = Math.min(ans, count);
		}
		
		out.println(ans);

		f.close();
		out.close();
	}
}

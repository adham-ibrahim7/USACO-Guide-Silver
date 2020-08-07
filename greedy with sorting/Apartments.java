import java.util.*;
import java.io.*;

public class Apartments {
	public static void main(String[] args) throws IOException {
		setIO();
		
		st = nl();
		int N = ni(st), M = ni(st), K = ni(st);
		
		int[] applicants = nia(N);
		Arrays.sort(applicants);
		
		int[] apartments = nia(M);
		Arrays.sort(apartments);
		
		int ans = 0;
		
		int i = 0, j = 0;
		while (i < N && j < M) {
			int d = applicants[i] - apartments[j];
			if (d < -K) {
				i++;
			} else if (d > K) {
				j++;
			} else {
				ans++;
				i++;
				j++;
			}
		}
		
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

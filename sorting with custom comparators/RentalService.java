import java.util.*;
import java.io.*;
//http://www.usaco.org/index.php?page=viewproblem2&cpid=787
public class RentalService {
	static int ni(StringTokenizer st) {
		return Integer.parseInt(st.nextToken());
	}
	
	static int ni(BufferedReader f) throws IOException {
		return Integer.parseInt(f.readLine());
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("rental.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("rental.out")));

		//BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		
		StringTokenizer st = new StringTokenizer(f.readLine());
		int N = ni(st), M = ni(st), R = ni(st);
		
		Integer[] cow = new Integer[N];
		for (int i = 0; i < N; i++) {
			cow[i] = ni(f);
		}
		
		Buyer[] buyer = new Buyer[M];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(f.readLine());
			buyer[i] = new Buyer(ni(st), ni(st));
		}
		
		Integer[] renter = new Integer[R];
		for (int i = 0; i < R; i++) {
			renter[i] = ni(f);
		}
		
		
		Arrays.sort(cow, Collections.reverseOrder());
		long[] s1 = new long[N+1];
		for (int i = 0; i < N; i++) {
			s1[i+1] = s1[i] + (long) cow[i];
		}
		
		Arrays.sort(buyer);
		long[] s3 = new long[M+1], s4 = new long[M+1];
		for (int i = 0; i < M; i++) {
			s3[i+1] = s3[i] + (long) buyer[i].p;
			s4[i+1] = s4[i] + (long) buyer[i].p * buyer[i].q;
		}
		
		Arrays.sort(renter, Collections.reverseOrder());
		long[] s2 = new long[R+1];
		for (int i = 0; i < R; i++) {
			s2[i+1] = s2[i] + (long) renter[i];
		}
		
		long ans = 0;
		for (int i = 0; i <= N; i++) {
			if (N-i > R) continue;
			
			long total = 0;
			/*int j = 0;
			while (buyer[j].p + a <= s1[i]) {
				a += buyer[j].p;
				total += (long) buyer[j].p * buyer[j].q;
				j++;
				if (j == M) break;
			}*/
			int j = 0;
			for (int b = M / 2; b >= 1; b /= 2) {
				while (j + b <= M && s3[j+b] < s1[i]) j += b;
			}
			total += s4[j];
			if (j > 0 && j < M && s3[j-1] <= s1[i]) total += (long) (s1[i] - s3[j]) * buyer[j].q;
			
			total += s2[N-i];
			
			ans = Math.max(ans, total);
		}
		
		out.println(ans);

		f.close();
		out.close();
	}
	
	static class Buyer implements Comparable<Buyer> {
		int p, q;
		Buyer(int p, int q) {
			this.p = p;
			this.q = q;
		}
		
		public int compareTo(Buyer o) {
			return -Integer.compare(this.q, o.q);
		}
		
		public String toString() {
			return p + " " + q;
		}
	}
}

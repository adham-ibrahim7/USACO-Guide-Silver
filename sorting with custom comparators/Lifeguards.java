import java.util.*;
import java.io.*;
//http://www.usaco.org/index.php?page=viewproblem2&cpid=786
public class Lifeguards {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("lifeguards.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lifeguards.out")));

		//BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		
		int N = Integer.parseInt(f.readLine());
		TreeSet<EndPoint> set = new TreeSet<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(f.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			set.add(new EndPoint(a, i, true));
			set.add(new EndPoint(b, i, false));
		}
		
		int[] s = new int[N];
		
		int count = 0, total = 0;
		int a = -1, b = -1;
		TreeSet<Integer> ids = new TreeSet<>();
		for (EndPoint u : set) {
			if (count == 0) {
				a = u.p;
			}
			
			if (u.isStart) {
				if (count == 1) {
					s[ids.first()] += u.p - b;
				}
				
				count++;
				ids.add(u.id);
				if (count == 1) {
					b = u.p;
				}
			} else {
				if (count == 1) {
					total += u.p - a;
					s[ids.first()] += u.p - b;
				}
				
				count--;
				ids.remove(u.id);
				if (count == 1) {
					b = u.p;
				}
			}
		}
		
		int min = Integer.MAX_VALUE;
		for (int n : s) min = Math.min(min, n);
		
		out.println(total - min);
		
		f.close();
		out.close();
	}
	
	static class EndPoint implements Comparable<EndPoint> {
		int p, id;
		boolean isStart;
		EndPoint(int p, int id, boolean isStart) {
			this.p = p;
			this.id = id;
			this.isStart = isStart;
		}
		
		public int compareTo(EndPoint o) {
			return Integer.compare(this.p, o.p);
		}
	}
}
import java.util.*;
import java.io.*;

public class TasksAndDeadlines {
	public static void main(String[] args) throws IOException {
		setIO();

		int N = ni();
		Task[] tasks = new Task[N];
		for (int i = 0; i < N; i++) {
			st = nl();
			int a = ni(st), d = ni(st);
			tasks[i] = new Task(a, d);
		}
		Arrays.sort(tasks);
		
		long s = 0, ans = 0;
		for (int i = 0; i < N; i++) {
			s += tasks[i].a;
			ans += tasks[i].d - s;
		}
		
		out.println(ans);
		
		f.close();
		out.close();
	}
	
	static class Task implements Comparable<Task> {
		int a, d;
		Task(int a, int d) {
			this.a = a;
			this.d = d;
		}
		
		public int compareTo(Task o) {
			return Integer.compare(this.a, o.a);
		}
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

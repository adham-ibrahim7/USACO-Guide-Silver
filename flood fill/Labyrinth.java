import java.util.*;
import java.io.*;

public class Labyrinth {
	public static void main(String[] args) throws IOException {
		setIO();

		st = nl();
		int N = ni(st);
		int M = ni(st);
		
		char[] A = new char[N*M];
		
		int s = -1, e = -1;
		for (int i = 0; i < N; i++) {
			char[] t = rl().toCharArray();
			for (int j = 0; j < M; j++) {
				int k = j + M * i;
				
				A[k] = t[j];
				
				if (A[k] == 'A') {
					s = k;
				} else if (A[k] == 'B') {
					e = k;
				}
			}
		}
		
		Queue<State> q = new LinkedList<>();
		q.add(new State(s, '`', null, 0));
		boolean[] vis = new boolean[N*M];
		
		boolean solved = false;
		while (!q.isEmpty()) {
			State curr = q.poll();
			
			vis[curr.i] = true;
			
			if (curr.i == e) {
				solved = true;
				
				out.println("YES\n" + curr.d);
				
				Stack<Character> st = new Stack<>();
				while (curr.prev != null) {
					st.push(curr.move);
					curr = curr.prev;
				}
				
				while (!st.isEmpty()) {
					out.print(st.pop());
				}
				
				break;
			}
			
			if (curr.i % M != 0 && !vis[curr.i-1] && A[curr.i-1] != '#') q.add(new State(curr.i-1, 'L', curr, curr.d+1));
			if (curr.i % M != M-1 && !vis[curr.i+1] && A[curr.i+1] != '#') q.add(new State(curr.i+1, 'R', curr, curr.d+1));
			if (curr.i >= M && !vis[curr.i-M] && A[curr.i-M] != '#') q.add(new State(curr.i-M, 'U', curr, curr.d+1));
			if (curr.i < (N-1) * M && !vis[curr.i+M] && A[curr.i+M] != '#') q.add(new State(curr.i+M, 'D', curr, curr.d+1));
		}
		
		if (!solved) out.println("NO");
		
		f.close();
		out.close();
	}
	
	static class State {
		int i, d;
		char move;
		State prev;
		
		State(int i, char move, State prev, int d) {
			this.i = i;
			this.move = move;
			this.prev = prev;
			this.d = d;
		}
	}
		
	static BufferedReader f;
	static PrintWriter out;
	static StringTokenizer st;

	static String rl() throws IOException {
		return f.readLine();
	}

	static int ni(StringTokenizer st) {
		return Integer.parseInt(st.nextToken());
	}

	static long nlg(StringTokenizer st) {
		return Long.parseLong(st.nextToken());
	}

	static int ni() throws IOException {
		return Integer.parseInt(rl());
	}

	static long nlg() throws IOException {
		return Long.parseLong(rl());
	}

	static StringTokenizer nl() throws IOException {
		return new StringTokenizer(rl());
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

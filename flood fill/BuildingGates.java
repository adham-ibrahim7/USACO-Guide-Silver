import java.util.*;
import java.io.*;

public class BuildingGates {
	public static void main(String[] args) throws IOException {
		setIO("gates");

		int MAX = 2010;
		
		int N = ni();
		char[] s = rl().toCharArray();
		
		boolean[][] vis = new boolean[MAX][MAX];
		
		int x = MAX / 2, y = MAX / 2;
		vis[y][x] = true;
		
		for (int i = 0; i < N; i++) {
			int dx = 0, dy = 0;
			
			if (s[i] == 'N') {
				dy = -1;
			} else if (s[i] == 'S') {
				dy = 1;
			} else if (s[i] == 'W') {
				dx = 1;
			} else {
				dx = -1;
			}
			
			vis[y+=dy][x+=dx] = true;
			vis[y+=dy][x+=dx] = true;
		}
		
		int ans = -1;
		for (int i = 0; i < MAX; i++) {
			for (int j = 0; j < MAX; j++) {
				if (!vis[i][j]) {
					Queue<Pos> q = new LinkedList<>();
					
					q.add(new Pos(i, j));
					
					while (!q.isEmpty()) {
						Pos c = q.poll();
						
						if (vis[c.i][c.j]) continue;
						vis[c.i][c.j] = true;
						
						if (c.i > 0 && !vis[c.i-1][c.j]) q.add(new Pos(c.i-1, c.j));
						if (c.i < MAX-1 && !vis[c.i+1][c.j]) q.add(new Pos(c.i+1, c.j));
						if (c.j > 0 && !vis[c.i][c.j-1]) q.add(new Pos(c.i, c.j-1));
						if (c.j < MAX-1 && !vis[c.i][c.j+1]) q.add(new Pos(c.i, c.j+1));
					}
					
					ans++;
				}
			}
		}
		
		out.println(ans);
		
		f.close();
		out.close();
	}
	
	static class Pos {
		int i, j;
		Pos(int i, int j) {
			this.i = i;
			this.j = j;
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

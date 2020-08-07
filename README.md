# USACO-Training
Solutions to the USACO guide problems.
The problems all can be found from https://usaco-guide.vercel.app/, a great guide with dozens of modules.

Java IO is slow using a scanner, so BufferedReader is preferable
The following methods are useful for shorter bufferedreader input (writing out stringtokenizer and all that is annoying)

```java
static StringTokenizer st;
static BufferedReader f;
static PrintWriter out;

//read the next int from string tokenizer
static int ni(StringTokenizer st) {
	return Integer.parseInt(st.nextToken());
}

//read the next int, if its on a line by itself
static int ni() throws IOException {
	return Integer.parseInt(f.readLine());
}

//read in the next line into a StringTokenizer
static StringTokenizer nl() throws IOException {
	return new StringTokenizer(f.readLine());
}

//read in an array, given the size
static int[] nia(int N) throws IOException {
	StringTokenizer st = nl();
	int[] A = new int[N];
	for (int i = 0; i < N; i++)
		A[i] = ni(st);
	return A;
}

//in from file
static void setIn(String s) throws IOException {
	f = new BufferedReader(new FileReader(s));
}

//out from file
static void setOut(String s) throws IOException {
	out = new PrintWriter(new FileWriter(s));
}

//stdin
static void setIn() {
	f = new BufferedReader(new InputStreamReader(System.in));
}

//stdout
static void setOut() {
	out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
}

//in and out from USACO files
static void setIO(String s) throws IOException {
	setIn(s + ".in");
	setOut(s + ".out");
}

//stdin + stdout
static void setIO() {
	setIn();
	setOut();
}
```

Consider the following input format:

Line 1 contains N, M, and Q. 
Lines 2 and 3 contain arrays A of length N and B of length M, respectively. 
Then, Q queries follow, containing indicies i and j, for 0 <= i < j < N.

With just BufferedReader, input looks like:

```java
StringTokenizer st = new StringTokenizer(f.readLine());
int N = Integer.parseInt(st.nextToken());
int M = Integer.parseInt(st.nextToken());
int Q = Integer.parseInt(st.nextToken());
int[] A = new int[N];
st = new StringTokenizer(f.readLine());
for (int i = 0; i < N; i++) {
	A[i] = Integer.parseInt(st.nextToken());
}
int[] B = new int[M];
st = new StringTokenizer(f.readLine());
for (int i = 0; i < M; i++) {
	B[i] = Integer.parseInt(st.nextToken());
}
while (Q-- > 0) {
	st = new StringTokenizer(f.readLine());
	int i = Integer.parseInt(st.nextToken());
	int j = Integer.parseInt(st.nextToken());
	//... process ...
}
```

Whereas with the above functions, the code can be significantly shortened to:

```java
st = nl();
int N = ni(st), M = ni(st), Q = ni(st);
int[] A = nia(N);
int[] B = nia(M);
while (Q-- > 0) {
	st = nl();
	int i = ni(st), j = ni(st);
	//... process ...
}
```

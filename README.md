# USACO-Training
Solutions to the USACO guide problems.

Java IO is slow using a scanner, so BufferedReader is preferable

The following methods are useful for shorter bufferedreader input (writing out stringtokenizer and all that is annoying)

```java
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

//set io with files
static void setIO(String s) throws IOException {
	f = new BufferedReader(new FileReader(s + ".in"));
	out = new PrintWriter(new FileWriter(s + ".out"));
}

//set console io
static void setIO() {
	f = (new BufferedReader(new InputStreamReader(System.in)));
	out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
}
```

The problems all can be found from https://usaco-guide.vercel.app/, a great guide with dozens of modules.

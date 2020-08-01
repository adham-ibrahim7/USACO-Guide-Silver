# USACO-Training
Solutions to the USACO guide problems.

Java IO is slow using a scanner, so BufferedReader is preferable

The following methods are useful for shorter bufferedreader input (writing out stringtokenizer and all that is annoying)

```java
static int ni(StringTokenizer st) { //read the next int from the tokenizer
	return Integer.parseInt(st.nextToken());
}

static int ni(BufferedReader f) throws IOException { //read a single number on a line
	return Integer.parseInt(f.readLine());
}

static StringTokenizer nl(BufferedReader f) throws IOException { //return the stringtokenizer for the next line
	return new StringTokenizer(f.readLine());
}

static int[] nia(int N, BufferedReader f) throws IOException { //read in an array, given the array size
	StringTokenizer st = nl(f);
	int[] A = new int[N];
	for (int i = 0; i < N; i++)
		A[i] = ni(st);
	return A;
}
```

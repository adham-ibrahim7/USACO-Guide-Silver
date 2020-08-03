# USACO-Training
Solutions to the USACO guide problems.

Java IO is slow using a scanner, so BufferedReader is preferable

The following methods are useful for shorter bufferedreader input (writing out stringtokenizer and all that is annoying)

```java
//read the next int from the tokenizer
static int ni(StringTokenizer st) { 
	return Integer.parseInt(st.nextToken());
}

//read a single number on a line
static int ni(BufferedReader f) throws IOException { 
	return Integer.parseInt(f.readLine());
}

//return the stringtokenizer for the next line
static StringTokenizer nl(BufferedReader f) throws IOException { 
	return new StringTokenizer(f.readLine());
}

//read in an array, given the array size
static int[] nia(int N, BufferedReader f) throws IOException { 
	StringTokenizer st = nl(f);
	int[] A = new int[N];
	for (int i = 0; i < N; i++)
		A[i] = ni(st);
	return A;
}
```

The problems all can be found from https://usaco-guide.vercel.app/, a great guide with dozens of modules.

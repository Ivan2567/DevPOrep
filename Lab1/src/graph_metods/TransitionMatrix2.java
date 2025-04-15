package graph_metods;

public class TransitionMatrix2 {
	public static int N;
	public static int[][] grid;

	public void init(int N) {
		TransitionMatrix2.N = N+1;
	    grid = new int[N+1][N+1];
	  }

	public void addEdge(int a, int b, int weight) {
	    grid[a][b] = weight;
	    //grid[b][a] = weight;	// Закоментить, если граф ориентированный
	  }
}
package graph_metods;
import static graph_metods.TransitionMatrix2.*;

public class FordFalkerson {

	public int networkFlow(int source, int sink) {
	    if (source == sink)
	      return 0;

	    int maxFlow = 0;
	    int[][] cap = new int[N][N];
	    for (int i = 0; i < N; i++)
	    	System.arraycopy(grid[i], 0, cap[i], 0, N); 

	    while (true) { // while there exists an augmenting path
	      int[] prev = new int[N], flow = new int[N];
	      boolean[] visited = new boolean[N];
	      int[] queue = new int[N];
	      int front = 0, back = 0;

	      queue[back++] = source;
	      visited[source] = true;
	      flow[source] = Integer.MAX_VALUE;
	      boolean success = false;

	      // find the path
	      outer: while (front != back) {
	        int node = queue[front++];

	        for (int i = 0; i < N; i++)
	          if (!visited[i] && cap[node][i] > 0) {
	            prev[i] = node;
	            flow[i] = Math.min(flow[node], cap[node][i]);
	            visited[i] = true;

	            if (i == sink) {
	              success = true;
	              break outer;
	            }

	            queue[back++] = i;
	          }
	      }
	      if (!success)
	        break;

	      // push flow through
	      int pathCap = flow[sink];
	      maxFlow += pathCap;

	      for (int x = sink; x != source; x = prev[x]) {
	        cap[prev[x]][x] -= pathCap;
	        cap[x][prev[x]] += pathCap;
	      }
	    }

	    return maxFlow;
	  }
}

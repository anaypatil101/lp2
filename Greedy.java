import java.util.Arrays;

public class Greedy {
    void selectionSort(int[] arr) {
        int n = arr.length;

        for(int i=0; i<n-1; i++) {
            int minIdx = i;
            for(int j=i+1; j<n; j++) {
                if(arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }

            // swapping logic
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
            System.out.println("Pass " + (i + 1) + ": " + Arrays.toString(arr));
        }
    }

    int minDist(int[] dist, boolean[] visited, int V) {
        int minDist = Integer.MAX_VALUE;    // minimum cost vertex distance
        int u = -1;        // minimum cost vertex
        for(int v=0; v<V; v++) {
            if(!visited[v] && dist[v] < minDist) {
                minDist = dist[v];
                u = v;
            }
        }
        return u;
    }

    void prims(int[][] graph, int V) {
        int[] parent = new int[V];
        int[] key = new int[V];
        boolean[] mstSet = new boolean[V];

        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;
        parent[0] = -1;

        for(int count=0; count < V-1; count++) {
            
            int u = minDist(key, mstSet, V);  // always need the minimum (thats why greedy)

            mstSet[u] = true;

            for(int v=0; v<V; v++) {
                if(!mstSet[v] && graph[u][v] != 0 && graph[u][v] < key[v]) {
                    key[v] = graph[u][v];
                    parent[v] = u;
                }
            }
        }

        System.out.println("\nEdge       Weight");
        System.out.println("------------------");
        int totalWeight = 0;
        for (int i = 1; i < V; i++) {
            System.out.printf(" %d  -  %d     %d%n", parent[i], i, graph[i][parent[i]]);
            totalWeight += graph[i][parent[i]];
        }
        System.out.println("------------------");
        System.out.println("Total MST Weight: " + totalWeight);
    }

    void dijkstra(int[][] graph, int src, int V) {
        int[] dist = new int[V];
        boolean[] visited = new boolean[V];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for(int count=0; count < V - 1; count++) {
            int u = minDist(dist, visited, V);
            // mark the vertex as true
            visited[u] = true;

            for(int v =0; v<V; v++) {
                if(!visited[v] && graph[u][v] != 0 && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        System.out.println("Distance from Source:");
         for(int i = 0; i < V; i++) {
            System.out.println(i + "        " + dist[i]);
        }
    }
    public static void main(String[] args) {
        Greedy g = new Greedy();

        int[][] graph = {
            {0, 4, 0, 0, 0, 0, 0, 8, 0},
            {4, 0, 8, 0, 0, 0, 0, 11, 0},
            {0, 8, 0, 7, 0, 4, 0, 0, 2},
            {0, 0, 7, 0, 9, 14, 0, 0, 0},
            {0, 0, 0, 9, 0, 10, 0, 0, 0},
            {0, 0, 4, 14, 10, 0, 2, 0, 0},
            {0, 0, 0, 0, 0, 2, 0, 1, 6},
            {8, 11, 0, 0, 0, 0, 1, 0, 7},
            {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };

        g.prims(graph, graph.length);
        
    }
}

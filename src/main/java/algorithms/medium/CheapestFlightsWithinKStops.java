package algorithms.medium;

import java.util.PriorityQueue;

public class CheapestFlightsWithinKStops {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][][] graph = createGraph(flights, n);
        return dijkstra(graph, src, dst, k, n);
    }

    int[][][] createGraph(int[][] arcs, int n){
        int[][][] graph = new int[n][][];
        
        int[] outDegree = new int[n + 1];
        for (int[] arc : arcs) {
            outDegree[arc[0]]++;
        }

        for (int i = 0; i < n; i++) {
            graph[i] = new int[outDegree[i]][2];
        }
        int[] currIdx = new int[n];
        for (int[] arc : arcs) {
            graph[arc[0]][currIdx[arc[0]]][0] = arc[1];
            graph[arc[0]][currIdx[arc[0]]++][1] = arc[2];
        }
        return graph;
    }

    int dijkstra(int[][][] graph, int src, int dst, int k, int n)
    {
        int[] dist = new int[n];
        int[] steps = new int[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        for(int i = 0; i<n; i++)
        {
            dist[i] = Integer.MAX_VALUE;
            steps[i] = Integer.MAX_VALUE;
        }
        dist[src]= 0;
        steps[src] = 0;
        pq.offer(new int[]{src, 0, 0});

        
        while(!pq.isEmpty())
        {
            int[] info = pq.poll();
            int vertex = info[0];
            int cost = info[1];
            int stops = info[2];
            
            if(vertex == dst)
            {
                return cost;
            }
            if(stops == k+1)
            {
                continue;
            }

            for(int[] neighbor : graph[vertex])
            {
                int next = neighbor[0];
                int alt = cost + neighbor[1];
                if(alt < dist[next])
                {
                    pq.offer(new int[]{next, alt, stops+1});
                    dist[next]  = alt;
                }
                else if(stops < steps[next]){
                    pq.offer(new int[]{next, alt, stops+1});
                }
                steps[next] = stops;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[][] flights = {
            {0,1,200},
            {0,2,500},
            {1,2,250}
        };
        var solution = new CheapestFlightsWithinKStops();
        System.out.println(solution.findCheapestPrice(3, flights, 0, 2, 0));

        flights = new int[][]{{0,1,1},{0,2,5},{1,2,1},{2,3,1}};
        System.out.println(solution.findCheapestPrice(4, flights, 0, 3, 1));
    }
}

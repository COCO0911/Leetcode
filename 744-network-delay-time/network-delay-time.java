public class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Step 1: Build the graph
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] time : times) {
            int u = time[0], v = time[1], w = time[2];
            graph.get(u).add(new int[]{v, w});
        }
        
        // Step 2: Initialize distances and priority queue
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{k, 0});
        
        // Step 3: Dijkstra's Algorithm
        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int u = node[0], currDist = node[1];
            
            if (currDist > dist[u]) continue;
            
            for (int[] neighbor : graph.get(u)) {
                int v = neighbor[0], time = neighbor[1];
                if (dist[u] + time < dist[v]) {
                    dist[v] = dist[u] + time;
                    pq.offer(new int[]{v, dist[v]});
                }
            }
        }
        
        // Step 4: Determine the result
        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            maxTime = Math.max(maxTime, dist[i]);
        }
        
        return maxTime;
    }
}

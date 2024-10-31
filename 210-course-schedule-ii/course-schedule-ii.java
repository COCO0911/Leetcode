class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // create a graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] inDegree = new int[numCourses];
        int[] res = new int[numCourses];
        
        for (int i = 0; i < prerequisites.length; i++) { 
            graph.computeIfAbsent(prerequisites[i][1], k ->  new ArrayList<>()).add(prerequisites[i][0]);
            inDegree[prerequisites[i][0]]++;

        }
        
        //找graph入口
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if(inDegree[i] == 0) q.offer(i);
        }
        
        //topological Sort
        int count = 0;
        while (!q.isEmpty()){
            int cur = q.poll();
            res[count++] = cur;
            for(int next : graph.getOrDefault(cur, new ArrayList<>())){
                if(--inDegree[next] == 0) q.offer(next);
            }
        }
       
       
        return count == numCourses ? res : new int[0];
        
    }
}
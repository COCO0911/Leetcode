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
        
        
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if(inDegree[i] == 0) q.offer(i);
        }
        
        int count = 0;
        while (!q.isEmpty()){
            int cur = q.poll();
            res[count++] = cur;
            List<Integer> toTake = graph.get(cur);
            for (int i = 0; toTake != null && i < toTake.size(); i++) {
                inDegree[toTake.get(i)]--;
                if (inDegree[toTake.get(i)] == 0) q.add(toTake.get(i));
            }
        }
       
       
        return count == numCourses ? res : new int[0];
        
    }
}
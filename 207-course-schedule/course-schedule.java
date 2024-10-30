class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge: prerequisites){
            int end = edge[0], start = edge[1];
            map.computeIfAbsent(start, x -> new ArrayList<>()).add(end);
            indegree[end]++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) q.offer(i);
        }
        int count = 0;
        while(!q.isEmpty()){
            int cur = q.poll();
            count++;
            for (int n: map.getOrDefault(cur, new ArrayList<>())){
                indegree[n]--;
                if (indegree[n] == 0) q.offer(n);
            }
        }
        return count == numCourses;
    }
}
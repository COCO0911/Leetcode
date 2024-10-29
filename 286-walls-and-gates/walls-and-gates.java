class Solution {
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        int n = rooms[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++){
                if (rooms[i][j] == 0) { //find gate
                    q.add(new int[]{i, j});
                }
            }
        }
        
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        int cur = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] loc = q.poll();
                int r = loc[0];
                int c = loc[1];
                
                rooms[r][c] = Math.min(cur, rooms[r][c]);
                for (int[] dir : dirs){
                    int x = r + dir[0];
                    int y = c + dir[1];
                    
                    if (x < 0 || y < 0 || x >= rooms.length || y >= rooms[0].length){
                        continue;
                    }
                    if (rooms[x][y] != Integer.MAX_VALUE) continue;
                    
                    q.offer(new int[]{x, y});
                }
            }
            cur++;
        }
    }
    
  
}

/*
bfs:
gate is starting point 
int cur 

add all gate(starting point into queue)
*/
class Solution {
    int[][] direction = {{-1, 0},{1, 0},{0, 1},{0, -1}};
    class State{
        int row;
        int col;
        int distance;
        State(int row, int col, int distance){
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length, col = mat[0].length;
        int[][] matrix = new int[row][col];

        Queue<State> queue = new LinkedList<>();

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (mat[r][c] == 0){
                    queue.add(new State(r, c, 0));
                }else {
                    matrix[r][c] = Integer.MAX_VALUE;
                }
            }
        }

        while(!queue.isEmpty()){
            State state = queue.remove();
            for (int[] dir : direction) {
                int newRow = state.row + dir[0];
                int newCol = state.col + dir[1];
                
                if (newRow >= 0 && newRow < row && newCol >= 0 && newCol < col) {
                    if (matrix[newRow][newCol] > state.distance + 1) {
                        matrix[newRow][newCol] = state.distance + 1;
                        queue.add(new State(newRow, newCol, matrix[newRow][newCol]));
                    }
                }
            }
        }
        return matrix;
    }

}
package week04;

public class NumberofIslands {
    private static final int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    private int rows, cols;
    private boolean[][] marked;
    private char[][] grid;
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        rows = grid.length;
        cols = grid[0].length;
        marked = new boolean[rows][cols];
        this.grid = grid;
        int count = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(!marked[i][j] && grid[i][j] == '1'){
                    count++;
                    dfs(i, j);
                }
            }
        }
        return count;
    }
    private void dfs(int i, int j){
        marked[i][j] = true;
        for(int k = 0; k < 4; k++){
            int xNew = i + direction[k][0];
            int yNew = j + direction[k][1];
            if(isArea(xNew, yNew) && !marked[xNew][yNew] && grid[xNew][yNew] == '1') dfs(xNew, yNew);
        }
    }

    private boolean isArea(int i, int j){
        return i >= 0 && i < rows && j >= 0 && j < cols;
    }
}

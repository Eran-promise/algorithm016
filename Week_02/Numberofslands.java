package week02;
/**
 * author: Eran-promise
 * question: 岛屿数量
 * url: https://leetcode-cn.com/problems/number-of-islands/
 * action: https://leetcode-cn.com/problems/number-of-islands/solution/dfs-bfs-bing-cha-ji-python-dai-ma-java-dai-ma-by-l/
 * time complexity：O(MN)
 */
public class Numberofslands {
    private static final int[][] derection = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    private int rows;
    private int cols;
    private boolean[][] marked;
    private char[][] grid;
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        rows = grid.length;
        cols = grid[0].length;
        this.grid = grid;
        marked = new boolean[rows][cols];
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
            int xNew = i + derection[k][0];
            int yNew = j + derection[k][1];
            if(inArea(xNew, yNew) && !marked[xNew][yNew] && grid[xNew][yNew] == '1') dfs(xNew, yNew);
        }
    }

    private boolean inArea(int i, int j){
        return i >= 0 && i < rows && j >= 0 && j < cols;
    }
}

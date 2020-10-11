package week04;

public class Searcha2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        int top = 0, bottom = matrix.length - 1, col = matrix[0].length - 1;
        while(top < bottom){
            int mid = (bottom + top) / 2;
            if(target > matrix[mid][col]) top = mid + 1;
            else bottom = mid;
        }
        int left = 0, right = col;
        while(left <= right){
            int mid = (left + right) / 2;
            if(matrix[top][mid] == target) return true;
            else if(matrix[top][mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
}

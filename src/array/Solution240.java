package array;

/**
 * @Author:zxp
 * @Description:
 * @Date:20:42 2024/5/21
 */
public class Solution240 {
    public static void main(String[] args) {
        Solution240 solution240 = new Solution240();
        System.out.println(solution240.searchMatrix(new int[][]{{1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 20));
    }
    public boolean searchMatrix(int[][] matrix, int target){
        int m=matrix.length;
        int n=matrix[0].length;
        int row=0,column=n-1;
        while (row<m&&column>=0){
            if(matrix[row][column]==target)
                return true;
            else if(matrix[row][column]>target)
                column--;
            else row++;
        }
        return false;
    }
}

package array;

/**
 * @Author:zxp
 * @Description:
 * @Date:20:31 2024/5/21
 */
public class Solution74 {
    public static void main(String[] args) {
        Solution74 solution74 = new Solution74();
        System.out.println(solution74.searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 100));
    }
    public boolean searchMatrix(int[][] matrix, int target){
        int m=matrix.length;
        int n=matrix[0].length;
        int row=-1;
        for(int i=0;i<m;i++){
            if(target<=matrix[i][n-1]){
                row=i;
                break;
            }
        }
        if(row==-1)
            return false;
        int left=0,right=n-1;
        while (left<=right){
            int mid=(left+right)/2;
            if(matrix[row][mid]==target)
                return true;
            else if(matrix[row][mid]>target)
                right=mid-1;
            else
                left=mid+1;
        }
        return false;
    }
}

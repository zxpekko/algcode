package leetcode150;

/**
 * @Author:zxp
 * @Description:
 * @Date:19:21 2024/8/20
 */
public class Solution74 {
    public static void main(String[] args) {
        Solution74 solution74 = new Solution74();
        System.out.println(solution74.searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}},130));
    }
    public boolean searchMatrix(int[][] matrix, int target){
        int row=-1;
        for(int i=0;i<matrix.length;i++){
            if(target<=matrix[i][matrix[i].length-1]){
                row=i;
                break;
            }
        }
        if(row==-1)
            return false;
        int left=0,right=matrix[row].length-1;
        while (left<=right){
            int mid=(left+right)/2;
            if(target==matrix[row][mid])
                return true;
            else if(target>matrix[row][mid])
                left=mid+1;
            else
                right=mid-1;
        }
        return false;
    }
}

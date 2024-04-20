package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:18:43 2024/4/7
 */
public class Solution54 {
    public static void main(String[] args) {
        int[][] matrix={{1,2,3},{4,5,6},{7,8,9}};
        Solution54 solution54 = new Solution54();
        System.out.println(solution54.spiralOrder(matrix));
    }

    public List<Integer> spiralOrder(int[][] matrix){
        int[][] order={{0,1},{1,0},{0,-1},{-1,0}};
        int m=matrix.length;
        int n=matrix[0].length;
        boolean[][] visted = new boolean[m][n];
        int index=0;
        int original=0;
        int row=0,column=0;
        List<Integer> result=new ArrayList<>();
        while (index<m*n){
            result.add(matrix[row][column]);
            visted[row][column]=true;
            int nextRow=row+order[original][0];
            int nextColumn=column+order[original][1];
            if(nextRow>=m||nextRow<0||nextColumn>=n||nextColumn<0||visted[nextRow][nextColumn])
                original=(original+1)%4;
            row=row+order[original][0];
            column=column+order[original][1];
            index++;
        }
        return result;
    }
}

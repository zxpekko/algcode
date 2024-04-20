package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:11:00 2024/4/18
 */
public class Solution54Ⅱ {
    public static void main(String[] args) {
        Solution54Ⅱ solution54Ⅱ = new Solution54Ⅱ();
        System.out.println(solution54Ⅱ.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
    }
    int[][] directions={{0,1},{1,0},{0,-1},{-1,0}};
    public List<Integer> spiralOrder(int[][] matrix){
        int m=matrix.length;
        int n=matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        int index=0;
        int row=0,column=0;
        int curDirection=0;
        List<Integer> result=new ArrayList<>();
        while (index<m*n){
            result.add(matrix[row][column]);
            visited[row][column]=true;
            int curRow=row+directions[curDirection][0];
            int curColumn=column+directions[curDirection][1];
            if(curRow<0||curRow>=m||curColumn<0||curColumn>=n||visited[curRow][curColumn])
                curDirection=(curDirection+1)%4;
            row=row+directions[curDirection][0];
            column=column+directions[curDirection][1];
            index++;
        }
        return result;
    }
}

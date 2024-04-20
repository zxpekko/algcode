package array;

import java.io.BufferedOutputStream;
import java.util.Arrays;

/**
 * @Author:zxp
 * @Description:
 * @Date:10:50 2024/4/18
 */
public class Solution59Ⅱ {
    public static void main(String[] args) {
        Solution59Ⅱ solution59Ⅱ = new Solution59Ⅱ();
        for (int[] ints : solution59Ⅱ.generateMatrix(3)) {
            System.out.println(Arrays.toString(ints));
        }

    }
    int[][] directions={{0,1},{1,0},{0,-1},{-1,0}};
    public int[][] generateMatrix(int n){
        int[][] result= new int[n][n];
        boolean[][] visited = new boolean[n][n];
        int index=1;
        int row=0,column=0;
        int curDirection=0;
        while (index<=n*n){
            result[row][column]=index;
            visited[row][column]=true;
            int curRow=row+directions[curDirection][0];
            int curColumn=column+directions[curDirection][1];
            if(curRow<0||curRow>=n||curColumn<0||curColumn>=n||visited[curRow][curColumn])
                curDirection=(curDirection+1)%4;
            row=row+directions[curDirection][0];
            column=column+directions[curDirection][1];
            index++;
        }
        return result;
    }
}

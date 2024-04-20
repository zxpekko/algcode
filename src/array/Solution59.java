package array;

import javax.rmi.ssl.SslRMIClientSocketFactory;
import java.util.Arrays;

/**
 * @Author:zxp
 * @Description:
 * @Date:19:09 2024/4/7
 */
public class Solution59 {
    public static void main(String[] args) {
        Solution59 solution59 = new Solution59();
        int[][] ints = solution59.generateMatrix(3);
//        System.out.println(Arrays.toString(ints));
        for(int i=0;i<ints.length;i++) {
            System.out.println(Arrays.toString(ints[i]));
        }
    }
    public int[][] generateMatrix(int n){
        int[][] order={{0,1},{1,0},{0,-1},{-1,0}};
        int[][] result= new int[n][n];
        int row=0,column=0;
        int original=0;
        boolean[][] visited = new boolean[n][n];
        for(int i=1;i<=n*n;i++) {
            result[row][column]=i;
            visited[row][column]=true;
            int nextRow=row+order[original][0];
            int nextColumn=column+order[original][1];
            if(nextRow>=n||nextRow<0||nextColumn>=n||nextColumn<0||visited[nextRow][nextColumn])
                original=(original+1)%4;
            row=row+order[original][0];
            column=column+order[original][1];
        }
        return result;
    }
}

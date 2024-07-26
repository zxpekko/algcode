package leetcode150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:12:17 2024/7/26
 */
public class Solution289 {
    public static void main(String[] args) {
        Solution289 solution289 = new Solution289();
        int[][] ints = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        solution289.gameOfLife(ints);
        for(int[] ints1:ints){
            System.out.println(Arrays.toString(ints1));
        }
    }
    int[][] directions={{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}};
    public void gameOfLife(int[][] board){
        List<int[]> toOne=new ArrayList<>();
        List<int[]> toZero=new ArrayList<>();
        int m=board.length,n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int ones=0;
                for(int k=0;k<directions.length;k++){
                    int row=i+directions[k][0];
                    int col=j+directions[k][1];
                    if(row<0||row>=m||col<0||col>=n)
                        continue;
                    if(board[row][col]==1)
                        ones++;
                }
                if(board[i][j]==1&&ones<2){
                    int[] rowAndCol = new int[2];
                    rowAndCol[0]=i;
                    rowAndCol[1]=j;
                    toZero.add(rowAndCol);
                }
                else if(board[i][j]==1&&ones>3){
                    int[] rowAndCol = new int[2];
                    rowAndCol[0]=i;
                    rowAndCol[1]=j;
                    toZero.add(rowAndCol);
                }
                else if(board[i][j]==0&&ones==3){
                    int[] rowAndCol = new int[2];
                    rowAndCol[0]=i;
                    rowAndCol[1]=j;
                    toOne.add(rowAndCol);
                }
            }
        }
        for(int i=0;i<toOne.size();i++){
            int[] ints = toOne.get(i);
            int row=ints[0];
            int col=ints[1];
            board[row][col]=1;
        }
        for(int i=0;i<toZero.size();i++){
            int[] ints = toZero.get(i);
            int row=ints[0];
            int col=ints[1];
            board[row][col]=0;
        }
    }
}

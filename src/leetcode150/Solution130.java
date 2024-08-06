package leetcode150;

import javax.print.DocFlavor;
import java.util.Arrays;

/**
 * @Author:zxp
 * @Description:
 * @Date:20:24 2024/8/5
 */
public class Solution130 {
    public static void main(String[] args) {
        Solution130 solution130 = new Solution130();
        char[][] chars = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        solution130.solve(chars);
        for(char[] chars1:chars)
            System.out.println(Arrays.toString(chars1));
    }
    int[][] directions={{0,1},{0,-1},{1,0},{-1,0}};
    public void solve(char[][] board){
        for(int i=0;i<board.length;i++){
            dfs(board,i,0);
            dfs(board,i,board[0].length-1);
        }
        for(int j=0;j<board[0].length;j++){
            dfs(board,0,j);
            dfs(board,board.length-1,j);
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='O')
                    board[i][j]='X';
                else if(board[i][j]=='A')
                    board[i][j]='O';
            }
        }
    }
    public void dfs(char[][] board,int row,int column){
        if(row<0||row>=board.length||column<0||column>=board[0].length)
            return;
        if(board[row][column]=='X'||board[row][column]=='A')
            return;
        board[row][column]='A';
        for(int i=0;i<directions.length;i++){
            int curRow=row+directions[i][0];
            int curCol=column+directions[i][1];
            dfs(board,curRow,curCol);
        }
    }
}
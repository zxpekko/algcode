package leetcode150;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:22:37 2024/8/12
 */
public class Solution79 {
    public static void main(String[] args) {
        Solution79 solution79 = new Solution79();
        char[][] board={{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(solution79.exist(board, "ABCB"));
    }
    int[][] directions={{0,1},{1,0},{0,-1},{-1,0}};
    List<String> result=new ArrayList<>();
    public boolean exist(char[][] board, String word){
        int m=board.length;
        int n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                boolean[][] visited = new boolean[m][n];
                dfs(board,visited,word,new StringBuilder(),i,j,0);
                if(result.size()>0)
                    return true;
            }
        }
        return false;
    }
    public void dfs(char[][] board,boolean[][] visited,String word,StringBuilder stringBuilder,int row,int column,int cur){
        if(result.size()>0)
            return;
        if(stringBuilder.length()==word.length()){
            result.add(stringBuilder.toString());
            return;
        }
        if(row<0||row>=board.length||column<0||column>=board[0].length)
            return;
        if(visited[row][column])
            return;
        if(!visited[row][column]&&board[row][column]!=word.charAt(cur))
            return;
        visited[row][column]=true;
        stringBuilder.append(board[row][column]);
        cur++;
        for(int i=0;i<directions.length;i++){
            int curRow=row+directions[i][0];
            int curCol=column+directions[i][1];
            dfs(board,visited,word,stringBuilder,curRow,curCol,cur);
        }
        visited[row][column]=false;
        stringBuilder.delete(stringBuilder.length()-1,stringBuilder.length());
        cur--;
    }
}
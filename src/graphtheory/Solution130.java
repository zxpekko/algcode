package graphtheory;

import com.sun.org.apache.xerces.internal.impl.dtd.models.DFAContentModel;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author:zxp
 * @Description:
 * @Date:10:51 2024/6/13
 */
public class Solution130 {
    int[][] directions={{-1,0},{1,0},{0,-1},{0,1}};
    public void solve(char[][] board){
        int m=board.length;
        int n=board[0].length;
        for(int i=0;i<m;i++){
            if(board[i][0]=='O')
                bfs(board,i,0);
            if(board[i][n-1]=='O')
                bfs(board,i,n-1);
        }
        for(int j=0;j<n;j++){
            if(board[0][j]=='O')
                bfs(board,0,j);
            if(board[m-1][j]=='O')
                bfs(board,m-1,j);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='A')
                    board[i][j]='O';
                else if(board[i][j]=='O')
                    board[i][j]='X';
            }
        }
    }
    public void dfs(char[][] board,int row,int column){
        if(row<0||row>=board.length||column<0||column>=board[0].length)
            return;
        if(board[row][column]=='A'||board[row][column]=='X')
            return;
        board[row][column]='A';
        for(int i=0;i<directions.length;i++){
            int curRow=row+directions[i][0];
            int curCol=column+directions[i][1];
            dfs(board,curRow,curCol);
        }
    }
    public void bfs(char[][] board,int row,int column){
        Queue<int[]> queue=new LinkedList<>();
        queue.offer(new int[]{row,column});
//        board[row][column]='A';
        while (!queue.isEmpty()){
            int[] poll = queue.poll();
            int pollRow=poll[0];
            int pollCol=poll[1];
            board[pollRow][pollCol]='A';
            for(int i=0;i<directions.length;i++){
                int curRow=pollRow+directions[i][0];
                int curCol=pollCol+directions[i][1];
                if(curRow<0||curRow>=board.length||curCol<0||curCol>=board[0].length)
                    continue;
                if(board[curRow][curCol]=='A'||board[curRow][curCol]=='X')
                    continue;
                queue.offer(new int[]{pollRow,pollCol});
            }
        }
    }
}
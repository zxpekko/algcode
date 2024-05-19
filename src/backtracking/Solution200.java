package backtracking;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author:zxp
 * @Description:
 * @Date:12:38 2024/5/18
 */
public class Solution200 {
    public static void main(String[] args) {
        Solution200 solution200 = new Solution200();
        System.out.println(solution200.numIslands(new char[][]{{'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}}));
    }
    private int[][] directions={{-1,0},{1,0},{0,-1},{0,1}};
    public int numIslands(char[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] record = new boolean[m][n];
        int result=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'&&!record[i][j]){
                    dfs(grid,i,j,record);
                    result++;
                }
            }
        }
        return result;
    }
    public void dfs(char[][] grid,int row,int column,boolean[][] record){
        if(row<0||row>=grid.length||column<0||column>=grid[0].length)
            return;
        if(record[row][column]||grid[row][column]=='0')
            return;
        record[row][column]=true;
        for(int i=0;i<directions.length;i++){
            int curRow=row+directions[i][0];
            int curColumn=column+directions[i][1];
            dfs(grid,curRow,curColumn,record);
        }
    }
}

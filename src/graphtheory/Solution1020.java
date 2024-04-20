package graphtheory;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author:zxp
 * @Description:
 * @Date:13:30 2024/4/17
 */
public class Solution1020 {
    public static void main(String[] args) {
        Solution1020 solution1020 = new Solution1020();
        System.out.println(solution1020.numEnclaves(new int[][]{{0,1,1,0}, {0,0,1,0}, {0,0,1,0}, {0,0,0,0}}));
        Solution1020Ⅱ solution1020Ⅱ = new Solution1020Ⅱ();
        System.out.println(solution1020Ⅱ.numEnclaves(new int[][]{{0, 1, 1, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}}));
    }
    int[][] directions={{-1,0},{1,0},{0,-1},{0,1}};
    public int numEnclaves(int[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        for(int i=0;i<m;i++){
            if(grid[i][0]==1)
                dfs(grid,i,0);
            if(grid[i][n-1]==1)
                dfs(grid,i,n-1);
        }
        for(int i=0;i<n;i++){
            if(grid[0][i]==1)
                dfs(grid,0,i);
            if(grid[m-1][i]==1)
                dfs(grid,m-1,i);
        }
        int result=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                result+=(grid[i][j]==1?1:0);
            }
        }
        return result;
    }
    public void dfs(int[][] grid,int row,int column){
        if(row<0||row>=grid.length||column<0||column>=grid[0].length)
            return;
        if(grid[row][column]==0)
            return;
        grid[row][column]=0;
        for(int i=0;i<directions.length;i++){
            dfs(grid,row+directions[i][0],column+directions[i][1]);
        }
    }
}
class Solution1020Ⅱ{
    int[][] directions={{-1,0},{1,0},{0,-1},{0,1}};
    public int numEnclaves(int[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        for(int i=0;i<m;i++){
            if(grid[i][0]==1)
                bfs(grid,i,0);
            if(grid[i][n-1]==1)
                bfs(grid,i,n-1);
        }
        for(int i=0;i<n;i++){
            if(grid[0][i]==1)
                bfs(grid,0,i);
            if(grid[m-1][i]==1)
                bfs(grid,m-1,i);
        }
        int result=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                result+=(grid[i][j]==1?1:0);
            }
        }
        return result;
    }
    public void bfs(int[][] grid,int row,int column){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row,column});
        while (!queue.isEmpty()){
            int[] poll = queue.poll();
            int pollRow=poll[0];
            int pollColumn=poll[1];
            grid[pollRow][pollColumn]=0;
            for(int i=0;i<directions.length;i++){
                int curRow=pollRow+directions[i][0];
                int curColumn=pollColumn+directions[i][1];
                if(curRow<0||curRow>=grid.length||curColumn<0||curColumn>=grid[0].length)
                    continue;
                if(grid[curRow][curColumn]==0)
                    continue;
                queue.offer(new int[]{curRow,curColumn});
            }
        }
    }
}
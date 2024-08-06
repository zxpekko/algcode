package leetcode150;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author:zxp
 * @Description:
 * @Date:21:48 2024/8/4
 */
public class Solution200 {
    public static void main(String[] args) {
        Solution200 solution200 = new Solution200();
        System.out.println(solution200.numIslands(new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}}));
    }
    int[][] directions={{0,1},{0,-1},{1,0},{-1,0}};
    public int numIslands(char[][] grid){
        int m= grid.length;;
        int n=grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j]&&grid[i][j]=='1'){
                    count++;
                    bfs(grid,i,j,visited);
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid,int row,int column,boolean[][] visited){
        if(row<0||row>=grid.length||column<0||column>=grid[0].length)
            return;
        if(grid[row][column]=='0'||visited[row][column])
            return;
        visited[row][column]=true;
        for(int i=0;i<directions.length;i++){
            int curRow=row+directions[i][0];
            int curCol=column+directions[i][1];
            dfs(grid,curRow,curCol,visited);
        }
    }
    public void bfs(char[][] grid,int row,int column,boolean[][] visited){
        Queue<int[]> queue=new LinkedList<>();
        queue.offer(new int[]{row,column});
        while (!queue.isEmpty()){
            int[] poll = queue.poll();
            int pollRow=poll[0];
            int pollCol=poll[1];
            if(pollRow<0||pollRow>=grid.length||pollCol<0||pollCol>=grid[0].length)
                continue;
            if(grid[pollRow][pollCol]=='0'||visited[pollRow][pollCol])
                continue;
            visited[pollRow][pollCol]=true;
            for(int i=0;i< directions.length;i++){
                int curRow=pollRow+directions[i][0];
                int curCol=pollCol+directions[i][1];
                queue.offer(new int[]{curRow,curCol});
            }
        }
    }
}
package backtracking;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author:zxp
 * @Description:
 * @Date:11:28 2024/5/27
 */
public class Solution994 {
    public static void main(String[] args) {
        Solution994 solution994 = new Solution994();
        System.out.println(solution994.orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}));
    }
//    int minute=0;
//    int max=Integer.MIN_VALUE;
    int[][] directions={{-1,0},{1,0},{0,-1},{0,1}};
//    public int orangesRotting(int[][] grid){
//        int maxMinute=Integer.MIN_VALUE;
//        int m=grid.length;
//        int n=grid[0].length;
//        boolean[][] visited = new boolean[m][n];
//        for(int i=0;i<m;i++){
//            for(int j=0;j<n;j++){
//                if(grid[i][j]==2&&!visited[i][j]){
//                    dfs(grid,visited,i,j);
//                }
//                maxMinute=Math.max(maxMinute,max);
//                minute=0;
//                max=Integer.MIN_VALUE;
//            }
//        }
//        return maxMinute;
//    }
//    public void dfs(int[][] grid,boolean[][] visited,int row,int column){
//        if(row<0||row>=grid.length||column<0||column>=grid[0].length)
//            return;
//        if(grid[row][column]==0||visited[row][column])
//            return;
//        grid[row][column]=2;
//        visited[row][column]=true;
//        for(int i=0;i<directions.length;i++){
//            int curRow=row+directions[i][0];
//            int curCol=column+directions[i][1];
//            dfs(grid,visited,curRow,curCol);
//            max=Math.max(max,minute);
//            minute=0;
//        }
//        minute++;
//    }
    int minute=0;
    public int orangesRotting(int[][] grid){
        Queue<int[]> queue=new LinkedList<>();
        int m=grid.length,n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2)
                    queue.offer(new int[]{i,j});
            }
        }
        bfs(grid,queue);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1)
                    return -1;
            }
        }
        return minute;
    }
    public void bfs(int[][] grid,Queue<int[]> queue){
        while (!queue.isEmpty()){
            int size=queue.size();
            int flag=0;
            for(int i=0;i<size;i++){
                int[] poll = queue.poll();
                int row=poll[0];
                int col=poll[1];
                for(int j=0;j<directions.length;j++){
                    int curRow=row+directions[j][0];
                    int curCol=col+directions[j][1];
                    if(curRow<0||curRow>=grid.length||curCol<0||curCol>=grid[0].length)
                        continue;
                    if(grid[curRow][curCol]==0||grid[curRow][curCol]==2)
                        continue;
                    flag=1;
                    grid[curRow][curCol]=2;
                    queue.offer(new int[]{curRow,curCol});
                }
            }
            if(flag==1)
                minute++;
        }
    }
}

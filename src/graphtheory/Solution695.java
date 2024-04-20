package graphtheory;

/**
 * @Author:zxp
 * @Description:
 * @Date:20:45 2024/4/19
 */
public class Solution695 {
    int[][] directions={{-1,0},{1,0},{0,-1},{0,1}};
    int area=0;

    public static void main(String[] args) {
        Solution695 solution695 = new Solution695();
        System.out.println(solution695.maxAreaOfIsland(new int[][]{{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}}));
    }
    public int maxAreaOfIsland(int[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int max=Integer.MIN_VALUE;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                area=0;
                if(grid[i][j]==1&&!visited[i][j]){
                    dfs(grid,i,j,visited);
                    max=Math.max(max,area);
                }
            }
        }
        return max==Integer.MIN_VALUE?0:max;
    }
    public void dfs(int[][] grid,int row,int column,boolean[][] visited){
        if(row<0||row>=grid.length||column<0||column>=grid[0].length)
            return;
        if(grid[row][column]==0||visited[row][column])
            return;
        visited[row][column]=true;
        area++;
        for(int i=0;i<directions.length;i++){
            int curRow=row+directions[i][0];
            int curColumn=column+directions[i][1];
            dfs(grid,curRow,curColumn,visited);
        }
    }
}

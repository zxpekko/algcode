package graphtheory;

/**
 * @Author:zxp
 * @Description:
 * @Date:10:34 2024/4/18
 */
public class Solution200 {
    public static void main(String[] args) {
        Solution200 solution200 = new Solution200();
        System.out.println(solution200.numIslands(new char[][]{{'1', '1', '1', '1', '0'}}));
    }
    int[][] direction={{-1,0},{1,0},{0,-1},{0,1}};
    public int numIslands(char[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        int result=0;
        boolean[][] visitd= new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'&&!visitd[i][j]){
                    dfs(grid,i,j,visitd);
                    result++;
                }
            }
        }
        return result;
    }
    public void dfs(char[][] grid,int row,int column,boolean[][] visited){
        if(row<0||row>=grid.length||column<0||column>=grid[0].length)
            return;
        if(grid[row][column]=='0'||visited[row][column])
            return;
        visited[row][column]=true;
        for(int i=0;i<direction.length;i++){
            int curRow=row+direction[i][0];
            int curColumn=column+direction[i][1];
            dfs(grid,curRow,curColumn,visited);
        }
    }
}

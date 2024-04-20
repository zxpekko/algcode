package unionfindsets;

/**
 * @Author:zxp
 * @Description:二维矩阵 grid 由 0 （土地）和 1 （水）组成。岛是由最大的4个方向连通的 0 组成的群，封闭岛是一个 完全 由1包围（左、上、右、下）的岛。
 *
 * 请返回 封闭岛屿 的数目。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
 * 输出：2
 * 解释：
 * 灰色区域的岛屿是封闭岛屿，因为这座岛屿完全被水域包围（即被 1 区域包围）。
 * 示例 2：
 *
 *
 *
 * 输入：grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
 * 输出：1
 * 示例 3：
 *
 * 输入：grid = [[1,1,1,1,1,1,1],
 *              [1,0,0,0,0,0,1],
 *              [1,0,1,1,1,0,1],
 *              [1,0,1,0,1,0,1],
 *              [1,0,1,1,1,0,1],
 *              [1,0,0,0,0,0,1],
 *              [1,1,1,1,1,1,1]]
 * 输出：2
 *
 *
 * 提示：
 *
 * 1 <= grid.length, grid[0].length <= 100
 * 0 <= grid[i][j] <=1
 * @Date:12:10 2024/2/22
 */
public class ClosedIsland {
    public static void main(String[] args) {
        ClosedIsland closedIsland = new ClosedIsland();
//        System.out.println(closedIsland.closedIsland(new int[][]{{1, 1, 1, 1, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 1, 0, 1}, {1, 1, 1, 1, 1, 1, 1, 0}}));
//        System.out.println(closedIsland.closedIsland(new int[][]{{0, 0, 1, 0, 0}, {0, 1, 0, 1, 0}, {0, 1, 1, 1, 0}}));
        System.out.println(closedIsland.closedIsland(new int[][]{{1, 1, 1, 1, 1, 1, 1}, {1, 0, 0, 0, 0, 0, 1}, {1, 0, 1, 1, 1, 0, 1}, {1, 0, 1, 0, 1, 0, 1}, {1, 0, 1, 1, 1, 0, 1}, {1, 0, 0, 0, 0, 0, 1}, {1, 1, 1, 1, 1, 1, 1}}));
    }
    int[][] position={{-1,0},{1,0},{0,-1},{0,1}};
    boolean flag=true;
    boolean[][] visited;
    public int closedIsland(int[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        visited=new boolean[m][n];
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0&&!visited[i][j]){
                    visited[i][j]=true;
                    dfs(grid,i,j,visited);
                    if(flag)
                        count++;
                    else
                        flag=true;
                }
            }
        }
        return count;
    }
    public void dfs(int[][] grid,int row,int column,boolean[][] visited){
        for(int i=0;i< position.length;i++){
            int curRow=row+position[i][0];
            int curColumn=column+position[i][1];
            if(curRow<0||curRow>=grid.length||curColumn<0||curColumn>=grid[0].length){
                flag=false;
                continue;
            }
            if(grid[curRow][curColumn]==1||visited[curRow][curColumn])
                continue;
            visited[curRow][curColumn]=true;
            dfs(grid,curRow,curColumn,visited);
        }
    }
}

package unionfindsets;

/**
 * @Author:zxp
 * @Description:这里有一幅服务器分布图，服务器的位置标识在 m * n 的整数矩阵网格 grid 中，1 表示单元格上有服务器，0 表示没有。
 *
 * 如果两台服务器位于同一行或者同一列，我们就认为它们之间可以进行通信。
 *
 * 请你统计并返回能够与至少一台其他服务器进行通信的服务器的数量。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：grid = [[1,0],[0,1]]
 * 输出：0
 * 解释：没有一台服务器能与其他服务器进行通信。
 * 示例 2：
 *
 *
 *
 * 输入：grid = [[1,0],[1,1]]
 * 输出：3
 * 解释：所有这些服务器都至少可以与一台别的服务器进行通信。
 * 示例 3：
 *
 *
 *
 * 输入：grid = [[1,1,0,0],[0,0,1,0],[0,0,1,0],[0,0,0,1]]
 * 输出：4
 * 解释：第一行的两台服务器互相通信，第三列的两台服务器互相通信，但右下角的服务器无法与其他服务器通信。
 *
 *
 * 提示：
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m <= 250
 * 1 <= n <= 250
 * grid[i][j] == 0 or 1
 * @Date:11:36 2024/2/23
 */
public class CountServers {
    public static void main(String[] args) {
        CountServers countServers = new CountServers();
//        System.out.println(countServers.countServers(new int[][]{{1,1,0,0}, {0,0,1,0},{0,0,1,0},{0,0,0,1}}));
        System.out.println(countServers.countServers(new int[][]{{1,0,0,1,0}, {0,0,0,0,0},{0,0,0,1,0}}));
    }
    int curSum=0;
    int sum=0;
    int[][] position={{-1,0},{1,0},{0,-1},{0,1}};
    boolean[][] visited;
    public int countServers(int[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        visited=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1&&!visited[i][j]&&judgeHasServers(grid,i,j)){
                    curSum++;
                    visited[i][j]=true;
                    dfs(grid,i,j);
                    sum+=curSum;
                    curSum=0;
                }
            }
        }
        return sum;
    }
    public void dfs(int[][] grid,int row,int column){
        for(int i=0;i<position.length;i++){
            int curRow=row+position[i][0];
            int curColumn=column+position[i][1];
            while (curRow>=0&&curRow< grid.length&&curColumn>=0&&curColumn<grid[0].length){
                if(grid[curRow][curColumn]==1&&!visited[curRow][curColumn]){
                    curSum++;
                    visited[curRow][curColumn]=true;
                }
                curRow=curRow+position[i][0];
                curColumn=curColumn+position[i][1];
            }
        }
    }
    public boolean judgeHasServers(int[][] grid,int row,int column){
        for(int i=0;i<grid.length;i++){
            if(grid[i][column]==1&&i!=row)
                return true;
        }
        for(int j=0;j<grid[0].length;j++){
            if(grid[row][j]==1&&j!=column)
                return true;
        }
        return false;
    }
}

package leetcode150;

import java.util.Scanner;

/**
 * @Author:zxp
 * @Description:
 * @Date:10:55 2024/11/7
 */
public class KAM106 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] grid = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                grid[i][j]=scanner.nextInt();
            }
        }
        int res = countLength(grid);
        System.out.println(res);
    }
    public static int countLength(int[][] grid){
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] visited = new boolean[n][m];
        label:for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    dfs(grid,i,j,visited);
                    break label;
                }
            }
        }
        return total;
    }
    static int total=0;
    static int[][] directions={{0,1},{0,-1},{1,0},{-1,0}};
    public static void dfs(int[][] grid,int row,int col,boolean[][] visited){
        if(row<0||row>=grid.length||col<0||col>=grid[0].length)
            return;
        if(grid[row][col]==0||visited[row][col])
            return;
        visited[row][col]=true;
        int board=0;
        for(int i=0;i<directions.length;i++){
            int curRow=row+directions[i][0];
            int curCol=col+directions[i][1];
            if(curRow<0||curRow>=grid.length||curCol<0||curCol>=grid[0].length)
                continue;
            if(grid[curRow][curCol]==0)
                continue;
            board++;
        }
        total+=(4-board);
        for(int i=0;i<directions.length;i++){
            int curRow=row+directions[i][0];
            int curCol=col+directions[i][1];
            dfs(grid,curRow,curCol,visited);
        }
    }
}

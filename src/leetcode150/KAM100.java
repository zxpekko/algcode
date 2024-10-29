package leetcode150;

import java.util.Scanner;

/**
 * @Author:zxp
 * @Description:
 * @Date:12:38 2024/10/22
 */
public class KAM100 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] grid = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                grid[i][j]=scanner.nextInt();
            }
        }
        int max=Integer.MIN_VALUE;
        boolean[][] visited=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1&&!visited[i][j]){
                    curMax=0;
                    dfs(grid,i,j,visited);
                    if(curMax>max)
                        max=curMax;
                }
            }
        }
        System.out.println(max);
    }
    static int curMax=0;
    static int[][] directions={{0,1},{0,-1},{1,0},{-1,0}};
    public static void dfs(int[][] grid,int row,int col,boolean[][] visited){
        if(row<0||row>=grid.length||col<0||col>grid[0].length)
            return;
        if(grid[row][col]==0||visited[row][col])
            return;
        visited[row][col]=true;
        curMax++;
        for(int i=0;i<directions.length;i++){
            int curRow=row+directions[i][0];
            int curCol=col+directions[i][1];
            dfs(grid,curRow,curCol,visited);
        }
    }
}
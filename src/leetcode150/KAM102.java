package leetcode150;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author:zxp
 * @Description:
 * @Date:13:15 2024/10/28
 */
public class KAM102 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] grid= new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                grid[i][j]=scanner.nextInt();
            }
        }
        boolean[][] visited = new boolean[n][m];
        for(int i=0;i<n;i++){
            dfs(grid,i,0,visited);
            dfs(grid,i,m-1,visited);
        }
        for(int j=0;j<m;j++){
            dfs(grid,0,j,visited);
            dfs(grid,n-1,j,visited);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j]&&grid[i][j]==1)
                    grid[i][j]=0;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(j!=m-1)
                    System.out.print(grid[i][j]+" ");
                else
                    System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }
    static int[][] directions={{0,1},{0,-1},{1,0},{-1,0}};
    public static void dfs(int[][] grid,int row,int col,boolean[][] visited){
        if(row<0||row>= grid.length||col<0||col>=grid[0].length)
            return;
        if(grid[row][col]!=1||visited[row][col])
            return;
        visited[row][col]=true;
        for(int i=0;i<directions.length;i++){
            int curRow=row+directions[i][0];
            int curCol=col+directions[i][1];
            dfs(grid,curRow,curCol,visited);
        }
    }
}

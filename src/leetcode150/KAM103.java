package leetcode150;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * @Author:zxp
 * @Description:
 * @Date:13:58 2024/10/29
 */
public class KAM103 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] grid= new int[n][m];
        boolean[][][] visited = new boolean[2][n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                grid[i][j]=scanner.nextInt();
            }
        }
        for(int i=0;i<n;i++){
//            fdfs(grid,i,0,visited);
            dfs(grid,i,0,visited,0);
//            sdfs(grid,i,m-1,visited);
            dfs(grid,i,m-1,visited,1);
        }
        for(int j=0;j<m;j++){
//            fdfs(grid,0,j,visited);
            dfs(grid,0,j,visited,0);
//            sdfs(grid,n-1,j,visited);
            dfs(grid,n-1,j,visited,1);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[0][i][j]&&visited[1][i][j]){
                    System.out.print(i+" "+j);
                    System.out.println();
                }
            }
        }
    }
    static int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};
//    static int[][] directions1={{1,0},{-1,0},{0,1},{0,-1}};
//    public static void fdfs(int[][] grid,int row,int col,boolean[][][] visited){
//        if(visited[0][row][col])
//            return;
//        visited[0][row][col]=true;
//        for(int i=0;i<directions.length;i++){
//            int curRow=row+directions[i][0];
//            int curCol=col+directions[i][1];
//            if(curRow<0||curRow>=grid.length||curCol<0||curCol>=grid[0].length)
//                continue;
//            if(grid[curRow][curCol]>=grid[row][col])
//                fdfs(grid,curRow,curCol,visited);
//        }
//    }
//    public static void sdfs(int[][] grid,int row,int col,boolean[][][] visited){
//        if(visited[1][row][col])
//            return;
//        visited[1][row][col]=true;
//        for(int i=0;i<directions.length;i++){
//            int curRow=row+directions[i][0];
//            int curCol=col+directions[i][1];
//            if(curRow<0||curRow>=grid.length||curCol<0||curCol>=grid[0].length)
//                continue;
//            if(grid[curRow][curCol]>=grid[row][col])
//                sdfs(grid,curRow,curCol,visited);
//        }
//    }
    public static void dfs(int[][] grid,int row,int col,boolean[][][] visited,int group){
        if(visited[group][row][col])
            return;
        visited[group][row][col]=true;
        for(int i=0;i<directions.length;i++){
            int curRow=row+directions[i][0];
            int curCol=col+directions[i][1];
            if(curRow<0||curRow>=grid.length||curCol<0||curCol>=grid[0].length)
                continue;
            if(grid[curRow][curCol]>=grid[row][col])
                dfs(grid,curRow,curCol,visited,group);
        }
    }
}

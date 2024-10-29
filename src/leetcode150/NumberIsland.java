package leetcode150;

import org.junit.Test;

import java.util.Scanner;

/**
 * @Author:zxp
 * @Description:
 * @Date:13:52 2024/10/16
 */
public class NumberIsland {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] nums = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                nums[i][j]=scanner.nextInt();
            }
        }
        int total=0;
        boolean[][] visted=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(nums[i][j]==1&&!visted[i][j]){
                    dfs(nums,i,j,visted);
                    total++;
                }
            }
        }
        System.out.println(total);
    }
    static int[][] directions={{0,1},{0,-1},{1,0},{-1,0}};
    public static void dfs(int[][] nums,int row,int col,boolean[][] visited){
        if(row<0||row>=nums.length||col<0||col>=nums[0].length)
            return;
        if(nums[row][col]==0||visited[row][col])
            return;
        visited[row][col]=true;
        for(int i=0;i<directions.length;i++){
            int curRow=row+directions[i][0];
            int curCol=col+directions[i][1];
            dfs(nums,curRow,curCol,visited);
        }
    }
}

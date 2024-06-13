package graphtheory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:15:14 2024/6/6
 */
public class Solution827 {
    public static void main(String[] args) {
        Solution827 solution827 = new Solution827();
        System.out.println(solution827.largestIsland(new int[][]{{1,0,1}, {0, 0,0},{0,1,1}}));
    }
    int sum=0;
    int[][] directions={{-1,0},{1,0},{0,-1},{0,1}};
//    public int largestIsland(int[][] grid){
//        int max=0;
//        int m=grid.length;
//        int n=grid[0].length;
//        for(int i=0;i<m;i++){
//            for(int j=0;j<n;j++){
//                if(grid[i][j]==0){
//                    grid[i][j]=1;
//                    boolean[][] visited = new boolean[m][n];
//                    dfs(grid,visited,i,j);
//                    grid[i][j]=0;
//                    max=Math.max(max,sum);
//                    sum=0;
//                }
//            }
//        }
//        return max==0?m*n:max;
//    }
//    public void dfs(int[][] grid,boolean[][] visited,int row,int colum){
//        if(row<0||row>=grid.length||colum<0||colum>=grid[0].length)
//            return;
//        if(grid[row][colum]==0||visited[row][colum])
//            return;
//        visited[row][colum]=true;
//        sum+=1;
//        for(int i=0;i<directions.length;i++){
//            int curRow=row+directions[i][0];
//            int curCol=colum+directions[i][1];
//            dfs(grid,visited,curRow,curCol);
//        }
//    }
    public int largestIsland(int[][] grid){
        int m=grid.length,n=grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] record = new int[m][n];
        int index=0;
        List<Integer> sums=new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1&&!visited[i][j]){
                    dfs(grid,visited,i,j,record,index);
                    sums.add(sum);
                    sum=0;
                    index++;
                }
            }
        }
        if(sums.size()==0)
            return 1;
        int max=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    HashSet<Integer> hashSet = new HashSet<>();
                    int curMax=1;
                    for(int k=0;k<directions.length;k++){
                        int curRow=i+directions[k][0];
                        int curCol=j+directions[k][1];
                        if(curRow<0||curRow>=m||curCol<0||curCol>=n)
                            continue;
                        if(hashSet.contains(record[curRow][curCol]))
                            continue;
                        if(grid[curRow][curCol]==0)
                            continue;
                        Integer curSum = sums.get(record[curRow][curCol]);
                        curMax+=curSum;
                        hashSet.add(record[curRow][curCol]);
                    }
                    max=Math.max(max,curMax);
                }
            }
        }
        return max==0?m*n:max;
    }
    public void dfs(int[][] grid,boolean[][] visited,int row,int column,int[][] record,int index){
        if(row<0||row>=grid.length||column<0||column>=grid[0].length)
            return;
        if(grid[row][column]==0||visited[row][column])
            return;
        sum+=1;
        visited[row][column]=true;
        record[row][column]=index;
        for(int i=0;i<directions.length;i++){
            int curRow=row+directions[i][0];
            int curCol=column+directions[i][1];
            dfs(grid,visited,curRow,curCol,record,index);
        }
    }
}
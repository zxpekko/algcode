package leetcode150;

import java.util.*;

/**
 * @Author:zxp
 * @Description:
 * @Date:11:56 2024/11/6
 */
public class KAM104 {
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
        int max = maxPersonIsland(grid);
        System.out.println(max);
    }
    public static int maxPersonIsland(int[][] grid){
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int[][] indexs = new int[n][m];
        List<Integer> mask=new ArrayList<>();
        int index=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1&&!visited[i][j]){
                    dfs(grid,i,j,visited,index,indexs);
                    mask.add(curArea);
                    curArea=0;
                    index++;
                }
            }
        }
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0){
                    int curMax=0;
                    Set<Integer> curIndex=new HashSet<>();
                    for(int d=0;d<directions.length;d++){
                        int curRow=i+directions[d][0];
                        int curCol=j+directions[d][1];
                        if(curRow<0||curRow>=grid.length||curCol<0||curCol>=grid[0].length)
                            continue;
                        if(grid[curRow][curCol]==0)
                            continue;
                        int nowIndex=indexs[curRow][curCol];
                        if(!curIndex.contains(nowIndex)){
                            curIndex.add(nowIndex);
                            curMax+=mask.get(nowIndex);
                        }
                    }
                    if(curMax+1>max)
                        max=curMax+1;
                }
            }
        }
        return max==0?n*m:max;
    }
    static int[][] directions={{0,1},{0,-1},{1,0},{-1,0}};
    static int curArea=0;
    public static void dfs(int[][] grid,int row,int col,boolean[][] visited,int index,int[][] indexs){
        if(row<0||row>=grid.length||col<0||col>=grid[0].length)
            return;
        if(grid[row][col]==0||visited[row][col])
            return;
        curArea++;
        visited[row][col]=true;
        indexs[row][col]=index;
        for(int i=0;i<directions.length;i++){
            int curRow=row+directions[i][0];
            int curCol=col+directions[i][1];
            dfs(grid,curRow,curCol,visited,index,indexs);
        }
    }
}
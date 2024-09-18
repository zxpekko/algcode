package interview;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Author:zxp
 * @Description:
 * @Date:20:05 2024/9/3
 */
public class MainD2 {
    private static final int[] dx={-1,1,0,0};
    private static final int[] dy={0,0,-1,1};
    static class State{
        int x,y,bombs,steps;
        State(int x,int y,int bombs,int steps){
            this.x=x;
            this.y=y;
            this.bombs=bombs;
            this.steps=steps;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int startX=0,startY=0;
        char[][] grid = new char[n][m];
        for(int i=0;i<n;i++){
            String next = scanner.next();
            for(int j=0;j<next.length();j++){
                grid[i][j]=next.charAt(j);
                if(next.charAt(j)=='B'){
                    startX=i;
                    startY=j;
                }
            }
        }
        int res = minSteps(grid, startX, startY);
        System.out.println(res);
    }
    public static int minSteps(char[][] grid,int startX,int startY){
        int n=grid.length,m=grid[0].length;
        Queue<State> queue=new LinkedList<>();
        boolean[][] visited=new boolean[n][m];
        queue.offer(new State(startX,startY,3,0));
        while (!queue.isEmpty()){
            State cur = queue.poll();
            for(int i=0;i<4;i++){
                int nx=cur.x+dx[i];
                int ny=cur.y+dy[i];
                if(nx>=0&&nx<n&&ny>=0&&ny<m){
                    if(grid[nx][ny]=='W'&&cur.bombs>0&&!visited[nx][ny]){
                        visited[nx][ny]=true;
                        queue.offer(new State(nx,ny,cur.bombs-1, cur.steps+2));
                    }
                    else if(grid[nx][ny]=='.'&&!visited[nx][ny]){
                        visited[nx][ny]=true;
                        queue.offer(new State(nx,ny,cur.bombs, cur.steps+1));
                    }
                    else if(grid[nx][ny]=='*'){
                        return cur.steps+1;
                    }
                }
            }
        }
        return -1;
    }
}

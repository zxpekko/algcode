package binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:11:08 2024/5/10
 */
public class leetcode54 {
    public static void main(String[] args) {
        leetcode54 leetcode54 = new leetcode54();
        System.out.println(leetcode54.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
    }
    int[][] directions={{0,1},{1,0},{0,-1},{-1,0}};
    public List<Integer> spiralOrder(int[][] matrix){
        int m=matrix.length;
        int n=matrix[0].length;
        boolean[][] record = new boolean[m][n];
        List<Integer> result=new ArrayList<>();
        int row=0,column=0;
        int index=0;
        int curDirc=0;
        while (index<m*n){
            result.add(matrix[row][column]);
            record[row][column]=true;
            int curRow=row+directions[curDirc][0];
            int curColumn=column+directions[curDirc][1];
            if(curRow<0||curRow>=m||curColumn<0||curColumn>=n||record[curRow][curColumn])
                curDirc=(curDirc+1)%4;
            row=row+directions[curDirc][0];
            column=column+directions[curDirc][1];
            index++;
        }
        return result;
    }
}

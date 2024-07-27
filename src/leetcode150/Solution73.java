package leetcode150;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @Author:zxp
 * @Description:
 * @Date:12:41 2024/7/26
 */
public class Solution73 {
    public static void main(String[] args) {
        Solution73 solution73 = new Solution73();
        int[][] ints = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        solution73.setZeroes(ints);
        for(int[] ints1:ints)
            System.out.println(Arrays.toString(ints1));
    }
    public void setZeroes(int[][] matrix){
        HashSet<Integer> rowSet=new HashSet<>();
        HashSet<Integer> colSet=new HashSet<>();
        int m=matrix.length,n=matrix[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }
        rowSet.forEach(v->{
            for(int j=0;j<n;j++)
                matrix[v][j]=0;
        });
        colSet.forEach(v->{
            for(int i=0;i<m;i++)
                matrix[i][v]=0;
        });
    }
}

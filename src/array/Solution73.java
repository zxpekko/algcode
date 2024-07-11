package array;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @Author:zxp
 * @Description:
 * @Date:13:03 2024/7/10
 */
public class Solution73 {
    public static void main(String[] args) {
        Solution73 solution73 = new Solution73();
        int[][] ints = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        solution73.setZeroes(ints);
        for(int i=0;i<ints.length;i++){
            System.out.println(Arrays.toString(ints[i]));
        }
    }
    public void setZeroes(int[][] matrix){
        HashSet<Integer> rowSet = new HashSet<>();
        HashSet<Integer> colSet = new HashSet<>();
        int m= matrix.length,n=matrix[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    rowSet.add(i);
                    colSet.add(j);
            }
        }
        }
        for(int i=0;i<m;i++){
            if(rowSet.contains(i)){
                for(int col=0;col<n;col++){
                    matrix[i][col]=0;
                }
            }
        }
        for(int j=0;j<n;j++){
            if(colSet.contains(j)){
                for(int row=0;row<m;row++){
                    matrix[row][j]=0;
                }
            }
        }
    }
}

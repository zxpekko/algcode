package leetcode150;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipInputStream;

/**
 * @Author:zxp
 * @Description:
 * @Date:21:01 2024/7/25
 */
public class Solution48 {
    public static void main(String[] args) {
        Solution48 solution48 = new Solution48();
        int[][] ints = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        solution48.rotate(ints);
//        System.out.println(Arrays.toString(ints));
        for(int[] ints1:ints)
            System.out.println(Arrays.toString(ints1));
    }
    public void rotate(int[][] matrix){
        List<Integer> mid=new ArrayList<>();
        int m=matrix.length;
        int n=matrix[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                mid.add(matrix[i][j]);
            }
        }
        int index=0;
        int col=n-1;
        while (col>=0){
            for(int i=0;i<m;i++)
                matrix[i][col]=mid.get(index++);
            col--;
        }
    }
}
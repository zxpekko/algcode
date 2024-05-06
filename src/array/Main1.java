package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author:zxp
 * @Description:
 * @Date:19:57 2024/5/6
 */
public class Main1 {
    public static void main(String[] args) {
        Main1 main1 = new Main1();
        ArrayList<ArrayList<Integer>> matrix=new ArrayList<>();
        ArrayList<Integer> matrix1=new ArrayList<>();
        ArrayList<Integer> matrix2=new ArrayList<>();
        ArrayList<Integer> matrix3=new ArrayList<>();
        matrix1.add(1);
        matrix1.add(2);
        matrix1.add(3);
        matrix2.add(4);
        matrix2.add(0);
        matrix2.add(6);
        matrix3.add(7);
        matrix3.add(8);
        matrix3.add(9);
        matrix.add(matrix1);
        matrix.add(matrix2);
        matrix.add(matrix3);
        System.out.println(main1.setZeroes(matrix));
    }
    public ArrayList<ArrayList<Integer>> setZeroes (ArrayList<ArrayList<Integer>> matrix){
        int row=matrix.size();
        int col=matrix.get(0).size();
        int[][] arrs = new int[row][col];
        for(int i=0;i<matrix.size();i++){
            for(int j=0;j<matrix.get(i).size();j++){
                arrs[i][j]=matrix.get(i).get(j);
            }
        }
        set(arrs);
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        for(int i=0;i<arrs.length;i++){
            ArrayList<Integer> subResult=new ArrayList<>();
            for(int j=0;j<arrs[i].length;j++)
                subResult.add(arrs[i][j]);
            result.add(subResult);
        }
        return result;
    }
    public void set(int[][] matrix){
        Set<Integer> row_zero=new HashSet<>();
        Set<Integer> col_zero=new HashSet<>();
        int row=matrix.length;
        int col=matrix[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j]==0){
                    row_zero.add(i);
                    col_zero.add(j);
                }
            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(row_zero.contains(i)||col_zero.contains(j))
                    matrix[i][j]=0;
            }
        }
    }
    public int maxWine(int[] weights){
        if(weights.length==0) return 0;
        if(weights.length==1) return weights[0];
        return Math.max(robRange(Arrays.copyOfRange(weights,0,weights.length-1)),robRange(Arrays.copyOfRange(weights,1,weights.length)));
    }
    public int robRange(int[] nums){
        int pre=0,cur=0,tmp;
        for(int num:nums){
            tmp=cur;
            cur=Math.max(pre+num,cur);
            pre=tmp;
        }
        return cur;
    }
}

package leetcode150;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:19:30 2024/8/14
 */
public class Solution120 {
    public static void main(String[] args) {
        Solution120 solution120 = new Solution120();
        List<List<Integer>> triangle=new ArrayList<>();
        List<Integer> sub1=new ArrayList<>();
        List<Integer> sub2=new ArrayList<>();
        List<Integer> sub3=new ArrayList<>();
        List<Integer> sub4=new ArrayList<>();
        sub1.add(2);
        sub2.add(3);
        sub2.add(4);
        sub3.add(6);
        sub3.add(5);
        sub3.add(7);
        sub4.add(4);
        sub4.add(1);
        sub4.add(8);
        sub4.add(3);
        triangle.add(sub1);
        triangle.add(sub2);
        triangle.add(sub3);
        triangle.add(sub4);
        System.out.println(solution120.minimumTotal(triangle));

    }
    public int minimumTotal(List<List<Integer>> triangle){
        int size = triangle.get(triangle.size() - 1).size();
        int[][] arr = new int[size][size];
        int row=0;
        for(List<Integer> list:triangle){
            int index=0;
            for(int num:list){
                arr[row][index++]=num;
            }
            row++;
        }
        int[][] dp = new int[size][size];
        dp[0][0]=arr[0][0];
        for(int i=1;i<size;i++){
            for(int j=0;j<triangle.get(i).size();j++){
                if(j==0){
                    dp[i][j]=arr[i][j]+dp[i-1][j];
                }
                else if(j==triangle.get(i).size()-1){
                    dp[i][j]=arr[i][j]+dp[i-1][j-1];
                }
                else
                    dp[i][j]=Math.min(dp[i-1][j],dp[i-1][j-1])+arr[i][j];
            }
        }
        int min=Integer.MAX_VALUE;
        for(int j=0;j<size;j++)
            min=Math.min(min,dp[size-1][j]);
        return min;
    }
}
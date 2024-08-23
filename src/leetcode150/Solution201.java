package leetcode150;

import org.junit.Test;

/**
 * @Author:zxp
 * @Description:
 * @Date:19:36 2024/8/22
 */
public class Solution201 {
    public static void main(String[] args) {
        Solution201 solution201 = new Solution201();
        System.out.println(solution201.rangeBitwiseAnd(1, 2));
    }
    public int rangeBitwiseAnd(int left, int right){
        int count=left;
        for(int i=left+1;i<=right;i++){
            count=count&i;
        }
        return count;
    }
    @Test
    public void test(){
        char c='中';
        System.out.println((int)c);
    }
}
package leetcode150;

/**
 * @Author:zxp
 * @Description:
 * @Date:22:45 2024/8/21
 */
public class Solution190 {
    public static void main(String[] args) {
        Solution190 solution190 = new Solution190();
        System.out.println(solution190.reverseBits(42949));
    }
    public int reverseBits(int n){
        StringBuilder stringBuilder = new StringBuilder();
        while (n>0){
            stringBuilder.append(n%2+"");
            n/=2;
        }
        int size=stringBuilder.length();
        int zeros=32-size;
        StringBuilder reverse=new StringBuilder();
        for(int i=0;i<zeros;i++)
            reverse.append(0+"");
        reverse.append(stringBuilder.reverse());
        StringBuilder reverse1 = reverse.reverse();
        int index=0;
        int result=0;
        for(int i=reverse1.length()-1;i>=0;i--){
            int jinzhi=reverse1.charAt(i)-'0';
            result+=(jinzhi*Math.pow(2,index++));
        }
        return result;
    }
}

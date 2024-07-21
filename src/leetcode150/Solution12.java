package leetcode150;

/**
 * @Author:zxp
 * @Description:
 * @Date:18:53 2024/7/20
 */
public class Solution12 {
    public static void main(String[] args) {
        Solution12 solution12 = new Solution12();
        System.out.println(solution12.intToRoman(3749));
    }
    public String intToRoman(int num){
        int[] nums={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] chars={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int cur=num;
        StringBuilder stringBuilder=new StringBuilder();
        int index=0;
        while (cur>0){
            int res=cur/nums[index];
            for(int i=0;i<res;i++)
                stringBuilder.append(chars[index]);
            cur=cur%nums[index++];
        }
        return stringBuilder.toString();
    }
}
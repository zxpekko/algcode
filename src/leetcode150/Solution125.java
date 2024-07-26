package leetcode150;

/**
 * @Author:zxp
 * @Description:
 * @Date:11:29 2024/7/22
 */
public class Solution125 {
    public static void main(String[] args) {
        Solution125 solution125 = new Solution125();
        System.out.println(solution125.isPalindrome("A man, a plan, a canal: Panama"));
    }
    public boolean isPalindrome(String s){
        String s1 = s.toLowerCase();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<s1.length();i++){
            if(Character.isLetterOrDigit(s1.charAt(i)))
                stringBuilder.append(s1.charAt(i));
        }
        int left=0,right=stringBuilder.length()-1;
        while (left<right){
            if(stringBuilder.charAt(left)==stringBuilder.charAt(right)){
                left++;
                right--;
            }
            else
                return false;
        }
        return true;
    }
}
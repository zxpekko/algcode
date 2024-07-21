package leetcode150;

/**
 * @Author:zxp
 * @Description:
 * @Date:12:06 2024/7/21
 */
public class Solution58 {
    public static void main(String[] args) {
        Solution58 solution58 = new Solution58();
        System.out.println(solution58.lengthOfLastWord("   fly me   to   the moon  "));
    }
    public int lengthOfLastWord(String s){
        int n=s.length();
        int result=0,cur=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)!=' '){
                cur++;
                result=cur;
            }
            else {
//                result=(cur==0?result:cur);
                cur=0;
            }
        }
        return result;
    }
}

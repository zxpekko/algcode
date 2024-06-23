import monotonicstack.Solution42;

/**
 * @Author:zxp
 * @Description:
 * @Date:19:23 2024/6/18
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.get_substr("222BCC111CB"));
    }
    public String get_substr (String st){
        StringBuffer sb = new StringBuffer(st);
        boolean changed=true;
        while (changed){
            changed=false;
            for(int i=0;i<sb.length()-2;i++){
                if(sb.charAt(i)==sb.charAt(i+1)&&sb.charAt(i+1)==sb.charAt(i+2)){
                    sb.delete(i,i+3);
                    changed=true;
                    break;
                }
            }
        }
        return sb.toString();
    }
}

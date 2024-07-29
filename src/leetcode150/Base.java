package leetcode150;

/**
 * @Author:zxp
 * @Description:一个数在2-36进制下的表示中，1的数量最多是多少？
 * @Date:23:05 2024/7/28
 */
public class Base {
    public static void main(String[] args) {
        Base base = new Base();
        System.out.println(base.getMaxOnes(100));
    }
    public int getMaxOnes(int n){
        int max=0;
        for(int base=2;base<=36;base++){
            int maxOneCount = getMaxOneCount(base, n);
            max=Math.max(max,maxOneCount);
        }
        return max;
    }
    public int getMaxOneCount(int base,int n){
        int count=0;
        while (n>0){
            if(n%base==1)
                count++;
            n/=base;
        }
        return count;
    }
}
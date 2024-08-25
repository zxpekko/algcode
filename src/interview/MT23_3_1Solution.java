package interview;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @Author:zxp
 * @Description:1.
 * 平均数为k的最长连续子数组
 * 给定
 * n
 * n个正整数组成的数组，求平均数正好等于
 * k
 * k 的最长连续子数组的长度。
 * 时间限制：C/C++ 2秒，其他语言4秒
 * 空间限制：C/C++ 256M，其他语言512M
 * 输入描述：
 * 第一行输入两个正整数n和k，用空格隔开。
 * 第二行输入n个正整数a_i，用来表示数组。
 *
 *
 * 输出描述：
 * 如果不存在任何一个连续子数组的平均数等于k，则输出-1。
 * 否则输出平均数正好等于 k 的最长连续子数组的长度。
 *
 * 示例1
 * 输入例子：
 * 5 2
 * 1 3 2 4 1
 * 输出例子：
 * 3
 * 例子说明：
 * 取前三个数即可，平均数为2。
 * @Date:18:15 2024/8/25
 */
public class MT23_3_1Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        HashMap<Long,Integer> hashMap=new HashMap<>();
        hashMap.put(0L,0);
        int result=0;
        long pre=0;
        long cur=0;
        for(int i=1;i<=n;i++){
            cur=pre+scanner.nextInt()-k;
            if(hashMap.containsKey(cur))
                result=Math.max(result,i-hashMap.get(cur));
            else hashMap.put(cur,i);
            pre=cur;
        }
        System.out.println(result);
    }
}

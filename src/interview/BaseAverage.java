package interview;

import java.util.Scanner;

/**
 * @Author:zxp
 * @Description:尽管是一个CS专业的学生，小B的数学基础很好并对数值计算有着特别的兴趣，喜欢用计算机程序来解决数学问题，现在，她正在玩一个数值变换的游戏。她发现计算机中经常用不同的进制表示一个数，如十进制数 123 表达为 16 进制时只包含两位数 7、11（B），用八进制表示为三位数 1、7、3，按不同进制表达时，各个位数的和也不同，如上述例子中十六进制和八进制中各位数的和分别是 18 和 11 。 小B感兴趣的是，一个数 A 如果按 2 到 A-1 进制表达时，各个位数之和的均值是多少？她希望你能帮她解决这个问题？ 所有的计算均基于十进制进行，结果也用十进制表示为不可约简的分数形式。
 *
 * 数据范围：
 * 1
 * ≤
 * 𝐴
 * ≤
 * 5000
 *
 * 1≤A≤5000
 * 时间限制：C/C++ 1秒，其他语言2秒
 * 空间限制：C/C++ 32M，其他语言64M
 * 输入描述：
 * 输入中有多组测试数据，每组测试数据为一个整数A
 * 输出描述：
 * 对每组测试数据，在单独的行中以X/Y的形式输出结果。
 * 示例1
 * 输入例子：
 * 5
 * 3
 * 输出例子：
 * 7/3
 * 2/1
 * @Date:16:30 2024/8/10
 */
public class BaseAverage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int A = scanner.nextInt();
            int baseSum = getBaseSum(A);
            String yuefen = yuefen(baseSum, A - 2);
            System.out.println(yuefen);
        }
    }
    public static String yuefen(int m,int n){
        int min=Math.min(m,n);
        for(int i=min;i>=2;i--){
            if(m%i==0&&n%i==0){
                m/=i;
                n/=i;
                break;
            }
        }
        return m+"/"+n;
    }
    public static int getBaseSum(int n){
        int count=0;
        for(int base=2;base<n;base++){
            int cur=n;
            while (cur>0){
                count+=(cur%base);
                cur/=base;
            }
        }
        return count;
    }
}

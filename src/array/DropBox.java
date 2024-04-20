package array;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @Author:zxp
 * @Description:
 * @Date:21:13 2024/3/17
 */
public class DropBox {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = 0;
        int m = 0;
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            n = in.nextInt();
            m = in.nextInt();
            break;
        }
        int count = 1;
        int flag = 0;//用于判断是否能在输入给定的操作数内完成目标。
        HashSet<Integer> hashset1 = new HashSet<>();//记录操作1处理过的盒子，意思是哪些盒子里被放过球。
        HashSet<Integer> hashset2 = new HashSet<>();//记录操作2处理过的盒子，意思是哪些盒子被跳过放球。
        int k = 0;//变量k，表示这次操作之后，有多少盒子里至少有一个球。
        int inFlag = 0;//用于判断是否出现过操作2.
        while (count<=m) {
            int t = in.nextInt();
            int x = in.nextInt();
            if (t == 1 && !hashset1.contains(x - 1)) {//操作1处理逻辑
                if (inFlag == 1 && hashset2.contains(x - 1)) {//曾经出现过操作2并且被跳过的盒子这次正好补上了，结束循环。
                    k++;
                    flag = 1;
                    System.out.println(count);
                    break;
                } else if (inFlag == 0) {//曾经没有出现操作2
                    k++;
                }
                hashset1.add(x - 1);
            } else if (t == 2) {//操作2处理逻辑
                inFlag = 1;
                if (!hashset2.isEmpty() && !hashset2.contains(x - 1)) {//hashset2非空并且上次操作2处理的盒子和这次不同，结束循环。
                    flag = 1;
                    System.out.println(count);
                    break;
                } else if (hashset1.contains(x - 1)) {//曾经出现的操作1补上了这次被跳过的盒子，结束循环。
                    flag = 1;
                    System.out.println(count);
                    break;
                } else {//hashset2为空或者上一次操作2处理的是相同盒子，将k设置为n-1.
                    hashset2.clear();
                    hashset2.add(x - 1);
                    k = n - 1;
                }
            }
            if (k == n) {//在遍历完一个操作时判断一下k是否等于n。
                flag = 1;
                System.out.println(count);
                break;
            }
            count++;
        }
        if (flag == 0)//不能在给定的操作之下完成目标。
            System.out.println(-1);
    }
}

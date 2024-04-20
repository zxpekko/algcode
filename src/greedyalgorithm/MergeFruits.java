package greedyalgorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:zxp
 * @Description:在一个果园里，达达已经将所有的果子打了下来，而且按果子的不同种类分成了不同的堆。
 *
 * 达达决定把所有的果子合成一堆。
 *
 * 每一次合并，达达可以把两堆果子合并到一起，消耗的体力等于两堆果子的重量之和。
 *
 * 可以看出，所有的果子经过 n−1
 *  次合并之后，就只剩下一堆了。
 *
 * 达达在合并果子时总共消耗的体力等于每次合并所耗体力之和。
 *
 * 因为还要花大力气把这些果子搬回家，所以达达在合并果子时要尽可能地节省体力。
 *
 * 假定每个果子重量都为 1
 * ，并且已知果子的种类数和每种果子的数目，你的任务是设计出合并的次序方案，使达达耗费的体力最少，并输出这个最小的体力耗费值。
 *
 * 例如有 3
 *  种果子，数目依次为 1，2，9
 * 。
 *
 * 可以先将 1、2
 *  堆合并，新堆数目为 3
 * ，耗费体力为 3
 * 。
 *
 * 接着，将新堆与原先的第三堆合并，又得到新的堆，数目为 12
 * ，耗费体力为 12
 * 。
 *
 * 所以达达总共耗费体力=3+12=15
 * 。
 *
 * 可以证明 15
 *  为最小的体力耗费值。
 *
 * 输入格式
 * 输入包括两行，第一行是一个整数 n
 * ，表示果子的种类数。
 *
 * 第二行包含 n
 *  个整数，用空格分隔，第 i
 *  个整数 ai
 *  是第 i
 *  种果子的数目。
 *
 * 输出格式
 * 输出包括一行，这一行只包含一个整数，也就是最小的体力耗费值。
 *
 * 输入数据保证这个值小于 231
 * 。
 *
 * 数据范围
 * 1≤n≤10000
 * ,
 * 1≤ai≤20000
 * 输入样例：
 * 3
 * 1 2 9
 * 输出样例：
 * 15
 * @Date:11:04 2023/8/14
 */
public class MergeFruits {
    public static void main(String[] args) {
        int[] fruits={1,2,9};
        MergeFruits mergeFruits = new MergeFruits();
        int greedy = mergeFruits.Greedy(fruits);
        System.out.println(greedy);
    }
    public int Greedy(int[] fruits){
        if(fruits.length==0||fruits.length==1)
            return 0;
        int sum=0;
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<fruits.length;i++){
            list.add(fruits[i]);
        }
        while(list.size()>1){
            int minIndex = getMinIndex(list);
            int secondMinIndex = getSecondMinIndex(list);
            sum+=list.get(minIndex);
            sum+=list.get(secondMinIndex);
            int mergeSum=list.get(minIndex)+list.get(secondMinIndex);
            if(minIndex>secondMinIndex){
                list.remove(minIndex);
                list.remove(secondMinIndex);
            }
            else {
                list.remove(secondMinIndex);
                list.remove(minIndex);
            }


            list.add(mergeSum);
        }
        return sum;
    }
    public int getMinIndex(List<Integer> nums){
        int minIndex=0;
        for(int i=1;i< nums.size();i++){
            if(nums.get(i)<nums.get(minIndex))
                minIndex=i;
        }
        return minIndex;
    }
    public int getSecondMinIndex(List<Integer> nums){
        int minIndex=0;
        int SecondMinIndex=-1;
        int SecondMin=30000;
        for(int i=1;i< nums.size();i++){
            if(nums.get(i)<nums.get(minIndex))
                minIndex=i;
        }
//        for(int i=1;i< nums.length;i++){
//            if(nums[i]<=nums[SecondMinIndex]&&nums[i]>nums[minIndex])
//                SecondMinIndex=i;
//        }
//        if(nums[minIndex]==nums[SecondMinIndex]){
//            for(int i=0;i< nums.length;i++){
//                if(nums[i]==nums[SecondMinIndex]&&i!=SecondMinIndex){
//                    SecondMinIndex=i;
//                    break;
//                }
//            }
//        }
        for(int i=0;i< nums.size();i++){
            if(i==minIndex)
                continue;
            else if(nums.get(i)<SecondMin){
                SecondMinIndex=i;
                SecondMin=nums.get(i);
            }
        }

        return SecondMinIndex;
    }
//    @Test
//    public void test(){
//        int[] nums={1,2,9};
//        MergeFruits mergeFruits = new MergeFruits();
//        int secondMinIndex = mergeFruits.getSecondMinIndex(nums);
//        int minIndex = mergeFruits.getMinIndex(nums);
//        System.out.println(secondMinIndex);
//        System.out.println(minIndex);
//    }
}

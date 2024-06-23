package array;

import com.sun.java.swing.plaf.windows.WindowsTextAreaUI;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author:zxp
 * @Description:
 * @Date:22:10 2024/4/22
 */
public class Solution80 {
    public static void main(String[] args) {
        Solution80 solution80 = new Solution80();
        System.out.println(solution80.removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3}));
        Solution80Ⅰ solution80Ⅰ = new Solution80Ⅰ();
        System.out.println(solution80Ⅰ.removeDuplicates(new int[]{-3,-1,0,0,0,3,3}));
        System.out.println(solution80Ⅰ.removeDuplicatesⅠ(new int[]{-3, -1, 0, 0, 0, 3, 3}));
        Solution80Ⅱ solution80Ⅱ = new Solution80Ⅱ();
        System.out.println(solution80Ⅱ.removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3}));
        Solution80Ⅲ solution80Ⅲ = new Solution80Ⅲ();
        System.out.println(solution80Ⅲ.removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}));
    }
    public int removeDuplicates(int[] nums){
        int count=1;
        int p=0,q=1;
        while (q<nums.length){
            if(nums[p]!=nums[q]){
                nums[p+1]=nums[q];
                p++;
                q++;
                count=1;
            }
            else {
                if(count<2){
                    nums[p+1]=nums[q];
                    p++;
                    q++;
                    count++;
                }
                else {
                    q++;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
        return p+1;
    }
    @Test
    public void test() {
        HashMap<Integer, Integer> record = new HashMap<>();
        record.put(1,1);
        record.put(2,2);
        record.put(3,3);
        record.put(-3,-3);

        record.forEach((key,value)->{
            System.out.println(key+" "+value);
        });
        for(Map.Entry<Integer,Integer> entry:record.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }
}
class Solution80Ⅰ{
    public int removeDuplicates(int[] nums){
        HashMap<Integer, Integer> record = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            record.put(nums[i],record.getOrDefault(nums[i],0)+1);
        }
//        int result=0;
        int index=0;
        for(Map.Entry<Integer,Integer> entry:record.entrySet()){
            if(entry.getValue()>=2){
                nums[index++]=entry.getKey();
                nums[index++]=entry.getKey();
            }
            else nums[index++]=entry.getKey();
        }
        Arrays.sort(nums,0,index);
        System.out.println(Arrays.toString(nums));
        return index;
    }
    public int removeDuplicatesⅠ(int[] nums){
        int count=1;
        int p=0,q=1;
        while (q<nums.length){
            if(nums[p]!=nums[q]){
                nums[p+1]=nums[q];
                p++;
                q++;
                count=1;
            }
            else {
                if(count<2){
                    nums[p+1]=nums[q];
                    p++;
                    q++;
                    count++;
                }
                else q++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return p+1;
    }
}
class Solution80Ⅱ{
    public int removeDuplicates(int[] nums){
        int n=nums.length;
        int p=0,q=1;
        int sames=1;
        while (q<n){
            if(nums[p]==nums[q]){
                if(sames<2){
                    sames++;
                    nums[p+1]=nums[q];
                    p++;
                    q++;
                }
                else
                    q++;
            }
            else {
                sames=1;
                nums[p+1]=nums[q];
                p++;
                q++;
            }
        }
        return p+1;
    }
}
class  Solution80Ⅲ{
    public int removeDuplicates(int[] nums){
        int n=nums.length;
        int count=1;
        int p=0,q=1;
        while (q<n){
            if(nums[p]==nums[q]){
                if(count<2){
                    nums[p+1]=nums[q];
                    p++;
                    q++;
                    count++;
                }
                else
                    q++;
            }
            else {
                nums[p+1]=nums[q];
                count=1;
                p++;
                q++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return p+1;
    }
}
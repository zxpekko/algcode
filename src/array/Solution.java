package array;

import javax.swing.tree.TreeNode;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author:zxp
 * @Description:
 * @Date:19:54 2024/5/7
 */
public class Solution {
    private int cap;
    LinkedHashMap<Integer,Integer> cache=new LinkedHashMap<>();
    public Solution(int capacity) {
        // write code here
//        super(capacity,0.75F,true);
        this.cap=capacity;
    }
    public int get(int key) {
        // write code here
        if(!cache.containsKey(key))
            return -1;
        makeRecently(key);
        return cache.get(key);

    }
    public void set(int key, int value){
        if(cache.containsKey(key)){
            cache.put(key,value);
            makeRecently(key);
            return;
        }
        if(cache.size()>=this.cap){
            int oldestKey=cache.keySet().iterator().next();
            cache.remove(oldestKey);
        }
        cache.put(key,value);
    }
    public void makeRecently(int key){
        int val=cache.get(key);
        cache.remove(key);
        cache.put(key,val);
    }
//    @Override
//    protected  boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest){
//        return size()>capacity;
//    }
public int maxProduct (int[] nums) {
    // write code here
    int max=Integer.MIN_VALUE,imax=1,imin=1;
    for(int i=0;i<nums.length;i++){
        if(nums[i]<0){
            int tmp=imax;
            imax=imin;
            imin=tmp;
        }
        imax=Math.max(imax*nums[i],nums[i]);
        imin=Math.min(imin*nums[i],nums[i]);
        max=Math.max(max,imax);
    }
    return max;
}
//Map<Integer,Integer> map;
//public TreeNode findNode(int[] inorder,int inBegin,int inEnd,int[] postorder,int postBegin,int postEnd){
//        if(inBegin>=inEnd||postBegin>=postEnd){
//            return null;
//        }
//        int rootIndex=map.get(postorder[postEnd-1]);
//        TreeNode root=new TreeNode(inorder[rootIndex]);
//        int leftLength=rootIndex-inBegin;
//
//}
}

package chaintable;

import leetcode.PathSum;

import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:20:32 2024/5/9
 */
public class Solution23 {
    public ListNode mergeKLists(ListNode[] lists){
        int n=lists.length;
        ListNode virtual=new ListNode(0);
        ListNode pre=virtual;
        boolean flag=true;
        while (!judgeNull(lists)){
            ListNode min=new ListNode(Integer.MAX_VALUE);
            int minIndex=Integer.MAX_VALUE;
            for(int i=0;i<n;i++){
                if(lists[i]==null)
                    continue;
                if(lists[i].val<min.val){
                    min=lists[i];
                    minIndex=i;
                }
            }
            if(flag){
                virtual.next=min;
                flag=false;
            }
            pre.next=min;
            pre=min;
            lists[minIndex]=lists[minIndex].next;
        }
        return virtual.next;
    }
    public boolean judgeNull(ListNode[] lists){//是否全是null。是就返回true
        for(int i=0;i<lists.length;i++){
            if(lists[i]!=null)
                return false;
        }
        return true;
    }
}

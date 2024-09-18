package leetcode150;

import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:0:12 2024/8/1
 */
public class Solution141 {
    public static void main(String[] args) {

    }
    public boolean hasCycle(ListNode head){
        if(head==null)
            return false;
        ListNode fast=head;
        ListNode slow=head;
        while (fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow)
                return true;
        }
        return false;
    }
}
class Solution141Ⅰ{
    public boolean hasCycle(ListNode head){
        if(head==null)
            return false;
        ListNode fast=head,slow=head;
        while (fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow)
                return true;
        }
        return false;
    }
}
class ListNode{
    ListNode next;
    int val;
    public ListNode(int val){
        this.val=val;
    }
    public ListNode(){}
}
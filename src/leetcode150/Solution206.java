package leetcode150;

import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:21:57 2024/9/9
 */
public class Solution206 {
    public ListNode reverseList(ListNode head){
        ListNode dummy=null,p=head;
        while (p!=null){
            ListNode next=p.next;
            p.next=dummy;
            dummy=p;
            p=next;
        }
        return dummy;
    }
}
class ListNode1{
    ListNode1 next;
    int val;
    public ListNode1(){}
    public ListNode1(int val){
        this.val=val;
    }
}
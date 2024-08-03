package leetcode150;

/**
 * @Author:zxp
 * @Description:
 * @Date:16:20 2024/8/2
 */
public class Solution92 {
    public ListNode reverseBetween(ListNode head, int left, int right){
        int cur=1;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode pre=dummy;
        ListNode p=head;
        while (cur<left){
            p=p.next;
            pre=pre.next;
            cur++;
        }
        ListNode rightQ=p;
        while (cur<right){
            rightQ=rightQ.next;
            cur++;
        }
        ListNode rightQNext=rightQ.next;
        ListNode flag=rightQNext;
        while (p!=flag){
            ListNode next=p.next;
            p.next=rightQNext;
            rightQNext=p;
            p=next;
        }
        pre.next=rightQ;
        return dummy.next;
    }
}
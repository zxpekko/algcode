package leetcode150;

import java.util.List;
import java.util.LongSummaryStatistics;

/**
 * @Author:zxp
 * @Description:
 * @Date:0:26 2024/8/1
 */
public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode head=new ListNode(0);
        ListNode p=head;
        int add=0;
        while (l1!=null&&l2!=null){
            int val1 = l1.val;
            int val2 = l2.val;
            int sum=val1+val2+add;
            add=sum/10;
            ListNode listNode = new ListNode(sum % 10);
            p.next=listNode;
            p=p.next;
            l1=l1.next;
            l2=l2.next;
        }
        while (l1!=null){
            int val = l1.val+add;
            add=val/10;
            ListNode listNode = new ListNode(val % 10);
            p.next=listNode;
            p=p.next;
            l1=l1.next;
        }
        while (l2!=null){
            int val = l2.val+add;
            add=val/10;
            ListNode listNode = new ListNode(val % 10);
            p.next=listNode;
            p=p.next;
            l2=l2.next;
        }
        if(add>0){
            ListNode listNode = new ListNode(add);
            p.next=listNode;
            p=p.next;
        }
        return head.next;
    }
}

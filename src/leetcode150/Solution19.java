package leetcode150;

import java.util.List;
import java.util.ListIterator;

/**
 * @Author:zxp
 * @Description:
 * @Date:13:33 2024/8/3
 */
public class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n){
        int length=0;
        ListNode p=head;
        while (p!=null){
            p=p.next;
            length++;
        }
        int index=length-n+1;
        ListNode pre=new ListNode(0);
        pre.next=head;
        p=head;
        ListNode q=pre;
        int cur=1;
        while (cur<index){
            q=p;
            p=p.next;
            cur++;
        }
        q.next=p.next;
        return pre.next;
    }
}

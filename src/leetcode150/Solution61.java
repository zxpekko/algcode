package leetcode150;

import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:14:58 2024/8/3
 */
public class Solution61 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null)
            return null;
        int length=0;
        ListNode p=head;
        while (p!=null){
            length++;
            p=p.next;
        }
        k=k%length;
        if(k==0)
            return head;
        int cur=1;
        p=head;
        ListNode pre=new ListNode(0);
        pre.next=head;
        ListNode q=pre;
        while (cur<length-k+1){
            q=p;
            p=p.next;
            cur++;
        }
        q.next=null;
        ListNode newCur=p;
        while (newCur.next!=null)
            newCur=newCur.next;
        newCur.next=head;
        return p;
    }
}

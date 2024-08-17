package interview;

import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:10:25 2024/8/17
 */
public class Solution {
    public static void main(String[] args) {

    }
    public ListNode exchange (ListNode head, int k){
        if(head==null)
            return head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        int n=0;
        ListNode p=head;
        while (p!=null){
            n++;
            p=p.next;
        }
        if(k>n)
            return head;
        ListNode left=head,right=head;
        ListNode leftPre=dummy,rightPre=dummy;
        int cur=1;
        while (cur<k){
            leftPre=left;
            left=left.next;
            cur++;
        }
        cur=1;
        while (cur<n-k+1){
            rightPre=right;
            right=right.next;
            cur++;
        }
        ListNode leftNext=left.next;
        ListNode rightNext=right.next;
        left.next=rightNext;
        rightPre.next=left;
        right.next=leftNext;
        leftPre.next=right;
        return dummy.next;
    }
}

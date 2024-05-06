package interview;

import java.util.List;

/**
 * @Author:zxp
 * @Description:k个一组翻转链表
 * @Date:0:17 2024/5/2
 */
public class KGroupReverse {
    public ListNode reverseKGroup(ListNode head, int k){
        if(head==null||k==1)
            return head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode cur=head;
        int size=0;
        while (cur!=null){
            size++;
            cur=cur.next;
        }
        ListNode pre=dummy;
        while (size>=k){
            cur=pre.next;
            ListNode next=cur.next;
            for(int i=1;i<k;i++){
                cur.next=next.next;
                next.next=pre.next;
                pre.next=next;
                next=cur.next;
            }
            pre=cur;
            size-=k;
        }
        return dummy.next;
    }
}
class ListNode{
    int val;
    ListNode next;
    public ListNode(int val){
        this.val=val;
    }
    public ListNode(ListNode next,int val){
        this.val=val;
        this.next=next;
    }
    public ListNode(){

    }

}

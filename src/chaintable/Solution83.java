package chaintable;

/**
 * @Author:zxp
 * @Description:
 * @Date:17:17 2024/7/15
 */
public class Solution83 {
    public ListNode deleteDuplicates(ListNode head){
        ListNode cur=head;
        while (cur!=null&&cur.next!=null){
            if(cur.val==cur.next.val){
                ListNode next=cur.next.next;
                cur.next=next;
            }
            else cur=cur.next;
        }
        return head;
    }
}

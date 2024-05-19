package chaintable;

import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:11:35 2024/5/18
 */
public class Solution206 {
    public ListNode reverseList(ListNode head){
        ListNode pre=null;
        ListNode cur=head;
        while (cur!=null){
            ListNode next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }
}

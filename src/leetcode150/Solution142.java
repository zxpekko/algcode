package leetcode150;

import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:12:01 2024/9/11
 */
public class Solution142 {
    public ListNode detectCycle(ListNode head){
        if(head==null)
            return null;
        ListNode fast=head,slow=head;
        while (fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                ListNode index1=head;
                ListNode index2=fast;
                while (index1!=index2){
                    index1=index1.next;
                    index2=index2.next;
                }
                return index1;
            }
        }
        return null;
    }
}

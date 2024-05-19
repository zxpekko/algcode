package chaintable;

import java.sql.Time;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author:zxp
 * @Description:
 * @Date:11:20 2024/5/14
 */
public class Solution142 {
    public ListNode detectCycle(ListNode head){
        ListNode fast=head,slow=head;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                ListNode index1=fast;
                ListNode index2=head;
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

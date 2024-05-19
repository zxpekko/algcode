package chaintable;

import java.util.HashSet;

/**
 * @Author:zxp
 * @Description:
 * @Date:10:34 2024/5/11
 */
public class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        HashSet<ListNode> record=new HashSet<>();
        while (headA!=null||headB!=null){
            if(!record.contains(headA)){
                record.add(headA);
                headA=headA.next;
            }
            if(!record.contains(headB)){
                record.add(headB);
                headB=headB.next;
            }
            else if(record.contains(headA))
                return headA;
            else return headB;
        }
        return null;
    }
}

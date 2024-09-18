package leetcode150;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:14:37 2024/9/9
 */
public class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        HashSet<ListNode> listNodes = new HashSet<>();
        ListNode p=headA;
        while (p!=null){
            listNodes.add(p);
            p=p.next;
        }
        p=headB;
        while (p!=null){
            if(listNodes.contains(p))
                return p;
            else
                p=p.next;
        }
        return null;
    }
}

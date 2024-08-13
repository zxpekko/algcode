package leetcode150;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author:zxp
 * @Description:
 * @Date:23:03 2024/8/8
 */
public class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root){
        List<List<Integer>> result=new ArrayList<>();
        if(root==null)
            return result;
        int flag=0;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size=queue.size();
            int[] ints = new int[size];
            for(int i=0;i<size;i++){
                TreeNode poll = queue.poll();
                ints[i]=poll.val;
                if(poll.left!=null)
                    queue.offer(poll.left);
                if(poll.right!=null)
                    queue.offer(poll.right);
            }
            List<Integer> subResult=new ArrayList<>();
            if(flag==1){
                for(int i=ints.length-1;i>=0;i--)
                    subResult.add(ints[i]);
                flag=0;
            }
            else {
                for(int i=0;i<ints.length;i++)
                    subResult.add(ints[i]);
                flag=1;
            }
            result.add(subResult);
        }
        return result;
    }
}
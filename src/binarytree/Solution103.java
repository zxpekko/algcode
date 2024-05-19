package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author:zxp
 * @Description:
 * @Date:10:09 2024/5/10
 */
public class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root){

        List<List<Integer>> result=new ArrayList<>();
        if(root==null)
            return result;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        boolean left=true;//表示是否从左向右遍历。
        while (!queue.isEmpty()){
            int size=queue.size();
            if(left){
                List<Integer> subResult=new ArrayList<>();
                for(int i=0;i<size;i++){
                    TreeNode poll = queue.poll();
                    subResult.add(poll.val);
                    if(poll.left!=null)
                        queue.offer(poll.left);
                    if(poll.right!=null)
                        queue.offer(poll.right);
                }
                result.add(subResult);
                left=false;
            }
            else {
                List<Integer> subResult=new ArrayList<>();
                List<Integer> temp=new ArrayList<>();
                for(int i=0;i<size;i++){
                    TreeNode poll = queue.poll();
                    temp.add(poll.val);
                    if(poll.left!=null)
                        queue.offer(poll.left);
                    if(poll.right!=null)
                        queue.offer(poll.right);
                }
                while (!temp.isEmpty()){
                    subResult.add(temp.get(temp.size()-1));
                    temp.remove(temp.size()-1);
                }
                result.add(subResult);
                left=true;
            }
        }
        return result;
    }
}

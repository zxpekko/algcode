package binarytree;

//import javax.swing.tree.TreeNode;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author:zxp
 * @Description:
 * @Date:20:09 2024/5/7
 */
public class Solution {
    Map<Integer,Integer> map;
    public TreeNode findNode(int[] inorder, int inBegin, int inEnd, int[] postorder, int postBegin, int postEnd){
        if(inBegin>=inEnd||postBegin>=postEnd){
            return null;
        }
        int rootIndex=map.get(postorder[postEnd-1]);
        TreeNode root=new TreeNode(inorder[rootIndex]);
        int leftLength=rootIndex-inBegin;
        root.left=findNode(inorder,inBegin,rootIndex,postorder,postBegin,postBegin+leftLength);
        root.right=findNode(inorder,rootIndex+1,inEnd,postorder,postBegin+leftLength,postEnd-1);
        return root;
    }
    public TreeNode buildTree (int[] inorder, int[] postorder) {
        // write code here
        map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return findNode(inorder,0,inorder.length,postorder,0,postorder.length);
    }
}

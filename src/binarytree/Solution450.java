package binarytree;

import javax.smartcardio.TerminalFactory;

/**
 * @Author:zxp
 * @Description:
 * @Date:20:36 2024/4/9
 */
public class Solution450 {
    public TreeNode deleteNode(TreeNode root, int key){
        if(root==null)
            return null;
        if(root.val>key)
            root.left=deleteNode(root.left,key);
        else if(root.val<key)
            root.right=deleteNode(root.right,key);
        else {
            if(root.right!=null){
                TreeNode cur=root.right;
                while (cur.left!=null)
                    cur=cur.left;
                cur.left=root.left;
                return root.right;
            }
            else {
                return root.left;
            }
        }
        return root;
    }
}

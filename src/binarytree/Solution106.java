package binarytree;

/**
 * @Author:zxp
 * @Description:
 * @Date:20:32 2024/5/7
 */
public class Solution106 {
    public TreeNode buildTree(int[] inorder, int[] postorder){
        return inAndPostTree(inorder,postorder,0,inorder.length-1,0,postorder.length-1);
    }
    public TreeNode inAndPostTree(int[] inorder,int[] postorder,int inL,int inR,int postL,int postR){
        if(inL>inR||postL>postR)
            return null;
        int val=postorder[postR];
        TreeNode root= new TreeNode(val);
        int index=0;
        for(int i=inL;i<=inR;i++){
            if(inorder[i]==val){
                index=i;
                break;
            }
        }
        root.left=inAndPostTree(inorder,postorder,inL,index-1,postL,postL+index-inL-1);
        root.right=inAndPostTree(inorder,postorder,index+1,inR,postL+index-inL,postR-1);
        return root;
    }
}

package leetcode150;

/**
 * @Author:zxp
 * @Description:
 * @Date:21:19 2024/8/7
 */
public class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder){
        return preAndInorder(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }
    public TreeNode preAndInorder(int[] preorder,int[] inorder,int preL,int preR,int inL,int inR){
        if(preL>preR||inL>inR)
            return null;
        int rootVal=preorder[preL];
        int midRoot=-1;
        for(int i=inL;i<=inR;i++){
            if(inorder[i]==rootVal){
                midRoot=i;
                break;
            }
        }
        int leftLength=midRoot-inL;
        int rightLength=inR-midRoot;
        TreeNode root=new TreeNode(rootVal);
        TreeNode left=preAndInorder(preorder,inorder,preL+1,preL+leftLength,inL,midRoot-1);
        TreeNode right=preAndInorder(preorder,inorder,preL+leftLength+1,preR,midRoot+1,inR);
        root.left=left;
        root.right=right;
        return root;
    }
}

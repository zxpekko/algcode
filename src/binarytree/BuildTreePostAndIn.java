package binarytree;

/**
 * @Author:zxp
 * @Description:
 * @Date:20:36 2024/4/5
 */
public class BuildTreePostAndIn {
    public TreeNode buildTree(int[] inorder, int[] postorder){
        return create(inorder,postorder,0,inorder.length-1,0, postorder.length-1);
    }
    public TreeNode create(int[] inorder,int[] postorder,int inLeft,int inRight,int postLeft,int postRight){
        if(inLeft>inRight||postLeft>postRight)
            return null;
        int rootVal=postorder[postRight];
        int rootIndex=inLeft;
        for(int i=inLeft;i<=inRight;i++){
            if(inorder[i]==rootVal){
                rootIndex=i;
                break;
            }
        }
        TreeNode root = new TreeNode();
        root.val=rootVal;
        root.left=create(inorder,postorder,inLeft,rootIndex-1,postLeft,postLeft+rootIndex-inLeft-1);
        root.right=create(inorder,postorder,rootIndex+1,inRight,postLeft+rootIndex-inLeft,postRight-1);
        return root;
    }
}

package offerJianZhi.tree;

import util.TreeNode;

public class 重建二叉树 {
    //前序遍历{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        TreeNode root = f(pre,0,pre.length-1,in,0,in.length-1);
        return root;


    }
    private TreeNode f(int[]pre,int preHead,int preTail,int[] in,int inHead,int inTail){
        if(preHead>preTail||inHead>inTail)
            return null;
        TreeNode root = new TreeNode(pre[preHead]);
        for(int i =  inHead;i<=inTail;i++){
            if(in[i]==pre[preHead]){
                root.left = f(pre,preHead+1,preHead+i-inHead,in,inHead,i-1);//关键：preHead+i-inHead
                root.right = f(pre,preHead+i-inHead+1,preTail,in,i+1,inTail);
            }
        }
        return root;
    }
}

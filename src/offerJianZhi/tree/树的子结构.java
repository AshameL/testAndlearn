package offerJianZhi.tree;

import util.TreeNode;

public class 树的子结构 {

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean res = false;
        //当Tree1和Tree2都不为零的时候，才进行比较。否则直接返回false
        if (root2 != null && root1 != null) {
            //如果找到了对应Tree2的根节点的点
            if (root1.val == root2.val) {
                //以这个根节点为为起点判断是否包含Tree2
                res = isSubtree(root1, root2);
            }
            if (!res)
                res = isSubtree(root1.left, root2);
            if (!res)
                res = isSubtree(root1.right, root2);
        }
        return res;
    }

    private boolean isSubtree(TreeNode t1, TreeNode t2) {
        //如果Tree2已经遍历完了都能对应的上，返回true
        if (t2 == null)
            return true;
        //如果Tree2还没有遍历完，Tree1却遍历完了。返回false
        if (t1 == null)
            return false;

        //如果其中有一个点没有对应上，返回false
        if (t1.val != t2.val)
            return false;
        //如果根节点对应的上，那么就分别去子节点里面匹配
        return isSubtree(t1.left, t2.left) && isSubtree(t1.right, t2.right);
    }
}

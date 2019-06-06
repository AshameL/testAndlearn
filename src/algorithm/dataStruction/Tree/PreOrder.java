package algorithm.dataStruction.Tree;

import java.util.Stack;

/**
 * 先序遍历的两种方法
 */
public class PreOrder {
    public void digui(TreeNode root) {
        if (root != null) {
            System.out.println(root.val + "__");
            digui(root.left);
            digui(root.right);
        }
    }

    // 非递归利用栈来遍历
    public void feiDigui(TreeNode root) {
        if (root == null)
            return;
        Stack<MyStack> stacks = new Stack<>();
        stacks.push(new MyStack(root, false));
        while (!stacks.isEmpty()) {
            MyStack ms = stacks.pop();
            if (ms.hasPrint == false) {
                ms.hasPrint = true;
                stacks.push(ms);
            } else {
                //进行输出
                System.out.println(ms.node.val + "__");
                // 先右再左，因为是栈
                if (ms.node.left != null)
                    stacks.push(new MyStack(ms.node.left, false));
                if (ms.node.right != null)
                    stacks.push(new MyStack(ms.node.right, false));
            }
        }
    }

    class MyStack {
        TreeNode node;
        boolean hasPrint;

        MyStack(TreeNode node, boolean hasPrint) {
            this.node = node;
            this.hasPrint = hasPrint;
        }
    }
}

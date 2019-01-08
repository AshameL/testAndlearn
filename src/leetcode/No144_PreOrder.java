package leetcode;

import util.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class No144_PreOrder {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null)
            return res;

        Stack<Command> stack = new Stack<>();
        stack.push(new Command(0, root));
        while (!stack.isEmpty()) {
            Command command = stack.pop();
            if (command.order == 1)
                res.add(command.node.val);
            else {
                TreeNode node = command.node;
                if (node.right != null)
                    stack.push(new Command(0, node.right));
                if (node.left != null)
                    stack.push(new Command(0, node.left));
                stack.push(new Command(1, node));
            }

        }
        return res;

    }

    class Command {
        int order; //0:go   1:print
        TreeNode node;

        Command(int order, TreeNode node) {
            this.order = order;
            this.node = node;
        }
    }

}

package org.example.Tree.TraversalIteration;

import org.example.Tree.Basic.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 前序遍历顺序：中-左-右，入栈顺序：中-右-左
class pre{
    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }
}

package org.example;

import org.example.Tree.Basic.TreeNode;
import org.example.Tree.TraversalIteration.post;

public class main{
    public static void main(String[] args){
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        // 步骤2：创建中间节点，关联叶子节点
        TreeNode node2 = new TreeNode(2, node4, node5); // 2的左=4，右=5
        TreeNode node3 = new TreeNode(3, null, node6);  // 3的左=null，右=6

        // 步骤3：创建根节点，关联中间节点
        TreeNode root = new TreeNode(1, node2, node3);

        post test = new post();
        test.postTraversal(root);
    }
}

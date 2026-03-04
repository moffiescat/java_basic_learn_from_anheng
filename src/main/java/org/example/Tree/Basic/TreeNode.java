package org.example.Tree.Basic;

public class TreeNode {
    public int val;//if it is int
    public TreeNode left;
    public TreeNode right;

    TreeNode(){}
    TreeNode(int val){
        this.val = val;
    }
    TreeNode(int val,TreeNode left,TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

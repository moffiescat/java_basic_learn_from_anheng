package org.example.Tree.TraversalRecursion;

import org.example.Tree.Basic.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class PreorderVisit {
    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<Integer>();
        preorder(root,result);
        return result;
    }

    public void preorder(TreeNode root,List<Integer> result){
        if(root == null){
            return;
        }

        result.add(root.val);
        preorder(root.left,result);
        preorder(root.right,result);
    }
}

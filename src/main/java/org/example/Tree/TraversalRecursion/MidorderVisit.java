package org.example.Tree.TraversalRecursion;

import org.example.Tree.Basic.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class MidorderVisit {
    public List<Integer> MIdorderVisit(TreeNode root){
        List<Integer> result = new ArrayList<>();
        Midorder(root,result);
        return result;
    }

    public void Midorder(TreeNode root,List<Integer> result){
        if(root == null){
            return;
        }

        Midorder(root.left,result);
        result.add(root.val);
        Midorder(root.right,result);
    }
}

package com.yang.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author shenqiuyang3
 * @date 2020/11/11 11:16
 */
public class InorderTranversal {

    public List<Integer> inorderTraversal(TreeNode root){

//        List<Integer> res = new ArrayList<>();
//        Stack<TreeNode> stack = new Stack<>();
//
//        while (root.left != null){
//            stack.push(root);
//            root = root.left;
//        }
//        while (!stack.isEmpty()){
//            TreeNode pop = stack.pop();
//            res.add(pop.val);
//            if (pop.right != null){
//                stack.push(pop.right);
//            }
//        }
//
//        return res;


        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while(root != null || !stack.isEmpty()){
            if(cur != null){
                stack.push(cur);
                cur = cur.left;
            }else{
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res;

    }
}

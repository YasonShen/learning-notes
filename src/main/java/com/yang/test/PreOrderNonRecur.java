package com.yang.test;

import java.util.*;

/**
 * @author shenqiuyang3
 * @date 2021/1/14 14:50
 * @Description
 */
public class PreOrderNonRecur {

    private ArrayList<TreeNode> preOrder(TreeNode root){

        ArrayList<TreeNode> list = new ArrayList<>();
//        Stack<TreeNode> stack = new Stack<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()){
            if (root != null){
//                list.add(root);  先序遍历
                stack.push(root);
                root = root.left;
            }else {
                root = stack.pop();
                list.add(root); //中序遍历
                root = root.right;
            }
        }
        return list;
    }

    //后序遍历
    private ArrayList<TreeNode> postOrder(TreeNode root){

        ArrayList<TreeNode> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> res = new Stack<>();

        while (root != null || !stack.isEmpty()){
            if (root != null){
                stack.push(root);
                res.push(root);
                root = root.right;
            }else {
                root = stack.pop();
                root = root.left;
            }

        }

        while (!res.isEmpty()){
            list.add(res.pop());
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(4);
        TreeNode c = new TreeNode(1);
        TreeNode d = new TreeNode(2);
        TreeNode e = new TreeNode(6);
        TreeNode f = new TreeNode(8);
        TreeNode g = new TreeNode(9);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        e.right = g;


        ArrayList<TreeNode> treeNodes = new PreOrderNonRecur().preOrder(a);
        Iterator<TreeNode> iterator = treeNodes.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().val);

        }
    }
}

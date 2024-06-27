package com.pyhita.test;

/**
 * @Author: kante_yang
 * @Date: 2024/6/18
 */

/**
 * 求二叉树的最近公共父节点
 * 假设有以下二叉树：
 *
 *     1
 *    / \
 *   2   3
 *  / \
 * 4   5
 * 假设我们要找到节点 4 和节点 5 的最近公共父节
 */
public class Main {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        TreeNode node = low(root, root.left.left, root.left.right);
        System.out.println(node == root.left);

    }

    public static TreeNode low(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = low(root.left, p, q);
        TreeNode right = low(root.right, p, q);

        if (left != null && right != null) {
            return root;
        } else {
            return left == null ? right : left;
        }
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(TreeNode left, TreeNode right) {
            this.left = left;
            this.right = right;
        }
    }

}

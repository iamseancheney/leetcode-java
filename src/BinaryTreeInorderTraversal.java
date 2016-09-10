import java.util.*;

/*
 94	Binary Tree Inorder Traversal	36.2%	Medium
 Problem:    Binary Tree Inorder Traversal
 Difficulty: Easy
 Source:     https://oj.leetcode.com/problems/binary-tree-inorder-traversal/
 Notes:
 Given a binary tree, return the inorder traversal of its nodes' values.
 For example:
 Given binary tree {1,#,2,3},
 1
  \
   2
  /
 3
 return [1,3,2].
 Note: Recursive solution is trivial, could you do it iteratively?
 Solution: 1. Recursive solution.      Time: O(n), Space: O(n).
           2. Iterative way (stack).   Time: O(n), Space: O(n).
           3. Threaded tree (Morris).  Time: O(n), Space: O(1).
 */

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BinaryTreeInorderTraversal {
	public List<Integer> inorderTraversal_1(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        inorder(root, res);
        return res;
    }
    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

    public class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) return res;
            List<Integer> left = inorderTraversal(root.left);
            List<Integer> right = inorderTraversal(root.right);
            res.addAll(left);
            res.add(root.val);
            res.addAll(right);

            return res;
        }
    }

    public List<Integer> inorderTraversal_2(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stk = new Stack<TreeNode>();
        TreeNode cur = root;
        while (!stk.isEmpty() || cur != null) {
            if (cur != null) {
                stk.push(cur);
                cur = cur.left;
            } else {
                cur = stk.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res;
    }


    
    //mirror traversal
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                res.add(cur.val);
                cur = cur.right;
            } else {
                TreeNode node = cur.left;
                while (node.right != null && node.right != cur)
                    node  = node.right;
                if (node.right == null) {
                    node.right = cur;
                    cur = cur.left;
                } else {
                    res.add(cur.val);
                    node.right = null;
                    cur = cur.right;
                }
            }
        }
        return res;
    }

    //facebook if is BST the inoder should be the increasing array;
    public int[] inorderBST(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) return new int[0];
        inorder(root, res);
        int[] arr = res.stream().mapToInt(Integer::intValue).toArray();
        return arr;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		 t1.right = t2;
		 t2.left = t3;
		 
		 BinaryTreeInorderTraversal slt = new BinaryTreeInorderTraversal();
		 List<Integer> res = slt.inorderTraversal(t1);
		 System.out.print(res);
	}

}

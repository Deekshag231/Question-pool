/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    boolean diff=true;
    public boolean isBalanced(TreeNode root) {
        helper(root);
        return diff;
    }
    public int helper(TreeNode root){
        if(root==null) return 0;
        int lh=helper(root.left);
        int rh=helper(root.right);
        if(Math.abs(lh-rh)>1){
            diff=false;
        }
        return Math.max(lh,rh)+1;
    }
}
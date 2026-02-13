
class Solution {
    int d=0;
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return d;
    }
    public int helper(TreeNode root){
        if(root==null) return 0;
        int ls=helper(root.left);
        int rs=helper(root.right);
        int mid=ls+rs;
        d=Math.max(d,mid);
        return Math.max(ls,rs)+1;
    }
}
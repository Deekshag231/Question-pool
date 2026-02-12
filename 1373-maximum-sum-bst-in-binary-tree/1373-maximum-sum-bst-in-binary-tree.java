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
    class box{
        boolean bst;
        int sum,min,max;
        public box(){
            sum=0;
            bst=true;
            max=Integer.MIN_VALUE;
            min=Integer.MAX_VALUE;
        }
    }
    public box helper(TreeNode root,int[] ts){
        if(root==null){
            return new box();
        }
        box left=helper(root.left,ts);
        box right=helper(root.right,ts);
        if(left.bst&&right.bst&& left.max<root.val&&right.min> root.val){
            box head=new box();
            head.sum=left.sum+right.sum+root.val;
            head.min=Math.min(left.min,root.val);
            head.max=Math.max(right.max,root.val);
            ts[0]=Math.max(ts[0],head.sum);
            return head;
        }
        else{
            right.bst=false;
            return right;
        }
        
    }
    public int largestBst(TreeNode root) {
        int[] totalSum = {0};  
        helper(root, totalSum);
        return totalSum[0];
    }
    public int maxSumBST(TreeNode root) {
        return largestBst(root);
    }
    
}
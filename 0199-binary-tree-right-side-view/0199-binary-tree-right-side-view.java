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
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> ls=new ArrayList<>();
        if(root==null) return ls;
        Deque<TreeNode> q=new ArrayDeque<>();
        q.addLast(root);
        int level=0;
        while(!q.isEmpty()){
            int n=q.size();
            ls.add(q.peekLast().val);
            while(n-->0){
                TreeNode temp=q.pollFirst();
                if(temp.left!=null) q.addLast(temp.left);
                if(temp.right!=null) q.addLast(temp.right);
            }
            level++;
        }
        return ls;
    }
}
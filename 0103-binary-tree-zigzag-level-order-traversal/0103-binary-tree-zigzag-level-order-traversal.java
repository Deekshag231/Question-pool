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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ls=new ArrayList<>();
        if(root==null) return ls;
        Deque<TreeNode> q=new LinkedList<>();
        q.add(root);
        boolean flag=false;
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> ans=new ArrayList<>(size);
            for(int i=0;i<size;i++){
                if(!flag){
                    TreeNode curr=q.pollFirst();
                    ans.add(curr.val);
                    if(curr.left!=null) q.addLast(curr.left);
                    if(curr.right!=null) q.addLast(curr.right);
                }
                else{
                    TreeNode curr=q.pollLast();
                    ans.add(curr.val);
                    if(curr.right!=null) q.addFirst(curr.right);
                    if(curr.left!=null) q.addFirst(curr.left);
                }
            }
            flag=!flag;
            ls.add(ans);
        }
        return ls;
    }
}
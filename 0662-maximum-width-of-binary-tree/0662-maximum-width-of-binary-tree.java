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
    class Pair{
        TreeNode node;
        int row;
        public Pair(TreeNode node,int row){
            this.node=node;
            this.row=row;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q=new LinkedList<>();
        int width=0;
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
            int size=q.size();
            Pair start=q.peek();
            Pair end=null;
            for(int i=0;i<size;i++){
                end=q.poll();
                if(end.node.left!=null) q.offer(new Pair(end.node.left,end.row*2+1));
                if(end.node.right!=null) q.offer(new Pair(end.node.right,end.row*2+2));
            }
            width=Math.max(end.row-start.row+1,width);
        }
        return width;
    }
}
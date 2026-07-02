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
    class Triple{
        TreeNode node;
        int row;
        int col;
        public Triple(TreeNode node,int row,int col){
            this.node=node;
            this.row=row;
            this.col=col;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map=new TreeMap<>();
        Queue<Triple> q=new LinkedList<Triple>();
        q.offer(new Triple(root,0,0));
        while(!q.isEmpty()){
            Triple triple=q.poll();
            TreeNode node=triple.node;
            int x=triple.row;
            int y=triple.col;
            if(!map.containsKey(x)){
                map.put(x,new TreeMap<>());
            }
            if(!map.get(x).containsKey(y)){
                map.get(x).put(y,new PriorityQueue<>());
            }
            map.get(x).get(y).offer(node.val);
            if(node.left!=null){
                q.offer(new Triple(node.left,x-1,y+1));
            }
            if(node.right!=null){
                q.offer(new Triple(node.right,x+1,y+1));
            }
        }
        List<List<Integer>> ls=new ArrayList<>();
        for(TreeMap<Integer,PriorityQueue<Integer>> ys:map.values()){
            ls.add(new ArrayList<>());
            for(PriorityQueue<Integer> pq:ys.values()){
                while(!pq.isEmpty()){
                    ls.get(ls.size()-1).add(pq.poll());
                }
            }
        }
        return ls;
    }
}
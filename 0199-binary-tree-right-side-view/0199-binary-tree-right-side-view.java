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
        int col;
        public Pair(TreeNode node, int col){
            this.node=node;
            this.col=col;
        }
    }
    public List<Integer> rightSideView(TreeNode root) {
        
        ArrayList<Integer> ls=new ArrayList<>();
        if(root==null) return ls;
        HashMap<Integer, Integer> map=new HashMap<>();
        Queue<Pair> q= new LinkedList<Pair>();
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
            Pair pair=q.poll();
            TreeNode temp=pair.node;
            int y=pair.col;
            if(map.get(y)==null) map.put(y,temp.val);
            if(map.containsKey(y)){
                map.put(y,temp.val);
            }
            if(temp.left!=null){
                q.add(new Pair(temp.left,y+1));
            }
            if(temp.right!=null){
                q.add(new Pair(temp.right,y+1));
            }
            
        }
        for(Map.Entry<Integer,Integer> e:map.entrySet()){
            ls.add(e.getValue());
        }
        return ls;
        
    }
}
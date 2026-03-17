class Solution {
    public int findCenter(int[][] edges) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<edges.length;i++){
            int v1=edges[i][0];
            int v2=edges[i][1];
            map.put(v1,map.getOrDefault(v1,0)+1);
            map.put(v2,map.getOrDefault(v2,0)+1);
            if(map.get(v1)==edges.length){
                return v1;
            }
            if(map.get(v2)==edges.length){
                return v2;
            }
        }
        return -1;
    }
}
class Solution {
    public long maximumImportance(int n, int[][] edges) {
        int[] degree=new int[n];
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            degree[u]++;
            degree[v]++;      
        }
        Arrays.sort(degree);
        long res=0;
        long l=1;
        for(int i=0;i<n;i++){
            res+=(degree[i]*l);
            l++;
        }
        return res;
    }
}
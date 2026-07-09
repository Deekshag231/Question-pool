class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[] component = new int[n];
        int id = 0;
        component[0] = id;
        for(int i=1;i<n;i++){
            if(nums[i]-nums[i-1] <= maxDiff){
                component[i] = id;
            }
            else{
                id++;
                component[i] = id;
            }
        }
        boolean[] ans = new boolean[queries.length];
        int i=0;
        for(int[] query : queries){
            int u = query[0];
            int v = query[1];
            if (component[u] == component[v]) {
                ans[i] = true;
            } 
            i++;
        }
        return ans;
    }
}
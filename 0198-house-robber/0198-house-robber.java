class Solution {
    public int rob(int[] nums) {
        int[] dp=new int[nums.length+1];
        Arrays.fill(dp,-1);
        return helper(nums,dp,nums.length-1);
    }
    public int helper(int[] arr,int[] dp, int n){
        if(n==0) return arr[n];
        if(n==-1) return 0;
        if(dp[n]!=-1) return dp[n];
        int pick=arr[n]+helper(arr,dp,n-2);
        int npick=0+helper(arr,dp,n-1);
        return dp[n]=Math.max(pick,npick);
    }
}
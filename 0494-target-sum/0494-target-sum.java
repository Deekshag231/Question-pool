class Solution {
    public int findTargetSumWays(int[] arr, int sum) {
        int total= 0;
        for(int i=0;i<arr.length;i++){
            total+=arr[i];
        }
        
        if(sum>total||sum<-total||(sum+total)%2!=0){
            return 0;
        }
        sum=(sum+total)/2;
        int[] dp= new int[sum+1];
        dp[0]= 1;
        for(int i=0;i<arr.length;i++){
           for(int j=sum;j>=arr[i];j--){ 
               dp[j]=dp[j]+dp[j-arr[i]];
           }
           
       }
        return dp[sum];
    }
}
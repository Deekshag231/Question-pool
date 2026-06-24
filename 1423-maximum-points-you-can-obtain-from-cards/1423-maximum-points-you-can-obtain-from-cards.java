class Solution {
    public int maxScore(int[] arr, int k) {
        int sum=0;
        int n=arr.length;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<k;i++){
            sum+=arr[i];
        }
        max=sum;

        //if(k==arr.length)  return sum;
        int i=n-1;
        int left=k-1;
        while(i>=0&&left>=0){
            sum+=arr[i]-arr[left];
            max=Math.max(sum,max);
            left--;
            i--;
        }
        return max;
    }
}
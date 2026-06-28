class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int goal1=helper(nums,goal);
        int goal2=helper(nums,goal-1);
        return goal1-goal2;
    }
    public int helper(int[] nums,int goal){
        int we=0;
        int ws=0;
        int count=0;
        int sum=0;
        if(goal<0) return 0;
        while(we<nums.length){
            sum+=nums[we];
            while(sum>goal){
                sum-=nums[ws];
                ws++;
            }
            count+=we-ws+1;
            we++;
        }
        return count;
    }
}
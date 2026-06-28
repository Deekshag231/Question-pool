class Solution {
    public int subarraysWithKDistinct(int[] nums, int goal) {
        int goal1=helper(nums,goal);
        int goal2=helper(nums,goal-1);
        return goal1-goal2;
    }
    public int helper(int[] nums,int goal){
        int we=0;
        int ws=0;
        int count=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        while(we<nums.length){
            map.put(nums[we],map.getOrDefault(nums[we],0)+1);
            while(map.size()>goal){
                map.put(nums[ws],map.getOrDefault(nums[ws],0)-1);
                if(map.get(nums[ws])==0){
                    map.remove(nums[ws]);
                }
                ws++;
            }
            count+=we-ws+1;
            we++;
        }
        return count;
    }
}
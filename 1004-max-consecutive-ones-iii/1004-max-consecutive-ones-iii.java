class Solution {
    public int longestOnes(int[] nums, int k) {
        int we=0;
        int ws=0;
        int maxlen=0;
        int zero=0;
        while(we<nums.length){
            if(nums[we]==0){
                zero++;
                if(zero>k){
                    while(zero>k){
                        if(nums[ws]==0) {
                            zero--;
                        }
                        ws++;
                    }
                }
            }
            
            maxlen=Math.max(maxlen,we-ws+1);
            we++;
        }
        return maxlen;
    }
}
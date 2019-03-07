class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        
        if(nums.length == 1) {
            return nums[0];
        }
        //create an array of length nums.length which will store our previous results
        int [] dp = new int[nums.length];
        //we can take two cases
        //we include the first element and discard the last element
        int max1 = helper(nums, dp , 0, nums.length-2);
        //we exclude the first element and include the last element
        int max2 = helper(nums, dp , 1 , nums.length-1);
        //we take maximum of the two
        return Math.max(max1,max2);
    }
    
    public int helper(int[] nums, int[] dp, int start, int end) {
        
        //if start == end, then we return start element
        if(start == end) {
            return nums[start];
        }
        //dp[start] initialize with nums[start]
        dp[start] = nums[start];
        // dp[start+1] = maximum of two at start and start+1
        dp[start+1] = Math.max(nums[start],nums[start+1]);
        //memoized solution. if we include the element at index i, then we need to add the maximum sum till index i-2 otherwise, if we exclude the element at index i , then we simply can include the maximum sum till i-1
        for(int i = start+2; i<= end; i++) {
            dp[i] = Math.max(dp[i-1],nums[i] + dp[i-2]);
        }
        return dp[end];
        
    }
}

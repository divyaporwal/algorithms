class Solution {
    public int lengthOfLIS(int[] nums) {
        //base case check
        if(nums.length == 0) {
            return 0;
        }
        //initialise j = 0 and i = 1
        int j = 0;
        int i = 1;
        //create an array to store the values for the memoized solutions
        int[] temp_arr = new int[nums.length];
        //initialise temp_arr[0] = 1 because every element is a LIS in itself
        temp_arr[0] = 1;
        //initialize max count = 1
        int  max_count = 1;
        
        while ( i < nums.length ) {
            //initialise the LIS for every element as 1 and mark j = 0 after each iteration
            temp_arr[i] = 1;
            j = 0;
            //we loop from jj = 0 to i and check if there is a LIS from 0..j including i, if so, we take the max of LIS at j + 1 and LIS at i
            // and keep it in solution.
            //we also update the max_count which stoes the length of the longest LIS
            while(j < i) {
                if(nums[j] < nums[i]) {
                    temp_arr[i] = Math.max(temp_arr[j] + 1, temp_arr[i]);
                    max_count = Math.max(max_count,temp_arr[i]);
                } 
                j++;
            }
            i++;
        }
      //return max_count
     return max_count;
    }
}

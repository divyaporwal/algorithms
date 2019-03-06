class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //sort the array
        Arrays.sort(nums);
        //declare a list of list called result
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        //now run a loop keeping i fixed and figuring out the two other elements from the subarray starting from i+1
        for(int i = 0; i < nums.length; i++) {
            //initialise j = i+1
            int j = i+1;
            //initialise k = nums.length - 1
            int k = nums.length - 1;
          
            //if value at i is same as value at i -1, then continue, we have nothing to do
            if (i > 0 && nums[i] == nums[i - 1]) {          
                continue;
            }
            // cheeck for the elements present at indices  and k,
            // if the value at indices i , j , k sum to 0, then we can add that to the list.
            
            while(j < k) {
                //initialise a list
                List<Integer> a = new ArrayList<Integer>();
                //sum = value at i + value at j + value at k
                int sum = nums[i] + nums[j] + nums[k];
                //if sum = 0, then we add the elements to the list
                if(sum == 0) {
                    //check for duplicate elements at j and j+1.
                        while (j<k && nums[j] == nums[j+1]) j++;
                    //check for duplicate elements at k and k -1
                        while (j<k && nums[k] == nums[k-1]) k--;
                        a.add(nums[i]);
                        a.add(nums[j]);
                        a.add(nums[k]);
                }
                //if sum < 0, then increment j because we need values greater than value at j to make the sum = 0, (since the array is sorted)
                
                if(sum < 0) {
                    j++;
                } else {
                    //if the sum is > 0, then decrement k , we need values lesser than value at k to make the sum = 0.
                    k--;
                }
                //if size of a is not 0, ten we add the list to the result list
                if(a.size() != 0)
                    result.add(a);
            }
            
           
        }
        return result;
    }
}

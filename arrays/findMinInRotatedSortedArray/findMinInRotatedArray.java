class Solution {
    public int findMin(int[] nums) {
        
        if(nums.length == 0 || nums.length == 1) {
            return nums[0];
        }
        if(nums[0] < nums[nums.length-1]) {
            return nums[0];
        }
        return findMinUtil(nums, 0, nums.length-1);
    }
    
    public int findMinUtil(int[] nums, int start, int end) {
       
        int mid = (start + end )/2;
        //if start > end, this means that array is not rotates at all
         if(start > end ) {
            return nums[0];
        }
        //if start == end, that means that only one element left, we return that
        if(start == end) {
            return nums[start];
        }
        //when mid itself is the element, we check for the left half of the array and also the fact that mid > start
        if(mid > start && nums[mid-1] > nums[mid]) {
            return nums[mid];
        }
        
        //when mid +1 is the element, we check for the right half of the array and also the fact that mid < end
        if(end > mid && nums[mid] > nums[mid+1]) {
            return nums[mid+1];
        }
        
       //check for the left and the right half, compare the nums[mid] with nums[start]
        if(nums[mid] >  nums[start]) {
            return findMinUtil(nums, mid+1,end);
        } else {
            return findMinUtil(nums,start,mid-1);
        }
    }
}

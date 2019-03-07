class Solution {

    //declare two arrays , initial array and the array we will change
    private int[] array;
    private int[] original;
    //initialise rand variable of random type
    Random rand = new Random();
    
    public Solution(int[] nums) {
        //initialise array to nums and original to nums.clone
        array = nums;
        original = nums.clone();
    }
    
    private int randRange(int min, int max) {
        //this will generate a number from 0-max-min, since we want to start from number min, we add min to it;
        int number = rand.nextInt(max-min)+min;
        return number;
    }
    
    private void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        array = original;
        original = original.clone();
        return original;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for(int i = 0; i  < array.length; i++) {
            swap(i,randRange(i,array.length));
        }
        return array;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */

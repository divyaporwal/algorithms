class Solution {
    public String intToRoman(int num) {
        //initialise all the vlaues in an array called nums
        int[] nums = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        //initialise all the corresponding roman values for the integers in nums
        String[] symbols = new String[] {
            "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
        };
        //initialise a stringbuilder
        StringBuilder sb = new StringBuilder();
        //loop through all the elements in nums
        for(int i = 0; i < nums.length && num > 0 ; i++) {
            //try to find out the actual value just greater than or equal to the nums.
            int cnt = num/nums[i];
            //keep appending the romans if we find the cnt greater than 0.
            while(cnt > 0) {
                sb.append(symbols[i]);
                cnt--;
            }
            //find the remainder left out after division of nums by nums[i] to get the next element
            num = num % nums[i];
        }
        return sb.toString();
    }
}

class Solution {
    public String largestNumber(int[] nums) {
        //convert numbers array to array of strings for comparision
        String[] numstr = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
            numstr[i] = String.valueOf(nums[i]);
        }
        //sort the array basede on the comparator compare function
        Arrays.sort(numstr, new LComparator());
        //if after sorting, the first numeric string i 0, then we return 0
        if(numstr[0].equals("0")) {
            return "0";
        }
        //otherwise we store the numbers in the string and return them
        String res = new String();
        for(int i = 0; i < numstr.length; i++) {
            res = res + numstr[i];
        }
        return res;
    }
    
    private class LComparator implements Comparator<String> {
       // implementing custom comparator
        public int compare(String a, String b) {
            //first form the string ab
            String x = a + b;
            //form the string ba
            String y = b + a;
            //compare which string is lexographically bigger
            return y.compareTo(x);
        }
    }
}

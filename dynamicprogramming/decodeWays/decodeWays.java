class Solution {
    public int numDecodings(String s) {
        /*
            1) If the last digit is non-zero, recur for remaining (n-1) digits and add the result to total count.
            2) If the last two digits form a valid character (or smaller than 27), recur for remaining (n-2) digits and add the result to total count.
        */
        
        //check for case when string is empty
        if(s.length() == 0) {
            return 0;
        }
        //check for case when there is only one element in string and it is 0
        if(s.length() == 1 && s.charAt(0) == '0') {
            return 0;
        }
        //check for the case when there is only one element in string and it is > 0
        if(s.length() == 1 && s.charAt(0) > '0') {
            return 1;
        }
        //initialise an array to memoize the previous results. size is s.length() + 1 because we need to keep the number of decoding ways for string of length 0 also
        int count[] = new int[s.length()+1];
        //set count[0] to be 0 when the element is 0 at index 0 of string otherwise set it to 1
        count[0] = s.charAt(0) != '0' ? 1 : 0;
        //set count[1] to be 0 when the element at index1 is 0 and also the element at index 0 is 0, otherwise set it to 1 (for element at index 1 or 1 and 0)
        count[1] = s.charAt(1) != '0' && s.charAt(0) != '0'? 1 : 0;
        
        //loop over the array from 2 to end of the string length
        for(int i = 2; i <= s.length(); i++) {
            //initialize the count of number of ways of string of length 0 to i as 0
            count[i] = 0;            
            //if the element at i-1 index is greater than 0, this means we can use the previous count[i-1] and add it to count[i] to get the total number of ways. The last digit forms a valid character here.
            if(s.charAt(i-1) > '0') {
                count[i] += count[i-1];
            }
            
            //next we can check for elements at position i-1 and i-2 for considering the number of elements at position i, we check if the value at i-2 or i-2 is either 1 or 2, and value at i-1 should be <=6 to be a valid number . the last two digits form a valid character.
            
            if(s.charAt(i-2) == '1' || s.charAt(i-2) == '2' && s.charAt(i-1) < '7') {
                count[i] += count[i-2];
            }
        }
        return count[s.length()];
        
    }
}

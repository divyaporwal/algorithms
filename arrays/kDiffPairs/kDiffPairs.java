

public class Solution {
    public int findPairs(int[] nums, int k) {
        int ret = 0;
        if (k < 0) return ret; 
        //declare hashmap to store the key and value pair
        HashMap<Integer, Integer> map = new HashMap<>();
        
        //put all the keys and value in hashmap
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
                
        //now check
        /*
            if k == 0 then number of times we have result is the value of key > 1
            if k != 0, then we lok for value hich is key + k
        */
        for (int key : map.keySet()) {
            if (k == 0) {
                if (map.get(key) > 1)   ret++;
            }
            else if (map.containsKey(key+k)) {
                ret++;
            }
        }
        
        return ret;
    }
}


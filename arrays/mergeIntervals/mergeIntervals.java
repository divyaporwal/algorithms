/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        //sort the collections based on the custom comparator method
        Collections.sort(intervals, new sortComparator());
        // declare a linkedlist called res which will store the merged intervals
        LinkedList<Interval> res = new LinkedList<Interval>();
        
        for(Interval interval : intervals) {
            //if our result list is empty, then we add the interval to the list
            if(res.isEmpty()) {
                res.add(interval);
            }
            //if the result list end interval has end value less than the start value of the current interval , then simply add the interval
            //because it cannot be merged
            if(res.getLast().end < interval.start) {
                res.add(interval);
            }
            //we get the maximum of the end value of the interval and update the last's end value
            if(res.getLast().end >= interval.start) {
                res.getLast().end = Math.max(interval.end,res.getLast().end);
            }
        }
        return res;
        
    }
    //implement compare function where we sort the intervals based on the start values
    private class sortComparator implements Comparator<Interval> {
        public int compare(Interval l1, Interval l2) {
            if(l1.start < l2.start) {
                return -1;
            } else if(l1.start == l2.start) {
                return 0;
            } else {
                return 1;
            }
        }
    }
}

import java.io.*;
import java.util.*;

class Solution {

  static int[] meetingPlanner(int[][] slotsA, int[][] slotsB, int dur) {
    int pA = 0;
    int pB = 0;
    int result[] = new int[0];
    //check for the empty arrays
    if(slotsA.length == 0 || slotsB.length == 0) {
      return result;
    }
    
    //loop through the two arrays
    while(pA < slotsA.length && pB < slotsB.length) {
      // start time is the maximum of the two time slots of slota[pa] and slotb[pb]
      int start = Math.max(slotsA[pA][0],slotsB[pB][0]);
      //end time is the minimum of two time slots of slota[pa] and slotb[pb]
      int end = Math.min(slotsA[pA][1],slotsB[pB][1]);
      //we check if the difference between end and start is atleast that of duration
      if(end-start >=  dur) {
        int [] res = new int[2];
        res[0] = start;
        res[1] = start + dur;
        return res;
      }
      //if the above case is not satisfied, we check if the end time of slota and slotb is greater, if end time of a is less than b, we increment pointer a to check for another available time slot. Here since the time intervals are disjoint, we can assume that the start time of next time interval is always greater than the end time of previous interval
      if(slotsA[pA][1] < slotsB[pB][1]) {
        pA++;
      } else {
        pB++;
      }
    }
    
    return result;
  }

  public static void main(String[] args) {

  }

}

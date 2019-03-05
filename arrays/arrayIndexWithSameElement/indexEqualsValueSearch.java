import java.io.*;
import java.util.*;

class Solution {
  
  static int indexEqualsValueSearch(int[] arr) {
    if(arr.length == 0) {
      return -1;
    }
    if(arr[0] == 0) {
      return 0;
    }
    int start = 0;
    int end = arr.length -1;
    return searchUtil(arr,start,end);
  }
  
  static int searchUtil(int[] arr, int start , int end) {
    
    if( end >= start) {
      int mid = (start + end)/2;
      if(mid == arr[mid] && mid -1 != arr[mid-1] ) {
        return mid;
      }
      
      if(mid > arr[mid]) {
        return searchUtil(arr,mid+1,end);
      } else {
        return searchUtil(arr,start,mid-1);
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] arr = {-8,0,2,5};
    System.out.println(indexEqualsValueSearch(arr));
    return;
  }
}

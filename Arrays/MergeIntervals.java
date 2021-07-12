/* Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping. */

public class MergeIntervals{

     public int[][] merge(int[][] intervals) {
        LinkedList<int[]> mergedList = new LinkedList<>();
        
        for(int[] interval : intervals){
            if(mergedList.isEmpty() || mergedList.getLast()[1] < interval[0]){
                mergedList.add(interval);
            } else {
                int[] lastInterval = mergedList.getLast();
                lastInterval[1] = Math.max(lastInterval[1], interval[1]);
                mergedList.removeLast();
                mergedList.add(lastInterval);
            }
        }
        return mergedList.toArray(new int[mergedList.size()][]); 
    }

}

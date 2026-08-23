/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {

        PriorityQueue<Integer> minheap = new PriorityQueue<>(); 

        Collections.sort(intervals, Comparator.comparingInt(i -> i.start));

        for (Interval interval : intervals)
        {
            if (!minheap.isEmpty() && minheap.peek() <= interval.start)
            {
                minheap.poll();
            }

            minheap.add(interval.end);
        }

        return minheap.size();
    }
}

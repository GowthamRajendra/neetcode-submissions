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
    public boolean canAttendMeetings(List<Interval> intervals) {
        if(intervals.isEmpty()) return true;

        Collections.sort(intervals, Comparator.comparingInt(i -> i.start));
        
        int end = intervals.get(0).end;

        for (int i = 1; i < intervals.size(); i++)
        {
            if (intervals.get(i).start >= end)
            {
                end = intervals.get(i).end;
            }
            else // if (intervals[i][0] < end)
            {
                return false;
            }
        }

        return true;
    }
}

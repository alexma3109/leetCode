public class Interval {
    int start, end;
    public Interval() {start = 0; end = 0;}
    public Interval(int s, int e) {start = s; end = e;}
}

public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        int res = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i = 0 ; i < intervals.length ; i++) {
            while(!pq.isEmpty() && pq.peek() <= intervals[i].start) {
                pq.poll();
            }
            pq.offer(intervals[i].end);
            res = Math.max(res, pq.size());
        }
        return res;
    }
//////////////////////////////////////////////////////////
    public int minMeetingRooms(Interval[] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for(int i=0; i<intervals.length; i++) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int rooms = 0;
        int endsItr = 0;
        for(int i=0; i<starts.length; i++) {
            if(starts[i]<ends[endsItr]) {
                rooms++;                
            }
            else {
                endsItr++;
            }
        }
        return rooms;
    }    
}
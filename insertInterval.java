public class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
 }

public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    	List<Interval> res = new ArrayList<Interval>();
        if(intervals == null || intervals.size() == 0){
        	res.add(newInterval);
        	return res;
        } 
        int pos = 0;
        for(int i = 0 ; i < intervals.size() ; i++){
        	if(intervals.get(i).end < newInterval.start){
        		res.add(intervals.get(i));
        		pos++;
        	}
        	else if(intervals.get(i).start > newInterval.end){
        		res.add(intervals.get(i));
        	}
        	else{
        		int start = Math.min(intervals.get(i).start, newInterval.start);
        		int end = Math.max(intervals.get(i).end, newInterval.end);
        		newInterval.start = start;
        		newInterval.end = end;        		
        	}
        }
        res.add(pos, newInterval);
        return res;        
    }
}
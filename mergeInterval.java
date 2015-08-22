public class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<Interval>();
        if(intervals == null || intervals.size() <= 1){
        	return intervals;
        }
		Collections.sort(intervals, new IntervalComparator());
		Interval temp = intervals.get(0);		
		for(int i = 1 ; i < intervals.size() ; i++){
			Interval curr = intervals.get(i);
			if(curr.start <= temp.end){
				temp.end = Math.max(temp.end, curr.end);
			}
			else{
				res.add(temp);
				temp = curr;
			}
		}
		res.add(temp);
		return res;
    }
	private class IntervalComparator implements Comparator<Interval>{
		public int compare(Interval a, Interval b){
			return a.start - b.start;
		}
	}
}
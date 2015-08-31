public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();
		helper(res, temp, k, n, 0, 0);
		return res;
    }
	public void helper(List<List<Integer>> res, List<Integer> temp, int k, int n, int sum, int cur){
		if(sum >= n || temp.size() > k){
			return;
		}
		if(sum == n && temp.size() == k && !res.contains(temp)){
			res.add(new ArrayList<Integer>(temp));
			return;
		}
		for(int i = cur ; i < 10 ; i++){
			temp.add(cur);
			helper(res, temp, k, n, sum + cur, i + 1);
			temp.remove(temp.size() - 1);
		}
	}
}
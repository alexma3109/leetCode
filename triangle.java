public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
		int n = triangle.size();
		int[] sums = new int[n];
		for(int i = n - 1 ; i >= 0 ; i--){
			for(int j = 0 ; j <= i ; j++){
				if(i == n - 1){
					sums[j] = triangle.get(i).get(j);
				}
				else{
					sums[j] = triangle.get(i).get(j) + Math.min(sums[j], sums[j + 1]);
				}
			}
		}
		return sums[0];		
    }
}
public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int res = (C - A) * (D - B) + (G - E) * (H - F);
		if(overlap(A, C, E, G) > 0 && overlap(B, D, F, H) > 0){
			res -= overlap(A, C, E, G) * overlap(B, D, F, H);
		}
		return res;
    }
	public int overlap(int m, int n, int x, int y){
		if(m > y || n < x){
			return 0;
		}
		return Math.min(n, y) - Math.max(m, x);
	}
}
//// check all the primes that < sqrt(n), throw away all the numbers that == prime * k (k start from 2) ////
public class Solution {
    public int countPrimes(int n) {
		if(n == 0 || n == 1){
			return 0;
		}
		boolean[] notPrime = new boolean[n];
		notPrime[0] = true;
		notPrime[1] = true;
		for(int i = 2 ; i * i < n ; i++){
			if(!notPrime[i]){
				int num = i * i; //// all the number less than i * i already checked by smaller primes ////
				while(num < n){
					notPrime[num] = true;
					num += i;
				}
			}			
		}
		int res = 0;
		for(boolean i : notPrime){
			if(!i){
				res++;
			}
		}
		return res;
	}
}
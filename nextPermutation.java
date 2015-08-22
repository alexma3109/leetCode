public class Solution {
//from the end to the beg, record count the first num[i] which is smaller than num[i+1]. If not, reverse all////
//from the end to the count, record the first num[i] that larger than num[count], and swap////
//from the count+1 to the end, reverse////
    public static void nextPermutation(int[] num) {
        if(num == null || num.length < 2){
        	return;
        }
        int len = num.length;
        int count = -1;
    	for(int i = len - 2 ; i >= 0 ; i--){
        	if(num[i] < num[i + 1]){
        		count = i;
        		break;
        	}
        }
    	if(count == -1){
    		int beg = 0;
    		int end = len - 1;
    		while(beg < end){
    			swap(num, beg, end);
    			beg++;
    			end--;
    		}
    		return;
    	}
    	for(int i = len - 1; i > count ; i--){
    		if(num[i] > num[count]){
    			swap(num, i, count);
    			break;
    		}
    	}
    	int beg = count + 1;
    	int end = len - 1;
		while(beg < end){
			swap(num, beg, end);
			beg++;
			end--;
		}
		return;
    }
	public static void swap(int[] num, int beg, int end){
		int temp = num[beg];
		num[beg] = num[end];
		num[end] = temp;      
    }
}
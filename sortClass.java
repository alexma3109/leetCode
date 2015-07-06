public class Sort {
	public int[] sort(int[] nums, int low, int high){
		int mid = low + (high - low) / 2;
		if(low < high){
			sort(nums, low, mid);
			sort(nums, mid + 1, high);
			merge(nums, low, mid, high);
		}
		return nums;
	}
	public merge(int[] nums, int low, int mid, int high){
		int[] temp = new temp[high - low + 1];
		int i = low;
		int j = mid + 1;
		int k = 0;
		while(i <= mid && j <= high){
			if(nums[i] < nums[j]){
				temp[k] = nums[i];
				i++;
			}
			else{
				temp[k] = nums[j];
				j++;
			}
			k++;
		}
		while(i<= mid){
			temp[k] = nums[i];
			i++;
			k++;
		}
		while(j <= high){
			temp[k] = nums[j];
			j++;
			k++;
		}
		for(k = 0 ; k < temp.length ; k++){
			nums[low + k] = temp[k];
		}
	}
}
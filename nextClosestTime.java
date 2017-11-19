class Solution {
	int minDiff = Integer.MAX_VALUE;
	int h, m;
	String res = "";
	public String nextClosestTime(String time) {
		String[] strArray = time.split(":");
		int[] digits = new int[4];
		h = Integer.parseInt(strArray[0]);
		m = Integer.parseInt(strArray[1]);
		digits[0] = h / 10;
		digits[1] = h % 10;
		digits[2] = m / 10;
		digits[3] = m % 10;
		dfs(digits, 0, new int[4]);
		return res;
	}
	public void dfs(int[] digits, int pos, int[] ans) {
		if (pos == 4) {
			int hour = ans[0] * 10 + ans[1];
			int minute = ans[2] * 10 + ans[3];
			int diff = getDiff(hour, minute);
			if (diff < minDiff) {
				minDiff = diff;
				res = getStr(hour) + ":" + getStr(minute);
			}
		}
		else {
			for (int i = 0 ; i < digits.length ; i++) {
				ans[pos] = digits[i];
				if (pos == 1) {
					int hour = ans[0] * 10 + ans[1];
					if (hour >= 0 && hour <= 23) {
						dfs(digits, pos + 1, ans);
					}
				}
				else if (pos == 3) {
					int minute = ans[2] * 10 + ans[3];
					if (minute >= 0 && minute <= 59) {
						dfs(digits, pos + 1, ans);
					}
				}
				else {
					dfs(digits, pos + 1, ans);
				}
			}
		}
	}
	public int getDiff(int hour, int minute) {
		int count1 = h * 60 + m;
		int count2 = hour * 60 + minute;
		return count1 < count2 ? count2 - count1 : 24 * 60 - (count1 - count2);
	}
	public String getStr(int num) {
		if (num < 10) {
			return "0" + num;
		}
		else {
			return num + "";
		}
	}
}
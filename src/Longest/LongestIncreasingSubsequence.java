package Longest;
import java.util.*;

public class LongestIncreasingSubsequence {
/*	Longest Increasing Subsequence - Leet Code - 300
	Longest Consecutive Subsequence - Leet Code -  128*/
	//Input: [10,9,2,5,3,7,101,18]
	//Output: 4 
	//Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 
	public static void main(String[] args) {
		int[] arr = { 2, 5, 3 };
		System.out.println(lengthOfLISBinarySearch(arr));
	}

	public static int lengthOfLISDP(int[] nums) {
	    if(nums==null || nums.length==0)
	        return 0;
	 
	    int[] max = new int[nums.length];
	    Arrays.fill(max, 1);
	 
	    int result = 1;
	    for(int i=0; i<nums.length; i++){
	        for(int j=0; j<i; j++){
	            if(nums[i]>nums[j]){
	                max[i]= Math.max(max[i], max[j]+1);
	 
	            }
	        }
	        result = Math.max(max[i], result);
	    }
	 
	   return result;
	}
	
	public static int lengthOfLISBinarySearch(int[] nums) {
		int[] dp = new int[nums.length];
		int len = 0; // len of sequence

		for (int num : nums) {
			int idx = Arrays.binarySearch(dp, 0, len, num);

			// if not found, return binarySearch return -insertPosition-1
			if (idx < 0) {
				idx = -(idx + 1);
			}

			dp[idx] = num;

			// update len when insert position is at the end
			if (idx == len) {
				len++;
			}
		}

		return len;
	}
	
	public static int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		ArrayList<Integer> list = new ArrayList<>();

		for (int num : nums) {
			if (list.size() == 0 || num > list.get(list.size() - 1)) {
				list.add(num);
			} else {
				int i = 0;
				int j = list.size() - 1;

				while (i < j) {
					int mid = (i + j) / 2;
					if (list.get(mid) < num) {
						i = mid + 1;
					} else {
						j = mid;
					}
				}

				list.set(j, num);
			}
		}

		return list.size();
	}
	
	
}

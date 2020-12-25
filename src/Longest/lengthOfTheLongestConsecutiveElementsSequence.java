package Longest;
import java.util.*;

//Find the length of the longest consecutive elements sequence from a given unsorted array of integers
//Input: [100, 4, 200, 1, 3, 2]
//Output: 4
//Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
public class lengthOfTheLongestConsecutiveElementsSequence {

	public static void main(String[] args) {

		int nums[] = { 100, 4, 200, 1, 3, 2 };
		int n = nums.length;
	
		System.out.println("The new length of the array is: " + findLongestConseqSubseq(nums,n));

	}

		
	public static int findLongestConseqSubseq(int arr[], int n) 
	{
		HashSet<Integer> S = new HashSet<Integer>();
		int ans = 0;

		// Hash all the array elements
		for (int i = 0; i < n; ++i)
			S.add(arr[i]);

		// check each possible sequence from the start
		// then update optimal length
		for (int i = 0; i < n; ++i) {
			// if current element is the starting
			// element of a sequence
			
			if (!S.contains(arr[i] - 1)) {
				// Then check for next elements
				// in the sequence
				int j = arr[i];
				while (S.contains(j))
					j++;

				// update optimal length if this
				// length is more
				if (ans < j - arr[i])
					ans = j - arr[i];
			}
		}
		return ans;
	} 
}
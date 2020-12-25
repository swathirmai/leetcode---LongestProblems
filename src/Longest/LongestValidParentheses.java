package Longest;
import java.util.*;

public class LongestValidParentheses {
	/*
	 * //HARD PROBLEM 
	 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
	 * Input: ")()())" 
	 * Output: 4 
	 * Explanation: The longest valid parentheses substring is "()()"
	 */
	public static void main(String[] args) {
		String str = ")()())";
		System.out.println(longestValidParentheses(str));

	}

	public static int longestValidParentheses(String s) {
		int maxans = 0;
		Stack<Integer> stack = new Stack<>();
		stack.push(-1);
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(i);
			} else {
				stack.pop();
				if (stack.empty()) {
					stack.push(i);
				} else {
					maxans = Math.max(maxans, i - stack.peek());
				}
			}
		}
		return maxans;
	}

}

public class Solution {
    public String longestPalindrome(String input) {
        
		int len = input.length();
		int maxLength = 1;
		String longestPallindrome = "";
		boolean[][] tracker = new boolean[len][len];

		// Make all diagonals as true i.e. each element is a pallindrome of
		// itself
		for (int i = 0; i < len; i++) {
			tracker[i][i] = true;
			longestPallindrome = input.substring(i, i + 1);
		}

		// For pallindrome of length two
		for (int i = 0; i < len - 1; i++) {
			if (input.charAt(i) == input.charAt(i + 1)) {
				tracker[i][i + 1] = true;
				maxLength = 2;
				longestPallindrome = input.substring(i, i + 2);
			}
		}

		// For all pallindromes of length more than 2
		for (int k = 3; k <= len; k++) {
			for (int l = 0; l < len - k + 1; l++) {

				// l and j points to characters that are compared, outer loop is
				// for various lengths
				int j = l + k - 1;
				// lth and jth element is same and the everything inside that is
				// a pallindrome
				if (input.charAt(l) == input.charAt(j)
						&& tracker[l + 1][j - 1] == true) {
					tracker[l][j] = true;
					if (k > maxLength) {
						maxLength = k;
						longestPallindrome = input.substring(l, j + 1);
					}
				}

			}
		}
    return longestPallindrome;
	}
}
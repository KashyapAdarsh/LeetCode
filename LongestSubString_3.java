public class Solution {
    /*
        Logic : Use two pointers start and end and an hashMap to check if the character
                is present between the pointers
                If end has a character that is already seen, then we store the current
                subString length and alter the start pointer and the count
                ex : abcdec -> after abcde is seen, we realize c is already encountered
                     so we store the length as 5 and then we move start pointer from
                     'a' to first 'c' and simultaneously remove characters that are 
                     present on the way and keep reudcing the count.
                     Now start will point tp 'd' and count would have reduced to 3.
    
    */
    public int lengthOfLongestSubstring(String s) {
		HashMap<Character, Integer> myMap = new HashMap<Character, Integer>();
		int finalCount = 0;
		int temp = 0;
		int start = 0;
		int end = 0;

		while (end < s.length()) {
			if (!myMap.containsKey(s.charAt(end))) {
				myMap.put(s.charAt(end), 1);
				end++;
				temp++;
			} else {
				if (finalCount <= temp)
					finalCount = temp;
				while (start < end && s.charAt(start) != s.charAt(end)) {
					myMap.remove(s.charAt(start));
					temp--;
					start++;
				} if (s.charAt(start) == s.charAt(end)) {
					start++;
					end++;
				}
			}
		}
		
		if (finalCount <= temp)
			finalCount = temp;
		
		return finalCount;
	}
}
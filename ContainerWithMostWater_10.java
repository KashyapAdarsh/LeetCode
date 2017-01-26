public class Solution {
    public int maxArea(int[] height) {
		if (height.length < 2) {
			return 0;
		}
		int first = 0;
		int second = height.length - 1;
		int area = 0;
		// Use 2 pointers, one at begin and one at end
		while (second > first) {
			int temp = (second - first) * Math.min(height[second], height[first]);
			if (temp > area) {
				area = temp;
			}
			int hSmall = height[first];
			int hBig = height[second];
			// Since first height is less, increment first
			if (hSmall < hBig) {
				if (height[first + 1] < hSmall) {
					// Keep incrementing until a line bigger than current line is found
					while (first < second && height[first + 1] < hSmall) {
						first++;
					}
				} else
					first++;
			}
		   // Keep decrementing until a line bigger than current line is found
			else {
				if (height[second - 1] < hBig) {
					while (first < second && (height[second - 1] < hBig)) {
						second--;
					}
				} else
					second--;
			}
		}
		return area;
	}
}
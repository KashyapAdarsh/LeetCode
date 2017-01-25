public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int[] temp = new int[nums1.length + nums2.length];
		int i = 0;
		int j = 0;
		for (int k = 0; k < temp.length; k++) {
			if (i < nums1.length && j < nums2.length) {
				if (nums1[i] < nums2[j])
					temp[k] = nums1[i++];
				else
					temp[k] = nums2[j++];
			} else {
				if (i == nums1.length)
					temp[k] = nums2[j++];
				else
					temp[k] = nums1[i++];
			}
		}

		if (temp.length % 2 == 0) 
			return (double) (temp[temp.length / 2] + temp[(temp.length / 2) - 1]) / 2;
		else 
			return temp[temp.length / 2];
	}
}
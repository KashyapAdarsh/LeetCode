public class Solution {
    public List<List<Integer>> threeSum(int[] input) {
        
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if (input == null || input.length < 3) {
			return result;
		}

		// Sorting the array
		Arrays.sort(input);

		for (int i = 0; i < input.length - 2; i++) {
		if (i != 0 && input[i] == input[i - 1])
				continue;
			int j = i + 1;
		
			int k = input.length - 1;
			while (j < k) {
			
				// Since it is less than target, need to increase total and hence increment j
				if(input[i] + input[j] + input[k] < 0){
					j++;
				}
				// Since it is more than target, need to reduce total and hence decrement k
				else if(input[i] + input[j] + input[k] > 0){
					k--;
				}
				// Equal to target case
				else{
					List<Integer> temp = new ArrayList<>();
					temp.add(input[i]);
					temp.add(input[j]);
					temp.add(input[k]);
					result.add(temp);
					
					j++;
					k--;
					
					// Only unique sets are required.
					
					// While decrementing k, if k elements are same we need to skip it so that we get unique sets
					while((j < k) && input[k] == input[k + 1]){
						k--;
					}
					// While incrementing j, if j elements are same we need to skip it so that we get unique sets
					while((j < k) && input[j] == input[j - 1]){
						j++;
					}	
				}
			}
		}
		return result;

	
    }
}
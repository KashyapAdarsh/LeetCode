public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> outputVector = null;
        outputVector = new ArrayList<>(3 ^ digits.length());
        if (digits.length() == 0) {
          return outputVector;
		}
		char[] output = new char[digits.length()];
		FindAllCombinations(outputVector, digits, digits.length(), output, 0, 0);	
		return outputVector;
    }
    
    private static void FindAllCombinations(List<String> outputVector, String input, int n, char[] output, int pos, int inputNumberPos) {
		int currentCharacterPos = 0;
		if (pos == n) {
			outputVector.add(new String(output));
		}
		if (pos != n) {
			String stringFromNum = numberToString(Character.getNumericValue(input.charAt(inputNumberPos++)));
			for (int i = 0; i < stringFromNum.length(); i++) {
				output[pos] = stringFromNum.charAt(currentCharacterPos++);
				FindAllCombinations(outputVector, input, n, output, pos + 1, inputNumberPos);
			}
		}
	}

	private static String numberToString(int num) {
		switch (num) {
		case 2:
			return "abc";
		case 3:
			return "def";
		case 4:
			return "ghi";
		case 5:
			return "jkl";
		case 6:
			return "mno";
		case 7:
			return "pqrs";
		case 8:
			return "tuv";
		case 9:
			return "wxyz";
		}
		return "";
	}
    
}
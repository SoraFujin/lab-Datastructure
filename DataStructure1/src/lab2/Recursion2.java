package lab2;

public class Recursion2 {

	public static void main(String[] args) {
		int[] numbers = {1, 2, 3, 3, 2, 1};
		boolean result = isPalindrome(numbers);
		System.out.println(result);
	}
	
	public static boolean isPalindrome(int [] list) {
		return isPalindrome(list, 0, list.length - 1);
	}

	private static boolean isPalindrome(int[] n, int start, int end) {
		if (end <= start) {
			return true;
		} else if (n[start] != n[end]) {
			return false;
		} else {
			return isPalindrome(n, start + 1, end - 1);
		}
	}
}

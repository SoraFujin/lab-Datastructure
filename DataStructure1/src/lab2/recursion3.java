package lab2;

public class recursion3 {

	public static void main(String[] args) {
		String line = "hello world how are you";
		String reverse = reverseWords(line);
		System.out.println(reverse);
	}

	public static String reverseWords(String input) {
		if (input.isEmpty() || input.indexOf(' ') == -1) {
			return input;
		} else {
			int spaceIndex = input.indexOf(' ');
			String firstWord = input.substring(0, spaceIndex);
			String remainingWords = input.substring(spaceIndex + 1);
			return reverseWords(remainingWords) + " " + firstWord;
		}
	}

}

package lab2;

public class postLab {

	public static void main(String[] args) {
		anagram("cat");
	}

	public static void anagram(String word) {
		if (word.length() == 0 || word == null)
			System.out.println(word);
		else
			anagram("", word);
	}

	private static void anagram(String s, String remaining) {
		if (remaining.length() == 0 || s == null) {
			System.out.println(s);
		} else {
			for (int i = 0; i < remaining.length(); i++) {
				anagram(s + remaining.charAt(i),
						remaining.substring(0, i) + remaining.substring(i + 1, remaining.length()));

			}
		}
	}
}

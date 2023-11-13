package lab2;

public class recursion4 {

	public static void main(String[] args) {
		System.out.println(countA("ahmad"));
	}

	public static int countA(String s) {
		if (s == null || s.isEmpty())
			return 0;
		return countA(s, 0);
	}

	private static int countA(String s, int index) {
		if(index == s.length())
			return 0;
		else if (s.charAt(index) == 'a')
			return 1 + countA(s, index + 1);
		else
			return 0 + countA(s, index + 1);

	}
}

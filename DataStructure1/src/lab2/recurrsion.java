package lab2;

import java.util.Scanner;

public class recurrsion {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a number: ");
		int n = scanner.nextInt();
		printNumber(n);

	}

	public static void printNumber(int n) {// we consider this a non-tail recursion if we want to make it
		//tail recursion we put the return (printNumber) at the end of the method
		if (n >= 0) {
			printNumber(n - 1);
			System.out.println(n);
		}
	}

}

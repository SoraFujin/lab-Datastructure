package lab1;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class ListTest {

	public static void main(String[] args) {
		List<USAName> USAList = new List<>(50000);
		

		try {
			Scanner scanner = new Scanner(
					new File("C:\\Users\\HP\\OneDrive\\Desktop\\eclipse\\DataStructure1\\usa.txt"));
			while (scanner.hasNext()) {
				String s[] = scanner.nextLine().split(",");
				USAName USA = new USAName(s[0], s[1].trim().charAt(0), Integer.parseInt(s[2].trim()));
				USAList.add(USA);
				
			}
			System.out.println("hello");
			USAList.print();

			int maxFreq = 0;
			String nameWithMaxFreq = "";

			for (USAName usa : USAList.arr) {
				if (usa.getFreq() > maxFreq) {
					maxFreq = usa.getFreq();
					nameWithMaxFreq = usa.getName();
				}
			}

			System.out.println(
					"The name with the highest frequency is: " + nameWithMaxFreq + " with a frequency of " + maxFreq);

		} catch (Exception e) {
			System.out.println("error");

		}
	}
}

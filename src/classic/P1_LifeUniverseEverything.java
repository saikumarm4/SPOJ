package classic;

import java.util.Scanner;

public class P1_LifeUniverseEverything {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int number = scan.nextInt();
		scan.nextLine();
		while (number != 42) {
			System.out.println(number);
			number = scan.nextInt();
			scan.nextLine();
		}
		scan.close();
	}

}

package classic;

import java.util.Scanner;

public class P2_PrimeGenerator {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.nextLine();
		int left, right;
		for (int i = 0; i < n; i++) {
			left = scan.nextInt();
			right = scan.nextInt();
			findPrimeFactors(left, right);
			scan.nextLine();
			System.out.println();
		}
		scan.close();
	}

	private static void findPrimeFactors(int left, int right) {
		for (int i = left; i <= right; i++) {
			if (isPrime(i) && i >= 2)
				System.out.println(i);

		}
	}

	private static boolean isPrime(int number) {
		for (int i = 2; i <= Math.sqrt(number); i++)
			if (number % i == 0)
				return false;
		return true;
	}

}

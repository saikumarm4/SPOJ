package classic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P5_PALIN {

	/*
	 * Though the solution passes test cases cannot achieve space and time
	 * complexity
	 */

	public static void main(String[] args) {

		BufferedReader scan = new BufferedReader(new InputStreamReader(
				System.in));
		int n = 0;

		try {
			n = Integer.parseInt(scan.readLine());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		StringBuffer valueBuffer = new StringBuffer();

		for (int i = 0; i < n; i++) {

			try {
				valueBuffer = new StringBuffer(scan.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}

			System.out.println(nextPlaindromeTest(valueBuffer));
		}

		try {
			scan.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static String nextPlaindromeTest(StringBuffer num) {
		int LENGTH = num.length();
		StringBuffer result = new StringBuffer();
		if (num.toString().equals("9") || num.toString().equals("10")) {
			return "11";
		}
		if (LENGTH % 2 == 0) {
			StringBuffer left = new StringBuffer(num.substring(0, LENGTH / 2));
			StringBuffer right = new StringBuffer(num.substring(LENGTH / 2,
					LENGTH));
			boolean leftLarge = findLarger(left, right);
			StringBuffer leftBuffer = new StringBuffer(num.substring(0,
					left.length()));
			if (leftLarge) {
				left.append(new StringBuffer(left).reverse());
				result = left;
			} else {
				left = incrementInput(left, left.length() - 1);
				if (leftBuffer.length() != left.length()) {
					leftBuffer = new StringBuffer(left.substring(0,
							leftBuffer.length()));
					left.append(new StringBuffer(leftBuffer).reverse());
				} else {
					left.append(new StringBuffer(left).reverse());
				}

				result = left;
			}
		} else {
			StringBuffer left = new StringBuffer(num.substring(0, LENGTH / 2));
			StringBuffer right = new StringBuffer(num.substring(LENGTH / 2 + 1,
					LENGTH));
			boolean leftLarge = findLarger(left, right);
			if (leftLarge) {
				StringBuffer leftTemp = new StringBuffer(num.substring(0,
						LENGTH / 2 + 1));
				leftTemp.append(new StringBuffer(left).reverse());
				result = leftTemp;
			} else {
				StringBuffer leftTemp = new StringBuffer(num.substring(0,
						LENGTH / 2 + 1));
				leftTemp = incrementInput(leftTemp, leftTemp.length() - 1);
				leftTemp.append(new StringBuffer(leftTemp.substring(0,
						leftTemp.length() - 1)).reverse());
				result = leftTemp;
			}
		}
		return result.toString();
	}

	private static boolean findLarger(StringBuffer left, StringBuffer right) {
		left = new StringBuffer(left).reverse();
		for (int i = 0; i < left.length(); i++) {
			if (left.charAt(i) == right.charAt(i)) {
				continue;
			} else if (left.charAt(i) > right.charAt(i)) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	public static StringBuffer incrementInput(StringBuffer input, int index) {
		input = new StringBuffer(input);
		boolean loop = true;
		while (loop) {
			if (index == -1) {
				input.insert(0, '1');
				return input;
			}
			if (Character.getNumericValue(input.charAt(index)) == 9) {
				input.setCharAt(index, '0');
				index--;
			} else {

				int charNum = Character.getNumericValue(input.charAt(index)) + 1;
				input.setCharAt(index, Character.forDigit(charNum, 10));
				index--;
				loop = false;
			}
		}
		return input;
	}

}

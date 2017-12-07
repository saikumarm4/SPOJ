package classic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class P6_ArithmaticExpression {

	public static void main(String[] args) {
		try {
			BufferedReader bReader = new BufferedReader(new InputStreamReader(
					System.in));

			int count = 0;
			try {
				count = Integer.parseInt(bReader.readLine());
			} catch (NumberFormatException e) {
				// e.printStackTrace();
				return;
			} catch (IOException e) {
				// e.printStackTrace();
				return;
			}
			String expression = "";
			for (int i = 0; i < count; i++) {
				try {
					expression = bReader.readLine();
				} catch (IOException e) {
					// e.printStackTrace();
					return;
				}

				printExpression(expression);
			}

			try {
				bReader.close();
			} catch (IOException e) {
				// e.printStackTrace();
				return;
			}
		} catch (Exception e) {
			// return;
		}

	}

	private static void printExpression(String expression) {
		if (expression.contains("*")) {
			printMultiplicationExpression(expression);
		} else if (expression.contains("+")) {
			printAdditionExpression(expression);
		} else {
			printSubtractionExpression(expression);
		}

	}

	private static void printSubtractionExpression(String expression) {
		String[] operands = expression.trim().split("\\-");
		BigDecimal result = new BigDecimal(operands[0]).add(new BigDecimal(
				operands[1]).negate());

		int L1 = operands[0].length();
		int L2 = operands[1].length();
		int length = result.toPlainString().length();

		int horizontalLength = (length <= L2 + 1) ? L2 + 1 : length;

		if (L1 > L2) {
			length = L1;
		} else {
			length = L2 + 1;
		}

		System.out.printf("%" + length + "s\n", operands[0]);
		System.out.printf("%" + length + "s\n", "-" + operands[1]);
		System.out.printf(String.format(
				"%" + length + "s\n",
				String.format("%" + horizontalLength + "s", "").replace(" ",
						"-")));
		System.out.printf("%" + length + "s\n\n", result.toPlainString());
	}

	private static void printAdditionExpression(String expression) {
		String[] operands = expression.trim().split("\\+");
		BigDecimal result = new BigDecimal(operands[0]).add(new BigDecimal(
				operands[1]));
		int L2 = operands[1].length();
		int length = result.toPlainString().length();

		int horizontalLength = (length <= L2 + 1) ? L2 + 1 : length;

		if (length < L2 + 1) {
			length = L2 + 1;
		}

		System.out.printf("%" + length + "s\n", operands[0]);
		System.out.printf("%" + length + "s\n", "+" + operands[1]);
		System.out.printf(String.format(
				"%" + length + "s\n",
				String.format("%" + horizontalLength + "s", "").replace(" ",
						"-")));
		System.out.printf("%" + length + "s\n\n", result.toPlainString());
	}

	private static void printMultiplicationExpression(String expression) {
		String[] operands = expression.trim().split("\\*");
		BigDecimal operand1 = new BigDecimal(operands[0]);
		BigDecimal operand2 = new BigDecimal(operands[1]);

		int L1 = operands[0].length();
		int L2 = operands[1].length();

		StringBuffer operand2Buff = new StringBuffer(operands[1]);

		BigDecimal result = operand1.multiply(operand2);

		int length = result.toString().length();

		BigDecimal[] intemediateResult = new BigDecimal[L2];

		for (int i = L2 - 1; i >= 0; i--) {
			intemediateResult[L2 - 1 - i] = operand1.multiply(new BigDecimal(
					operand2Buff.charAt(i) + ""));
		}

		if (length < L2 + 1) {
			length = L2 + 1;
		}

		if (length < L1) {
			length = L1;
		}

		/*
		 * ----- length of number of -'s equals initialLength
		 */

		int initialLength = L2 + 1;
		if (intemediateResult[0].toPlainString().length() > initialLength) {
			initialLength = intemediateResult[0].toPlainString().length();
		}

		System.out.printf("%" + length + "s\n", operands[0]);
		System.out.printf("%" + length + "s\n", "*" + operands[1]);
		System.out
				.printf(String.format(
						"%" + length + "s\n",
						String.format("%" + initialLength + "s", "").replace(
								" ", "-")));

		for (int i = 0; i < L2; i++) {
			if (i != 0) {
				System.out.printf(
						"%" + length + "s\n",
						intemediateResult[i].toPlainString()
								+ String.format("%" + i + "s", ""));
			} else {
				System.out.printf("%" + length + "s\n",
						intemediateResult[i].toPlainString());
			}

		}
		if (L2 != 1) {
			System.out.printf(String.format("%" + length + "s\n", String
					.format("%" + result.toPlainString().length() + "s", "")
					.replace(" ", "-")));
			System.out.printf("%" + length + "s\n\n", result.toPlainString());
		} else {
			System.out.println();
		}
	}
}

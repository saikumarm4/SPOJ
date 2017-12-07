package classic;

import java.util.Scanner;
import java.util.Stack;

public class P4_ONP {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.nextLine();
		for (int i = 0; i < n; i++) {
			System.out.println(findONP(scan.nextLine().trim()));
		}
		scan.close();
	}

	private static String findONP(String input) {
		String output = "";
		Stack<Character> operators = new Stack<Character>();
		for (char ch : input.toCharArray()) {
			if (ch == '(') {
				continue;
			} else if ("+-*/^".contains(Character.toString(ch))) {
				operators.push(ch);
			} else if (ch == ')') {
				output += operators.pop();
			} else {
				output += Character.toString(ch);
			}
		}
		return output;
	}
}

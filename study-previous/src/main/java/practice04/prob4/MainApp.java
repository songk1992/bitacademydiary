package practice04.prob4;

import java.util.Stack;

public class MainApp {
	public static void main(String[] args) {
		try {
			Stack stack = new Stack();

			System.out.println("======================================");

			stack = new Stack();
			stack.push("Hello");
			stack.push("World");
			stack.push("!!!");
			stack.push("java");
			stack.push(".");

			while (!stack.isEmpty()) {
				System.out.println(stack.pop());
			}

			System.out.println("======================================");

			stack = new Stack();
			stack.push("Hello");

			System.out.println(stack.pop());
			System.out.println(stack.pop());
		} catch (RuntimeException ex) {
			System.out.println(ex.toString());
		}
	}
}

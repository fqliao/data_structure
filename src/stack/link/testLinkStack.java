package stack.link;

import java.util.Scanner;

import stack.sequence.SequenceStack;

public class testLinkStack {
	public static void main(String[] args) throws Exception {
		LinkStack stack = new LinkStack();
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < 5; i++) {
			System.out.println("输入第"+(i+1)+"个数");
			int value = scanner.nextInt();
			stack.push(value);
		}
		for (int i = 0; i < 5; i++) {
			System.out.println(stack.pop());
		}
	}
}

package stack.sequence;

import java.util.Scanner;

public class testSequenceStack {
	public static void main(String[] args) throws Exception {
		SequenceStack stack = new SequenceStack(5);
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

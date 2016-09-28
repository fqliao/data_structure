package queue.link;

import queue.Queue;
import stack.Stack;
import stack.link.LinkStack;

public class testLinkQueue {
	
	//回文算法的实现 利用队列和栈的数据结构
	public static boolean isHuiWen(String str) throws Exception{
		//创建队列和栈
		Queue<String> queue = new LinkQueue<String>();
		Stack stack = new LinkStack();
		
		//将字符串按单个字符分别进入队列和栈
		for (int i = 0; i < str.length(); i++) {
			queue.append(str.substring(i,i+1));
			stack.push(str.substring(i,i+1));
		}
		
		//出队列和出栈比较 用while循环比较好，若用for循环，则还是按次数，没有有while判断更方便 安全
		while (!queue.isEmpty() && !stack.isEmpty()) {
			if(!queue.delete().equals(stack.pop()))
			{
				return false;
			}
		}

		return true;
	}
	
	public static void main(String[] args) throws Exception {
		Queue<String> queue = new LinkQueue<String>();
		queue.append("A");
		queue.append("B");
		queue.append("C");
		queue.append("D");
		queue.delete();
		queue.delete();
		queue.delete();
		queue.append("E");
		queue.append("F");
		queue.append("G");
		queue.append("H");
		queue.append("I");
		queue.delete();
		queue.delete();

		while(!queue.isEmpty())
		{
			System.out.print(queue.delete()+" ");
		}
		
//		String str1 = "7ABCDCBA7";
//		String str2 = "ABCDBA";
//		System.out.println(isHuiWen(str1));
//		System.out.println(isHuiWen(str2));
	}
}

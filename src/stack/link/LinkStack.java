package stack.link;

import stack.Stack;

public class LinkStack implements Stack {
	
	Node head;//栈顶指针
	int count;//节点个数  计数器
	
	public LinkStack(){
		head = null;
		count = 0;
	}
	
	@Override
	public void push(Object element) throws Exception {
		head = new Node(element, head);
		count++;
	}

	@Override
	public Object pop() throws Exception {
		if(isEmpty()){
			throw new Exception("栈为空");
		}
		Object element = head.getElement();//获得栈顶元素
		head = head.getNext();//移动栈顶
		count--;//节点数减1
		return element;
	}

	@Override
	public Object getTop() throws Exception {
		if(isEmpty()){
			throw new Exception("栈为空");
		}
		return head.getElement();
	}

	@Override
	public boolean isEmpty() {
		
		return count == 0;
	}

}

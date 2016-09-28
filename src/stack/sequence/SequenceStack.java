package stack.sequence;

import stack.Stack;

public class SequenceStack implements Stack {
	
	Object[] stack;//数组实现栈结构
	int top;//栈顶位置
	int defaultSize = 5;//默认栈的长度
	int size;//栈的长度
	
	public SequenceStack() {
		init(defaultSize);
	}
	public SequenceStack(int size) {
		init(size);
	}
	public void init(int size){
		this.size = size;
		stack = new Object[this.size];
		top = 0;
	}
	@Override
	public void push(Object element) throws Exception {
		if(top>=size){
			throw new Exception("栈已满");
		}
		stack[top] = element;
		top++;
	}

	@Override
	public Object pop() throws Exception{
		if(isEmpty()){
			throw new Exception("栈为空");
		}
		top--;//top变量的值改变了
		return stack[top];
	}

	@Override
	public Object getTop() throws Exception{
		if(isEmpty()){
			throw new Exception("栈为空");
		}
		return stack[top-1];//top变量的值没变
	}

	@Override
	public boolean isEmpty() {
		return top==0;
	}

}

package queue.sequence;

import java.lang.reflect.Array;

import queue.Queue;

public class CircleQueue<T> implements Queue<T> {
	
	Object[] queue;//队列
	int rear;//队尾
	int front;//队头
	int count;//统计队列中元素的个数
	int defaultSize = 5;//队列默认大小为5
	int maxSize;//队列最大长度
	
	//默认大小创建队列
	public CircleQueue() {
		init(defaultSize);
	}
	//指定大小创建队列
	public CircleQueue(int size) {
		init(size);
	}
	private void init(int size) {
		maxSize = size;
		queue = new Object[maxSize];
		rear = 0;
		front = 0;
		count = 0;
	}

	@Override
	public void append(T element) throws Exception {
		//顺序队列因为有固定初始化大小，因此首先判断队列是否已满 链式队列不用
		if(count > 0 && rear == front){
			throw new Exception("队列已满！");
		}else{
			queue[rear] = element;
			rear = (rear+1)%maxSize; //循环用模  则不用判断 还减少重复代码
			count++;	
		}
	}

	@Override
	public T delete() throws Exception {
		Object element;
		//首先判断队列是否为空  顺序或是链式都必须判断
		if(isEmpty()){
			throw new Exception("栈为空");
		}else{
			element = queue[front];
			front = (front+1)%maxSize; //循环用模  则不用判断 还减少重复代码
			count--;
		}
		return (T) element;
	}

	@Override
	public T getFront() throws Exception {
		//首先判断队列是否为空
		if(isEmpty()){
			return null;
		}else{
			return (T) queue[front];
		}
		
	}

	@Override
	public boolean isEmpty() {
		return count == 0;
	}
	
	@Override
	public int getSize() {
		return count;
	}
	
	public static void main(String[] args) throws Exception {
		Queue<String> queue = new CircleQueue<String>();
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
//		queue.append("I");
//		queue.delete();
//		queue.delete();
//		queue.delete();
//		queue.delete();
//		queue.delete();
//		queue.delete();
		while(!queue.isEmpty())
		{
			System.out.print(queue.delete()+" ");
		}
		
	}

}

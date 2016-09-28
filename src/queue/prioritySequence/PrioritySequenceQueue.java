package queue.prioritySequence;

import queue.Queue;

public class PrioritySequenceQueue<T> implements Queue<T>{
	
	static final int defaultSize = 10;//默认的队列长度  顺序结构有固定长度
	int front;//队头
	int rear;//对尾
	int maxSize;//最大长度
	int count;//队列实际大小
	Element[] queue;//队列
	
	public PrioritySequenceQueue() {
		super();
		init(defaultSize);
	}
	public PrioritySequenceQueue(int size) {
		super();
		init(size);
	}
	public void init(int size)
	{
		this.front = this.rear = 0;
		this.maxSize = size;
		queue = new Element[this.maxSize];
		this.count = 0;
	}
	@Override
	public void append(T element) throws Exception {
		//顺序队列首先要判断是否已满
		if(count >= maxSize)
		{
			throw new Exception("队列已满！");
		}
		queue[rear] = (Element) element;
		rear++;
		count++;
	}

	@Override
	public T delete() throws Exception {
		//带有优先级队列出队体现其特点！
		//首先判断队列是否为空
		if(isEmpty())
		{
			throw new Exception("队列为空！");
		}
		Element element = queue[front];//不妨设最小优先级默认为队头
		int minIndex = front;//记录优先级最小元素的索引 以便删除
		//循环遍历队列中每个元素的优先级
		for(int i = 0;i<count;i++)
		{
			if(queue[i].getPriority() < element.getPriority())
			{
				element = queue[i];
				minIndex = i;
			}
		}
		//出队优先级最高的元素（即优先级的值最小的元素），出队即删除元素 队列实际是数组构成的
		System.arraycopy(queue, minIndex+1, queue, minIndex, count-minIndex);
		rear--;
		count--;
		return (T) element;
	}

	@Override
	public T getFront() throws Exception {
		//首先判断队列是否为空
		if(isEmpty())
		{
			throw new Exception("队列为空！");
		}
		Element element = queue[front];//不妨设最小优先级默认为队头
		int minIndex = front;//记录优先级最小元素的索引 以便删除
		//循环遍历队列中每个元素的优先级
		for(int i = 0;i<count;i++)
		{
			if(queue[i].getPriority() < element.getPriority())
			{
				element = queue[i];
				minIndex = i;
			}
		}
		return (T) element;
	}

	@Override
	public boolean isEmpty() {
		
		return count == 0;
	}

	@Override
	public int getSize() {
		
		return count;
	}

}

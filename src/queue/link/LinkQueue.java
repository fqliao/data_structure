package queue.link;

import queue.Queue;

/**
 * 链式队列
 * @author Administrator
 *
 * @param <T>
 */
public class LinkQueue<T> implements Queue<T> {
	Node front; //队头
	Node rear; //对尾
	int count; //计数器
	
	public LinkQueue()
	{
		init();
	}
	public void init()
	{
		front = rear = null;
		count = 0;
	}
	
	@Override
	public void append(T element) throws Exception {
		//创建节点，队列只有向后插，不能中间插，即队列不允许插队，因此插入的都是尾节点，指针域为空
		Node node = new Node(element,null);
		//如果当前队列不为空 设置尾节点的指针域为新节点  ===注意链式结构，没有固定大小，因此没有判断是否满的情况
		if(rear!= null)
		{
			rear.setNext(node);
		}
		//设置对尾节点为新节点 尾指针移到最后
		rear = node;

		//如果当前队列为空，则插入的节点为头节点
		if(front == null)
		{
			front = node;
		}
		count++;
	}

	@Override
	public T delete() throws Exception {
		//删除首先要判断链式队列是否为空
		if(isEmpty())
		{
			throw new Exception("链式队列为空！");
		}
		//先保存删除的节点
		Node node = front;
		front = front.getNext();
		count--;
		return (T) node.getElement();
	}

	@Override
	public T getFront() throws Exception {
		//删除首先要判断链式队列是否为空
		if(isEmpty())
		{
			return null;
		}
		else
		{
			return (T) front.getElement();
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


}

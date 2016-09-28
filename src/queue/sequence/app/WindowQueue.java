package queue.sequence.app;

import queue.Queue;
import queue.sequence.CircleQueue;

//卖票窗口
public class WindowQueue {
  
  //卖票的队列	
  int maxSize =10;
  Queue queue = new CircleQueue(maxSize);
  int num=0; //统计卖票的数量，一天最多卖100张票。
  boolean isAlive = true; //判断是否继续卖票。
  
  //排队买票
  public synchronized void producer() throws Exception
  {
	if(queue.getSize() < maxSize)
	{
		queue.append(num++); //等待买票的数量加1
		System.out.println("第"+num+"个客户排队等待买票！");
		this.notifyAll();//唤醒卖票的线程
	}
	else
	{
		try
		{
			System.out.println("队列已满...请等待！");
			this.wait();//队列满时，排队买票线程等待。
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
  }
  
  //卖票
  public synchronized void consumer() throws Exception
  {
	if(queue.getSize() > 0)
	{
		Object obj = queue.delete();
		int temp = Integer.parseInt(obj.toString());
		System.out.println("第"+(temp+1)+"个客户买到票离开队列！");
		//如果当前队列为空，并且卖出票的数量大于等于100，说明卖票结束
		if(queue.isEmpty() && this.num>=100)
		{
			this.isAlive = false;
		}
		this.notifyAll(); //唤醒排队买票的线程。
	}
	else
	{
		try
		{
			System.out.println("队列已空...请等待！");
			this.wait();//队列空时，卖票线程等待。
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
  }
}

package queue.sequence.app;

//卖票者
public class Consumer implements Runnable {

	WindowQueue queue ;
  
	public Consumer(WindowQueue queue)
	{
		this.queue = queue;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
	   while(queue.isAlive)
	   {
		   try
		   {
			   queue.consumer();
		   }
		   catch(Exception ex)
		   {
			   ex.printStackTrace();
		   }
	   }
	}
	
}

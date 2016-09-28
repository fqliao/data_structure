package queue.sequence.app;

//买票者
public class Producer implements Runnable {
 
	WindowQueue queue ;
	public Producer(WindowQueue queue)
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
			   queue.producer();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
	}
	
}

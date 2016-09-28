package queue.sequence.app;

public class Test {
	
	
	public static void main(String[] args) {
		WindowQueue queue = new WindowQueue();
		//注意一定要传同一个窗口对象
		Producer p = new Producer(queue);
		Consumer c = new Consumer(queue);
		
		//排队买票线程
		Thread pThread = new Thread(p);
		//卖票线程
		Thread cThread = new Thread(c);

		pThread.start(); //开始排队买票
		cThread.start();  //开始卖票
	}

}

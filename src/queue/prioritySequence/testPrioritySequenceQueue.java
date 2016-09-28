package queue.prioritySequence;

import queue.Queue;

public class testPrioritySequenceQueue {

	public static void main(String[] args) throws Exception {
		
	       Queue queue = new PrioritySequenceQueue();
	       Element temp;
     
	       //五个进程入队
	       queue.append(new Element(1,30));
	       queue.append(new Element(2,20));
	       queue.append(new Element(3,40));
	       queue.append(new Element(4,20));
	       queue.append(new Element(5,0));
	       
	       //按照优先级出队。
	       System.out.println("编号  优先级");
	       while(!queue.isEmpty())
	       {
	    	   temp =(Element)queue.delete();
	    	   System.out.println(temp.getElement()+" "+temp.getPriority());
	       }

	}

}

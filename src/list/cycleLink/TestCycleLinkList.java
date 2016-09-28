package list.cycleLink;

public class TestCycleLinkList {

	public static void main(String[] args) throws Exception {
		CycleLinkList<Integer> linkList = new CycleLinkList<Integer>();
		for (int i = 0; i < 5; i++) {
			linkList.add(i, ((int)(Math.random()*100))%100);
		}
		for (int i = 0; i < linkList.getSize(); i++) {
			System.out.print(linkList.get(i)+" ");
		}
		System.out.println("\n=====");
		linkList.delete(1);
		linkList.update(1, 5);
		linkList.add(1, 4);
		for (int i = 0; i < linkList.getSize(); i++) {
			System.out.print(linkList.get(i)+" ");
		}
	}

}

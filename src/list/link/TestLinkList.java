package list.link;

public class TestLinkList {

	public static void main(String[] args) throws Exception {
		LinkList<String> linkList = new LinkList<String>();
//		for (int i = 0; i < 5; i++) {
//			linkList.add(i, ((int)(Math.random()*100))%100);
//		}
		linkList.add(0, "A");
		linkList.add(1, "B");
		linkList.add(2, "C");
		linkList.add(3, "D");
		linkList.add(4, "E");
//		linkList.add(5, "E");
//		linkList.add(6, "E");  //如果第五个节点不插 直接插入第六个是不可以的，越界，不是说大小固定 而是只能连续插入，不能中间空着往后面插

		linkList.printPre();
		System.out.println("\n=====");
		linkList.delete(1);
		linkList.update(1, "F");
		linkList.add(1, "G");
		linkList.printPre();
		System.out.println();
		System.out.println(linkList.find("F"));
		linkList.printPre();
		System.out.println();
		linkList.printPos();
	}

}

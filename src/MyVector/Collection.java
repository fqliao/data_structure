package MyVector;

public interface Collection {
	//在指定位置添加
	public void add(int index,Object element) throws Exception;
	//在集合末端添加
	public void add(Object element) throws Exception;
	//在指定位置设置元素
	public void set(int index,Object element) throws Exception;
    //获得指定位置的元素
	public Object get(int index) throws Exception;
	//获得集合大小
	public int size();
	//在指定位置删除
	public void removeByIndex(int index) throws Exception;
	//删除指定对象
	public void remove(Object element) throws Exception;
	//是否包含指定对象
	public boolean contain(Object element) throws Exception;
}

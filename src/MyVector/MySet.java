package MyVector;

public class MySet {
	
	private MyVector v;
	
	public MySet() {
		v = new MyVector();
	}
	public MySet(int size) {
		v = new MyVector(size);
	}

	//1 添加对象
	public void add(Object element) throws Exception{
		//不允许添加空对象
		if(element == null){
			return;
		}
		if(contain(element)){//集合不允许有相同的元素出现
			return;
		}
		v.add(element);
	}
	
	//2 删除对象
	public void remove(Object element) throws Exception{
		v.remove(element);
	}
	
	//3 判断元素是否属于集合
	public boolean contain(Object element) throws Exception{
		return v.contain(element);
	}
	
	//4 判断集合的包含关系
	public boolean include(MySet otherSet) throws Exception{
		if(otherSet == null){
			return true;
		}
		for (int i = 0; i < otherSet.size(); i++) {
			if(!v.contain(otherSet.v.get(i))){
				return false;
			}
		}
		return true;
	}
	
	//5 判断相等关系
	public boolean equal(MySet otherSet) throws Exception{
		if(this.include(otherSet) && otherSet.include(this)){
			return true;
		}else{
			return false;
		}
	}
	
	//6 集合元素个数
	public int size(){
		return v.size();
	}
	
	//7 集合是否为空
	public boolean isEmpty(){
		if(size() == 0){
			return true;
		}else{
			return false;
		}
	}
	@Override
	public String toString() {
		return v.toString() ;
	}
	
	
}

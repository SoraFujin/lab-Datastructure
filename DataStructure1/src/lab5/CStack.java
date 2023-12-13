package lab5;

public class CStack<T extends Comparable<T>> implements Stackable<T> {
	Cursor<T> cursor = new Cursor<>();
	int list;
	public CStack(int capacity) {
		list = cursor.createList();
	}
	
	@Override
	public void push(T data) {
		cursor.insertAtHead(data, list);
		
	}
	@Override
	public T Pop() {
		return (T) cursor.delete(null, list);
	}
	@Override
	public T peek() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	

}

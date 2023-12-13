package lab5;

public class LinkedStack<T extends Comparable<T>> implements Stackable<T> {
	LinkedList<T> list = new LinkedList<>();

	@Override
	public void push(T data) {
		list.addAtHead(data);

	}

	@Override
	public T Pop() {
		return list.deleteAtHead();
	}

	@Override
	public T peek() {
		list = new LinkedList<>();
		if (!isEmpty()) {
			return list.getHead().getData();
		}
		return null;
	}

	@Override
	public boolean isEmpty() {
		return (list.getHead() == null);
	}

	@Override
	public void clear() {
		list.setHead(null);
	}

}

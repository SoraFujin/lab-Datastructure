package lab5;



public class Node<T extends Comparable<T>> {
	private T data;
	private Node<T> next;
	private int cursor;
	
	public Node(T data, Node<T> next) {
		this.data = data;
		this.next = next;
	}
	
	public Node(T data, int cursor) {
		this.data = data;
		this.cursor = cursor;
	}
	
	public int getCursor() {
		return cursor;
	}

	public void setCursor(int cursor) {
		this.cursor = cursor;
	}

	public Node (T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + "]";
	}
}

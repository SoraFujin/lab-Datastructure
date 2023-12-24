package lab6;

public class LQueue<T extends Comparable<T>> implements Queueable<T> {
	private Node<T> back;

	@Override
	public void enqueue(T data) {
		Node<T> newNode = new Node<>(data);
		if (isEmpty()) {
			back = newNode;
			back.setNext(back);
		} else {
			newNode.setNext(back.getNext());
			back.setNext(newNode);
			back = newNode;
		}
	}

	@Override
	public T dequeue() {
		if (!isEmpty()) {
			T data = back.getNext().getData();
			if (back == back.getNext()) {
				back = null;
			} else {
				back.setNext(back.getNext().getNext());
			}
			return data;
		}
		return null;
	}

	@Override
	public T getFront() {
		if (!isEmpty())
			return back.getNext().getData();
		return null;
	}

	@Override
	public T pop() {
		if (!isEmpty()) {
			T data = back.getData();
			if (back.getNext() == back) {
				back = null;
			} else {
				Node<T> current = back.getNext();
				while (current.getNext() != back)
					current = current.getNext();
				current.setNext(back.getNext());
				back = current;
			}
			return data;
		}
		System.out.println("Queue is empty");
		return null;
	}

	@Override
	public boolean isEmpty() {
		return back == null;
	}

	@Override
	public void clear() {
		back = null;
	}
	
}

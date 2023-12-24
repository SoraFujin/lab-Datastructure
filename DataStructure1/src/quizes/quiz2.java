package quizes;

public class quiz2<T extends Comparable<T>> implements XQueueInterferface<T> {

	private T[] queueArray;
	private int first;
	private int tail;
	private int maxSize;
	private int size;

	public quiz2(int maxSize) {
		this.maxSize = maxSize;
		queueArray = (T[]) new Object[maxSize];
		first = 0;
		tail = -1;
		size = 0;
	}

	@Override
	public void enqueue(T data) {
		// TODO Auto-generated method stub

	}

	@Override
	public T dequeue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T getFront() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T pop() {
		if (!isEmpty()) {
			T temp = queueArray[first];
			first = (first + 1) % maxSize;
			size--;
			return temp;
		}
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

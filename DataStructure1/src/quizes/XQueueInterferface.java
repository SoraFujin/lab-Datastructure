package quizes;

public interface XQueueInterferface<T> {
	void enqueue(T data);

	T dequeue();
	
	T getFront();
	
	T pop();
	
	boolean isEmpty();

	void clear();
}

package lab6;

public interface Queueable<T> {
	void enqueue(T data);

	T dequeue();
	
	T getFront();
	
	T pop();
	
	boolean isEmpty();

	void clear();
}

package lab5;

public interface Stackable<T> {
	
	void push(T data);

	T Pop();
	
	T peek();
	
	boolean isEmpty();
	
	void clear();

	

}

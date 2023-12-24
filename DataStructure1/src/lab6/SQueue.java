package lab6;

import java.util.Stack;

public class SQueue<T extends Comparable<T>> implements Queueable<T> {
	Stack<T> stack = new Stack<T>();

	@Override
	public void enqueue(T data) {
		Stack<T> temp = new Stack<T>();
		while (!stack.isEmpty())
			temp.push(stack.pop());
		stack.push(data);
		while (!temp.isEmpty())
			stack.push(temp.pop());
	}

	@Override
	public T dequeue() {
		if (!isEmpty())
			return stack.pop();
		return null;
	}

	@Override
	public boolean isEmpty() {
		return stack.isEmpty();
	}

	@Override
	public T getFront() {		
		return stack.peek();
	}

	@Override
	public T pop() {
		return null;
	}

	@Override
	public void clear() {
		stack.clear();

	}
}

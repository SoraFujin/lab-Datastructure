package lab3;

public class CLinkList<T extends Comparable<T>> {

	private Node<T> head;

	public void addAtHead(T data) {
		Node<T> node = new Node<>(data);
		if (head == null) {
			head = node;
			node.setNext(head);
		} else {
			node.setNext(head);
			Node<T> current = head;
			while (current.getNext() != head) {
				current = current.getNext();
			}
			head = node;
			current.setNext(head);
		}
	}

	public void insertSorted(T data) {
		Node<T> newNode = new Node(data);
		if (head == null) {
			head = newNode;
			head.setNext(head);
		} else {
			Node<T> current = head;
			Node<T> prev = null;

			do {
				prev = current;
				current = current.getNext();
			} while (current != head && data.compareTo(current.getData()) > 0);
			prev.setNext(newNode);
			newNode.setNext(current);

			if (data.compareTo(newNode.getData()) < 0) {
				head = newNode;
			} else if (current == head) {
				prev.setNext(newNode);
				newNode.setNext(head);
			}
		}
	}

	public void traverse() {
		if (head == null) {
			System.out.println("List is empty");
			return;
		}

		Node<T> current = head;
		do {
			System.out.print(current.getData() + " ");
			current = current.getNext();
		} while (current != head);
		System.out.println();
	}

	public Node<T> search(T data) {
		return searchRecursive(head, data);
	}

	private Node<T> searchRecursive(Node<T> current, T data) {
		if (current == null) {
			return null;
		}
		if (current.getData().equals(data)) {
			return current;
		} else {
			if (current.getNext() != head)
				return searchRecursive(current.getNext(), data);
			else
				return null;
		}
	}

	public Node<T> delete(T data) {
		// in the delete method there are 4 cases,
		// 1. if there is only one element in the linked list
		// 2. if the element is the first element but not the only element
		// 3. if the element is at the end of the list
		// 4. if the element is in the middle of the list
		Node<T> current = head;
		Node<T> prev = null;

		while (current != null && !current.getData().equals(data)) {
			prev = current;
			current = current.getNext();
		}
		if (current == null)
			return null;

		if (current == head)
			head = (current.getNext() == head) ? null : current.getNext();
		else
			prev.setNext((current.getNext() == head) ? head : current.getNext());

		return current;
	}

	public void reverse() {
		if (head == null || head.getNext() == head)
			return;

		Node<T> prev = null;
		Node<T> current = head;
		Node<T> next;

		do {
			next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
		} while (current != null && current != head);

		head.setNext(prev);
		head = prev;
	}

}

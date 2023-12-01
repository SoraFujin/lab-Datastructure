package quizes;

class ArrayLinkedList {
	quiz1Online[] arrayLinkedList;
	int size;

	public ArrayLinkedList(int size) {
		this.size = size;
		arrayLinkedList = new quiz1Online[size];
		for (int i = 0; i < size; i++) {
			arrayLinkedList[i] = new quiz1Online();
		}
	}

	public void insert(int index, int data) {
		if (index < 0 || index >= size) {
			System.out.println("Index out of range");
			return;
		}
		arrayLinkedList[index].insert(data);
	}

	public int length(int index) {
		if (index < 0 || index >= size) {
			System.out.println("Index out of range");
			return -1;
		}
		int count = 0;
		Node current = arrayLinkedList[index].head;
		while (current != null) {
			count++;
			current = current.next;
		}
		return count;
	}

	public void display() {
		for (int i = 0; i < size; i++) {
			System.out.print("Linked List at index " + i + ": ");
			arrayLinkedList[i].display();
		}
	}
}

package lab5;

public class Cursor<T extends Comparable<T>> {
	Node<T>[] cursorArray;

	public int initialization() {
		for (int i = 0; i < cursorArray.length - 1; i++) {
			cursorArray[i] = new Node<>(null, i + 1);
		}
		cursorArray[cursorArray.length - 1] = new Node<>(null, 0);
		return 0;
	}

	public int malloc() {
		int p = cursorArray[0].getCursor();
		cursorArray[0].setNext(cursorArray[p].getNext());
		return p;
	}

	public void free(int p) {
		cursorArray[p] = new Node<>(null, cursorArray[0].getNext());
		cursorArray[0].setCursor(p);
	}

	public boolean isNull(int l) {
		return cursorArray[l] == null;
	}

	public boolean isEmpty(int l) {
		return cursorArray[l].getCursor() == 0;
	}

	public boolean isLast(int p) {
		return cursorArray[p].getCursor() == 0;
	}

	public int createList() {
		int l = malloc();
		if (l == 0)
			System.out.println("Error: Out of space!!!");
		else
			cursorArray[l] = new Node<T>((T) "-", 0);
		return l;
	}

	public void insertAtHead(T data, int l) {
		if (isNull(l)) // list not created
			return;
		int p = malloc();
		if (p != 0) {
			cursorArray[p] = new Node<>(data, cursorArray[l].getNext());
			cursorArray[l].setCursor(p);
		} else
			System.out.println("Error: Out of space!!!");
	}

	public void traversList(int l) {
		System.out.print("list_" + l + "-->");
		while (!isNull(l) && !isEmpty(l)) {
			l = cursorArray[l].getCursor();
			System.out.print(cursorArray[l] + "-->");
		}
		System.out.println("null");
	}

	public int find(T data, int l) {
		while (!isNull(l) && !isEmpty(l)) {
			l = cursorArray[l].getCursor();
			if (cursorArray[l].getData().equals(data))
				return l;
		}
		return -1; // not found
	}

	public int findPrevious(T data, int l) {
		while (!isNull(l) && !isEmpty(l)) {
			if (cursorArray[cursorArray[l].getCursor()].getData().equals(data))
				return l;
			l = cursorArray[l].getCursor();
		}
		return -1; // not found
	}

	public Node<T> delete(T data, int l) {
		int p = findPrevious(data, l);
		if (p != -1) {
			int c = cursorArray[p].getCursor();
			Node<T> temp = cursorArray[c];
			cursorArray[p].setNext(temp.getNext());
			free(c);
		}
		return null;
	}
}

package Lab4;

import java.util.ArrayList;
import java.util.Collection;

public class DoublyLinkedList<T extends Comparable<T>> {
	private DNode<T> head = new DNode<>(null);

	public void inseretAtHead(T data) {
		DNode<T> newNode = new DNode<>(data);
		if (head.getNext() != null)
			head.getNext().setPrev(newNode);

		newNode.setPrev(head);
		newNode.setNext(head.getNext());
		head.setNext(newNode);

	}

	public void inseretLast(T data) {
		DNode<T> newNode = new DNode<>(data);
		DNode<T> current = head;

		while (current.getNext() != null)
			current = current.getNext();

		newNode.setPrev(current);
		current.setNext(newNode);

	}

	public void insertSorted(T data) {
		DNode<T> newNode = new DNode<>(data);
		DNode<T> current = head;

		while (current.getNext() != null) {
			if (current.getNext().getData().compareTo(data) > 0) {
				newNode.setNext(current.getNext());
				newNode.setPrev(current);
				current.setNext(newNode);
				return;
			}
			current = current.getNext();
		}
		current.setNext(newNode);
		newNode.setPrev(current);
	}

	public void deleteSorted(T data) {
		DNode<T> current = head;
		while (current.getNext() != null) {
			if (current.getNext().getData().compareTo(data) == 0) {
				DNode<T> nextNode = current.getNext().getNext();
				current.setNext(nextNode);
				if (nextNode != null) {
					nextNode.setPrev(current);
				}
			} else {
				current = current.getNext();
			}
		}
	}

	public void traverse() {
		DNode<T> current = head.getNext();
		while (current != null) {
			System.out.print(current.getData() + " -> ");
			current = current.getNext();
		}
	}

	// post lab:
	// Q1: Remove duplicated, 2 ways recursive and iterative:
	// Q2: Radix Sort method

	// Q1: iterative method:
	public void removeDuplicateIterative(T data) {
		DNode<T> current = head;

		if (current == null || current.getNext() == null) {
			System.out.println("List is empty or has only one node");
			return;
		}

		while (current.getNext() != null) {
			if (current.getNext().getData().equals(data)) {
				DNode<T> temp = current.getNext();
				if (temp.getNext() != null && temp.getData().equals(temp.getNext().getData())) {
					DNode<T> nextNode = temp.getNext().getNext();
					current.setNext(nextNode);
					if (nextNode != null) {
						nextNode.setPrev(current);
					}
				} else {
					current = current.getNext();
				}
			} else {
				current = current.getNext();
			}
		}
	}

	// Q1: recursive method:
	public void removeDuplicates() {
		if (head == null || head.getNext() == null) {
			return; // No nodes or only one node in the list
		}
		removeDuplicatesRecursive(head.getNext());
	}

	private void removeDuplicatesRecursive(DNode<T> current) {
		if (current == null || current.getNext() == null) {
			return;
		}

		if (current.getData().equals(current.getNext().getData())) {
			DNode<T> nextNode = current.getNext().getNext();
			current.setNext(nextNode);
			if (nextNode != null) {
				nextNode.setPrev(current);
			}
			removeDuplicatesRecursive(current);
		} else {
			removeDuplicatesRecursive(current.getNext());
		}
	}

	// Q2: Radix Sort:
	public void radixSort(DNode<Integer> head) {
	    if (head == null || head.getNext() == null) {
	        return;
	    }

	    int maxDigits = getMaxDigits(head.getNext());

	    for (int digitPlace = 1; digitPlace <= maxDigits; digitPlace++) {
	        head.setNext(countingSort(head.getNext(), digitPlace));
	    }
	}

	private int getMaxDigits(DNode<Integer> head) {
	    int maxDigits = 0;
	    DNode<Integer> current = head;

	    while (current != null) {
	        int numDigits = (int) Math.log10(Math.abs(current.getData())) + 1;
	        maxDigits = Math.max(maxDigits, numDigits);
	        current = current.getNext();
	    }
	    return maxDigits;
	}

	private DNode<Integer> countingSort(DNode<Integer> head, int digitPlace) {
	    final int RADIX = 10;
	    ArrayList<DNode<Integer>> count = new ArrayList<>();

	    for (int i = 0; i < RADIX; i++) {
	        count.add(null);
	    }

	    DNode<Integer> current = head;

	    while (current != null) {
	        int digit = getDigitAtPlace(current.getData(), digitPlace);
	        DNode<Integer> next = current.getNext();

	        current.setPrev(null);
	        current.setNext(null);

	        if (count.get(digit) == null) {
	            count.set(digit, current);
	        } else {
	            DNode<Integer> temp = count.get(digit);
	            while (temp.getNext() != null) {
	                temp = temp.getNext();
	            }
	            temp.setNext(current);
	            current.setPrev(temp);
	        }

	        current = next;
	    }

	    DNode<Integer> newHead = null;
	    DNode<Integer> tail = null;

	    for (DNode<Integer> node : count) {
	        while (node != null) {
	            if (newHead == null) {
	                newHead = node;
	            } else {
	                tail.setNext(node);
	                node.setPrev(tail);
	            }
	            tail = node;
	            node = node.getNext();
	        }
	    }
	    return newHead;
	}

	private int getDigitAtPlace(int number, int place) {
	    return (number / (int) Math.pow(10, place - 1)) % 10;
	}


	// setters and getters
	public DNode<T> getHead() {
		return head;
	}

	public void setHead(DNode<T> head) {
		this.head = head;
	}

}

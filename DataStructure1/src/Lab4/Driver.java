package Lab4;

public class Driver<T extends Comparable<T>> {
	
	
	public static void main(String[] args) {
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
		list.inseretAtHead(10);
		list.inseretAtHead(20);
		list.inseretAtHead(60);
	//	list.inseretAtHead(100);
		
		list.inseretLast(30);
		list.inseretLast(90);
		list.inseretLast(40);
		list.inseretLast(20);
		list.inseretLast(200);
		System.out.println("the list before radix sort: ");
		list.traverse();
		System.out.println();
		System.out.println("Radix sort: ");
		list.radixSort(list.getHead());
		list.traverse();
		System.out.println();
		
		
//		list.insertSorted(10);
//		list.insertSorted(7);
//		list.insertSorted(5);
//		list.insertSorted(2);
//		list.insertSorted(6);
//		list.insertSorted(6);
//		list.insertSorted(6);
//		list.insertSorted(6);
//		list.insertSorted(6);
//		list.insertSorted(10);
//		list.insertSorted(10);
//		list.insertSorted(10);
//		list.insertSorted(10);
//		list.insertSorted(10);
//	
//		System.out.println("original list");
//		list.traverse();
//		System.out.println();
		
		//list.removeDuplicateIterative();
		//removing duplicates:
		System.out.println("removing the duplicates: ");
		list.removeDuplicates();
		list.traverse();
		System.out.println();
		
		//delete at last
		System.out.println("---------- \n" + "deleting:");
		System.out.println("last node (200)");
		list.deleteSorted(200);
		list.traverse();
		System.out.println();
		
		//delete between nodes:
		System.out.println("between nodes(40)");
		list.insertSorted(200);
		list.deleteSorted(40);
		list.traverse();
		System.out.println();
		
		//delete first:
		System.out.println("first(10)");
		list.insertSorted(40);
		list.deleteSorted(10);
		list.traverse();
		System.out.println();
		
		list.insertSorted(10);
		System.out.println("list");
		list.traverse();
		System.out.println();
		
		
	}

}

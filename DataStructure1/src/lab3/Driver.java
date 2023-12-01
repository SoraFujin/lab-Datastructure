package lab3;

public class Driver {

	public static void main(String[] args) {
		CLinkList<Integer> list = new CLinkList<>();
		// adding at the head of the list:
		 list.addAtHead(10);
		 list.addAtHead(90);
		 list.addAtHead(60);
		 list.addAtHead(20);
		 list.addAtHead(40);

		// sorted elements:
		// list.insertSorted(10);
		// list.insertSorted(90);
		// list.insertSorted(60);
		// list.insertSorted(20);
		// list.insertSorted(40);

		// System.out.println("sorted list: ");
		// list.traverse();
		// System.out.println("-----------");
		// list.delete(40);
		// list.traverse();

		 System.out.println("original list:");
		 list.traverse();
		 System.out.println("-----------");
		 System.out.println("reversed list:");
		 list.reverse();
		 list.traverse();
		 list.reverse();
		 System.out.println("-----------");
		 System.out.println("search method test:");
		 System.out.println("searching for an existing element: \n" + list.search(60));
		 System.out.println("searching for an element that is not in the list: \n" + list.search(0));
		 System.out.println("-----------");		 
		 list.delete(40);
		 list.traverse();
	}

}

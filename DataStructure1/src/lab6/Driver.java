package lab6;

public class Driver {
	public static void main(String[] args) {
		LQueue<Integer> q = new LQueue<>();
		SQueue<Integer> s = new SQueue<>();
		
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
				
//		System.out.println(q.dequeue());
//		System.out.println(q.dequeue());
//		System.out.println(q.dequeue());
//		System.out.println(q.dequeue());
//		System.out.println(q.dequeue());
//		System.out.println(q.dequeue());
//		System.out.println(q.pop());
//		System.out.println(q.pop());
//		System.out.println(q.pop());
//		System.out.println(q.pop());
//		System.out.println(q.pop());
//		System.out.println(q.pop());
		
		s.enqueue(1);
		s.enqueue(2);
		s.enqueue(3);
		s.enqueue(4);
		s.enqueue(5);		
		System.out.println(s.dequeue());
		System.out.println(s.dequeue());
		System.out.println(s.dequeue());
		System.out.println(s.dequeue());
		System.out.println(s.dequeue());
		System.out.println(s.dequeue());
	}

}

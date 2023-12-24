package lab6;

import java.util.Random;

public class QueueSimulation {

	static Random rand = new Random();
	static SQueue<Integer> squeue = new SQueue<Integer>();

	public static void main(String[] args) {
		int totalCustomers = 0;
		int waitingTotal = 0;
		int maxWaited = 0;
		for (int m = 1; m <= 1440; m++) {
			totalCustomers++;

			if (!squeue.isEmpty()) {
				int waitingTime = m - squeue.dequeue();
				waitingTotal += waitingTime;
				if (waitingTime > maxWaited)
					maxWaited = waitingTime;
			}

			int random = rand.nextInt(4);
			switch (random) {
			case 1:
				squeue.enqueue(m);
				break;
			case 2:
				squeue.enqueue(m);
				squeue.enqueue(m);
				break;
			}

			switch (m) {
			case 30:
			case 60:
			case 120:
			case 480:
				System.out.println("Avarage wating times " + m + " minutes is: "
						+ (double) waitingTotal / totalCustomers + " minutes.");
				System.out.println(
						"Total  served after " + m + " minutes is: " + totalCustomers + ".");
				System.out.println(
						"Combined time waited " + m + " minutes is: " + waitingTotal);
				System.out.println(
						"Max time waited " + m + " minutes is: " + maxWaited + " minutes");
				break;
			}
		}
		System.out.println("Average waiting time for every customer is: "
				+ (double) waitingTotal / totalCustomers + " minutes.");
		System.out.println("Customers served: " + totalCustomers + ".");
		System.out.println("Combined time waited: " + waitingTotal);
		System.out.println("The max time waited for a customer: " + maxWaited + " minutes");
	}

}

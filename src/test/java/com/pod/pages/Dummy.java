package com.pod.pages;

public class Dummy {

	public static void main(String[] args) {
		int sizeOfStops = 5;
		
		/* */
		

		for (int i = 1; i <= sizeOfStops; i++) {
			if (i != sizeOfStops && i<sizeOfStops) {
				System.out.print("Size = " + sizeOfStops);
				System.out.println("\ti = " + i);
				sizeOfStops--;
			}
		}

	}

}

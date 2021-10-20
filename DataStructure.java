package com.gl.ds;

import java.util.Scanner;
import java.util.Stack;

public class DataStructure {

	static void floorSizeDays(int[] array, int floors) {
		// base condition

		int a = floors;
		if (floors == 0) {
			System.out.println("No floors mentioned");
			return;
		}

		else {
			System.out.println("The order of construction is as follows");
			Stack<Integer> st = new Stack<>();
			for (int i = 0; i < a; i++) {
				if (array[i] == floors) {
					System.out.println("Day " + (i + 1) + "\n" + array[i]);
					floors--;
					floors = checkStack(st, floors);
				} else {
					System.out.println("Day " + (i + 1));
					if (!st.empty() && st.peek() < array[i]) {
						st.push(array[i]);
					} else {
						st.push(array[i]);
						st = sortstack(st);
					}
				}
			}
		}

	}

	static int checkStack(Stack<Integer> input, int num) {
		if (!input.empty() && input.peek() == num) {
			int b = input.pop();
			System.out.println(b);
			num--;
			checkStack(input, num);
		}

		return num;
	}

	public static Stack<Integer> sortstack(Stack<Integer> input) {
		Stack<Integer> tmpStack = new Stack<Integer>();
		while (!input.isEmpty()) {
			int tmp = input.pop();
			while (!tmpStack.isEmpty() && tmpStack.peek() > tmp) {

				input.push(tmpStack.pop());
			}
			tmpStack.push(tmp);
		}
		return tmpStack;
	}

	public static void main(String[] args) {

		Scanner obj = new Scanner(System.in);
		int[] list;
		System.out.println("Enter the total no of floors in the building");
		int size = obj.nextInt();
		list = new int[size];

		for (int i = 0; i < size; i++) {
			System.out.println("Enter the floor size given on day : " + (i + 1));
			list[i] = obj.nextInt();
		}

		floorSizeDays(list, size);

		obj.close();
	}
}

/*
Title: Parallel Arrays 5.6
Name: Angie Seto
Date Created: May 5, 2026
Date Updated: May 6, 2026 */

import java.util.Arrays;

public class PracticeProblem {

	public static void main(String args[]) {

		String[] names = {"Bev", "Ged", "Zed"};
		int[] ages = {12, 10, 27};

		System.out.println(getAge(names, ages, "Zed"));
	
		// System.out.println(swapPeople(names, ages, "Zed", "Bev"));
	}

	//q1
	public static int getAge (String[] names, int[] ages, String name) {
		
		int count = 0;
		int age; 

		for (int i = 0; i < names.length; i++) {
			if (!(names[i].matches(name))) {
				count++;
			}
			else {
				i = names.length;
			}
		}
		age = ages[count];
		return age;
	}

	//q2
	public static int[] createLengthArray (String[] arr) {
	
		int length;
		int[] arr2 = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			length = arr[i].length();
			arr2[i] = length;
		}
		return arr2;
	}

	//q3
	public static void swapPeople (String[] names, int[] ages, String name, String nameTwo) {
		int count = 0;
		int age = 0; 
		int age2 = 0;

		for (int i = 0; i < names.length; i++) { //find index of name
			if (!(names[i].matches(name))) { //match name 1
				count++;
			}
			else {
				age = count;
				i = names.length; //stop loop
				count = 0; //clear count
			} 
		}

		for (int b = 0; b < names.length; b++) { //find index of name 2
			if (!(names[b].matches(nameTwo))) { //match name 2
				count++;
			}
			else {
				age2 = count;
				b = names.length; //stop loop
			}
		} //end of name search

		int tempAge = ages[age];
		String tempName = names[age]; 

		ages[age] = ages[age2]; //age2 -> age 1
		names[age] = names[age2]; //name2 -> name 1

		ages[age2] = tempAge; //age 1 -> age 2
		names[age2] = tempName; // name 1 -> name 2
	}

}


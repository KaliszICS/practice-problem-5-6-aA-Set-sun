
class Notes {
	public static void main(String[] args) {

		

		

		String names[] = new String[5];
		int ages[] = new int[names.length]; //the two arrays HAVE to have the same length.

		names[0] = "Kevin";
		names[1] = "Helen";
		names[2] = "Fred";
		names[3] = "George";
		names[4] = "Harry";

		ages[0] = 15; //Kevin
		ages[1] = 20; //Helen
		ages[2] = 53; //Fred
		ages[3] = 99; //George
		ages[4] = 12; //Harry

		int index = 2;
		String value = "Brad";
		int age = -1;
		
		//iterating through parallel arrays

		for (int i = 0; i < names.length; i++) {
			System.out.println(names[i] + ": " + ages[i]);
		}
		
		//modifying or anything you do in parallel arrays needs to be done to both

		//remove the last element from both arrays

		//Creating arrays to use temporary to remove an element, I need to do it for all arrays that are parallel
		String[] namesCopy = new String[names.length - 1];
		int[] agesCopy = new int[ages.length - 1];

		for (int i = 0; i < namesCopy.length; i++) { //edit both arrays, not just one
			namesCopy[i] = names[i];
			agesCopy[i] = ages[i];
		}

		//replace both arrays, not just one
		names = namesCopy;
		ages = agesCopy;

		for (int i = 0; i < names.length; i++) {
			System.out.println(names[i] + ": " + ages[i]);
		}

		System.out.println(names[index] + " " + ages[index]);

		for (int i = 0; i < names.length; i++) {
			if (value.equals(names[i])) {
				age = ages[i];
			}
		}

		System.out.println(value + " " + age);

		//Swapping in parallel arrays

		int temp;

		temp = ages[2];
		ages[2] = ages[0];
		ages[0] = temp;

		//Need to the same swap to our other array

		String temp1;

		temp1 = names[2];
		names[2] = names[0];
		names[0] = temp1;

		//Swapped the values at index 0 and index 4 for both arrays, so the values are still parallel.

		for (int i = 0; i < names.length; i++) {
			System.out.println("Name: " + names[i]);
			System.out.println("Age: " + ages[i]);
		}


	}
}

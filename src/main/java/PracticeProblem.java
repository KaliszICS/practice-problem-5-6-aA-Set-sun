public class PracticeProblem {

	public static void main(String args[]) {

	}

	//q1
	public static int getAge (String[] names, int[] ages, String name) {
		
		int count = 0;
		int age = 0; 

		for (int i = 0; i < names.length; i++) {
			if (!(names[i].matches(name))) {
				count++;
			}
			else {
				ages[count] = age;
				return age;
			}
		}
		ages[count] = age;
		return age;

	}

	//q2
	/*public static int[] createLengthArray (String[] arr) {
	
	} */

	//q3
	/* public static swapPeople (String[] names, int[] ages, String name, String name2) {
	
	}*/

}


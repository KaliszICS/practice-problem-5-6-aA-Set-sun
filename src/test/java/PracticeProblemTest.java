import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import java.lang.reflect.Method;

class PracticeProblemTest {

   // --- getAge() Robust Tests ---

   @Test
   @DisplayName("getAge should find the name at the very end of the arrays")
   void getAgeTest_LastElement() {
      Class<?> testClass = PracticeProblem.class;
      try {
         String[] names = {"Alice", "Bob", "Charlie", "Zed"};
         int[] ages = {20, 30, 40, 50};
         Class<?>[] cArg = { String[].class, int[].class, String.class };
         Method method = testClass.getDeclaredMethod("getAge", cArg);
         assertEquals(50, (int) method.invoke(null, names, ages, "Zed"));
      } catch (Exception e) { fail("Test failed: " + e); }
   }

   @Test
   @DisplayName("getAge should handle duplicate names by returning the first occurrence")
   void getAgeTest_DuplicateNames() {
      Class<?> testClass = PracticeProblem.class;
      try {
         String[] names = {"Alice", "Bob", "Alice"};
         int[] ages = {25, 30, 99};
         Class<?>[] cArg = { String[].class, int[].class, String.class };
         Method method = testClass.getDeclaredMethod("getAge", cArg);
         // Standard behavior for parallel arrays is usually finding the first match
         assertEquals(25, (int) method.invoke(null, names, ages, "Alice"));
      } catch (Exception e) { fail("Test failed: " + e); }
   }

   // --- createLengthArray() Robust Tests ---

   @Test
   @DisplayName("createLengthArray should handle an empty input array")
   void createLengthArrayTest_EmptyArray() {
      Class<?> testClass = PracticeProblem.class;
      try {
         String[] input = {};
         Class<?>[] cArg = { String[].class };
         Method method = testClass.getDeclaredMethod("createLengthArray", cArg);
         int[] result = (int[]) method.invoke(null, (Object) input);
         assertEquals(0, result.length);
      } catch (Exception e) { fail("Test failed: " + e); }
   }

   @Test
   @DisplayName("createLengthArray should correctly count lengths of strings with special characters and numbers")
   void createLengthArrayTest_SpecialChars() {
      Class<?> testClass = PracticeProblem.class;
      try {
         String[] input = {"!@#$", "123456", "\t\n"};
         Class<?>[] cArg = { String[].class };
         Method method = testClass.getDeclaredMethod("createLengthArray", cArg);
         int[] result = (int[]) method.invoke(null, (Object) input);
         assertArrayEquals(new int[]{4, 6, 2}, result);
      } catch (Exception e) { fail("Test failed: " + e); }
   }

   @Test
   @DisplayName("createLengthArray should handle very long strings")
   void createLengthArrayTest_LongStrings() {
      Class<?> testClass = PracticeProblem.class;
      try {
         String longStr = "a".repeat(1000);
         String[] input = {longStr};
         Class<?>[] cArg = { String[].class };
         Method method = testClass.getDeclaredMethod("createLengthArray", cArg);
         int[] result = (int[]) method.invoke(null, (Object) input);
         assertEquals(1000, result[0]);
      } catch (Exception e) { fail("Test failed: " + e); }
   }

   // --- swapPeople() Robust Tests ---

   @Test
   @DisplayName("swapPeople should work when names are at the extreme ends of the array")
   void swapPeopleTest_Ends() {
      Class<?> testClass = PracticeProblem.class;
      try {
         String[] names = {"Start", "Middle", "End"};
         int[] ages = {1, 2, 3};
         Class<?>[] cArg = { String[].class, int[].class, String.class, String.class };
         Method method = testClass.getDeclaredMethod("swapPeople", cArg);
         method.invoke(null, names, ages, "Start", "End");
         
         assertArrayEquals(new String[]{"End", "Middle", "Start"}, names);
         assertArrayEquals(new int[]{3, 2, 1}, ages);
      } catch (Exception e) { fail("Test failed: " + e); }
   }

   @Test
   @DisplayName("swapPeople should correctly swap adjacent elements")
   void swapPeopleTest_Adjacent() {
      Class<?> testClass = PracticeProblem.class;
      try {
         String[] names = {"A", "B", "C"};
         int[] ages = {10, 20, 30};
         Class<?>[] cArg = { String[].class, int[].class, String.class, String.class };
         Method method = testClass.getDeclaredMethod("swapPeople", cArg);
         method.invoke(null, names, ages, "A", "B");
         
         assertArrayEquals(new String[]{"B", "A", "C"}, names);
         assertArrayEquals(new int[]{20, 10, 30}, ages);
      } catch (Exception e) { fail("Test failed: " + e); }
   }

   @Test
   @DisplayName("swapPeople should handle names with internal spaces")
   void swapPeopleTest_SpacesInNames() {
      Class<?> testClass = PracticeProblem.class;
      try {
         String[] names = {"John Doe", "Jane Smith"};
         int[] ages = {40, 45};
         Class<?>[] cArg = { String[].class, int[].class, String.class, String.class };
         Method method = testClass.getDeclaredMethod("swapPeople", cArg);
         method.invoke(null, names, ages, "John Doe", "Jane Smith");
         
         assertArrayEquals(new String[]{"Jane Smith", "John Doe"}, names);
         assertArrayEquals(new int[]{45, 40}, ages);
      } catch (Exception e) { fail("Test failed: " + e); }
   }

   @Test
   @DisplayName("swapPeople should only swap the first instances found if duplicates exist")
   void swapPeopleTest_DuplicateNamesInArray() {
      Class<?> testClass = PracticeProblem.class;
      try {
         String[] names = {"Alice", "Bob", "Alice", "Charlie"};
         int[] ages = {1, 2, 3, 4};
         Class<?>[] cArg = { String[].class, int[].class, String.class, String.class };
         Method method = testClass.getDeclaredMethod("swapPeople", cArg);
         method.invoke(null, names, ages, "Alice", "Bob");
         
         // Only the first Alice (index 0) should swap with Bob (index 1)
         assertArrayEquals(new String[]{"Bob", "Alice", "Alice", "Charlie"}, names);
         assertArrayEquals(new int[]{2, 1, 3, 4}, ages);
      } catch (Exception e) { fail("Test failed: " + e); }
   }
}
Sure, here are implementations for the Java programs you've asked for:

1. **Check if a given string is palindrome using recursion:**

   ```java
   public class PalindromeRecursive {

       public static boolean isPalindrome(String str) {
           if (str == null || str.length() <= 1) {
               return true;
           }
           char first = str.charAt(0);
           char last = str.charAt(str.length() - 1);
           if (first == last) {
               return isPalindrome(str.substring(1, str.length() - 1));
           } else {
               return false;
           }
       }

       public static void main(String[] args) {
           String str = "madam";
           if (isPalindrome(str)) {
               System.out.println(str + " is a palindrome.");
           } else {
               System.out.println(str + " is not a palindrome.");
           }
       }
   }
   ```

2. **Write a Java Program to print Fibonacci Series using Recursion:**

   ```java
   public class FibonacciRecursive {

       public static int fibonacci(int n) {
           if (n <= 1) {
               return n;
           }
           return fibonacci(n - 1) + fibonacci(n - 2);
       }

       public static void main(String[] args) {
           int n = 10; // Number of Fibonacci numbers to print
           for (int i = 0; i < n; i++) {
               System.out.print(fibonacci(i) + " ");
           }
       }
   }
   ```

3. **Write a Java program to check if two strings are anagrams:**

   ```java
   import java.util.Arrays;

   public class AnagramCheck {

       public static boolean areAnagrams(String str1, String str2) {
           if (str1.length() != str2.length()) {
               return false;
           }

           char[] charArray1 = str1.toCharArray();
           char[] charArray2 = str2.toCharArray();

           Arrays.sort(charArray1);
           Arrays.sort(charArray2);

           return Arrays.equals(charArray1, charArray2);
       }

       public static void main(String[] args) {
           String str1 = "listen";
           String str2 = "silent";
           if (areAnagrams(str1, str2)) {
               System.out.println(str1 + " and " + str2 + " are anagrams.");
           } else {
               System.out.println(str1 + " and " + str2 + " are not anagrams.");
           }
       }
   }
   ```

4. **Write a Java Program to find the factorial of a given number:**

   ```java
   public class FactorialRecursive {

       public static int factorial(int n) {
           if (n == 0 || n == 1) {
               return 1;
           }
           return n * factorial(n - 1);
       }

       public static void main(String[] args) {
           int num = 5;
           System.out.println("Factorial of " + num + " is: " + factorial(num));
       }
   }
   ```

5. **Given an array of non-duplicating numbers from 1 to n where one number is missing, write an efficient Java program to find that missing number:**

   ```java
   public class MissingNumber {

       public static int findMissingNumber(int[] nums) {
           int n = nums.length + 1;
           int totalSum = n * (n + 1) / 2;
           int sum = 0;
           for (int num : nums) {
               sum += num;
           }
           return totalSum - sum;
       }

       public static void main(String[] args) {
           int[] nums = {1, 2, 4, 5, 6};
           int missingNumber = findMissingNumber(nums);
           System.out.println("The missing number is: " + missingNumber);
       }
   }
   ```

6. **Write a Java Program to check if any number is a magic number or not:**

   ```java
   public class MagicNumber {

       public static boolean isMagicNumber(int num) {
           while (num > 9) {
               int sum = 0;
               while (num != 0) {
                   sum += num % 10;
                   num /= 10;
               }
               num = sum;
           }
           return num == 1;
       }

       public static void main(String[] args) {
           int number = 19;
           if (isMagicNumber(number)) {
               System.out.println(number + " is a magic number.");
           } else {
               System.out.println(number + " is not a magic number.");
           }
       }
   }
   ```

7. **Write a Java program to create and throw custom exceptions:**

   ```java
   class CustomException extends Exception {
       public CustomException(String message) {
           super(message);
       }
   }

   public class CustomExceptionExample {

       public static void validateAge(int age) throws CustomException {
           if (age < 18) {
               throw new CustomException("Age must be at least 18 years.");
           } else {
               System.out.println("Valid age: " + age);
           }
       }

       public static void main(String[] args) {
           try {
               validateAge(15); // Testing custom exception
           } catch (CustomException e) {
               System.out.println("Exception caught: " + e.getMessage());
           }
       }
   }
   ```

8. **Write a Java program to reverse a string:**

   ```java
   public class ReverseString {

       public static String reverse(String str) {
           if (str.isEmpty()) {
               return str;
           }
           return reverse(str.substring(1)) + str.charAt(0);
       }

       public static void main(String[] args) {
           String str = "Hello, World!";
           String reversedStr = reverse(str);
           System.out.println("Original string: " + str);
           System.out.println("Reversed string: " + reversedStr);
       }
   }
   ```

9. **Write a Java program to rotate arrays 90 degrees clockwise by taking matrices from user input:**

   ```java
   import java.util.Arrays;

   public class RotateMatrix {

       public static void rotateMatrix(int[][] matrix) {
           int rows = matrix.length;
           int cols = matrix[0].length;

           // Transpose matrix
           for (int i = 0; i < rows; i++) {
               for (int j = i + 1; j < cols; j++) {
                   int temp = matrix[i][j];
                   matrix[i][j] = matrix[j][i];
                   matrix[j][i] = temp;
               }
           }

           // Reverse rows
           for (int i = 0; i < rows; i++) {
               for (int j = 0; j < cols / 2; j++) {
                   int temp = matrix[i][j];
                   matrix[i][j] = matrix[i][cols - 1 - j];
                   matrix[i][cols - 1 - j] = temp;
               }
           }
       }

       public static void main(String[] args) {
           int[][] matrix = {
                   {1, 2, 3},
                   {4, 5, 6},
                   {7, 8, 9}
           };

           System.out.println("Original Matrix:");
           for (int[] row : matrix) {
               System.out.println(Arrays.toString(row));
           }

           rotateMatrix(matrix);

           System.out.println("\nMatrix after 90 degree clockwise rotation:");
           for (int[] row : matrix) {
               System.out.println(Arrays.toString(row));
           }
       }
   }
   ```

10. **Write a Java program to check if any number given as input is the sum of 2 prime numbers:**

    ```java
    public class SumOfPrimes {

        public static boolean isPrime(int num) {
            if (num <= 1) {
                return false;
            }
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        }

        public static boolean checkSumOfPrimes(int num) {
            for (int i = 2; i <= num / 2; i++) {
                if (isPrime(i) && isPrime(num - i)) {
                    return true;
                }
            }
            return false;
        }

        public static void main(String[] args) {
            int number = 34;
            if (checkSumOfPrimes(number)) {
                System.out.println(number + " can be expressed as the sum of two prime numbers.");
            } else {
                System.out.println(number + " cannot be expressed as the sum of two prime numbers.");
            }
        }
    }
    ```

11. **Write a Java program for solving the Tower of Hanoi Problem:**

    ```java
    public class TowerOfHanoi {

        public static void towerOfHanoi(int n, char fromRod, char toRod, char auxRod) {
            if (n == 1) {
                System.out.println("Move disk 1 from rod " + fromRod + " to rod " + toRod);
                return;
            }
            towerOfHanoi(n - 1, fromRod, auxRod, toRod);
            System.out.println("Move disk " + n + " from rod " + fromRod + " to rod " + toRod);
            towerOfHanoi(n - 1, auxRod, toRod, fromRod);
        }

        public static void main(String[] args) {
            int n = 3; // Number of disks
            towerOfHanoi(n, 'A', '

C', 'B');
}
}
```

12. **Implement Binary Search in Java using recursion:**

    ```java
    public class BinarySearchRecursive {

        public static int binarySearch(int[] arr, int left, int right, int target) {
            if (right >= left) {
                int mid = left + (right - left) / 2;
                if (arr[mid] == target) {
                    return mid;
                }
                if (arr[mid] > target) {
                    return binarySearch(arr, left, mid - 1, target);
                }
                return binarySearch(arr, mid + 1, right, target);
            }
            return -1;
        }

        public static void main(String[] args) {
            int[] arr = {2, 3, 4, 10, 40};
            int target = 10;
            int result = binarySearch(arr, 0, arr.length - 1, target);
            if (result != -1) {
                System.out.println("Element found at index " + result);
            } else {
                System.out.println("Element not present in array");
            }
        }
    }
    ```

These programs cover a variety of concepts and algorithms in Java. Feel free to ask if you have any more questions or need further clarification!
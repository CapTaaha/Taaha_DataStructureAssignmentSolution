import java.util.Scanner;
import java.util.Stack;

public class Driver {
    public static void main(String[] args) {

        // Taking no. of floors
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the total no of floors in the building");
        int n = scn.nextInt();

        // Creating arrays and stack
        int[] arr = new int[n];
        int[] arr_sorted = new int[n];
        Stack<Integer> stack = new Stack<Integer>();

        // Taking sizes
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the floor size given on day :" + (i + 1));
            arr[i] = scn.nextInt();
            arr_sorted[i] = arr[i];
        }

        // sorting the sizes
        MergeSort ob = new MergeSort();
        ob.sort(arr_sorted, 0, arr_sorted.length - 1);

        // Finding max value in inputs
        int max_size = arr_sorted[0];

        // Showing order of construction
        System.out.println("The order of construction is as follows:");
        for (int i = 0; i < n; i++) {
            System.out.println("Day: " + (i + 1));
            if (arr[i] == max_size) {
                System.out.println(arr[i]);
                max_size = arr_sorted[+1];
            } else {
                stack.push(arr[i]);
                System.out.println("Day: " + (i + 2));
                if (arr[i + 1] == max_size) {
                    System.out.println(arr[i + 1]);
                    System.out.println(stack.pop());
                } else {
                    stack.push(arr[i + 1]);
                }
            }
        }

        scn.close();

    }
}

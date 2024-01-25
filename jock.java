/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thisoneisbetterlol;



import java.util.Scanner;

public class Thisoneisbetterlol {
    
    static int ctr = 0; 
    
    static int getMax(int[] arr, int n) {
        int max = arr[0]; ctr++;
        for (int i = 1; i < n; i++)
            if (arr[i] > max)
                max = arr[i]; ctr++;
        return max;
    }

    static void countingSort(int[] arr, int n, int exp) {
        int[] output = new int[n]; ctr++;
        int[] count = new int[10]; ctr++;

        for (int i = 0; i < 10; i++)
            count[i] = 0; ctr++;

        for (int i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++; ctr++;

        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1]; ctr++;

        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i]; ctr++;
            count[(arr[i] / exp) % 10]--; ctr++;
        }

        System.arraycopy(output, 0, arr, 0, n); ctr++;
    }

    static void radixSort(int[] arr, int n) {
        int max = getMax(arr, n); ctr++;

        for (int exp = 1; max / exp > 0; exp *= 10)
            countingSort(arr, n, exp); ctr++;
    }

    static void printArray(int[] arr, int size) {
        for (int i = 0; i < size; i++)
            System.out.print(arr[i] + " "); ctr++;
        System.out.println(); ctr++;
    }

    public static void main(String[] args) {
        int[] arr = new int[8]; ctr++;

        Scanner scanner = new Scanner(System.in); ctr++;
        System.out.println("Enter 8 numbers:"); ctr++;

        for (int i = 0; i < 8; i++) {
            System.out.print("Number " + (i + 1) + ": "); ctr++;
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); ctr++;
            }
            arr[i] = scanner.nextInt(); ctr++;
        }

        radixSort(arr, arr.length); ctr++;

        System.out.println("Sorted Array:"); ctr++;
        printArray(arr, arr.length); ctr++;
        
        System.out.println("this is lol idk = " + ctr);
    }
}

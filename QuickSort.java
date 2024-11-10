// package PROFDAA.PR6;

import java.util.Random;
import java.util.Scanner;

public class QuickSort {

    public static void Quicksort(int arr[],int low,int high){
             if(low<high){
                int pi=partition(arr,low,high);
                Quicksort(arr,low,pi-1);
                Quicksort(arr, pi+1, high);

             }
    }
    public static int partition(int arr[],int low,int high){
              int pivot=arr[high];
              int i=(low-1);
              for(int j=low;j<high;j++){
                if(arr[j]<pivot){
                    i++;
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
              }
              int temp=arr[i+1];
              arr[i+1]=arr[high];
              arr[high]=temp;
              return i+1;
   }
    public static void Display(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        
     Scanner sc = new Scanner(System.in);
        System.out.println("Choose the case:");
        System.out.println("1. Best Case");
        System.out.println("2. Average Case");
        System.out.println("3. Worst Case");
        int choice = sc.nextInt();

        int size = 100; // Increase the size for better time measurement
        int arr[] = new int[size];

        switch (choice) {
            case 1:
                for (int i = 0; i < size; i++) {
                    arr[i] = i + 1;
                }
                System.out.println("Best Case:");
                break;
            case 2:
                Random rand = new Random();
                for (int i = 0; i < size; i++) {
                    arr[i] = rand.nextInt(100);
                }
                System.out.println("Average Case:");
                break;
            case 3:
                for (int i = 0; i < size; i++) {
                    arr[i] = size - i;
                }
                System.out.println("Worst Case:");
                break;
            default:
                System.out.println("Invalid choice!");
                return;
        }

        Display(arr);

        long startTime = System.nanoTime(); // Use nanoTime for better resolution
        Quicksort(arr, 0, arr.length - 1);
        long endTime = System.nanoTime();

        Display(arr);
        long duration = endTime - startTime;

        System.out.println("Start time: " + startTime);
        System.out.println("End time: " + endTime);
        System.out.println("Time taken to sort: " + duration / 1000000.0 + " milliseconds");
    }
}

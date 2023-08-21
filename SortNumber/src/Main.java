import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int[] myIntegers = getIntegers(5);
        int[] sorted = sortIntegers(myIntegers);
        printArr(sorted);
    }

    public static int[] getIntegers(int capacity){
        int[] arr = new int[capacity];
        System.out.println("Enter " + capacity + " integers values:\r");
        for(int i=0; i<arr.length; i++){
            arr[i] =  scanner.nextInt();
        }
        return arr;
    }

    public static void printArr(int[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.println("Element " + i + " contents " + arr[i]);
        }
    }

    public static int[] sortIntegers(int[] arr){
        int[] sortedArr = new int[arr.length];
        for(int i = 0; i<arr.length; i++){
            sortedArr[i] = arr[i];
        }
        boolean flag = true;
        int temp;
        while (flag){
            flag = false;
            for(int i=0; i<sortedArr.length-1;i++){
                if(sortedArr[i] < sortedArr[i+1]){
                    temp = sortedArr[i];
                    sortedArr[i] = sortedArr [i+1];
                    sortedArr[i+1] = temp;
                    flag = true;
                }
            }
        }
        return sortedArr;

    }
}
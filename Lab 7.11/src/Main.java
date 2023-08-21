import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[] myIntegers = getIntegers(5);
        int[] sorted = sortIntegers(myIntegers);
        printArray(sorted);
    }

    public static int[] getIntegers(int capacity){
        int[] arr = new int[capacity];
        System.out.println("Nhap gia tri cho " + capacity + " phan tu: ");
        for(int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    public static void printArray(int[] array){
        for(int i = 0; i < array.length; i++){
            System.out.println("Phan tu thu " + i + " co gia tri la: " + array[i]);
        }
    }

    public static int[] sortIntegers(int[] array){
        int[] sortedArray = new int[array.length];
        for(int i = 0; i < array.length; i++){
            sortedArray[i] = array[i];
        }

        boolean flag = true;
        int temp;
        while (flag){
            flag = false;
            for(int i = 0; i < array.length-1; i++){
                if(sortedArray[i] < sortedArray[i + 1]){
                    temp = sortedArray[i];
                    sortedArray[i] = sortedArray[i + 1];
                    sortedArray[i + 1] = temp;
                    flag = true;
                }
            }
        }
        return sortedArray;
    }
}
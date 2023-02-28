import java.util.*;

public class InsertionSort {
    private InsertionSort(int rounds) {
        int average_case[] = new int[rounds];
        int best_case[] = new int[rounds];
        int worst_case[] = new int[rounds];

        for(int i = 1; i <= rounds; i++) {
            performSort(i, average_case, best_case, worst_case);
        }

        System.out.println("\n\nActual Average Case: ");
        for(int i = 0; i < rounds; i++) {
            System.out.println("Round " + (i + 1) + ": " + " size = " + (i + 1) * 50 + ", count = " + average_case[i]);
            // System.out.println(""+average_case[i]);
        }
        for(int i = 0; i < rounds; i++) {
            System.out.println(""+average_case[i]);}
        
        
        System.out.println("\n\nActual Best Case: ");
        for(int i = 0; i < rounds; i++) {
            System.out.println("Round " + (i + 1) + ": " + " size = " + (i + 1) * 50 + ", count = " + best_case[i]);
        }
        for(int i = 0; i < rounds; i++) {
            System.out.println(""+best_case[i]);}

        System.out.println("\n\nActual Worst Case: ");
        for(int i = 0; i < rounds; i++) {
            System.out.println("Round " + (i + 1) + ": " + " size = " + (i + 1) * 50 + ", count = " + worst_case[i]);
        }
        for(int i = 0; i < rounds; i++) {
            System.out.println(""+worst_case[i]);}
    }

    private void performSort(int round, int[] average_case, int[] best_case, int[] worst_case) {
        int[] array = generateArray(round * 50);
        int sorted[] = sort(array, round, average_case);

        sort(sorted, round, best_case);
        sort(reverse(sorted), round, worst_case);
    }

    private int[] generateArray(int size) {
        ArrayList<Integer> array = new ArrayList<>(size);

        int count = 0;
        
        while (count < size) {
            int number = (int) (Math.random() * 2000);
            if(! array.contains(number)) {
                array.add(number);
                count++;
            }
        }

        int arr[] = new int[size];

        for(int i = 0; i < array.size(); i++) {
            arr[i] = array.get(i);
        }

        return arr;
    }

    private int[] sort(int[] array, int round, int[] counts) {
        int count = 1;

        for(int i = 1; i < array.length; i++) {
            int num = array[i];
            int j = i - 1;
            count++;
            while(j >= 0 && num < array[j]) {
                count++;
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = num;
        }

        System.out.println("Count of Executions = " + count);
        counts[round - 1] = count;

        return array;
    }

    public int[] reverse(int[] array) {
        int reversed[] = new int[array.length];

        for(int i = array.length - 1, j = 0; i >= 0; System.out.print(array[i] + " "), reversed[j++] = array[i--]);
        return reversed;
    }
    public static void main(String args[]) {
        new InsertionSort(20);
    }
}

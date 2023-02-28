import java.util.Arrays;
import java.util.Scanner;

class quicksort {


  static int partition(int array[], int down, int up) {
   
    int pivot = array[up];
    
   
    int i = (down - 1);

    for (int j = down; j < up; j++) {
      if (array[j] <= pivot) {

 
        i++;


        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
      }

    }

    int temp = array[i + 1];
    array[i + 1] = array[up];
    array[up] = temp;

    return (i + 1);
  }

  static void quickSort(int array[], int down, int up) {
    if (down < up) {

      int pi = partition(array, down, up);
      
      quickSort(array, down, pi - 1);

      quickSort(array, pi + 1, up);
    }
  }
}

class Main {
  public static void main(String args[]) {


    System.out.println("Please enter the size of array");
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int data[] = new int[n];
    System.out.println("Enter array element");
     for(int i = 0; i < n; i++){
      
      int a = sc.nextInt();
      data[i]=a;
      
     }
    
    // int[] data = { 8, 7, 2, 1, 0, 9, 6 };
    System.out.println("Unsorted Array");
    System.out.println(Arrays.toString(data));

    int size = data.length;

    quicksort.quickSort(data, 0, size - 1);

    System.out.println("Sorted Array in Ascending Order ");
    System.out.println(Arrays.toString(data));
  }
}
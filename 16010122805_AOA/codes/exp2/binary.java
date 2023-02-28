import java.io.*;
import java.util.*;

public class binary {
    int x = 0;
    public static void main(String[] args) throws IOException{
       new binary();

}
public binary(){
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter No of Elements: " );
    int n = sc.nextInt();
    Random r= new Random();
    int a[]=new int [n];
    int b[]=new int [n];
    System.out.println("\nRandom Array = ");
    for(int i=0;i<n;i++)
    {

        b[i]=a[i]=r.nextInt(100);
        System.out.print(a[i]+" ");
    }
    Arrays.sort(a);
    System.out.println("\nThe sorted array is: ");
    for (int num : a) {
        System.out.print(num + " ");  
}
System.out.println("\nEnter the number to be searched: ");
    int key = sc.nextInt();
int count=0;
    count = binarysearch(key,a,0,a.length-1);
    if(count == -1)
        System.out.println("Element Not found");
    else
        System.out.println("Element found at "+ count +" positions");
        System.out.println("No. of iterations performed: "+ x); 

}

 int binarysearch(int key, int arr[],int lw,int hg)
    {
        x = x+1;
        if(lw==hg)
        {
            if(arr[lw]==key)
                return lw;
            else
                return -1;
        }
        else
        {
            System.out.println("Entered next iteration");
            int count = (lw+hg)/2;
            if(arr[count]==key)
                return count;
            else if(arr[count] < key)
                return binarysearch(key,arr,count+1,hg);
            else
                return binarysearch(key,arr,lw,count-1);
        }
    }
}

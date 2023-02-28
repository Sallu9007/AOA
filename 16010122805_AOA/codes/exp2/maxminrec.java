import java.util.*;
public class maxminrec {
    public static int max,min;
   static int arr[]= new int[10];
   

    public static void main(String[] args) {
        Random r=new Random();
        
        for(int i=0;i<arr.length;i++){
            
            arr[i]=r.nextInt(10);
        } 
        for(int i=0;i<arr.length;i++){
            
            System.out.println(arr[i]);
        } 
        
        max=min=0;
        maxmin(1,arr.length-1);
    }

     public static void maxmin(int i,int j){
        int max1,min1,mid;
        if(i==j){
            max=min=arr[i];
            
        }
        if(i==j-1){
           if(arr[i] > arr[j]) {
            max=arr[i];
            min=arr[j];
           }
           else{
            max=arr[j];
            min=arr[i];
           }
        }
        else{
            mid=(i+j)/2;
            maxmin(i,mid);
            max1=max;
            min1=min;
            maxmin(mid+1,j);
            if(max<max1){
                max=max1;
            }
            if(min>min1){
                min=min1;
            }

        }

     }

     


    
}

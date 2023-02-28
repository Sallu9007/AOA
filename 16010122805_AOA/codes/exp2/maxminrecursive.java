
import java.util.*;

public class maxminrecursive
{
    public static int min,min1,max,max1;
    public static void main(String args[])
    {
        new maxminrecursive();
    }

    public maxminrecursive(){
        System.out.println("Enter Number of terms to find max min");
        Scanner sc =new Scanner(System.in);
        int n =sc.nextInt();
        Random r= new Random();
        int a[]=new int [n];
        int b[]=new int [n];
        System.out.println("\nRandom Array = ");
        for(int i=0;i<n;i++)
        {
            b[i]=a[i]=r.nextInt(100);
            System.out.print(a[i]+" ");
        }
        System.out.println("\n");
        min=max=a[0];
        MinMax(a,0,n-1);    
        System.out.println("Max = "+max+" Min = "+min);
    }
    static void MinMax(int a[],int i,int j)
    {
        if (i==j)
            max=min=a[i];
        else if(i==(j-1))
        {
            if(a[i]<a[j])
            {
                min=a[i];
                max=a[j];
            }
            else
            {
                min=a[j];
                max=a[i];
            }
        }
        else
        {
            int mid=(i+j)/2;max1=max;min1=min;
            MinMax(a,i,mid);
            MinMax(a,mid+1,j);
            if(max<max1)
                max=max1;
            if(min>min1)
                min=min1;
        }
    }
}

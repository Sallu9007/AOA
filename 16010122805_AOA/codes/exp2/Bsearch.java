import java.util.*;
class Main
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of Elements = ");
        int usr_inp = sc.nextInt(), ind=0;
        int usr_arr[] = new int[usr_inp];
        System.out.print("Enter Elements = ");
        for(int i=0;i<usr_inp;i++)
            usr_arr[i] = sc.nextInt();
        System.out.print("Enter Key = ");
        int key = sc.nextInt();
        System.out.println("1.Iterative B.S.\n2.Recursive B.S.");
        long start_time=0, end_time=0;
        usr_inp = sc.nextInt();
        switch(usr_inp)
        {
            case 1: start_time = System.nanoTime();
                    ind = iter_binar_sear(key,usr_arr);
                    end_time = System.nanoTime();
                    break;
            case 2: start_time = System.nanoTime();
                    ind = binar_sear(key,usr_arr,0,usr_arr.length-1);
                    end_time = System.nanoTime();
                    break;
        }
        if(ind == -1)
            System.out.println("Element Not found");
        else
            System.out.println("Element found at "+ ind);
        System.out.println("\n\nExecution Time = "+ (end_time - start_time)/Math.pow(10,4)+" x10^(-2)ms");
    }

    static int binar_sear(int key, int arr[],int lw,int hg)
    {
        if(lw==hg)
        {
            if(arr[lw]==key)
                return lw;
            else
                return -1;
        }
        else
        {
            int ind = (lw+hg)/2;
            if(arr[ind]==key)
                return ind;
            else if(arr[ind] < key)
                return binar_sear(key,arr,ind+1,hg);
            else
                return binar_sear(key,arr,lw,ind-1);
        }
    }

    static int iter_binar_sear(int key, int arr[])
    {
        int low=0, high=arr.length-1;
        while(low!=high)
        {
            int ind = (low+high)/2;
            if(arr[ind] == key)
                return ind;
            else if(key > arr[ind])
                low = ind+1;
            else
                high = ind-1;
        }
        if(arr[low]==key)
            return low;
        else
            return -1;
    }
}
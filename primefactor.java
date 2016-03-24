import java.util.Scanner;

/**
 *  *
 *   * @author hsarma
 *    */
public class primefactor 
{
    public static void main(String[] args)
    {
        int l;
        int i;
        System.out.println(" Enter a number ");
        Scanner sc=new Scanner(System.in);
        l=sc.nextInt();
        primefactor pf=new primefactor();
        pf.calNo(l);
    }
    
    public void calNo(int n)
    {
        int[] arr=new int[200];
       // Print the number of 2s that divide n
        int i=2,j=0;
        while(n>1)
        {
            if(n%i == 0)
            { 
                arr[j]=i;
                j++;
                n=n/i;
            }
            else
            i++;
        }
              
        for(i=0;i<j;i++)
        {
            boolean isDistinct = false;
            for(int y=0;y<i;y++)
            {
                if(arr[i] == arr[y])
                {
                    isDistinct = true;
                    break;
                }
            }
            if(!isDistinct)
            {
                System.out.print(arr[i]+" ");
            }
        }

    }
}
                                                                                                                                                     
                                                                                                                                                     
                                        

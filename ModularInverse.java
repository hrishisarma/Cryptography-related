import java.math.BigInteger;
import java.util.Scanner;

public class ModularInverse
{


    public static void main (String[] args) throws Exception
    {
        
        Scanner k = new Scanner(System.in);
        System.out.print(" Enter dividend: ");
        BigInteger b= new BigInteger(k.nextLine());
        System.out.print(" Enter divisor: ");
        BigInteger a= new BigInteger(k.nextLine());
        
        BigInteger inv=ModularInverse.ModInv(b,a);
        System.out.println(" Inverse is "+inv);
        
    }
    
    public static BigInteger ModInv(BigInteger a, BigInteger b)
    {
        
        BigInteger v1=b;
        BigInteger rem[]=new BigInteger[100];
        BigInteger quo[]=new BigInteger[100];
        BigInteger one=new BigInteger("1");
        rem[0]=b;
        rem[1]=a;
        int count=2;
        BigInteger r = b.mod(a);
        if(r.compareTo(one)==0)
        {
         rem[2]=one;
         quo[0]=b.divide(a);
         count=3;
        }
        for(int i=2;r.compareTo(one)==1;i++)
        {
         r=b.mod(a);
         rem[i]=r;
         quo[i-2]=b.divide(a);
         b=a;
         a=r;
         count++;
        }
        
        System.out.print("Remainder :");
        for(int i=0;i<=count-1;i++)
        {
            if(rem[i]==null)
            {
                 System.out.print("0");
            }
            else System.out.print(rem[i]+" ");
        }
        
        System.out.println();
        
        System.out.print("Quotients : 	   ");
        for(int i=0;i<=count-3;i++)
        {
         if(quo[i]==null)
         {
             System.out.print("0");
         }
         else System.out.print(quo[i]+" ");
        }
        System.out.println();
        
	BigInteger values[]=new BigInteger[count];
        values[0]=BigInteger.ZERO;
        values[1]=one;
        int size=count-2;
        int j=1;
        for(int i=size-1;i>=0;i--)
        {
            values[j+1]=(values[j].multiply(quo[i])).add(values[j-1]);
            j++;
        }
        System.out.print(" Values   :  [");
        for(int i=count-1;i>=0;i--)
        {
            System.out.print(values[i]+ " ");
        }
        System.out.println("]");

        if(count%2==0)
        {
            return(values[count-1]);
            
        }
        else return(v1.subtract(values[count-1]));
    }
}   



import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author hsarma
 */
public class SquareMultiply 
{
    public static BigInteger SquareMod(BigInteger number, BigInteger power, BigInteger divisor)
    {
        BigInteger count=new BigInteger("0");
        BigInteger zero=new BigInteger("0");
        BigInteger one=new BigInteger("1");
        BigInteger two=new BigInteger("2");
        
        BigInteger n[]=new BigInteger[100];
        BigInteger c[]=new BigInteger[100];
        BigInteger v[]=new BigInteger[100];
        BigInteger a[]=new BigInteger[100];
                        
        if(power.compareTo(one)==0)
        {
            BigInteger answer=number.mod(divisor);
            return answer;
        }
        
        n[0]=power;
        
        for(int i=0;power.compareTo(zero)>0;i++)
        {
            c[i]=power.mod(two);
            n[i+1]=(n[i].subtract(c[i])).divide(two);
            power=power.divide(two);
            count=count.add(one);
        }
        
        v[0]=number;
        
        for(int i=1;i<count.intValue();i++)
        {
            v[i]=(v[i-1].pow(2)).mod(divisor);
        }
        
        if(c[0].compareTo(zero)==0)
        {
            a[0]=one;
        }
        
        else
        {
            a[0]=number;
        }
        
        for(int i=1;i<count.intValue();i++)
        {
            if(c[i].compareTo(zero)==0)
            {
                a[i]=a[i-1];
            }
            else a[i]=(v[i].multiply(a[i-1])).mod(divisor);
        }
        
        int d=(count.subtract(one)).intValue();
        
        return a[d];
    }
    
    public static void main(String args[]) throws IOException
    {
        Scanner sc= new Scanner(System.in);
        System.out.print(" Enter value ");
        BigInteger number= new BigInteger(sc.nextLine());
        System.out.print(" Enter mod divisor: ");
        BigInteger divisor= new BigInteger(sc.nextLine());

        System.out.print(" Enter power: ");
        BigInteger power= new BigInteger(sc.nextLine());
                
        BigInteger ans=SquareMultiply.SquareMod(number,power,divisor);
        System.out.println(number+"^" +power+ " mod "+divisor+" = " +ans);
        
    }

    
}


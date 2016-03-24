
import java.math.BigInteger;
import java.util.Scanner;
 class primefactors 
{
        
    public void calNo(int n)
    {
        int m=n;
        int o=0;
        int [] arr1=new int[200];
        int[] arr=new int[200];
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
                arr1[o]=arr[i];
                o++;                          
            }
            
        }
      int z=1;
        while(z<m)        
        { 
            z++;
            int h=generator(z,arr1,m,o);
            if(h==o)return;
            else System.out.println(z+" is not a generator ");

        }
    
    }
         

    public int generator(int a,int[] b,int m,int o)
    {
        int pow=m,flag=0;
        BigInteger base = new BigInteger(Integer.toString(a));
        BigInteger mod = new BigInteger(Integer.toString(m+1));
        System.out.println();
        System.out.println(" Trying generator = "+base);
        for(int i=0;i<o;i++)
        {   
            int z=pow/b[i];
            BigInteger power = new BigInteger(Integer.toString(z));
            BigInteger gen=SquareMultiply.SquareMod(base, power, mod);
            System.out.println(base+"^"+power+" mod "+mod+" = "+gen);
            int w=gen.intValue();
            if(w!=1) flag++;
            if (flag==o)
            {
                System.out.println(base+" is a generator ");
                return flag;
            }
                
        }

       return 0;
            
        }
    }
    
                                                                                                                                                     
                                                                                                                                                     
                                        
public class Generator 
{
    
    
    public static void main(String args[]) throws Exception
    {
        
        Scanner sc=new Scanner(System.in);
        System.out.println(" Enter number ");
        int number=sc.nextInt();
        primefactors prime=new primefactors();
        prime.calNo(number-1);
         
    }    

   
}
 

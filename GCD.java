
import java.util.Scanner;

/**
 *
 * @author hsarma
 */
public class GCD {
    
    public static void main(String[] args){
    long a,b;    
    System.out.println(" Enter two numbers ");
        Scanner scanner = new Scanner(System.in);
        a= scanner.nextLong();
        b= scanner.nextLong();
        double d;
        GCD gc= new GCD();
        d = gc.calGCD(a,b);
    System.out.print(" The GCD of "+a+" and "+b+" is "+d+" \n");
    }
        
    public long calGCD(long a, long b){
         long c;
  while ( a != 0 ) {
     c = a; a = b%a;  b = c;
  }

  return b;
    }
    
}


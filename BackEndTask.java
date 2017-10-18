import java.io.*;
import java.util.*;
import java.lang.*;
class BackEndTask{
public static void main(String args[])
	{
		Scanner scan=new Scanner(System.in);
		long t=scan.nextLong();
		while(t--!=0)
		{
			long num=scan.nextLong();
			long res=fib(num);
			System.out.println(res);
		}
	}
static void multiply(long F[][],long M[][])
{
	long x=((F[0][0]*M[0][0])%1000000007 + (F[0][1]*M[1][0])%1000000007)%1000000007;
	long y=((F[0][0]*M[0][1])%1000000007 + (F[0][1]*M[1][1])%1000000007)%1000000007;
	long z=((F[1][0]*M[0][0])%1000000007 + (F[1][1]*M[1][0])%1000000007)%1000000007;
	long w=((F[1][0]*M[0][1])%1000000007 + (F[1][1]*M[1][1])%1000000007)%1000000007;

  F[0][0] = x;
  F[0][1] = y;
  F[1][0] = z;
  F[1][1] = w;
}
static void power(long F[][],long n)
{
	if( n == 0 || n == 1)
      	  return;
	long M[][] = {{1,1},{1,0}};
	power(F, n/2);
  	multiply(F, F);
 
  	if (n%2 != 0)
     		multiply(F, M);
}
static long fib(long n)
{
  long F[][] = {{1,1},{1,0}};
  if (n == 0)
    return 0;
  if (n == 1)
    return 2;
  if (n == 2)
    return 3;
  power(F, n-2);
  return (F[0][0]*3+F[0][1]*2)%1000000007;
}

}

package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class P10253 {
   public static void main(String[] args) throws Exception {
	  BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
	  StringTokenizer str = new StringTokenizer(bfr.readLine());
	  int n = Integer.parseInt(str.nextToken());
	  for (int i=0; i<n; i++) {
		  str = new StringTokenizer(bfr.readLine());
		  int a = Integer.parseInt(str.nextToken());
		  int b = Integer.parseInt(str.nextToken());
		  while(a!=1) {
			  int temp = (b%a==0) ? (b/a) : (b/a + 1);
			  a = a*temp - b;
			  b= b*temp;
			  int g = gcd(a,b);
			  a/=g; b/=g;
		  }
		  System.out.println(b);
	  }
   }
   static int gcd(int a, int b) {
	   if(b==0)
		   return a;
	   return gcd(b, a%b);
   }
}
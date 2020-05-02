package BAEKJOON;
import java.util.*;
import java.io.*;

public class P15466 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(bfr.readLine());
		int N = Integer.parseInt(str.nextToken());
		int[] A;
		int[] B;
		
		float union=0;
		for (int i=0; i<N; i++) {
			float intersection=0;
			str = new StringTokenizer(bfr.readLine());
			A = new int[Integer.valueOf(str.nextToken())];
			B = new int[Integer.valueOf(str.nextToken())];
			str = new StringTokenizer(bfr.readLine());
			for (int j=0; j<A.length; j++) {
				A[j] = Integer.valueOf(str.nextToken());
			}
			str = new StringTokenizer(bfr.readLine());
			for (int j=0; j<B.length; j++) {
				B[j] = Integer.valueOf(str.nextToken());
			}
			
			for (int j = 0; j<A.length; j++) {
				for (int z = 0; z<B.length; z++) {
					
					if(A[j]==B[z]) {intersection++;}
				}
			}
			
			union = A.length+B.length-intersection;
			
			float J = intersection/union;
			
			if(J>0.5) System.out.println("1");
			else System.out.println("0");
			
		}
	}

}

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2588 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(bfr.readLine());
		int a = Integer.parseInt(str.nextToken());
		str = new StringTokenizer(bfr.readLine());
		int b = Integer.parseInt(str.nextToken());
		int result = a*b;
		for(int i=0; i<3; i++) {
			int tmp = b%10;
			System.out.println(tmp*a);
			b /=10;
		}
		System.out.println(result);
		
	}

}

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P6588 {
	static final int MAX = 1000000;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str;
		boolean[] prime = new boolean[MAX+1];
        for(int i = 2; i <= MAX; i++) {
            prime[i] = true;
        }
        for(int i = 2; i <= MAX; i++) {
            for(int j = i * 2; j <= MAX; j += i) {
                if(!prime[j]) continue;
                prime[j] = false;
            }
        }
		int input = 0;
		while(true) {
			str = new StringTokenizer(bfr.readLine());
			input = Integer.parseInt(str.nextToken());
			boolean isPossible = false;
			if(input==0)
				break;
			for(int i=3; i<input; i+=2) {
				if(prime[i]&&prime[input-i]) {
					System.out.println(input+" = "+i+" + "+(input-i));
					isPossible = true;
					break;
				}
			}
			if(!isPossible) {
				System.out.println("Goldbach's conjecture is wrong.");
			}
		}
	}

}

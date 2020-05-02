package BAEKJOON;
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
public class P15764 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(bfr.readLine());
		int N = Integer.parseInt(str.nextToken());
		int M = Integer.parseInt(str.nextToken());
		int K = Integer.parseInt(str.nextToken());
		int[] list = new int[N+1];
		int[] mlist = new int[M+1];
		boolean[] check = new boolean[N+1];
		int one_index = 0;
		int first_false_index = 0;
		
		str = new StringTokenizer(bfr.readLine());
		for (int i=1; i<=M; i++) {
			int temp = Integer.parseInt(str.nextToken());
			mlist[i] = temp;
			if(temp==1) one_index=i;
			
		}
		
		for (int i=1; i<=K; i++) {
			str = new StringTokenizer(bfr.readLine());
			int cow_num = Integer.parseInt(str.nextToken());
			int cow_index = Integer.parseInt(str.nextToken());
			if(cow_num==1) {System.out.println(cow_index); return;}
			list[cow_index] = cow_num;
			check[cow_index] = true;
		}
		int tmp1=1;
		while(true) {
			if(check[tmp1]!=true) {first_false_index=tmp1; break;}
			tmp1++;
		}
		
		int n = N;
		
		
		for (int i=M; i>one_index; i--) {
			int temp = mlist[i];
			
			for (int j = n; j>0; j--) {
				
				if(list[j]==temp) {
					
					n=j-1; break;}
				if(j==1 && list[j]!=temp) {
					while(true) {
						if(check[n]!=true) break;
						n--;
					}
					
					check[n]=true; n--;}
			}
			
		}
		int front=1;
		for (int i=1; i<one_index; i++) {
			int temp = mlist[i];
			
			
			for (int j = front; j<=n; j++) {
				if(list[j]==temp) {
					for(int k=1; k<j; k++) {
						check[k] = true;
					}
					front=j+1; break;}
				if(j==n && list[j]!=temp) {
					while(true) {
						if(check[front]!=true) break;
						front++;
					}
					
					check[front]=true; front++;}
			}
		}
		for(int i=1;i<=N; i++) {
			System.out.println(check[i]);
		}
		
		int tmp=1;
		while(true) {
			if(check[tmp]!=true) {System.out.println(tmp); return;}
			tmp++;
		}
		
	}
}


package BAEKJOON;
import java.util.*;
import java.io.*;
public class P15753 {
	static int[] log;
	static int min;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(bfr.readLine());
		int N = Integer.parseInt(str.nextToken());
		log = new int[N+1];
		str = new StringTokenizer(bfr.readLine());
		for(int i=1; i<=N; i++) {
			log[i] = Integer.parseInt(str.nextToken());
		}
		int max_pnt = 0;
		min = 0;
		///////////////day 1�� ���� ��� �˻� /////////////
		isBreakout(1);
		///////////////day 1�� ���� ��� �˻� /////////////
		
		///////////////day n�� ���� ��� �˻�/////////////
		while(N>1) {
			if(N<=log[N]) {
				System.out.println("-1");
				return;
			}
			if(log[N]== -1) {
				max_pnt++;
				N--;
			}
			else if(log[N] == 0) {
				min++;
				N--;
			}
			else {
				for (int i=1; i<=log[N]; i++) {
					/////////////////breakout�Ͼ day�� ���//////////////
					if(i == log[N]) {
						isBreakout(N-i);
					}
					////////////////////////////////////////////////////
					//////////////////���� ī��Ʈ ���� ���//////////////////////
					else {
						if(log[N-i]==log[N]-i || log[N-i]==-1) {
							if(N-i == 2) break;
						}
						else {
							System.out.println("-1");
							return;
						}
					}
					////////////////////////////////////////////////////
				}

				N= N-log[N]-1; //Ȯ���� day�� ���� -> �� ����day�� ����
			}
		}
		System.out.println(min+" "+(min+max_pnt));
	}
	
	static void isBreakout(int n) {
		if(log[n] == 0 || log[n] == -1) {
			min++;	
		}
		else {
			System.out.println("-1");
			return;
		}
	}

}

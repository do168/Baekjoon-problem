package baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
public class P17198 {
	static int[][] map;
	static int[][] visit;
	static int[] bp;
	static int[] rp;
	static int[] lp;
	static int[] x_dir = {-1,1,0,0};
	static int[] y_dir = {0,0,-1,1};
	public static void main(String[] args) throws IOException{
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		visit = new int[10][10];
		bp = new int[2];
		rp = new int[2];
		lp = new int[2];
		for(int i=0; i<10; i++) {
			String[] rl = bfr.readLine().split("");
			for(int j=0; j<10; j++) {

				if(rl[j].equals(".")) {
					continue;
				}
				else if (rl[j].equals("B")) {
					bp[0] = i; bp[1] = j;
				}
				else if(rl[j].equals("R")) {
					rp[0] = i; rp[1] = j;
				}
				else if(rl[j].equals("L")) {
					lp[0] = i; lp[1] = j;
				}
			}
		}
		Cal_path(bp[0], bp[1]);
		System.out.println(visit[lp[0]][lp[1]]-2);
	}
	static void Cal_path(int x, int y) {
		Queue<Node2> q = new LinkedList<Node2>();
		q.add(new Node2(x,y));
		visit[x][y] = 1;
		while (!q.isEmpty()) {
			Node2 n = q.poll(); // ť���� �ϳ� ������
			for (int i=0; i<4; i++) { // �������� �� ������.
				int nx = n.x + x_dir[i];
				int ny = n.y + y_dir[i];
				if (nx < 0 || ny < 0 || nx >= 10 || ny >= 10) {
					continue;
				}
				// ���� ���� ��ǥ�� �� ũ�⸦ �Ѿ� ������ �ǳʶٱ�
				if (visit[nx][ny]>0) {
					continue;
				}
				if (nx==rp[0] && ny==rp[1]) {
					continue;
				}
				//�̹� �湮�ߴ� ���̰ų� ���������̸� �ǳʶٱ�
				visit[nx][ny] = visit[n.x][n.y]+1;
				q.add(new Node2(nx, ny));
			}
		}
	}	
}
class Node2 {
	int x;
	int y;
	Node2(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
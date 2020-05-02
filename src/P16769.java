package BAEKJOON;
import java.io.*;
import java.util.*;
public class P16769 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str;
		CircularLinkedList bucket = new CircularLinkedList();
		for (int i=0; i<3; i++) {
			str = new StringTokenizer(bfr.readLine());
			int bucket_cap = Integer.parseInt(str.nextToken());
			int milk_in_bucket = Integer.parseInt(str.nextToken());
			bucket.insert(bucket_cap, milk_in_bucket);
		}
		
		for (int i=0; i<100; i++) {
			bucket.pour();
		}
		bucket.Print();
		return;
	}

}

class LinkedNode {
	int b;
	int m;
	LinkedNode next;
	
	public LinkedNode() {
		this.b=0;
		this.m=0;
		this.next = null;
	}
	public LinkedNode(int b, int m) {
		this.b = b;
		this.m = m;
		this.next = null;
	}
	public LinkedNode(int b, int m, LinkedNode next) {
		this.b = b;
		this.m = m;
		this.next = next;
	}
}

class CircularLinkedList {
	LinkedNode CL;
	LinkedNode Step;
	public CircularLinkedList() {
		this.CL = null;
		Step = CL;
	}
	void insert(int b, int m) {
		LinkedNode node = new LinkedNode(b,m);
		if(CL==null) {
			CL = node;
			node.next = node;
		}
		else {
			LinkedNode current = CL;
			while(current.next!=CL) {
				current=current.next;
			}
			node.next = current.next;
			current.next = node;
			Step = node.next;
		}
	}
	
	void change(int m) {
		CL.m = m;
	}
	void pour() {
		int temp = Step.m+Step.next.m;
		if(temp>Step.next.b) {
			Step.next.m = Step.next.b;
			Step.m = temp-Step.next.b;
		}
		else {
			Step.next.m = temp;
			Step.m = 0;
		}
		Step = Step.next;
	}
	void Print() {
		System.out.println(CL.m);
		System.out.println(CL.next.m);
		System.out.println(CL.next.next.m);
	}
	
}

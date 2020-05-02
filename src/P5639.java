package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P5639 {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		int data1 = Integer.parseInt(bfr.readLine());
		Tree_Node node = new Tree_Node(data1); //root node
		String input = "";
		while((input = bfr.readLine())!=null && input.length()!=0) { //EOF
			int data = Integer.parseInt(input);
			node.connec_node(node, data); //make tree
		}
		postorder(node);
		System.out.println(sb);
	}
	static void postorder(Tree_Node node) {
		if(node.left!=null) postorder(node.left);
		if(node.right!=null) postorder(node.right);
		sb.append(node.data + "\n");
	}
}
class Tree_Node {
	int data;
	Tree_Node left;
	Tree_Node right;
	
	
	Tree_Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
	public Tree_Node connec_node(Tree_Node node, int insert_data) {
		Tree_Node temp_node = null;
		if(node==null)
			node = new Tree_Node(insert_data);
		else if (node.data>insert_data) {
			temp_node = connec_node(node.left, insert_data);
			node.left = temp_node;
		}
		else if(node.data<insert_data) {
			temp_node = connec_node(node.right, insert_data);
			node.right = temp_node;
		}
		return node;
	}
}
